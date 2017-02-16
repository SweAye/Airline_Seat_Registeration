package airline;

public class first_class extends seat_chart {
	String [][] seat_chart = new String[3][3];
	String seat;
	boolean space;
	
	public first_class(){
		
	 seat = "";	
	 space = false;//empty
	}
	
	public boolean find_Seat(String preference){
		//if window preference, find in this [][] to this [][]
		//else if middle preference, find this in seat_chart [][] to [][] 
		//else 
		//not found your preference seat
		//if successful update or(set) seat number to objec.seat
		return space;//return success or not
	}
	public void reserved_seat(int row, int coloum){
		
		//after finding the seat assign seat as occupied space
	}
	
	
	public boolean cancel_seat(String seat){
		
		//Take string or int value for the seat and make space as unavaiable. 
		return space;
	}

}

