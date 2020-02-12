/*
 * This class will act like a conductor between airline_testMain class and the rest of the helper classes.
 */
package airline;

import java.util.*;

import java.io.*;


public class Menu {
	Economy_FirstClass eco = new Economy_FirstClass();
	


	public  Menu(){
		
		//call the method to read a recorded file to populate the custLists(Eco and FirstClass)
		try{
			eco.populate_flightList();
		//this is just testing if the cust_list is correctly pouplated with  recorded file
			//System.out.println("****This is from window list");
			//eco.showWcustList();
			
			System.out.println("****This is from All customer list");
			eco.ShowAllCust();
			
			
		}catch (IOException e){
			System.out.println("Exception handle in menu constructor");
			}
}

	public void displayMenu() {
		try {
			
			char answer;
			do {
				Scanner in = new Scanner(System.in);

				// economy_Class eco = new economy_Class();
				// initiate the FirstClass here;

				char choice;// choice of service

				int temp;
				int temp2;

				System.out.println(
						"Welcome to the Airline System" + "\n" + "Please enter your choice of service." + "\n");
				System.out.println("1: Make a resvation" + "\n" + "2. To cancel the reservation" + "\n");
				System.out.print("Your Choice :");
				temp = in.nextInt();
				// System.out.println("This is you enter: " + temp);// just a
				// test
				// for
				if (temp == 1) {
					if (!eco.isFlightFulllyBooked())
					{
						System.out.println("Flight is Already booked, please choose the another flight:");
						
					}
					else

					{
							System.out.println(
					
							"Please choose service of class" + "\n" + "1. Economy Class." + "\n" + "2. First Class.");
					System.out.println("Your Choice:");
					temp2 = in.nextInt();
					// Another if for choosing eco or firstclass
					if (temp2 == 1) {
						System.out.println("Your want to reserve in Economy Class!:");

						// ?????????This is currently testing for the Boss of
						// Economy in Economy Class?????????????????
					
						
						
						eco.EconomyClassHelper();// should return, Economy class
													// is full.

					}

					else
						{
							System.out.println("You want to reserve in First Class!:");
							eco.BossOfFirstClass();
						}
						
						
					}
					
				} else
					{System.out.println("You want to cancel the reservation!");
					//this is cancleing now:
					eco.BoosofCancleEco( );}
					
					
				
				
					
				// This just repeating the menu
				System.out.println("Do you want to repeat the Menu? Y or N: ");
				answer = in.next().charAt(0);
				System.out.println("This is you enter: " + answer);

			} while (answer == 'Y');
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		eco.showWcustList();
		System.out.println(
				"This is from the menu class, test economy class's window list array still holding the data: "
						+ eco.windowSeat[0] + " " + eco.windowSeat[1]);
	try{
		eco.SaveCustListEco();

		}catch (IOException e){
			System.out.println("Exception handle in menue");
			}
	System.out.println("What up that all");
	}
	
	
}
	
	

/*
 * 
 * public void evaluateService(char service){ try{ char temp, temp2;
 * //System.out.println("service is : " + service); if (service == '1') {
 * System.out.println("Please choose service of class" + "\n"
 * +"1. Economy Class." +"\n" +"2. First Class.");
 * System.out.println("Enter: "); temp = (char)System.in.read();} if (temp ==
 * '1'){ System.out.println("You choose Economy Class: "); else
 * System.out.println("You choose First Class."); } else
 * System.out.println(" You want to cancel!"); }catch(IOException e){
 * 
 * System.out.println("exception occur in system.in at evaluate Service"); } }
 * 
 * public void evaluateLevel(char level) throws IOException { if (level == '1')
 * System.out.println("You choose Economy Class: "); //
 * eco.BossOfEconomyClass(); else System.out.println("You choose First Class:");
 * 
 * }
 */

/*
 * els if (class ==2) call other class's Boss
 * 
 * : : :
 * 
 * else if (choice =2) Call to cancelReservation : : : :
 * 
 * else if (choice=3) call some class
 * 
 * else if (choice=4) call some class
 * 
 */
