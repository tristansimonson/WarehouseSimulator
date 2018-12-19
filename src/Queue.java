import java.util.ArrayList;

// class for dealing with package processing, ordered by priority
public class Queue {
	ArrayList<Package> queue = new ArrayList<Package>();
	
	// add item to the queue
	public void addToQueue(Package p) {
		queue.add(p);
		// temp list to hold values while sorting
		ArrayList<Package> tempQueue = new ArrayList<Package>();
		Package min = queue.get(0);
		int position = 0;
		// order queue by priority
		for(int i = 0; i < queue.size(); i++) {
			for(int j = 0; j < queue.size(); j++) {
				Package pos = queue.get(j);
			    if(pos.priority > min.priority && pos.id != min.id && pos.status == Status.READY) {
				    position = j;
			    	min = queue.get(j);
			    }
			}
			queue.get(position).status = Status.PROCESSING;
			tempQueue.add(queue.get(position));
		}
		queue = tempQueue;
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
		}
		queue = new ArrayList<Package>();
		System.out.println("Processing done...");
	}
}
