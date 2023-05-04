package com.example.demo.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

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

    public Items(String namn, String pris ){
        this.namn = namn;
        this.pris = pris;
    }

}
