import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * 
 * This is an application that reads in a CSV file called ‘cleaned_data.csv’ and uses a set of scanners to carefully extract the required information from the file to store into ‘Item’ objects. 
 * An array of objects is used in this class in order to ease the workload. 
 * So every time the scanner reads a new line of the CSV file, a new ‘Item’ object is created and stored into the fixed size array (500) of ‘Item’ objects
 * Just before the program terminates the opCount instance variable is stored in a text file called ArrayPerformance.txt
 * 
 * @author Shai Aarons
 */



public class PowerArrayApp {
	/**
	 * Stored in this class is a static instance variable called opCount which is used to measure the amount of comparison operations that occurs when one uses the printDateTime method to search for a specific date/time (used as the key) in the array of ‘Item’ objects
	 */
	
	

	private static Item items[] = new Item[500];
	private static int opCount = 0;
	
	
	/**
	 * The printAllDateTimes method returns a string output of all the date/times stored in the array of ‘Item’ objects.
	 */
	public static void printAllDateTimes() {
		for(int i = 0; i<items.length;i++) {
			System.out.println(items[i].getDate());
		}
	}
	
	/**
	 * The printDateTime method receives a String argument in the form of a specific date/time that the user is looking and returns a string with the information relating to that specific date/time using the toString method defined in the Item class by using the find method in the BinarySearchTree class. 
	 * @param dateTime used as the String passed to search for in the array of objects.
	 */
	
	public static void printDateTime(String dateTime) {
		boolean found = false;
		for(int i = 0;i<items.length;i++) {
			if(items[i].getDate().equalsIgnoreCase(dateTime)) {
				found = true;
				opCount++;
				System.out.println(items[i].getDate()+"\t"+items[i].getPower()+"\t"+items[i].getVoltage());
				break;
			}else {
				opCount++;
			}
		}
		if (found==false) {
			System.out.println("Date/time not found");
		}
	}
	
	
	
	
	

	public static void main(String[] args) {
		
		
		try {
			Scanner scan = new Scanner(new File("cleaned_data.csv"));
			String ignore = scan.nextLine();
			int count = 0;
			while(scan.hasNextLine()) {
				Scanner line = new Scanner(scan.nextLine()).useDelimiter(",");
				String date = line.next();
				double power = line.nextDouble();
				ignore = line.next();
				double voltage = line.nextDouble();
				items[count] = new Item(date, power, voltage);
				count++;
				
				
				
			}
	
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	     
	   
		if(args.length==0) {
			printAllDateTimes();
		}else {
			printDateTime(args[0]);
			
			
			
			
		}
		
		try {
			String output = ""+opCount;
			BufferedWriter writer;
			writer = new BufferedWriter(new FileWriter("arrayPerformance.txt"));
		
			 writer.write(output);
			 writer.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
