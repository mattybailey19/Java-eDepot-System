package system;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Depot implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final String PATH = "";

	List<Driver> drivers = new ArrayList<Driver>();
	// final List<Manager> managers = new ArrayList<Manager>();
	final List<WorkSchedule> schedules = Collections.synchronizedList(new ArrayList<WorkSchedule>());
	final List<Vehicle> vehicles = new ArrayList<Vehicle>();
	private String location;

	// Vehicles broken down into two separate ArrayLists of its children, to enable
	// instantiation.
	final static List<Truck> trucks = new ArrayList<Truck>();
	final static List<Tanker> tankers = new ArrayList<Tanker>();

	public Depot() {
		//deSerialize();
		/*
		// Adding all mangers to the serialized data.
		drivers.add(new Manager("GlynofLpool", "GH1234"));
		drivers.add(new Manager("SorrenofMchester", "SH5678"));
		drivers.add(new Manager("JoeofLeeds", "J1234"));

		// Adding all drivers to the serialized data.
		drivers.add(new Driver("Mark", "MK123"));
		drivers.add(new Driver("Kirsty", "KY456"));
		drivers.add(new Driver("Andy", "AY789"));

		// Adding all vehicles to the serialized data - only need one of each type to
		// test.
		vehicles.add(new Truck("1234", "astra", "1", 100, 200));
		vehicles.add(new Tanker("2345", "ford", "2", 100, 200, "oil"));
		vehicles.add(new Tanker("3456", "kia", "3", 100, 200, "petrol"));
		*/
		//serialize();
	}

	public Depot(String depot) {

		this.location = depot;
	}

	// Needs to deSerialize all ArrayLists - drivers, vehicles, schedules maybe? -
	// Matt
	private void deSerialize() {
		ObjectInputStream ois;

		try {
			ois = new ObjectInputStream(new FileInputStream(PATH + "drivers.ser"));

			drivers = (List<Driver>) ois.readObject();
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void serialize() {
		ObjectOutputStream oos;

		try {
			oos = new ObjectOutputStream(new FileOutputStream("./drivers.ser"));
			oos.writeObject(drivers);
			// We could do with putting this in finally, but we then need a throws about
			// everywhere
			oos.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean logOn(String username, String password) {
		// Moving through all driver details
		for (int i = 0; i < drivers.size(); i++)
			if (drivers.get(i).username.equals(username) && drivers.get(i).password.equals(password)) {
				return true;
			}
		return false;
	}

//	public boolean logOnAsManager(String username, String password) {
//		for (int i = 0; i < managers.size(); i++)
//			if (managers.get(i).username.equals(username) && managers.get(i).password.equals(password)) {
//				return true;
//			}
//		return false;
//	}

	public String getLocation() {
		return location;
	}

	public void createSchedule(WorkSchedule workSchedule) {
		schedules.add(workSchedule);

	}

	public Driver getDriverByName(String name) {
		for (Driver d : drivers) {
			if (d.getUserName().equals(name)) {
				return d;
			}
		}
		return null;
	}

	public Vehicle getVehicleByRegNo(String regNo) {
		for (Vehicle v : vehicles) {
			if (v.getRegNo().equals(regNo)) {
				return v;
			}
		}
		return null;
	}

}