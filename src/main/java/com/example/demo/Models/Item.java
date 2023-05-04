package com.example.demo.Models;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
//@Table(name = "Item")
public class Item {

    @Id
    @GeneratedValue
    protected long id;
    protected String namn;
    protected String pris;
    //@ManyToMany(cascade = CascadeType.ALL)
    /*@ManyToMany(mappedBy = "Item")
    @JsonIgnore
    private Set<Orders> orders = new HashSet<>();*/

    public Item(String namn, String pris ){
        this.namn = namn;
        this.pris = pris;
    }

}
