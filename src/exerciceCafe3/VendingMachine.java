package exerciceCafe3;

import exerciceCafe3.utils.InvalidDrinkException;
import exerciceCafe3.utils.InvalidExtraException;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class VendingMachine {

    public static final String DRINKS_PACKAGE_NAME = "exerciceCafe3.drinks";
    public static final String EXTRAS_PACKAGE_NAME = "exerciceCafe3.extras";

    public static String[] getAvailableDrinks(boolean showPrices) {
        Reflections reflections = new Reflections(DRINKS_PACKAGE_NAME); /*Gets the specified package*/
        ArrayList<Class> drink_classes = new ArrayList<>(reflections.getSubTypesOf(Drink.class)); /*Gets the classes of the specified package extending Drink abstract class */
        return getClassesSimplenames(drink_classes, showPrices);
    }

    public static String[] getAvailableExtras(boolean showPrices) {
        Reflections reflections = new Reflections(EXTRAS_PACKAGE_NAME); /*Gets the specified package*/
        ArrayList<Class> extra_classes = new ArrayList<>(reflections.getSubTypesOf(Extra.class)); /*Gets the classes of the specified package extending Extra abstract class */
        return getClassesSimplenames(extra_classes, showPrices);
    }

    private static String[] getClassesSimplenames(ArrayList<Class> classes, boolean showPrices) {
        String[] classNames = new String[classes.size()];
        int i = 0;
        for(Class clazz:classes) {
            try {
                String className = clazz.getSimpleName();
                if (showPrices) {
                    double price = (double) clazz.getDeclaredField("PRICE").get(new Object());
                    className += " (" + price + "€)";
                }
                classNames[i] = className;
                i++; }
            catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace(); } }
        return classNames;
    }

    public static String getAvailableVendingItems(boolean showPrices) {
        StringBuffer sb = new StringBuffer();
        sb.append("Available drinks : \n");
        for(String drink:getAvailableDrinks(showPrices)) {
            sb.append("  - ").append(drink).append("\n");
        }
        sb.append("\nAvailable extras : \n");
        for(String extra:getAvailableExtras(showPrices)) {
            sb.append("  - ").append(extra).append("\n");
        }
        return sb.toString();
    }

    public static Drink processOrder(String orderStr) throws InvalidDrinkException, InvalidExtraException {
        String[] orderItems = orderStr.split(" ");
        int extras_nb = orderItems.length - 1;
        Drink order = getDrinkByOrder(orderItems[0]);
        for(int i = 0; i < extras_nb;) {
            order = getExtraByOrder(orderItems[++i], order);
        }
        return order;
    }

    private static Drink getDrinkByOrder(String drinkName) throws InvalidDrinkException {
        String drinkClass = null;
        for (String drink:getAvailableDrinks(false)) {
            if (drink.toLowerCase().equals(drinkName.toLowerCase())) {
                drinkClass = drink;
                break; } }
        if (drinkClass == null) {
            throw new InvalidDrinkException("The specified drink does not correspond to any available drink : '" + drinkName + "'."); }
        else {
            try {
                Class clazz = Class.forName(DRINKS_PACKAGE_NAME + "." + drinkClass);
                Constructor<?> cons = clazz.getConstructor(null);
                return (Drink) cons.newInstance(); }
            catch (Exception e) {
                e.printStackTrace();
                throw new InvalidDrinkException("The drink class could not be found ('" + drinkClass + "')", e); } }
    }

    private static Extra getExtraByOrder(String extraName, Drink drink) throws InvalidExtraException {
        String extraClass = null;
        for (String extra:getAvailableExtras(false)) {
            if (extra.toLowerCase().equals(extraName.toLowerCase())) {
                extraClass = extra;
                break; } }
        if (extraClass == null) {
            throw new InvalidExtraException("The specified extra does not correspond to any available extra : '" + extraName + "'."); }
        else {
            try {
                Class clazz = Class.forName(EXTRAS_PACKAGE_NAME + "." + extraClass);
                Constructor<?> cons = clazz.getConstructor(Drink.class);
                return (Extra) cons.newInstance(drink); }
            catch (Exception e) {
                e.printStackTrace();
                throw new InvalidExtraException("The extra class could not be found ('" + extraClass + "')", e); }
        }
    }



}
