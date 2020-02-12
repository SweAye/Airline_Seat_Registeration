package airline;
	import java.io.*;
	import java.util.*;

	public class file_write {

		public static void main(String []args)throws IOException, FileNotFoundException{
			ArrayList<customer> custList = new ArrayList<customer>();
			custList.add(new customer("David", "A12", "Economy", "W"));
			custList.add(new customer("Naccy", "C12", "First", "M"));
			custList.add(new customer("Rohan", "D12", "Economy", "W"));
			custList.add(new customer("Rachel", "E12", "Economy", "M"));
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Customer_2.txt")));
			for(int i=0; i<custList.size(); i++){
				
				bw.write (custList.get(i).name + " " + custList.get(i).seat + " " +custList.get(i).level + " " + custList.get(i).preference);
				bw.newLine();
			}
			bw.close();
			
		}
	}


