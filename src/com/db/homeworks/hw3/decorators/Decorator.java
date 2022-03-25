package com.db.homeworks.hw3.decorators;

import com.db.homeworks.hw3.pizzas.Pizza;

public abstract class Decorator extends Pizza {
    private final Pizza pizza;

    public Decorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String decorate() {
        return pizza.decorate();
    }
}
