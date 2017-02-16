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
	int countTotalSeat=0;
	
	boolean[][] custArray = new boolean[4][4];
	ArrayList<customer> eco_custo = new ArrayList<customer>();

	// default constructor
	public economy_Class() {
		seat = " ";
		for (int i = 0; i < custArray.length; i++) {
			for (int j = 0; j < custArray.length; j++) {
				custArray[i][j] = false;//it is empty
			}
		}
	}

	// display for default economy class customer array(custArray)
	public void displayArray() {
		for (int i = 0; i < custArray.length; i++) {
			for (int j = 0; j < custArray.length; j++) {
				System.out.print(custArray[i][j] + " ");
			}
		}
	}

	// Constructor with String seat argument
	public economy_Class(String seat) {
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
	public void reserved_seat() {

		custArray[0][2] = true;//make it occupied
		custArray[2][3] = true;

	}

	// This method will search in the economy seat
	public boolean isEmpty(int row, int colum)
	{
		if (!(custArray[row][colum]))//not false is true means occupied
		return true;//it is occupied
		else
		return false;//it is not occupied
	}

	// This method will take the customer name, seat and classOfService
	public void makeList() {
		eco_custo.add(new customer("David", "1A", "Economy", "W"));
		eco_custo.add(new customer("Naccy", "1C", "Economy", "W"));

	}

	public void fillCustomArray(int row, int coloum) {

	}
	
	public void convert_To_Flight_Seat(int row, int cloum){
		
		//This method have to convert the row and cloum to the plance seat 
		//such as 1A, 2B, 20D , ect..
		
	}

}
