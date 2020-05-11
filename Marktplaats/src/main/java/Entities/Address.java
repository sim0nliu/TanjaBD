package Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Address {

    @Id
    @GeneratedValue
    int id;
    @OneToMany(mappedBy = "address")
    List<User> user = new ArrayList<>();
    String streetName;
    String city;
    String zipcode;
    int number;

    public Address(){}

    public Address(String streetName, int number, String zipcode, String city){
        this.streetName = streetName;
        this.number = number;
        this.zipcode = zipcode;
        this.city = city;
    }

    @Override
    public String toString(){
        return "";
    }

}
