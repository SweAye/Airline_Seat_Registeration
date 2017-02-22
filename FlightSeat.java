package airline;

public class FlightSeat {
	
	//this method will translate window array index into the real window seat in flight
	public static String tranlateW(int i)
	{
		String seat="";
		
		if(i ==0)
			seat = "A10";
		
		else if (i==1)
			seat = "A11";
		
		else if (i==2)
			seat ="A12";
		
		else if (i==3)
			seat = "A13";
		
		else if (i==4)
			seat = "A14";
	return seat;
	}

	//make middle seat translation
	//make aisel seat translation
	
}
