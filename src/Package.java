import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

// class for package details
public class Package {
	double weight;
	double width;
	double height;
	double depth;
	int id;
	int priority;
	int tracking;
	Carrier carrier;
	Status status;
	Address return_add;
	Address receiving_add;
	User receiver;
	User sender;
	ArrayList<Integer> tracking_nums = new ArrayList<Integer>();
	ArrayList<Product> contents = new ArrayList<Product>();

	// create a package with specified details
	public Package newPackage(double w, double h, double d, int id, int p, Carrier c, User r, User s) {
		this.width = w;
		this.height = h;
		this.depth = d;
		this.id = id;
		this.tracking = generateTracking();
		this.status = Status.READY;
		this.priority = p;
		this.carrier = c;
		this.receiver = r;
		this.sender = s;
		this.return_add = sender.address;
		this.receiving_add = receiver.address;
		this.contents = new ArrayList<Product>();
		
		return this;
	}
	
	// generates ten digit tracking number and makes sure it is not a duplicate
	public int generateTracking() {
		boolean redo = true;
		int num = ThreadLocalRandom.current().nextInt(1000000000, 1099999999);
		// check if duplicate tracking numbers
		while(redo) {
			redo = false;
			for(int i = 0; i < tracking_nums.size(); i++) {
				if(tracking_nums.get(i) == num) {
					num = ThreadLocalRandom.current().nextInt(1000000000, 1099999999);
					redo = true;
				}
			}
		}
		tracking_nums.add(num);
		return num;
	}
	
	// adds product to package
	public void fillPackage(Product p) {
		if(checkDimensions(this, p)) {
		    this.weight += p.weight;
		    this.contents.add(p);
		}
	}
	
	public static boolean checkDimensions(Package pack, Product prod) {
		if(pack.height > prod.height && pack.width > prod.width && pack.depth > prod.depth) {
			return true;
		}
		return false;
	}
}
