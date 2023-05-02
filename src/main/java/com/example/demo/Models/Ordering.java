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


public class Ordering {

    @Id
    @GeneratedValue
    protected long id;
    protected String date;
    @ManyToOne
    @JoinColumn
    //Denna rad hör till 1-N-filmen
    private Costumer costumer;

    @ManyToMany
    @JoinTable
    private List<Varor> VarorIOrderingList = new ArrayList<>();

    public void addVaror(Varor v){
        VarorIOrderingList.add(v);
    }

    public Ordering(String date, Costumer costumer){
        this.date = date;
        this.costumer = costumer;
    }
}
