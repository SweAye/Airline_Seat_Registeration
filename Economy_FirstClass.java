package airline;

import java.util.*;
import java.awt.List;
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
public class Economy_FirstClass {
	String seat;
	int countAllSeat = 0;// This will back to 0 after testing
	int countEcoAll = 0;
	int countFAll = 0;

	FlightSeat tranSeat = new FlightSeat();// This will translate the array
											// index into real flight seat.
	final int Flight_Seat = 20;
	// Four final count for seat, this cannot change//should make those more
	// object orientend(something like putting in the constructor or so)
	final int ETotalSeat = 12;
	final int window_Seat = 4;// the seat number is = 40 seat per each w, m, and
								// A seats
	final int middle_Seat = 4;
	final int aiseal_Seat = 4;

	// counting window seat, middle seat and aiseal seat
	int Ecount_W = 0;// These all will back to 0 after testing
	int Ecount_M = 0;
	int Ecount_A = 0;
	// *********************this is first class variables*****************
	final int FTotalSeat = 8;
	final int Fwindow_Seat = 4;// the seat number is = 40 seat per each w, m,
								// and
	final int Faiseal_Seat = 4;

	// counting window seat, middle seat and aiseal seat
	int Fcount_W = 0;// These all will back to 0 after testing
	int Fcount_A = 0;

	// *********************this is first class variables Done
	// here*****************
	// Three array to to populate the seat request
	// This is just testing with arrayList???????Here testing

	ArrayList<customer> ALL_CusList = new ArrayList<customer>();// this is
																// whole
	ArrayList<customer> All_EcoList = new ArrayList<customer>(); // Plane
	ArrayList<customer> ALL_FList = new ArrayList<customer>(); // ArrayList,
	// mainly
	// will
	// use in calcelation or searching for a customer's name, seat

	ArrayList<customer> EWcustList = new ArrayList<customer>();// this Window
																// customer
																// arraylist

	ArrayList<customer> EMcustList = new ArrayList<customer>();// this middle
																// seat customer
																// arraylist

	ArrayList<customer> EAcustList = new ArrayList<customer>();// this is Aiseal

	// **********************This is for First Class******************
	ArrayList<customer> FWcustList = new ArrayList<customer>();
	ArrayList<customer> FAcustList = new ArrayList<customer>();// this is Aiseal

	boolean[] windowSeat = new boolean[window_Seat];// These number will depend
													// on the place's seat
													// structure
	boolean[] middleSeat = new boolean[middle_Seat];// for this project of plane
													// seat structure that will
													// fix.
	boolean[] AisaelSeat = new boolean[aiseal_Seat];// if plane seat setting are
													// change, just need to
													// change the final
													// variables

	boolean[] FwindowSeat = new boolean[window_Seat];// These number will depend
	boolean[] FAisaelSeat = new boolean[aiseal_Seat];// if plane seat setting
														// are
	// may be make constructor to initialize the all hard code numbers;
	// default constructor
	// this will populated all three array with false(means there is no occupied
	// seat)

	public Economy_FirstClass() {
		seat = " ";
		for (int i = 0; i < windowSeat.length; i++) {
			windowSeat[i] = false;
			middleSeat[i] = false;
			AisaelSeat[i] = false;

		}
		for (int i = 0; i < FwindowSeat.length; i++) {
			windowSeat[i] = false;
			AisaelSeat[i] = false;
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
			if (isFullyBookedEco())// if is false, it is not full, it is true
			{ // return, it is full
				System.out.println("It is avaiable");

			} else {
				System.out.println("It is full, choose another class!");
				return;
			}

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

				else {
					System.out.println("You will have your window seat");

					// the window seat array and assign the first founded window

					int recordIndex = resvWindowSeat();// this will assign the
														// seat
														// and return the index
														// value of the array
					System.out.println("This is the assigned seat in the window array seat, index: " + recordIndex);
					// Here call the translator(method) of array index to real
					// flight seat number.

					String s = tranSeat.tranlateW(recordIndex);
					System.out.println("This is real seat: " + s);

					// Now call for the customer object ArrayList to send,
					// custoemr
					// name, class and seat
					String name = getname();
					System.out.println("This is your name: " + name);

					// method call to set customer arraylist
					makeCustListWE(name, s, "Economy", "W");// "W" and Economy
															// will
															// change according
															// to
															// the method call.
					makeAllCustList(name, s, "Economy", "W");
					makeAllEcoList(name, s, "Economy", "W");

					return;
				}

			}

			// This will test the Middle Seat full?
			else if (temp == 2) {
				if (isMiddleSeatFull()) {
					System.out.println("Middle seats are full");
					return;
				} else {
					System.out.println("You will have your middleseat");

					int recordIndex = resvMiddleSeat();
					System.out.println("This is the assigned seat in the Middle array seat, index: " + recordIndex);
					// Here call the translator(method) of array index to real
					// flight seat number.

					String s = tranSeat.tranlateM(recordIndex);
					System.out.println("This is real seat: " + s);

					String name = getname();// is that a test? missing a purpose
					System.out.println("This is your name: " + name);
					// method call to set customer arraylist
					makeCustListM(name, s, "Economy", "M");// "W" and Economy
					makeAllCustList(name, s, "Economy", "M");
					makeAllEcoList(name, s, "Economy", "M");

					System.out.println("This is from the middle Sesat in boos of econmy: ");
					ShowAllCust();

					return;
				}

			}

			else if (isAisealSeatFull()) {
				System.out.println("Aiseal seats are full");
				return;
			} else {
				System.out.println("You will have your Aiseal seat");

				int recordIndex = resvAisealSeat();
				System.out.println("This is the assigned seat in the Aiseal array seat, index: " + recordIndex);
				// Here call the translator(method) of array index to real
				// flight seat number.

				String s = tranSeat.tranlateA(recordIndex);
				System.out.println("This is real seat: " + s);

				String name = getname();// is that a test? missing a purpose
				System.out.println("This is your name: " + name);
				// method call to set customer arraylist
				makeCustListA(name, s, "Economy", "A");// "W" and Economy will
														// change according to
				makeAllCustList(name, s, "Economy", "A"); // the method
				makeAllEcoList(name, s, "Economy", "A"); // call.

				System.out.println("This is from the Aiseal Seat in boos of econmy: ");
				ShowAllCust();
				return;
			}

		} catch (Exception e) {
			System.out.println("Exception occur in seat choice of boss of economy Class.");
		}

	}

	// This method will make customer list for whole economy class
	// customers(Window,middle, Aiseal)
	// Now it time to make whole customer profile

	private void makeCustListWE(String name, String seat, String level, String pref) {

		customer newcust = new customer(name, seat, level, pref);

		EWcustList.add(newcust);
		System.out.println("This is first customer profile :\n " + EWcustList.get(0).name + "\t "
				+ EWcustList.get(0).seat + "\t" + EWcustList.get(0).level + "\t" + EWcustList.get(0).Preference);

	}

	private void makeCustListWF(String name, String seat, String level, String pref) {

		customer newcust = new customer(name, seat, level, pref);

		FWcustList.add(newcust);
		System.out.println("This is first customer profile :\n " + FWcustList.get(0).name + "\t "
				+ FWcustList.get(0).seat + "\t" + FWcustList.get(0).level + "\t" + FWcustList.get(0).Preference);

	}

	private void makeCustListM(String name, String seat, String level, String pref) {

		customer newcust = new customer(name, seat, level, pref);

		EMcustList.add(newcust);
		System.out.println("This is first customer profile :\n " + EMcustList.get(0).name + "\t "
				+ EMcustList.get(0).seat + "\t" + EMcustList.get(0).level + "\t" + EMcustList.get(0).Preference);

	}

	private void makeCustListA(String name, String seat, String level, String pref) {

		customer newcust = new customer(name, seat, level, pref);

		EAcustList.add(newcust);
		System.out.println("This is first customer profile :\n " + EAcustList.get(0).name + "\t "
				+ EAcustList.get(0).seat + "\t" + EAcustList.get(0).level + "\t" + EAcustList.get(0).Preference);

	}

	private void makeCustListAF(String name, String seat, String level, String pref) {

		customer newcust = new customer(name, seat, level, pref);

		FAcustList.add(newcust);
		System.out.println("This is first customer profile :\n " + FAcustList.get(0).name + "\t "
				+ FAcustList.get(0).seat + "\t" + FAcustList.get(0).level + "\t" + FAcustList.get(0).Preference);

	}

	private void makeAllCustList(String name, String seat, String level, String pref) {

		customer newcust = new customer(name, seat, level, pref);

		ALL_CusList.add(newcust);

	}

	private void makeAllEcoList(String name, String seat, String level, String pref) {

		customer newcust = new customer(name, seat, level, pref);

		All_EcoList.add(newcust);

	}

	private void makeAllFirsitList(String name, String seat, String level, String pref) {

		customer newcust = new customer(name, seat, level, pref);

		ALL_FList.add(newcust);

	}

	// This one will display the customer list fromt he custListArrayList

	public void showWcustList() {
		for (customer show : EWcustList) {
			System.out.println(show.name + "\t" + show.seat + "\t" + show.level + "\t" + show.Preference + "\n");
		}
	}

	public void ShowAllCust() {
		for (customer show : ALL_CusList) {
			System.out.println(show.name + "\t" + show.seat + "\t" + show.level + "\t" + show.Preference + "\n");
		}
	}

	public void ShowAllEco() {
		for (customer show : All_EcoList) {
			System.out.println(show.name + "\t" + show.seat + "\t" + show.level + "\t" + show.Preference + "\n");
		}
	}

	public void ShowAllFirst() {
		for (customer show : ALL_FList) {
			System.out.println(show.name + "\t" + show.seat + "\t" + show.level + "\t" + show.Preference + "\n");
		}
	}

	public void SaveCustListEco() throws IOException {
		try {
			System.out.println("This is in the Final SaveCustListEco of All_EcoocustList:** ");
			ShowAllCust();

			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("CuEcoList.txt")));

			// System.out.println("This is size of EcocustList.size:
			// "+ALL_CusList.size());

			for (int i = 0; i < ALL_CusList.size(); i++) {

				bw.write(ALL_CusList.get(i).name + " " + ALL_CusList.get(i).seat + " " + ALL_CusList.get(i).level + " "
						+ ALL_CusList.get(i).Preference);
				bw.newLine();
			}
			bw.close();
		} catch (FileNotFoundException e) {
			System.out.println("Exception from the SaveCustListEco emthod in Eco class.\n");
		}
	}

	public void populate_flightList() throws IOException, FileNotFoundException {
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

			// This is populating to the All customer economy arrylist:
			customer a = new customer(name, seat, level, prefer);
			ALL_CusList.add(a);
			System.out.println("This is int he populate list fo All Cust list : ");
			ShowAllCust();
			if (level.contentEquals("Economy")) {

				// this will handle the w , m and A seat count:
				if (prefer.contentEquals("W")) {
					Ecount_W++;
					countAllSeat++;
					countEcoAll++;
					customer c = new customer(name, seat, level, prefer);
					EWcustList.add(c);
					int index = tranSeat.tranlateWIndex(seat);

					windowSeat[index] = true;// this line is updating the
												// windwSeat array

				} else if (prefer.contentEquals("M")) {
					Ecount_M++;
					countAllSeat++;
					countEcoAll++;
					customer c = new customer(name, seat, level, prefer);
					EMcustList.add(c);
					int index = tranSeat.tranlateMIndex(seat);

					middleSeat[index] = true;

				}

				else if (prefer.contentEquals("A")) {
					Ecount_A++;
					countAllSeat++;
					countEcoAll++;
					customer c = new customer(name, seat, level, prefer);
					EAcustList.add(c);
					int index = tranSeat.tranlateAIndex(seat);

					windowSeat[index] = true;
				}

			} else {
				if (prefer.contentEquals("W")) {
					Fcount_W++;
					countFAll++;
					countAllSeat++;
					customer c = new customer(name, seat, level, prefer);
					FWcustList.add(c);
					int index = tranSeat.tranlateWIndexF(seat);

					FwindowSeat[index] = true;// this line is updating the
												// windwSeat array

				} else if (prefer.contentEquals("A")) {
					Fcount_A++;
					countAllSeat++;
					countFAll++;
					customer c = new customer(name, seat, level, prefer);
					FAcustList.add(c);
					int index = tranSeat.tranlateAIndexF(seat);

					FAisaelSeat[index] = true;
				}

			}

		}
		read.close();
	}

	// This is only one for Eco and First class
	public void BoosofCancleEco() { // find customer in the All eco array List.

		try {
			Scanner in = new Scanner(System.in);

			System.out.println("Enter your name: ");
			String name = in.nextLine();
			System.out.println("Your name is :" + name);
			for (int i = 0; i < ALL_CusList.size(); i++) {

				if (ALL_CusList.get(i).name.contentEquals(name)) {
					System.out.println("name in i is " + ALL_CusList.get(i).name);
					System.out.println(" Theere is the customer name: " + name);
					String temp = ALL_CusList.get(i).seat;

					System.out.println("Your seat is: " + temp);

					String level = (ALL_CusList.get(i).level);

					if (level.contentEquals("Economy"))
						;
					{
						deleteSeat(temp, name);
						fixAllEcoList(name);
						countEcoAll--;

					}

					{
						deleteSeatF(temp, name);
						fixAllFirstList(name);
						countFAll--;
					} // send level to delete Seat

					ALL_CusList.remove(i);
					countAllSeat--;

					return;
				}
			}

			System.out.println(" No such name\n");

		} catch (Exception e) {
			System.out.println("Exception occur in seat choice of boss of Cancel economy Class.");
		}
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
	// name from the scanners
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

				System.out
						.println("I am in the resvWindowSeat before increase it: Ecount_W here is : " + this.Ecount_W);// just
																														// testing
				Ecount_W++;// update the window seat
				countAllSeat++;// update the total seat
				System.out.println("countAllSeat= " + countAllSeat);
				System.out.println("Ecount_W= " + Ecount_W);
				System.out.println("This is windowSeat[" + i + "]:" + windowSeat[i]);

				temp = i;
				break;
			}
		}
		showWindow();

		return temp;// the array index will return to the caller
	}

	private int resvWindowSeatF() {
		int i;
		int temp = 0;
		for (i = 0; i < Fwindow_Seat; i++) {
			if (!(FwindowSeat[i])) {
				FwindowSeat[i] = true;

				System.out
						.println("I am in the resvWindowSeat before increase it: Fcount_W here is : " + this.Fcount_W);// just
																														// testing
				Fcount_W++;// update the window seat
				countFAll++;// update the total seat
				System.out.println("countFAll= " + countFAll);
				System.out.println("Fcount_W= " + Fcount_W);
				System.out.println("This is windowSeat[" + i + "]:" + FwindowSeat[i]);

				temp = i;
				break;
			}
		}
		showWindowF();

		return temp;// the array index will return to the caller
	}

	private int resvMiddleSeat() {
		int i;
		int temp = 0;
		for (i = 0; i < middle_Seat; i++) {
			if (!(middleSeat[i])) {
				middleSeat[i] = true;

				System.out
						.println("I am in the resvMiddleSeat before increase it: Ecount_M here is : " + this.Ecount_M);// just
																														// testing
				Ecount_M++;// update the window seat
				countAllSeat++;// update the total seat
				System.out.println("countAllSeat= " + countAllSeat);
				System.out.println("Ecount_M= " + Ecount_M);
				System.out.println("This is middleSeat[" + i + "]:" + middleSeat[i]);

				temp = i;
				break;
			}
		}

		// ******come back here******
		showMiddle();
		// System.out.println("ATT:::::This is i in the resvWindowSeat: " + i);
		return temp;// the array index will return to the caller
	}

	private int resvAisealSeat() {
		int i;
		int temp = 0;
		for (i = 0; i < aiseal_Seat; i++) {
			if (!(AisaelSeat[i])) {
				AisaelSeat[i] = true;

				System.out
						.println("I am in the resvAisealSeat before increase it: Ecount_A here is : " + this.Ecount_A);// just
																														// testing
				Ecount_A++;// update the window seat
				countAllSeat++;// update the total seat
				System.out.println("countAllSeat= " + countAllSeat);
				System.out.println("Ecount_A= " + Ecount_A);
				System.out.println("This is AisealSeat[" + i + "]:" + AisaelSeat[i]);

				temp = i;
				break;
			}
		}

		showAiseal();

		return temp;// the array index will return to the caller
	}

	private int resvAisealSeatF() {
		int i;
		int temp = 0;
		for (i = 0; i < Faiseal_Seat; i++) {
			if (!(FAisaelSeat[i])) {
				FAisaelSeat[i] = true;

				System.out
						.println("I am in the resvAisealSeat before increase it: Fcount_A here is : " + this.Fcount_A);// just
																														// testing
				Fcount_A++;// update the window seat
				countFAll++;// update the total seat
				System.out.println("countFAll= " + countFAll);
				System.out.println("Fcount_A= " + Fcount_A);
				System.out.println("This is AisealSeat[" + i + "]:" + FAisaelSeat[i]);

				temp = i;
				break;
			}
		}

		showAisealF();

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
	private Economy_FirstClass(String seat) {
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

	public boolean isFlightFulllyBooked() {
		System.out.println("This is in the isFlightFullyBooked: countAllseat: " + countAllSeat);
		System.out.println("This is in the isFullyBooked: ETotalSeat: " + ETotalSeat);
		if (countAllSeat < ETotalSeat)
			return true; // it is not full, return true
		else
			return false;// it full, return false

	}

	public boolean isFullyBookedEco() {
		System.out.println("This is in the isFullyBooked: coutTotalSeat: " + countAllSeat);
		System.out.println("This is in the isFullyBooked: ETotalSeat: " + ETotalSeat);
		if (countAllSeat < ETotalSeat)
			return true; // it is not full, return true
		else
			return false;// it full, return false

	}

	public boolean isFulllyBookedF() {
		System.out.println("This is in the isFullyBooked first Class: coutTotalSeatF: " + countFAll);
		// System.out.println("This is in the isFullyBooked: ETotalSeat: "+
		// ETotalSeat);
		if (countFAll < FTotalSeat)
			return true; // it is not full, return true
		else
			return false;// it full, return false

	}

	private boolean isWindowSeatFull() {
		System.out.println("Count_W is: " + Ecount_W);

		if (Ecount_W < window_Seat)
			return false;// is not full
		else
			return true;// it is full

	}

	private boolean isMiddleSeatFull() {

		if (Ecount_M < middle_Seat)
			return false;// is not full
		else
			return true;// it is full

	}

	private boolean isAisealSeatFull() {
		if (Ecount_A < aiseal_Seat)
			return false;// is not full
		else
			return true;// it is full

	}

	// ****************first Class**************************
	private boolean isWindowSeatFullF() {
		System.out.println("Count_WFis: " + Fcount_W);

		if (Fcount_W < Fwindow_Seat)
			return true;// is not full
		else
			return false;// it is full

	}

	private boolean isAisealSeatFullF() {
		if (Fcount_A < Faiseal_Seat)
			return true;// is not full
		else
			return false;// it is full

	}

	public void showWindow() {
		for (int i = 0; i < windowSeat.length; i++) {
			System.out.println("Window Seat with true and faluse: " + windowSeat[i] + "\n");
		}

	}

	public void showMiddle() {
		for (int i = 0; i < middleSeat.length; i++) {
			System.out.println("Middle Seat with true and false: " + middleSeat[i] + "\n");
		}

	}

	public void showAiseal() {
		for (int i = 0; i < AisaelSeat.length; i++) {
			System.out.println("Aiseal Seat with true and false: " + AisaelSeat[i] + "\n");
		}

	}

	public void showWindowF() {
		for (int i = 0; i < FwindowSeat.length; i++) {
			System.out.println("Window Seat with true and faluse: " + FwindowSeat[i] + "\n");
		}

	}

	public void showAisealF() {
		for (int i = 0; i < FAisaelSeat.length; i++) {
			System.out.println("Aiseal Seat with true and false: " + FAisaelSeat[i] + "\n");
		}

	}

	// This will find the seat in the specific window array, m array and A array
	public void deleteSeat(String seat, String name) {
		// if string has A or F go to W array

		// else if string has B or E go to M array

		// else if string has c or D go to Aiseal array

		//
		int index = tranSeat.tranlateWIndex(seat);

		if ((seat.indexOf("A") >= 0) || (seat.indexOf("F") >= 0)) {
			System.out.println("This seat is from the Window class\n");
			// find that index in the window array.
			windowSeat[index] = false;
			Ecount_W--;

			fixWcustList(name);

		} else if ((seat.indexOf("B") >= 0) || (seat.indexOf("E") >= 0)) {
			System.out.println("This seat is from the Middle class\n");
			// find that index in the window array.
			middleSeat[index] = false;
			Ecount_M--;

			fixMcustList(name);

		} else if ((seat.indexOf("C") >= 0) || (seat.indexOf("D") >= 0)) {
			System.out.println("This seat is from the Aiseal class\n");
			// find that index in the window array.
			AisaelSeat[index] = false;
			Ecount_A--;

			fixAcustList(name);
		}
		System.out.println("This is from delete Seat: countAllSeat before --:" + countAllSeat);

		System.out.println("This is from delete Seat: countAllSeat after --:" + countAllSeat);
	}

	// **********************first Class**********************

	public void deleteSeatF(String seat, String name) {
		// if string has A or F go to W array

		// else if string has B or E go to M array

		// else if string has c or D go to Aiseal array
		int index = tranSeat.tranlateWIndex(seat);

		if ((seat.indexOf("A") >= 0) || (seat.indexOf("D") >= 0)) {
			System.out.println("This seat is from the Window class\n");
			// find that index in the window array.
			FwindowSeat[index] = false;
			Fcount_W--;

			fixWcustListF(name);

		} else if ((seat.indexOf("B") >= 0) || (seat.indexOf("C") >= 0)) {
			System.out.println("This seat is from the Aiseal class\n");
			// find that index in the window array.
			FAisaelSeat[index] = false;
			Fcount_A--;

			fixAcustListF(name);
		}
		System.out.println("This is from delete Seat: countAllSeat before --:" + countFAll);

		System.out.println("This is from delete Seat: countAllSeat after --:" + countFAll);
	}

	// *************frist Class***************************

	// this method should call from the boss of cancel with given customer's
	// name to cancel
	public void fixWcustList(String s) {

		for (int i = 0; i < EWcustList.size(); i++) {

			if (EWcustList.get(i).name.contentEquals(s)) {
				System.out.println("name in i is " + EWcustList.get(i).name);
				EWcustList.remove(i);
			}

		}
	}

	public void fixWcustListF(String s) {

		for (int i = 0; i < FWcustList.size(); i++) {

			if (FWcustList.get(i).name.contentEquals(s)) {
				System.out.println("name in i is " + FWcustList.get(i).name);
				FWcustList.remove(i);
			}

		}
	}

	public void fixMcustList(String s) {

		for (int i = 0; i < EMcustList.size(); i++) {

			if (EMcustList.get(i).name.contentEquals(s)) {
				System.out.println("name in i is " + EMcustList.get(i).name);
				EMcustList.remove(i);
			}

		}
	}

	public void fixAcustList(String s) {

		for (int i = 0; i < EAcustList.size(); i++) {

			if (EAcustList.get(i).name.contentEquals(s)) {
				System.out.println("name in i is " + EAcustList.get(i).name);
				EAcustList.remove(i);
			}

		}
	}

	public void fixAcustListF(String s) {

		for (int i = 0; i < FAcustList.size(); i++) {

			if (FAcustList.get(i).name.contentEquals(s)) {
				System.out.println("name in i is " + FAcustList.get(i).name);
				FAcustList.remove(i);
			}

		}
	}

	public void fixAllEcoList(String s) {

		for (int i = 0; i < All_EcoList.size(); i++) {

			if (All_EcoList.get(i).name.contentEquals(s)) {
				System.out.println("name in i is " + All_EcoList.get(i).name);
				All_EcoList.remove(i);
			}

		}
	}

	public void fixAllFirstList(String s) {

		for (int i = 0; i < ALL_FList.size(); i++) {

			if (ALL_FList.get(i).name.contentEquals(s)) {
				System.out.println("name in i is " + ALL_FList.get(i).name);
				ALL_FList.remove(i);
			}

		}
	}

	// **********************************First Class Start
	// Here*********************************************************//

	public void BossOfFirstClass() {
		try {
			int temp;
			Scanner in = new Scanner(System.in);
			// if first class full?
			if (!isFulllyBookedF()) {
				System.out.println("It is full, choose another class!");
				return;
			}

			else {
				System.out.println("It is avaiable");
				System.out.println("Please Enter your preference seat: 1 for Window, 3 for Aiseal:");
				temp = in.nextInt();
				System.out.println("You enter this : " + temp);
				// testing for window seat full?
				if (temp == 1) {
					// call isfullWindow method
					if (!isWindowSeatFullF()) {
						System.out.println("First class Window seats are full");
						return;
					}

					else {
						System.out.println("You will have your window seat in first Class");

						// the window seat array and assign the first founded
						// window

						int recordIndex = resvWindowSeatF();// this will assign
															// the
															// seat
															// and return the
															// index
															// value of the
															// array
						System.out.println("This is the assigned seat in the window array seat, index: " + recordIndex);
						// Here call the translator(method) of array index to
						// real
						// flight seat number.

						String s = tranSeat.tranlateWF(recordIndex);
						System.out.println("This is real seat: " + s);

						// Now call for the customer object ArrayList to send,
						// custoemr
						// name, class and seat
						String name = getname();
						System.out.println("This is your name: " + name);

						// method call to set customer arraylist
						makeCustListWF(name, s, "First_Class", "W");// "W" and
																	// Economy
						// will
						// change according
						// the method call.

						makeAllCustList(name, s, "First_Class", "W");
						makeAllFirsitList(name, s, "First_Class", "W");
						return;
					}

				}

				else if (!isAisealSeatFullF()) {
					System.out.println("First class Aiseal seats are full");
					return;

				} else {
					System.out.println("You will have your Aiseal seat");

					int recordIndex = resvAisealSeatF();
					System.out.println("This is the assigned seat in the Aiseal array seat, index: " + recordIndex);
					// Here call the translator(method) of array index to real
					// flight seat number.

					String s = tranSeat.tranlateAF(recordIndex);
					System.out.println("This is real seat: " + s);

					String name = getname();// is that a test? missing a purpose
					System.out.println("This is your name: " + name);
					// method call to set customer arraylist
					makeCustListAF(name, s, "First_Class", "A");// "W" and
																// Economy will
					// change according to
					makeAllCustList(name, s, "First_Class", "A"); // the method
					makeAllFirsitList(name, s, "First_Class", "A"); // call.
					// System.out.println("This is from the Aiseal Seat in boos
					// of econmy: ");

					ShowAllCust();
					return;
				}
			}

		} catch (Exception e) {
			System.out.println("Exception occur in seat choice of boss of first Class.");
		}

	}

}
