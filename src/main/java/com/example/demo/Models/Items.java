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
public class Items {

    @Id
    @GeneratedValue
    protected long id;
    protected String namn;
    protected String pris;

    public Items(String namn, String pris){
        this.namn = namn;
        this.pris = pris;
    }

}
