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


public class Orders {

    @Id
    @GeneratedValue
    protected long id;
    protected String date;
    @ManyToOne
    @JoinColumn
    //Denna rad hör till 1-N-filmen
    private Customer customer;

    @ManyToMany
    @JoinTable
    private List<Items> VarorIOrderingList = new ArrayList<>();

    /*public void addVaror(Varor v){
        Varor.add(v);
    }*/

    public Orders(String date, Customer customer){
        this.date = date;
        this.customer = customer;
    }
}
