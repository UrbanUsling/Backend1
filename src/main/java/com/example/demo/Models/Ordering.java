package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity


public class Ordering {

    @Id
    @GeneratedValue
    protected long id;
    protected String date;
    /*@ManyToOne
    @JoinColumn
    //Denna rad hör till 1-N-filmen
    private Costumer costumer;*/

    public Ordering(String date){
        this.date = date;
        //this.costumer = costumer;
    }
}
