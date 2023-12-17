import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private static Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Before
    public void prepareTestData() {
        burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100.00F);
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");
        Mockito.when(ingredient.getPrice()).thenReturn(100.00F);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void addBunsToBurgerTest() {
        burger.setBuns(bun);
        assertEquals("black bun", burger.bun.getName());
    }

    @Test
    public void addIngredientToBurgerTest() {
        burger.addIngredient(ingredient);
        assertEquals("hot sauce", burger.ingredients.get(0).getName());
    }

    @Test
    public void removeIngredientFromBurgerTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        assertEquals(2, burger.ingredients.size());
        burger.removeIngredient(1);
        assertEquals(1, burger.ingredients.size());
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        Ingredient firstIng = ingredient;
        Ingredient secondIng = ingredient;
        burger.addIngredient(firstIng);
        burger.addIngredient(secondIng);
        burger.moveIngredient(1, 0);
        assertEquals(secondIng, burger.ingredients.get(0));
        assertEquals(firstIng, burger.ingredients.get(1));
    }

    @Test
    public void getPriceOfBurgerTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float expectedPrice = bun.getPrice() * 2 + ingredient.getPrice();
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptOfBurgerTest() {
        burger.setBuns(bun);
        Ingredient firstIng = ingredient;
        Ingredient secondIng = ingredient;
        burger.addIngredient(firstIng);
        burger.addIngredient(secondIng);
        assertEquals("(==== black bun ====)\r\n" +
                "= sauce hot sauce =\r\n" +
                "= sauce hot sauce =\r\n" +
                "(==== black bun ====)\r\n" +
                "\r\n" +
                "Price: 400,000000\r\n", burger.getReceipt());
    }
}
