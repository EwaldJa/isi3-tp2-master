package exerciceCafe3.extras;

import exerciceCafe3.Drink;
import exerciceCafe3.Extra;

public class Milk extends Extra {

    public static final double PRICE = 0.1;
    public static final String NAME = "Milk";

    public Milk(Drink drink) {
        super();
        _drink = drink;
    }

    @Override
    public String getName() {
        return _drink.getName() + " " + NAME;
    }

    @Override
    public double getPrice() {
        return _drink.getPrice() + PRICE;
    }
}
