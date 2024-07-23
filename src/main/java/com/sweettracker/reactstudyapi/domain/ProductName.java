package com.sweettracker.reactstudyapi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductName {
    private int id;
    private String name;

    @Builder
    public ProductName(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
