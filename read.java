package airline;
import java.io.*;
import java.util.*;

/**
 * Reading from the file and send them to ArrayList as object of customer.
 * 
 * @author Aye Swe
 *
 */

public class read {

	/*
	 * This file will be the first draft for the Air Line ticket reservation, need to fill up more
	 * ****************************************************************************************
	 * This code will read from the "customer.txt" file line by line representing as an object of a customer 
	 * object of customers are added to the ArrayList to their representing attribute from a single line demiminated by 
	 * a white space.
	 * ***********need to do stuff here**********************************
	 * Try a deleting an object with another method 
	 * Write back customer object to the file from the ArrayList.
	 * ******************************************************************************************
	 * Other method need toconstruct are two different two dimentional array for First Class and Economy class 
	 * and assign the desinated seat number.
	 * After the program is end (customer choose to quit the program)
	 */

	

		
		public static void main(String[] args) throws IOException, FileNotFoundException {

			ArrayList<customer> custList = new ArrayList<customer>();
			Scanner read = new Scanner(new File("Customer_2.txt"));
			String line =" ";
			String name, seat, level, prefer = "";
			while (read.hasNextLine()) {
				
				line = read.nextLine();
				
				String [] array = line.split("\\s+");
				name  = array[0];
				seat = array[1];
				level = array[2];
				prefer = array[3];

				customer c = new customer(name, seat, level, prefer);
				custList.add(c);

				System.out.println(c.name + " " + c.seat + " " + c.level + " " + c.Preference + " ");
			}
			read.close();

			
		}

		
	}
			/*
			while (read.hasNextLine()) {

				name = read.nextLine();
				seat = read.nextLine();
				level = read.nextLine();
				prefer = read.nextLine();

				Customer c = new Customer(name, seat, level, prefer);
				custList.add(c);

				System.out.println(c.name + " " + c.seat + " " + c.level + " " + c.Preference + " ");
			}
			read.close();

			for (int i = 0; i < custList.size(); i++) {

				System.out.println(custList.get(i).name + " " + custList.get(i).level + " " + custList.get(i).seat);
			}

		}
	*/


	

