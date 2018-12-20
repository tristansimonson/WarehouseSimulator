import java.util.ArrayList;

// main class
public class Warehouse_Simulator {
	
	public static void main(String[] args) {
		Product pencil = new Product();
		pencil = pencil.newProduct("Pencil", "Lead and wood", "Ticondoroga", "8675309", 0.1, 8.0, 0.25, 0.25);
		
		Address add1 = new Address();
		add1 = add1.newAddress("123 Nonyabusiness Rd", "", "Ashland", "WI", "12345");
		User Jim = new User();
		Jim = Jim.newUser(101, "Jim", "Halpert", add1);
		Address add2 = new Address();
		add2 = add2.newAddress("420 Lebowski Dr", "Apt 4", "Seattle", "WA", "54321");
		User John = new User();
		John = John.newUser(102, "John", "Appleseed", add2);
		
		Package package1 = new Package();
		package1 = package1.newPackage(12.0, 12.0, 12.0, 10000, 1, Carrier.DHL, Jim, John);
		package1.fillPackage(pencil);		
		Package package2 = new Package();
		package2 = package2.newPackage(12.0, 12.0, 12.0, 10002, 3, Carrier.FEDEX, Jim, John);
		package2.fillPackage(pencil);
		Package package3 = new Package();
		package3 = package3.newPackage(12.0, 12.0, 12.0, 10001, 2, Carrier.USPS, Jim, John);
		package3.fillPackage(pencil);
		
		Queue priorityQueue = new Queue();
		ArrayList<Package> myList = new ArrayList<Package>();
		myList.add(package1);
		myList.add(package2);
		myList.add(package3);
		priorityQueue.addToQueue(myList);
		priorityQueue.processQueue();
	}
}
