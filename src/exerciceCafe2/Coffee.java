package exerciceCafe2;

import java.util.ArrayList;
import java.util.List;

public class Coffee extends VendingItem {

    List<Extra> _extras;

    public Coffee(String name, double price) {
        super(name, price);
        _extras = new ArrayList<>();
    }

    public Coffee addExtras(List<Extra> extras) {
        _extras.addAll(extras);
        return this;
    }

    @Override
    public String toString() {
        double total_price = _price;
        StringBuffer sb = new StringBuffer().append(_name);
        for(Extra extra:_extras) {
            sb.append(" ").append(extra.getName());
            total_price += extra.getPrice();
        }
        sb.append(" : ").append(total_price).append("€");
        return sb.toString();
    }

    public Coffee clone() {
        Coffee clone = new Coffee(_name, _price);
        clone.addExtras(_extras);
        return clone;
    }
}
