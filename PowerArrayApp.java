import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Shai Aarons
 * This is the application used to read in values from a CSV file and store them to an unsorted array
 *
 */
public class PowerArrayApp {
	private static Item items[] = new Item[500];
	private static int opCount = 0;
	
	
	
	public static void printAllDateTimes() {
		for(int i = 0; i<items.length;i++) {
			System.out.println(items[i].getDate());
		}
	}
	
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
			String output = "Amount of comparison operations completed:\t"+opCount;
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
