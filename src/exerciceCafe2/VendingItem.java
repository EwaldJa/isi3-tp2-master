package exerciceCafe2;

public abstract class VendingItem {

    protected String _name;
    protected double _price;

    public VendingItem(String name, double price) {
        this._name = name;
        this._price = price;
    }

    public double getPrice() { return _price; }

    public String getName() { return _name; }

    public String toString() {
        return _name + " ("  + _price + "€)";
    }
}
