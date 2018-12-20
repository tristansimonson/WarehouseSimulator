import java.util.ArrayList;

// class for dealing with package processing, ordered by priority
public class Queue {
	ArrayList<Package> queue = new ArrayList<Package>();
	
	// add item to the queue
	public void addToQueue(Package p) {
		queue.add(p);
		// temp list to hold values while sorting
		ArrayList<Package> tempQueue = new ArrayList<Package>();
		Package min;
		Package pos;
		int location;
		// order queue by priority
		for(int i = 0; i < queue.size(); i++) {
			min = queue.get(i);
			location = i;
			for(int j = 0; j < queue.size(); j++) {
				pos = queue.get(j);
			    if(pos.priority > min.priority && pos.id != min.id && pos.status != Status.PROCESSING) {
				    location = j;
			    	min = queue.get(j);
			    }
			}
			queue.get(location).status = Status.PROCESSING;
			tempQueue.add(queue.get(location));
		}
		queue = tempQueue;
	}
	
	// add items to the queue
	public void addToQueue(ArrayList<Package> p) {
		for(int i = 0; i < p.size(); i++) {
			addToQueue(p.get(i));
		}
	}
	
	// remove item from queue
	public void removeFromQueue(int id) {
		for(int i = 0; i < queue.size(); i++) {
    		if(queue.get(i).id == id) {
    			queue.remove(i);
    		}
    	}
	}
	
	// process the queue
	public void processQueue() {
		System.out.println("Processing queue...");
		for(int i = 0; i < queue.size(); i++) {
			System.out.println("Processing package: #" + queue.get(i).id);
			packageSummary(queue.get(i));
		}
		queue = new ArrayList<Package>();
		System.out.println("Processing done...");
	}
	
	// package processing summary
	public static void packageSummary(Package p) {
		System.out.println("----------PACKAGE----------");
		System.out.println("Package #" + p.id);
		System.out.println("Dimensions: " + p.height + " x " + p.width + " x " + p.depth);
		System.out.println("Weight: " + p.weight + "lbs");
		System.out.println("Sender: " + p.sender.last_name + ", " + p.sender.first_name);
		System.out.println("Recipient: " + p.receiver.last_name + ", " + p.receiver.first_name);
		System.out.println("----------CONTENT----------");
		for(int i = 0; i < p.contents.size(); i++) {
			productSummary(p.contents.get(i));
		}
		System.out.println("----------CONTENT----------");
		System.out.println("----------PACKAGE----------");
	}
	
	// product processing summary
	public static void productSummary(Product p) {
		System.out.println("Product: " + p.name);
		System.out.println("Serial Number: " + p.serial_number);
		System.out.println("Description: " + p.description);
		System.out.println("Manufacturer: " + p.manufacturer);
		System.out.println("Dimensions: " + p.height + " x " + p.width + " x " + p.depth);
		System.out.println("Weight: " + p.weight + "lbs");
	}
}
