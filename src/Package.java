// class for package details
public class Package {
	int weight;
	int height;
	int depth;
	int id;
	int priority;
	Status status;
	User receiver;
	User sender;
	Queue priorityQueue;

	// create a package with specified details
	public void newPackage(int w, int h, int d, int id, int p, Status status, User r, User s) {
		this.weight = w;
		this.height = h;
		this.depth = d;
		this.id = id;
		this.status = Status.READY;
		this.priority = p;
		this.receiver = r;
		this.sender = s;
	}
	
	// adds package to queue
	public void addPackage() {
		
	}
}
