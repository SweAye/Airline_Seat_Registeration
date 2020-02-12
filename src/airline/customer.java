package airline;

import java.io.Serializable;

/**
 This is generic customer class (super) for individual and group
 This class is for customer and all attributes of the customer 
 are initialized here.
 @ parameter name will be the key object handler.
 @ parameter seat
 @ parameter seatPreference
 @parameter Class;
 */


public class customer implements Serializable {

	//Filed attributes
	String name; //customer name
	String seat;// 1A, 4D, etc.(This will assign by the program from the available seat)
	String preference; //window(w), center(c), middle(m)
	String level;//First class, Economy Class
	
	//default Constructor 
	public customer()
	{
		name =" ";
		seat = " ";
		preference =" ";
		level =" ";
				
	}
	
	public customer (String name, String seat, String level, String Preference)
	{
		this.name = name;
		this.level = level;
		this.seat = seat;
		this.preference = Preference;
	}
	
	
}
