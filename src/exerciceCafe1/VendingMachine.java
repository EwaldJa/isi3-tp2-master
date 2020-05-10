package exerciceCafe1;

import java.util.ArrayList;
import java.util.HashMap;

public class VendingMachine {

    private static HashMap<String, Double> coffees = new HashMap<>();
    static { coffees.put("Colombia", 0.5); coffees.put("Expresso", 0.6); coffees.put("Deca", 0.4); }

    public static String showAllCoffees() {
        int coffeesNb = 1;
        StringBuffer sb = new StringBuffer().append("Available coffees : \n");
        for(String coffee: coffees.keySet()) {
            sb.append("  -").append(coffeesNb++).append("- ").append(coffee).append(" : ").append(coffees.get(coffee)).append("€\n");
        }
        return sb.toString();
    }

    public static String getChoice(int itemNb) {
        ArrayList<String> coffees_names = new ArrayList<>(coffees.keySet());
        if (itemNb < 1 || itemNb > coffees_names.size()) {
            return "No such item : " + itemNb;
        }
        else {
            return coffees_names.get(itemNb - 1) + " : " + coffees.get(coffees_names.get(itemNb - 1)) + "€";
        }
    }

}
