import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Shai Aarons
 * This is the application used to read in values from a CSV file and store them to an unsorted array
 *
 */
public class PowerArrayApp {
	private static Item items[] = new Item[500];
	
	
	
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
				System.out.println(items[i].getDate()+"\t"+items[i].getPower()+"\t"+items[i].getVoltage());
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
	
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(args.length==0) {
			printAllDateTimes();
		}else {
			printDateTime(args[0]);
			
		}
		
		
		
		
		

	}

}
