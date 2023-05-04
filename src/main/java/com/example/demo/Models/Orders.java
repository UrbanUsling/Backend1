package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.apache.bcel.generic.Tag;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity



public class Orders {

    @Id
    @GeneratedValue
    protected long id;
    protected String date;
    @ManyToOne
    @JoinColumn
    private Customer customer;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private List<Items> items = new ArrayList<>();

    public Orders(String date, Customer customer){
        this.date = date;
        this.customer = customer;
    }
    public void addItems(Items item) {
        items.add(item);
    }
}
