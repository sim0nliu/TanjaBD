package Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class User {

    @Id
    String username;
    String password;
    String mail;
    String shippingMethod;
    @ManyToOne(cascade = CascadeType.ALL)
    Address address;

    public User(){}

    public User(String username, String password, String mail, String shippingMethod, Address address) {
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.shippingMethod = shippingMethod;
        this.address = address;
    }
    
    
    @Override
    public String toString() {
        return "Username: " + username;
    }

}
