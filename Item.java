/**
 * 
 * @author Shai Aarons
 * This is a class used to store a data item of the time series of power usage for a suburban dwelling in an array of objects
 *
 */
public class Item {
	
	private String date;
	private double power;
	private double voltage;
	
	
	/**
	 * 
	 * @param date - used to store the date recorded
	 * @param power - used to store the global active power
	 * @param voltage - used to store the voltage used by the person
	 */
	public Item(String date, double power, double voltage) {
		this.date = date;
		this.power = power;
		this.voltage = voltage;
	}
	
	/**
	 * Used as a no-args constructor
	 */
	public Item() {
		date = null;
		power = 0;
		voltage = 0;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}

	public double getVoltage() {
		return voltage;
	}

	public void setVoltage(double voltage) {
		this.voltage = voltage;
	}
	
	

}
