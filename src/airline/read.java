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

				System.out.println(c.name + " " + c.seat + " " + c.level + " " + c.preference + " ");
			}
			read.close();

			
		}

		
	}
			


	

