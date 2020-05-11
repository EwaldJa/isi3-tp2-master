package exerciceCafe3;

public abstract class Drink {

    private String _name;
    private double _price;

    public String getName() { return _name; }
    public double getPrice() { return _price; }

    protected void setName(String name) { this._name = name; }
    protected void setPrice(double price) { this._price = price; }

    public String toString() {
        return getName() + " (" + getPrice() + "€)";
    }
}
