package com.db.homeworks.hw3;

import com.db.homeworks.hw3.commands.OrderPizza;
import com.db.homeworks.hw3.decorators.Decorator;
import com.db.homeworks.hw3.decorators.ToppingDecorator;
import com.db.homeworks.hw3.pizzas.Pizza;
import com.db.homeworks.hw3.pizzas.PizzaFactory;

public class Main {
    public static void main(String[] args) {
        // Decorator test

        Pizza capricciosa = PizzaFactory.INSTANCE.createPizza(PizzaFactory.Types.CAPRICCIOSA);
        Pizza marguerita = PizzaFactory.INSTANCE.createPizza(PizzaFactory.Types.MARGUERITA);
        Decorator toppingDecorator1 = new ToppingDecorator(capricciosa,
                ToppingDecorator.Toppings.TOMATOES);
        Decorator toppingDecorator2 = new ToppingDecorator(marguerita,
                ToppingDecorator.Toppings.CAULIFLOWER);
        System.out.println(toppingDecorator1.decorate());
        System.out.println(toppingDecorator2.decorate());

        // Observer test

        Client client1 = new Client();
        Client client2 = new Client();
        PizzaFactory.INSTANCE.addObserver(client1);
        PizzaFactory.INSTANCE.addObserver(client2);
        PizzaFactory.INSTANCE.createPizza(PizzaFactory.Types.PROSCIUTTOFUNGHI);
        System.out.println("Last baked pizza: " + client1.getNewPizza());
        System.out.println("Last baked pizza: " + client2.getNewPizza());

        // Command test
        client1.executeCommand(new OrderPizza(PizzaFactory.Types.QUATTROSTAGIONI));
        client2.executeCommand(new OrderPizza(PizzaFactory.Types.NO_PIZZA));
    }
}
