package com.db.homeworks.hw3.pizzas;

import com.db.homeworks.hw3.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * Factory class that creates pizzas. Also, an Observable for {@link Client} Observers.
 * Choosing to implement this Singleton as an enum.
 * See this https://stackoverflow.com/a/26292956
 */
public enum PizzaFactory {
    INSTANCE;

    private final List<Client> clients = new ArrayList<>();    // list of clients as Observers

    /**
     * Enum listing Pizza types for object creation
     */
    public enum Types {
        NO_PIZZA("No Pizza"),
        MARGUERITA("Marguerita"),
        PROSCIUTTOFUNGHI("Prosciutto Funghi"),
        CAPRICCIOSA("Capricciosa"),
        QUATTROSTAGIONI("Quattro Stagioni");

        private final String type;

        Types(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return type;
        }
    }

    public void addObserver(Client client) {
        clients.add(client);
    }

    public void removeObserver(Client client) {
        clients.remove(client);
    }

    public void notifyClients(Types type) {
        for (var client : clients) {
            client.update(type);
        }
    }

    /**
     * Creates a pizza object based on given type
     */
    public Pizza createPizza(Types type) {
        notifyClients(type);

        return switch (type) {
            case MARGUERITA -> new Marguerita();
            case CAPRICCIOSA -> new Capricciosa();
            case PROSCIUTTOFUNGHI -> new ProsciuttoFunghi();
            case QUATTROSTAGIONI -> new QuattroStagioni();
            case NO_PIZZA -> null;
        };
    }
}
