package practicatdd.model;

import practicatdd.exceptions.InvalidClanRatException;

public class ClanRat {

    private String name;
    private int quantity;
    private int cost;

    private ClanRat(String name, int quantity, int cost) {
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
    }

    public static ClanRat getNewInstance(String name, int quantity, int cost) throws InvalidClanRatException {

        // Validar el nombre. Es nulo? Esta vacio?
        if (name == null || name.isBlank()) {
            throw new InvalidClanRatException("Name is null or empty");
        }

        // validar el numero de soldados
        if (quantity <= 0 || quantity > 160) {
            throw new InvalidClanRatException("Quantity is out of range");
        }

        // validar que el costo no sea negativo o cero
        if (cost <= 0) {
            throw new InvalidClanRatException("Cost is negative or zero");
        }

        return new ClanRat(name, quantity, cost);
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }
}
