package airline;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class First_Class {
	
	public class economy_Class {
		String seat;
		int countTotalSeat = 0;// This will back to 0 after testing

		FlightSeat tranSeat = new FlightSeat();// This will translate the array
												// index into real flight seat.

		// Four final count for seat, this cannot change//should make those more
		// object orientend(something like putting in the constructor or so)
		final int TotalSeat = 12;
		final int window_Seat = 4;// the seat number is = 40 seat per each w, m, and
									// A seats
		final int middle_Seat = 4;
		final int aiseal_Seat = 4;

		// counting window seat, middle seat and aiseal seat
		int count_W = 0;// These all will back to 0 after testing
		int count_M = 0;
		int count_A = 0;

		// Three array to to populate the seat request
		// This is just testing with arrayList???????Here testing

		ArrayList<customer> ALL_EcocustList = new ArrayList<customer>();// this is
																		// whole
																		// Economy
																		// ArrayList,
																		// mainly
																		// will
		// use in calcelation or searching for a customer's name, seat

		ArrayList<customer> WcustList = new ArrayList<customer>();// this Window
																	// customer
																	// arraylist

		ArrayList<customer> McustList = new ArrayList<customer>();// this middle
																	// seat customer
																	// arraylist

		ArrayList<customer> AcustList = new ArrayList<customer>();// this is Aiseal
																	// seat customer
																	// arraylist

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

		// may be make constructor to initialize the all hard code numbers;
		// default constructor
		// this will populated all three array with false(means there is no occupied
		// seat)
		public economy_Class() {
			seat = " ";
			for (int i = 0; i < windowSeat.length; i++) {
				windowSeat[i] = false;
				middleSeat[i] = false;
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
				if (isFulllyBooked())// if is false, it is not full, it is true
				{ // return, it is full
					System.out.println("It is avaiable");
					
				} else
					{System.out.println("It is full, choose another class!");
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
						makeCustListW(name, s, "Economy", "W");// "W" and Economy
																// will
																// change according
																// to
																// the method call.
						makeALL_EcocustList(name, s, "Economy", "W");
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
						makeALL_EcocustList(name, s, "Economy", "M");

						System.out.println("This is from the middle Sesat in boos of econmy: ");
						showAllEco();

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
					makeALL_EcocustList(name, s, "Economy", "A"); // the method
																	// call.
					System.out.println("This is from the Aiseal Seat in boos of econmy: ");
					showAllEco();
					return;
				}

			} catch (Exception e) {
				System.out.println("Exception occur in seat choice of boss of economy Class.");
			}

		}

		// This method will make customer list for whole economy class
		// customers(Window,middle, Aiseal)
		// Now it time to make whole customer profile
		private void makeCustListW(String name, String seat, String level, String pref) {

			customer newcust = new customer(name, seat, level, pref);

			WcustList.add(newcust);
			System.out.println("This is first customer profile :\n " + WcustList.get(0).name + "\t " + WcustList.get(0).seat
					+ "\t" + WcustList.get(0).level + "\t" + WcustList.get(0).Preference);

		}

		private void makeCustListM(String name, String seat, String level, String pref) {

			customer newcust = new customer(name, seat, level, pref);

			McustList.add(newcust);
			System.out.println("This is first customer profile :\n " + McustList.get(0).name + "\t " + McustList.get(0).seat
					+ "\t" + McustList.get(0).level + "\t" + McustList.get(0).Preference);

		}

		private void makeCustListA(String name, String seat, String level, String pref) {

			customer newcust = new customer(name, seat, level, pref);

			AcustList.add(newcust);
			System.out.println("This is first customer profile :\n " + AcustList.get(0).name + "\t " + AcustList.get(0).seat
					+ "\t" + AcustList.get(0).level + "\t" + AcustList.get(0).Preference);

		}

		private void makeALL_EcocustList(String name, String seat, String level, String pref) {

			customer newcust = new customer(name, seat, level, pref);

			ALL_EcocustList.add(newcust);

		}

		// This one will display the customer list fromt he custListArrayList

		public void showWcustList() {
			for (customer show : WcustList) {
				System.out.println(show.name + "\t" + show.seat + "\t" + show.level + "\t" + show.Preference + "\n");
			}
		}

		public void showAllEco() {
			for (customer show : ALL_EcocustList) {
				System.out.println(show.name + "\t" + show.seat + "\t" + show.level + "\t" + show.Preference + "\n");
			}
		}

		public void SaveCustListEco() throws IOException {
			try {
				System.out.println("This is in the Final SaveCustListEco of All_EcoocustList:** ");
				showAllEco();
				
				BufferedWriter bw = new BufferedWriter(new FileWriter(new File("CuEcoList.txt")));
				
				System.out.println("This is size of EcocustList.size: "+ALL_EcocustList.size());
				
				
				for (int i = 0; i < ALL_EcocustList.size(); i++) {
					
					bw.write(ALL_EcocustList.get(i).name + " " + ALL_EcocustList.get(i).seat + " "
							+ ALL_EcocustList.get(i).level + " " + ALL_EcocustList.get(i).Preference);
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

				// This is populating to the All customer economy arrylist:
				customer a = new customer(name, seat, level, prefer);
				ALL_EcocustList.add(a);
				System.out.println("This is int he populate list fo All Eco list : " );
				showAllEco();
				// this will handle the w , m and A seat count:
				if (prefer.contentEquals("W")){
					count_W++;
					countTotalSeat++;
					customer c = new customer(name, seat, level, prefer);
					WcustList.add(c);
					int index = tranSeat.tranlateWIndex(seat);

					windowSeat[index] = true;// this line is updating the
												// windwSeat array

				} else if (prefer.contentEquals("M")) {
					count_M++;
					countTotalSeat++;
					customer c = new customer(name, seat, level, prefer);
					McustList.add(c);
					int index = tranSeat.tranlateMIndex(seat);

					middleSeat[index] = true;

				}

				else if (prefer.contentEquals("A")) {
					count_A++;
					countTotalSeat++;
					customer c = new customer(name, seat, level, prefer);
					AcustList.add(c);
					int index = tranSeat.tranlateAIndex(seat);

					windowSeat[index] = true;
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

		public void BoosofCancleEco() { // find customer in the All eco array List.

			try {
				Scanner in = new Scanner(System.in);

				System.out.println("Enter your name: ");
				String name = in.nextLine();
				System.out.println("Your name is :" + name);
				for (int i = 0; i < ALL_EcocustList.size(); i++) {

					if (ALL_EcocustList.get(i).name.contentEquals(name)) {
						System.out.println("name in i is " + ALL_EcocustList.get(i).name);
						System.out.println(" Theere is the customer name: " + name);
						String temp = ALL_EcocustList.get(i).seat;
						System.out.println("Your seat is: " + temp);
						deleteSeat(temp, name);
						ALL_EcocustList.remove(i);

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

					System.out.println("I am in the resvWindowSeat before increase it: count_W here is : " + this.count_W);// just
																															// testing
					count_W++;// update the window seat
					countTotalSeat++;// update the total seat
					System.out.println("countTotalSeat= " + countTotalSeat);
					System.out.println("count_W= " + count_W);
					System.out.println("This is windowSeat[" + i + "]:" + windowSeat[i]);

					temp = i;
					break;
				}
			}
			showWindow();

			return temp;// the array index will return to the caller
		}

		private int resvMiddleSeat() {
			int i;
			int temp = 0;
			for (i = 0; i < middle_Seat; i++) {
				if (!(middleSeat[i])) {
					middleSeat[i] = true;

					System.out.println("I am in the resvMiddleSeat before increase it: count_M here is : " + this.count_M);// just
																															// testing
					count_M++;// update the window seat
					countTotalSeat++;// update the total seat
					System.out.println("countTotalSeat= " + countTotalSeat);
					System.out.println("count_M= " + count_M);
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

					System.out.println("I am in the resvAisealSeat before increase it: count_A here is : " + this.count_A);// just
																															// testing
					count_A++;// update the window seat
					countTotalSeat++;// update the total seat
					System.out.println("countTotalSeat= " + countTotalSeat);
					System.out.println("count_A= " + count_A);
					System.out.println("This is AisealSeat[" + i + "]:" + AisaelSeat[i]);

					temp = i;
					break;
				}
			}

			showAiseal();

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
			System.out.println("This is in the isFullyBooked: coutTotalSeat: "+ countTotalSeat);
			System.out.println("This is in the isFullyBooked: TotalSeat: "+ TotalSeat);
			if (countTotalSeat < TotalSeat)
				return true; //it is not full, return true
			else
				return false;// it full, return false

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

		// This will find the seat in the specific window array, m array and A array
		public void deleteSeat(String seat, String name) {
			// if string has A or F go to W array

			// else if string has B or E go to M array

			// else if string has c or D go to Aiseal array
			int index = tranSeat.tranlateWIndex(seat);

			if (seat.indexOf("A") >= 0) {
				System.out.println("This seat is from the Window class\n");
				// find that index in the window array.
				windowSeat[index] = false;
				count_W--;
				fixWcustList(name);

			} else if(seat.indexOf("B") >= 0) {
				System.out.println("This seat is from the Middle class\n");
				// find that index in the window array.
				middleSeat[index] = false;
				count_M--;
				fixMcustList(name);
			}
			else if	(seat.indexOf("C") >= 0) {
					System.out.println("This seat is from the Aiseal class\n");
					// find that index in the window array.
					AisaelSeat[index] = false;
					count_A--;
					fixAcustList(name);}
				System.out.println("This is from delete Seat: countTotalSeat before --:"+ countTotalSeat);
			countTotalSeat--;
			System.out.println("This is from delete Seat: countTotalSeat after --:"+ countTotalSeat);
		}

		// this method should call from the boss of cancel with given customer's
		// name to cancel
		public void fixWcustList(String s) {

			for (int i = 0; i < WcustList.size(); i++) {

				if (WcustList.get(i).name.contentEquals(s)) {
					System.out.println("name in i is " + WcustList.get(i).name);
					WcustList.remove(i);
				}

			}
		}
		public void fixMcustList(String s) {

			for (int i = 0; i < McustList.size(); i++) {

				if (McustList.get(i).name.contentEquals(s)) {
					System.out.println("name in i is " + McustList.get(i).name);
					McustList.remove(i);
				}

			}
		}
			
			public void fixAcustList(String s) {

				for (int i = 0; i < AcustList.size(); i++) {

					if (AcustList.get(i).name.contentEquals(s)) {
						System.out.println("name in i is " + AcustList.get(i).name);
						AcustList.remove(i);
					}

				}
			}
	}


}
