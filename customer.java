package airline;

import java.io.Serializable;

/**
 This is generic customer class (super) for individual and group
 This class is for customer and all atrributes of the customer 
 are initialized here.
 @ parameter name will be the key object handler.
 @ parameter seat
 @ paramter seatPreference
 @paramter Class;
 */


public class customer implements Serializable {//For the purpose of write to file, must implement this)

	//Filed attributes
	String name; //customer name
	String seat;// 1A, 4D, etc.(This will assign by the program from the avaiable seat)
	String Preference; //window(w), center(c), middle(m)
	String level;//First class, Economy Class
	//default Constructor 
	public customer()
	{
		name =" ";
		seat = " ";
		Preference =" ";
		level =" ";
				
	}
	
	public customer (String name, String seat, String level, String Preference)
	{
		this.name = name;
		this.level = level;
		this.seat = seat;
		this.Preference = Preference;
	}
	
	
}
