// main class
public class Warehouse_Simulator {
	
	public static void main(String[] args) {
		Product pencil = new Product();
		pencil = pencil.newProduct("Pencil", "Lead and wood", "Ticondoroga", "8675309", 0.1, 8.0, 0.25, 0.25);
		
		User Jim = new User();
		Jim = Jim.newUser(101, "Jim", "Halpert", "360 Nonyabusiness Rd, Ashland, WI 12345");
		User John = new User();
		John = John.newUser(102, "John", "Appleseed", "420 Lebowski Dr, Seattle, WA 54321");
		
		Package package1 = new Package();
		package1 = package1.newPackage(12.0, 12.0, 12.0, 10000, 1, Jim, John);
		package1.fillPackage(pencil);
		
		Queue priorityQueue = new Queue();
		priorityQueue.addToQueue(package1);
		priorityQueue.processQueue();
	}
}
