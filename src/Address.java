// class for holding address information
public class Address {
	String street1;
	String street2;
	String city;
	String state;
	String zip;
	
	public Address newAddress(String street1, String street2, String city, String state, String zip) {
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		return this;
	}
	
	public String addressToString() {
		return "to do";
	}
}
