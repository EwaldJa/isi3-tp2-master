package exerciceCafe3;

import exerciceCafe3.utils.InvalidDrinkException;
import exerciceCafe3.utils.InvalidExtraException;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

/**
 * Cette classe représente un distributeur de boissons avec des suppléments possibles
 *
 * @author Ewald Janin
 */
public class VendingMachine {

    public static final String DRINKS_PACKAGE_NAME = "exerciceCafe3.drinks";
    public static final String EXTRAS_PACKAGE_NAME = "exerciceCafe3.extras";

    /**
     * Renvoie un tableau de String contenant toutes les boissons disponibles (classes dans le package DRINKS_PACKAGE_NAME)
     * @param showPrices booléen valant true ou false selon que l'on veuille afficher ou non le prix de chacune des boissons
     * @return tableau de String représentant les boissons
     * @see #DRINKS_PACKAGE_NAME
     * @see #getClassesSimplenames(ArrayList, boolean)
     */
    public static String[] getAvailableDrinks(boolean showPrices) {
        Reflections reflections = new Reflections(DRINKS_PACKAGE_NAME); /*Gets the specified package*/
        ArrayList<Class> drink_classes = new ArrayList<>(reflections.getSubTypesOf(Drink.class)); /*Gets the classes of the specified package extending Drink abstract class */
        return getClassesSimplenames(drink_classes, showPrices);
    }

    /**
     * Renvoie un tableau de String contenant tous les suppléments disponibles (classes dans le package EXTRAS_PACKAGE_NAME)
     * @param showPrices booléen valant true ou false selon que l'on veuille afficher ou non le prix de chacun des suppléments
     * @return tableau de String représentant les suppléments
     * @see #EXTRAS_PACKAGE_NAME
     * @see #getClassesSimplenames(ArrayList, boolean)
     */
    public static String[] getAvailableExtras(boolean showPrices) {
        Reflections reflections = new Reflections(EXTRAS_PACKAGE_NAME); /*Gets the specified package*/
        ArrayList<Class> extra_classes = new ArrayList<>(reflections.getSubTypesOf(Extra.class)); /*Gets the classes of the specified package extending Extra abstract class */
        return getClassesSimplenames(extra_classes, showPrices);
    }

    /**
     * Récupère les noms simples (sans package) des classes passées en argument, et ajoute ou non le prix
     * @param classes les classes dont on veut les noms
     * @param showPrices s'il faut ou non afficher les prix des items à vendre
     * @return un tableau de String
     */
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

    /**
     * Renvoie une String bien formattée permettant d'afficher tous les éléments qui se vendent sur ce distributeur
     * @param showPrices s'il faut ou non afficher les prix
     * @return une String qui peut être affichée (sys.out ou sys.err) à l'utilisateur
     */
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

    /**
     * Crée et renvoie la commande du client
     * @param orderStr la commande du client, au format String, avec en premier la boisson, et ensuite les éventuels suppléments, séparés par des espaces
     * @return une boisson correspondant à la commande
     * @throws InvalidDrinkException si la boisson spécifiée est invalide
     * @throws InvalidExtraException s'il y a un problème avec un des extras
     * @see #getDrinkByOrder(String)
     * @see #getExtraByOrder(String, Drink)
     */
    public static Drink processOrder(String orderStr) throws InvalidDrinkException, InvalidExtraException {
        String[] orderItems = orderStr.split(" ");
        int extras_nb = orderItems.length - 1;
        Drink order = getDrinkByOrder(orderItems[0]);
        for(int i = 0; i < extras_nb;) {
            order = getExtraByOrder(orderItems[++i], order);
        }
        return order;
    }

    /**
     * Renvoie une instance de la classe correspondant à la String passée en paramètre
     * @param drinkName une String devant normalement représenter une boisson
     * @return une instance de boisson correspondante
     * @throws InvalidDrinkException si l'input est invalide, ou ne correspond pas à une boisson
     */
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

    /**
     * Renvoie une instance correspondant à la String et à la boisson passées en paramètre
     * @param extraName une String devant normalement représenter un supplément
     * @param drink la boisson à laquelle appliquer un supplément
     * @return une instance de la boisson spécifiée en paramètre à laquelle a été appliqué le supplément
     * @throws InvalidExtraException si l'input est invalide, ou ne correspond pas à un supplément
     */
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
