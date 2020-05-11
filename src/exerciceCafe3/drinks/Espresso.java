package exerciceCafe3.drinks;

import exerciceCafe3.Drink;

public class Espresso extends Drink {

    public static final double PRICE = 0.6;
    public static final String NAME = "Espresso";

    public Espresso() {
        super();
        setName(NAME);
        setPrice(PRICE);
    }
}
