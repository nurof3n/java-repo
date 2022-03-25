package com.db.homeworks.hw3.decorators;

import com.db.homeworks.hw3.pizzas.Pizza;

public class ToppingDecorator extends Decorator {
    private final Toppings topping;

    public enum Toppings {
        NO_TOPPING("no topping"),
        TOMATOES("tomatoes"),
        CAULIFLOWER("cauliflower");

        private final String topping;

        Toppings(String topping) {
            this.topping = topping;
        }

        @Override
        public String toString() {
            return topping;
        }
    }

    public ToppingDecorator(Pizza pizza, Toppings topping) {
        super(pizza);
        this.topping = topping;
    }

    @Override
    public String decorate() {
        return super.decorate() + addTopping();
    }

    private String addTopping() {
        return topping.toString();
    }
}
