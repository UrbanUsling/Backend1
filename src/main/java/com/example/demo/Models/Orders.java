package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity

//@Table(name = "Orders")


public class Orders {

    @Id
    @GeneratedValue
    protected long id;
    protected String date;
    @ManyToOne
    @JoinColumn
    //Denna rad hör till 1-N-filmen
    private Customer customer;

    /*
    public void addVaror(Varor v){
        Varor.add(v);
    }*/
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable


    //private Set<Item> items = new HashSet<>();
    private List<Item> items = new ArrayList<>();

    public Orders(String date, Customer customer){
        this.date = date;
        this.customer = customer;
    }
    public void addItems(Item item) {
        items.add(item);
    }
}
