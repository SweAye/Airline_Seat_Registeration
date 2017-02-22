package airline;

import java.util.*;

import java.io.*;

/**
 * @author aswe
 * 
 *         This is Economy Class seat Main feature is to find a seat by the
 *         customer preference in the Economy Class 1. First check if all full
 *         booked 2. if not full look for preference seat among windows(W),
 *         Middle(M), and Aisle(A) 3. if full, back to the request and display
 *         no seat is left for the preference and ask for start over again to
 *         look for more avaible seat 4. if not full, take the first seat that
 *         match customer preference and display it, 5. Assign as occupied in
 *         the Economy seat Array along with the customer information(Object of
 *         Customer) 6. Write to the customer record file (In this case CL34.txt
 *         file for furture reference: This file will be used to repopulated to
 *         the Economy ArrayList when the program start again.
 * 
 *
 */
public class economy_Class {
	String seat;
	int countTotalSeat = 0;// This will back to 0 after testing

	FlightSeat tranSeat = new FlightSeat();// This will translate the array
											// index into real flight seat.

	// Four final count for seat, this cannot change//should make those more
	// object orientend(something like putting in the constructor or so)
	final int TotalSeat = 5;
	final int window_Seat = 2;// the seat number is = 40 seat per each w, m, and
								// A seats
	final int middle_Seat = 5;
	final int aiseal_Seat = 5;

	// counting window seat, middle seat and aiseal seat
	int count_W = 0;// These all will back to 0 after testing
	int count_M = 0;
	int count_A = 0;

	// Three array to to populate the seat request
	// This is just testing with arrayList???????Here testing
	ArrayList<customer> custList = new ArrayList<customer>();

	boolean[] windowSeat = new boolean[window_Seat];// These number will depend
													// on the place's seat
													// structure
	String[] middleSeat = new String[middle_Seat];// for this project of plane
													// seat structure that will
													// fix.
	String[] AisaelSeat = new String[aiseal_Seat];// if plane seat setting are
													// change, just need to
													// change the final
													// variables

	// may be make constructor to initialize the all hard code numbers;
	// default constructor
	// this will populated all three array with false(means there is no occupied
	// seat)
	public economy_Class() {
		seat = " ";
		for (int i = 0; i < windowSeat.length; i++) {
			windowSeat[i] = false;
			middleSeat[i] = null;
			AisaelSeat[i] = null;

		}

	}
	// *********************************************************************************************************
	// This method will handle all major qury check before it is book to the
	// economy class and return the query
	// And ****This is the only method will be public in this class
	// To handle all of those qurey to process the real reservation and return
	// the request to the caller of this class,
	// In order to hide the operations in this class.

	public void BossOfEconomyClass() {
		try {
			int temp;
			Scanner in = new Scanner(System.in);
			// if economy class full?
			if (isFulllyBooked())// if is false, it is not full, it is true
									// return, it is full
				System.out.println("It is full, choose another class!");

			else
				System.out.println("It is avaiable");

			System.out.println("Please Enter your preference seat: 1 for Window, 2 for middle, 3 for Aiseal:");
			temp = in.nextInt();
			System.out.println("You enter this : " + temp);
			// testing for window seat full?
			if (temp == 1) {
				// call isfullWindow method
				if (isWindowSeatFull()) {
					System.out.println("Window seats are full");
					return;
				}

				else
					System.out.println("You will have your window seat");
				// the window seat array and assign the first founded window
				int recordIndex = resvWindowSeat();// this will assign the seat
													// and return the index
													// value of the array
				System.out.println("This is the assigned seat in the window array seat, index: " + recordIndex);
				// Here call the translator(method) of array index to real
				// flight seat number.
				String s = tranSeat.tranlateW(recordIndex);
				System.out.println("This is real seat: " + s);
				// Now call for the customer object ArrayList to send, custoemr
				// name, class and seat
				String name = getname();
				System.out.println("This is your name: " + name);

				// method call to set customer arraylist
				makeCustList(name, s, "Economy", "W");// "W" and Economy will
														// change according to
														// the method call.
				// save the cusomer List to file (call from here)

			}

			// This will test the Middle Seat full?
			else if (temp == 2) {
				if (isMiddleSeatFull()) {
					System.out.println("Middle seats are full");
				} else
					System.out.println("You will have your middleseat");
			}

			else if (isAisealSeatFull()) {
				System.out.println("Aiseal seats are full");
			} else
				System.out.println("You will have your Aiseal seat");

		} catch (Exception e) {
			System.out.println("Exception occur in seat choice of boss of economy Class.");
		}

	}

	// This method will make customer list for whole economy class
	// customers(Window,middle, Aiseal)
	// Now it time to make whole customer profile
	private void makeCustList(String name, String seat, String level, String pref) {

		customer newcust = new customer(name, seat, level, pref);

		custList.add(newcust);
		System.out.println("This is first customer profile :\n " + custList.get(0).name + "\t " + custList.get(0).seat
				+ "\t" + custList.get(0).level + "\t" + custList.get(0).Preference);

	}

	// This one will display the customer list fromt he custListArrayList

	public void showCustList() {
		for (customer show : custList) {
			System.out.println(show.name + "\t" + show.seat + "\t" + show.level + "\t" + show.Preference + "\n");
		}
	}

	public void SaveCustListEco() throws IOException {
		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("CuEcoList.txt")));
			for (int i = 0; i < custList.size(); i++) {

				bw.write(custList.get(i).name + " " + custList.get(i).seat + " " + custList.get(i).level + " "
						+ custList.get(i).Preference);
				bw.newLine();
			}
			bw.close();
		} catch (FileNotFoundException e) {
			System.out.println("Exception from the SaveCustListEco emthod in Eco class.\n");
		}
	}

	public void populate_CustListEcO() throws IOException, FileNotFoundException {
		Scanner read = new Scanner(new File("CuEcoList.txt"));
		String line = "";
		// String name, seat, level, prefer = "";
		while (read.hasNextLine()) {

			line = read.nextLine();

			String[] array = line.split("\\s+");
			String name = array[0];
			String seat = array[1];
			String level = array[2];
			String prefer = array[3];
			// this will handle the w , m and A seat count:
			if (prefer.contentEquals("W")) {
				count_W++;
				countTotalSeat++;
				customer c = new customer(name, seat, level, prefer);
				custList.add(c);

				for (int i = 0; i < window_Seat; i++) {
					if (!(windowSeat[i])) {
						windowSeat[i] = true;// this line is updating the
												// windwSeat array
					}
				}
			} else if (prefer.contentEquals("M")) {
				count_M++;
				countTotalSeat++;
			}

			else if (prefer.contentEquals("A")) {
				count_A++;
				countTotalSeat++;
			}
			// System.out.println(
			// "HEllO I am here: ..countW , countM, countA are: " + count_W +
			// count_M + count_A);

			// System.out.println(c.name + " " + c.seat + " " + c.level
			// + " " +
			// c.Preference + " ");

		}
		read.close();
	}

	private String setname() {
		String name = "";
		try {
			int temp;
			Scanner in = new Scanner(System.in);

			System.out.println("Enter your name: ");
			name = in.next();

		} catch (Exception e) {
			System.out.println("Exception in get name:");
		}
		return name;
	}

	// This method will return the customer name from the setname which get the
	// name from the scanner
	private String getname() {
		return setname();
	}

	// ***********************************************************************************************************************
	// Window seat reserved array
	// This method will check the specific array index for false(not occupied
	// if not occupied, make it true(occupied) and return the array index of the
	// assigned
	// idex
	private int resvWindowSeat() {
		int i;
		int temp = 0;
		for (i = 0; i < window_Seat; i++) {
			if (!(windowSeat[i])) {
				windowSeat[i] = true;

				System.out.println("I am in the resvWindowSeat before increase it: count_W here is : " + this.count_W);// just
																														// testing
				count_W++;// update the window seat
				countTotalSeat++;// update the total seat
				System.out.println("countTotalSeat= " + countTotalSeat);
				System.out.println("count_W= " + count_W);
				System.out.println("This is windowSeat[" + i + "]:" + windowSeat[i]);
				// System.out.println("This is windowSeat[1]: " +
				// windowSeat[i+1]);
				// System.out.println("This is windowSeat[2]: " +
				// windowSeat[i+2]);
				temp = i;
				break;
			}
		}
			showWindow();
		//System.out.println("ATT:::::This is i in the resvWindowSeat: " + i);
		return temp;// the array index will return to the caller
	}

	// Just for testing for window array
	/*
	 * public void fillWindArray(){ windowSeat[0]= true; windowSeat[1]= true;
	 * windowSeat[2]= true;
	 * 
	 * 
	 * }
	 */

	// boolean[][] custArray = new boolean[4][4];
	// ArrayList<customer> eco_custo = new ArrayList<customer>();

	// display for default economy class customer array(custArray)
	/*
	 * private void displayArray() { for (int i = 0; i < windowSeat.length; i++)
	 * { System.out.print(windowSeat[i]+ " "); System.out.println();
	 * System.out.print(middleSeat[i]+ " "); System.out.println();
	 * System.out.print(AisaelSeat[i]+ " "); System.out.println(); }
	 * 
	 * }
	 */
	// Constructor with String seat argument
	private economy_Class(String seat) {
		this.seat = seat;
	}

	// seat getter
	public String getSeat() {

		return this.seat;
	}

	// seat setter
	public void setSeat(String seat) {
		this.seat = seat;
	}

	// This method is in construction, which will be modified to
	// taking two argument(row and colum) to reserved a seat rather than a hard
	// number [0][1] or [2][1] for the index
	/*
	 * private void reserved_seat() {
	 * 
	 * custArray[0][2] = true;// make it occupied custArray[2][3] = true;
	 * 
	 * }
	 */
	/*
	 * // This method will search in the economy seat private boolean
	 * isEmpty(int row, int colum) { if (!(custArray[row][colum]))// not false
	 * is true means occupied return true;// it is occupied else return false;//
	 * it is not occupied }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * private void displaySeatINFormat() { try{
	 * 
	 * int x = Integer.valueOf("3"); //double c = Double.parseDouble("5");
	 * //String b = Integer.toBinaryString(3);//This one can't convert to binary
	 * number
	 * 
	 * System.out.println(x);}catch(NumberFormatException e){ }
	 * //System.out.println(c); //System.out.println(b); } //This will store the
	 * name of the RealSeat to the seat array private int assignSeat(String
	 * seatName) { int SeatIndex = 0;//This get to be increase and global later
	 * to handle the cancel and add the seat
	 * 
	 * String [] array = new String[5];//This has to be global in this class,
	 * for now using the hard code to test it array[SeatIndex] = seatName;
	 * 
	 * return SeatIndex;//This doesn't have to return it, searchSeat can handle
	 * to find the seat for customer }
	 * 
	 * 
	 * 
	 * /*need searching algorith to find the String seat(1B, 1C in the array),
	 * Prototype of the seat search This method will use only when customer
	 * cancel the seat, customer object will pass the customer's seat name such
	 * as 1A , 1B and this method will find it int the array and cancel the
	 * seat.
	 * 
	 */

	// general economy class full qurey
	public boolean isFulllyBooked() {
		if (countTotalSeat <= TotalSeat)// if not fully, return false
			return false;
		else
			return true;// if full, return true

	}

	private boolean isWindowSeatFull() {
		System.out.println("Count_W is: " + count_W);

		if (count_W < window_Seat)
			return false;// is not full
		else
			return true;// it is full

	}

	private boolean isMiddleSeatFull() {

		if (count_M < middle_Seat)
			return false;// is not full
		else
			return true;// it is full

	}

	private boolean isAisealSeatFull() {
		if (count_A < aiseal_Seat)
			return false;// is not full
		else
			return true;// it is full

	}

	public void showWindow() {
		for (int i = 0; i < windowSeat.length; i++) {
			System.out.println("Window Seat with true and faluse: " + windowSeat[i] + "\n");
		}

	}

}