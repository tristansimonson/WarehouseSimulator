import java.util.ArrayList;

// class for dealing with package processing, ordered by priority
public class Queue {
	ArrayList<Package> queue = new ArrayList<Package>();
	
	// add item to the queue
	public void addToQueue(Package p) {
		queue.add(p);
		Package temp;
        for (int i = 0; i < queue.size() - 1; i++) {
            for (int j = i + 1; j < queue.size(); j++) {
                if (queue.get(i).priority > queue.get(j).priority) {
                    temp = queue.get(j);
                    queue.set(j, queue.get(i));
                    queue.set(i, temp);
                }
            }
        }
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
			if(queue.size() > 1) {
				System.out.println("\n");
			}
			packageSummary(queue.get(i));
		}
		System.out.println("\n");
		queue = new ArrayList<Package>();
		System.out.println("Processing done...");
	}
	
	// package processing summary
	public static void packageSummary(Package p) {
		System.out.println("----------PACKAGE----------");
		System.out.println("Package #" + p.id);
		System.out.println("Tracking #" + p.tracking);
		System.out.println("Provider: " + p.carrier);
		System.out.println("Address: " + p.return_add.addressToString());
		System.out.println("Dimensions: " + p.height + " x " + p.width + " x " + p.depth);
		System.out.println("Weight: " + p.weight + "lbs");
		System.out.println("Sender: " + p.sender.last_name + ", " + p.sender.first_name);
		System.out.println("Recipient: " + p.receiver.last_name + ", " + p.receiver.first_name);
		System.out.println("----------CONTENT----------");
		for(int i = 0; i < p.contents.size(); i++) {
			productSummary(p.contents.get(i));
		}
		System.out.println("---------------------------");
		System.out.println("---------------------------");
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
