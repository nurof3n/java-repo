package com.db.homeworks.hw3.commands;

import com.db.homeworks.hw3.pizzas.Pizza;
import com.db.homeworks.hw3.pizzas.PizzaFactory;

public abstract class Command {
    abstract public Pizza execute();
}
