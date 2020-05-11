package exerciceCafe3;

public abstract class Extra extends Drink {

    protected Drink _drink;

    public abstract String getName();
    public abstract double getPrice();

    public String toString() {
        return getName() + " (" + getPrice() + "€)";
    }

}
