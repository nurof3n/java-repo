package com.db.homeworks.hw3;

import com.db.homeworks.hw3.commands.Command;
import com.db.homeworks.hw3.pizzas.Pizza;
import com.db.homeworks.hw3.pizzas.PizzaFactory;

/**
 * Acts as an Observer for {@link com.db.homeworks.hw3.pizzas.PizzaFactory}
 */
public class Client {
    public PizzaFactory.Types newPizza = PizzaFactory.Types.NO_PIZZA;

    public PizzaFactory.Types getNewPizza() {
        return newPizza;
    }

    public void update(PizzaFactory.Types type) {
        newPizza = type;
    }

    public Pizza executeCommand(Command command) {
        return command.execute();
    }
}
