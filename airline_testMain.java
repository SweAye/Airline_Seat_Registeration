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
	
	System.out.println();
	
	cust_1.displaySeatINFormat();
	
	//This is testing how String seat is assign to the seat array
	int index = cust_1.assignSeat("1A");//this index variable will go to Customer object's seat field variable
	System.out.println("This is the seat index : " +index);
	
	
	//system checking if there is such seat
	if	(cust_1.istherSeat("33B"))
	{
		System.out.println("Yes, there is ");
	}
	else
		System.out.println("No, there is not ");
	}	
	

}
