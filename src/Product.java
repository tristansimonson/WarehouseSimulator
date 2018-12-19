// class describing product that is packaged
public class Product {
    String name;
    String description;
    String manufacturer;
    String serial_number;
    double weight;
    double height;
    double width;
    double depth;
    
    // create product
    public Product newProduct(String n, String des, String m, String s, double we, double h, double wi, double d) {
    	this.name = n;
    	this.description = des;
    	this.manufacturer = m;
    	this.serial_number = s;
    	this.weight = we;
    	this.height = h;
    	this.width = wi;
    	this.depth = d;
    	
    	return this;
    }
}
