/*
 * This class will be future private library of mine for translating things.
 */
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
			seat ="F10";
		
		else if (i==3)
			seat = "F11";
		
		else if (i==4)
			seat = "F12";
		
		
	return seat;
	}
	
	//This method translate "A10" to 0 and so on.
	public static int tranlateWIndex(String s)
	{
		int i=0;
		
		if(s.contentEquals("A10"))
			i = 0;
		
		else if (s.contentEquals("A11"))
			i= 1;
		
		else if (s.contentEquals("F10"))
			i= 2;
		
		else if(s.contentEquals("F11"))
			i = 3;
		
		else if (s.contentEquals("F12"))
			i= 4;
		
		else if (s.contentEquals("F13"))
			i= 5;
		
			return i;
	}
	

	//make middle seat translation
	public static String tranlateM(int i)
	{
		String seat="";
		
		if(i ==0)
			seat = "B10";
		
		else if (i==1)
			seat = "B11";
		
		else if (i==2)
			seat ="E10";
		
		else if (i==3)
			seat = "E11";
		
		else if (i==4)
			seat = "E12";
	return seat;
	}
	
	//This method translate "A10" to 0 and so on.
	public static int tranlateMIndex(String s)
	{
		int i=0;
		
		if(s.contentEquals("B10"))
			i = 0;
		
		else if (s.contentEquals("B11"))
			i= 1;
		
		else if (s.contentEquals("E10"))
			i= 2;
		
		else if(s.contentEquals("E11"))
			i = 3;
		
		else if (s.contentEquals("E12"))
			i= 4;
		
		else if (s.contentEquals("E13"))
			i= 5;
		
			return i;
	}

	public static String tranlateA(int i)
	{
		String seat="";
		
		if(i ==0)
			seat = "C10";
		
		else if (i==1)
			seat = "C11";
		
		else if (i==2)
			seat ="D10";
		
		else if (i==3)
			seat = "D11";
		
		else if (i==4)
			seat = "D12";
	return seat;
	}
	
	//This method translate "A10" to 0 and so on.
	public static int tranlateAIndex(String s)
	{
		int i=0;
		
		if(s.contentEquals("C10"))
			i = 0;
		
		else if (s.contentEquals("C11"))
			i= 1;
		
		else if (s.contentEquals("D10"))
			i= 2;
		
		else if(s.contentEquals("D11"))
			i = 3;
		
		else if (s.contentEquals("D12"))
			i= 4;
		
		else if (s.contentEquals("D13"))
			i= 5;
		//here continue define more seat number D23, D20, ect.
			return i;
	}

	
	
	
	
	//make aisel seat translation
	
}
