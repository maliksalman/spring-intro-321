package com.example.springintro;

import org.springframework.data.annotation.Id;

public record Hero(
        @Id
        Long id,
        String name,
        int age) {

        public Hero(String name, int age) {
                this(null, name, age);
        }
}
