// class describing product that is packaged
public class Product {
    String name;
    String description;
    String manufacturer;
    String serial_number;
    int weight;
    int height;
    int width;
    int depth;
    
    // create product
    public void newProduct(String n, String des, String m, String s, int we, int h, int wi, int d) {
    	this.name = n;
    	this.description = des;
    	this.manufacturer = m;
    	this.serial_number = s;
    	this.weight = we;
    	this.height = h;
    	this.width = wi;
    	this.depth = d;
    }
}
