package exerciceCafe3.extras;

import exerciceCafe3.Drink;
import exerciceCafe3.Extra;

public class Chantilly extends Extra {

    public static final double PRICE = 0.4;
    public static final String NAME = "Chantilly";

    public Chantilly(Drink drink) {
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
