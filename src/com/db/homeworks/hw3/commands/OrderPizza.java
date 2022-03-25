package com.db.homeworks.hw3.commands;

import com.db.homeworks.hw3.pizzas.Pizza;
import com.db.homeworks.hw3.pizzas.PizzaFactory;

public class OrderPizza extends Command {
    private final PizzaFactory.Types type;

    public OrderPizza(PizzaFactory.Types type) {
        this.type = type;
    }

    @Override
    public Pizza execute() {
        System.out.println("Order executed: " + type.toString() + " created!");
        return PizzaFactory.INSTANCE.createPizza(type);
    }
}
