import java.util.ArrayList;

// user of service, consists of senders and receivers
public class User {
    int id;
    String first_name;
    String last_name;
    Address address;
    ArrayList<User> users = new ArrayList<User>();
 
    // create new user and add them to user list
    public User newUser(int id, String first_name, String last_name, Address address) {
	    this.id = id;
	    this.first_name = first_name;
	    this.last_name = last_name;
	    this.address = address;
	    users.add(this);
	    
	    return this;
    }
    
    // remove a user from list
    public void removeUser(int id) {
    	User user = getUserById(id);
    	users.remove(user);
    }
    
    // return user
    public User getUserById(int id) {
    	for(int i = 0; i < users.size(); i++) {
    		if(users.get(i).id == id) {
    			return users.get(i);
    		}
    	}
    	return null;
    }
    
    // edit user address
    public void changeAddress(int id, Address address) {
    	User user = getUserById(id);
    	user.address = address;
    }
}
