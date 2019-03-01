import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PowerBSTApp {
	private static BinarySearchTree<Item> x = new BinarySearchTree<>();
	
	public static void printAllDateTimes() {
		x.inOrder();
		
	}
	
	public static void printDateTime(String dateTime) {

		if (x.find(dateTime)==null) {
			System.out.println("Date/time not found");
		}else {
			System.out.println(x.find(dateTime));
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
				Item temp = new Item(date,power,voltage);
				x.insert(temp);
				
				
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
			String output = "Amount of comparison operations completed:\t"+x.getOpCount();
			BufferedWriter writer;
			writer = new BufferedWriter(new FileWriter("BSTPerformance.txt"));
		
			 writer.write(output);
			 writer.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}//end of main

}//end of class
