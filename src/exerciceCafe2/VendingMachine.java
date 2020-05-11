package exerciceCafe2;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private static List<Coffee> available_coffees = new ArrayList<>();
    private static List<Extra> available_extras = new ArrayList<>();

    static {
        available_coffees.add(new Coffee("Colombia", 0.5)); available_coffees.add(new Coffee("Expresso", 0.6)); available_coffees.add(new Coffee("Deca", 0.4));
        available_extras.add(new Extra("Milk", 0.1)); available_extras.add(new Extra("Sugar", 0.1)); available_extras.add(new Extra("Caramel", 0.2)); available_extras.add(new Extra("Chantilly", 0.4));}

    public static String showAllCoffees() {
        int coffeesNb = 1;
        StringBuffer sb = new StringBuffer().append("Available coffees : \n");
        for(Coffee coffee:available_coffees) {
            sb.append("  -").append(coffeesNb++).append("- ").append(coffee).append("\n");
        }
        return sb.toString();
    }

    public static String showAllExtras() {
        StringBuffer sb = new StringBuffer().append("Available extras : \n");
        available_extras.forEach(extra -> sb.append("  - ").append(extra).append("\n"));
        return sb.toString();
    }


    public static List<Extra> getAvailable_extras() {
        return available_extras;
    }


    public static String getCoffeeChoice(int coffeeNb, List<Extra> extras) {
        if ((coffeeNb < 1) || (coffeeNb > available_coffees.size())) {
            return "No such coffee : " + coffeeNb;
        }
        else {
            return available_coffees.get(coffeeNb - 1).clone().addExtras(extras).toString();
        }
    }

}
