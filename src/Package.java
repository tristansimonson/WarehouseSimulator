import java.util.ArrayList;

// class for package details
public class Package {
	int weight;
	int width;
	int height;
	int depth;
	int id;
	int priority;
	Status status;
	User receiver;
	User sender;
	Queue priorityQueue;
	ArrayList<Product> contents = new ArrayList<Product>();

	// create a package with specified details
	public void newPackage(int we, int wi, int h, int d, int id, int p, Status status, User r, User s) {
		this.weight = we;
		this.width = wi;
		this.height = h;
		this.depth = d;
		this.id = id;
		this.status = Status.READY;
		this.priority = p;
		this.receiver = r;
		this.sender = s;
		this.contents = new ArrayList<Product>();
	}
	
	// adds product to package
	public void fillPackage(Product p) {
		if(checkDimensions(this, p)) {
		    this.weight += p.weight;
		}
	}
	
	public static boolean checkDimensions(Package pack, Product prod) {
		if(pack.height > prod.height && pack.width > prod.width && pack.depth > prod.depth) {
			return true;
		}
		return false;
	}
	
	// adds package to queue
	public void addPackage(Package p) {
		priorityQueue.addToQueue(p);
	}
	
	// removes package from queue
	public void removePackage(int id) {
		priorityQueue.removeFromQueue(id);
	}
}
