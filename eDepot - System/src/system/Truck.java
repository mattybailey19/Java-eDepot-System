package system;

/**
 * System class Truck inherits from the Vehicle class, which extends the
 * Vehicle class variables and declares them as super.
 * 
 * @author Matt Bailey, Joe Macneil, Liam Clarke.
 * @version 1.0.
 */
public class Truck extends Vehicle {

	//Declared private variables that can be accessed outside the class, if public getter methods are present in the class.
	private int cargoCapacity;

	public Truck(String regNo, String make, String model, int weight, int cargoCapacity) {
		super(regNo, make, model, weight);

		// Declare a this.variable to allow the current object to be called.
		this.cargoCapacity = cargoCapacity;
	}

	/**
	 * Declares a 'getCargoCapacity', to allow the private variable to be accessed by a java class.
	 * @param <T>
	 */
	public <Vehicle> int getCargoCapacity() {
		return cargoCapacity;
	}

	/**
	 * Declare a 'setCargoCapacity', to allow the private variable to be accessed and update the value in a java class. 
	 * @param cargoCapacity
	 */
	public void setCargoCapacity(int cargoCapacity) {
		this.cargoCapacity = cargoCapacity;
	}
	
	/**
	 *  Declare a 'toStringheader' to print and format a message alongside the variable types when executed.
	 */
	@Override
	public String toString() {
		return "Reg No: " + regNo + " | Make: " + make + " | Model: " + model + " | Weight: " + weight + " | Cargo Capacity: " + cargoCapacity;
	}

}
