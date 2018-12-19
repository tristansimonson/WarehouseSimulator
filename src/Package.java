import java.util.ArrayList;

// class for package details
public class Package {
	double weight;
	double width;
	double height;
	double depth;
	int id;
	int priority;
	Status status;
	User receiver;
	User sender;
	ArrayList<Product> contents = new ArrayList<Product>();

	// create a package with specified details
	public Package newPackage(double w, double h, double d, int id, int p, User r, User s) {
		this.width = w;
		this.height = h;
		this.depth = d;
		this.id = id;
		this.status = Status.READY;
		this.priority = p;
		this.receiver = r;
		this.sender = s;
		this.contents = new ArrayList<Product>();
		
		return this;
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
