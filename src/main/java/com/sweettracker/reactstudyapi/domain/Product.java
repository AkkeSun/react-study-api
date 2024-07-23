package com.sweettracker.reactstudyapi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Product {
    private int id;
    private String name;
    private int price;
    private String description;

    @Builder
    public Product(int id, String name, int price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public void updateId(int id) {
        this.id = id;
    }
}
