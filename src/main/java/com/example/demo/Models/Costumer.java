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
public class Costumer {

    @Id
    @GeneratedValue
    protected long id;
    protected String name;
    protected String personId;

    public Costumer(String name, String personId) {
        this.name = name;
        this.personId = personId;
    }

}

