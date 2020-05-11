package exerciceCafe3;

import org.junit.Assert;
import org.junit.Test;

import exerciceCafe3.drinks.Colombia;
import exerciceCafe3.drinks.Espresso;
import exerciceCafe3.extras.Caramel;
import exerciceCafe3.extras.Chantilly;
import exerciceCafe3.extras.Sugar;

public class DrinksExtrasTest {

	@Test
	public void orders() {

		Drink espressoSugar = new Sugar(new Espresso());

		double espressoSugarPrice = espressoSugar.getPrice();
		String espressoSugarName = espressoSugar.getName();

		Assert.assertEquals(0.7, espressoSugarPrice, 0.0);
		Assert.assertEquals("Espresso Sugar", espressoSugarName);

		System.out.println("Espresso with Sugar : test succeeded");


		Drink colombiaChantillyCaramel = new Caramel(new Chantilly(new Colombia()));

		double colombiaChantillyCaramelPrice = colombiaChantillyCaramel.getPrice();
		String colombiaChantillyCaramelName = colombiaChantillyCaramel.getName();

		Assert.assertEquals(1.1, colombiaChantillyCaramelPrice, 0.0);
		Assert.assertEquals("Colombia Chantilly Caramel", colombiaChantillyCaramelName);

		System.out.println("Colombia with Chantilly and Caramel : test succeeded");
	}
}
