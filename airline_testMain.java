package airline;

public class airline_testMain {
	
	
	public static void main(String[] args){
	economy_Class cust_1 = new economy_Class();
	
	cust_1.displayArray();
	cust_1.reserved_seat();
	
	System.out.println("After reserve");
	cust_1.displayArray();
	System.out.println();
	
	if (cust_1.isEmpty(1, 0)) //this test if the seat is occupied that will return true if occupied, if not false
	System.out.println("Is Empty");
	else
		System.out.println("It is occupied");
	
	
	}	
	

}
