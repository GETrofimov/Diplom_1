import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private Ingredient ing;
    private String expectedName;
    private float expectedPrice;
    private IngredientType expectedType;
    private static Database db = new Database();
    
    public IngredientTest(Ingredient ing, String expectedName, float expectedPrice, IngredientType expectedType) {
        this.ing = ing;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
        this.expectedType = expectedType;
    }
    
    @Parameterized.Parameters
    public static Object[][] getParams() {
      return new Object[][] {
              {db.availableIngredients().get(0), db.availableIngredients().get(0).name, db.availableIngredients().get(0).price, db.availableIngredients().get(0).type},
              {db.availableIngredients().get(1), db.availableIngredients().get(1).name, db.availableIngredients().get(1).price, db.availableIngredients().get(1).type},
              {db.availableIngredients().get(2), db.availableIngredients().get(2).name, db.availableIngredients().get(2).price, db.availableIngredients().get(2).type},
              {db.availableIngredients().get(3), db.availableIngredients().get(3).name, db.availableIngredients().get(3).price, db.availableIngredients().get(3).type},
              {db.availableIngredients().get(4), db.availableIngredients().get(4).name, db.availableIngredients().get(4).price, db.availableIngredients().get(4).type},
              {db.availableIngredients().get(5), db.availableIngredients().get(5).name, db.availableIngredients().get(5).price, db.availableIngredients().get(5).type},
      };
    }
    
    @Test
    public void getIngredientNameTest() {
        assertEquals(expectedName, ing.getName());
    }
    
    @Test
    public void getIngredientPriceTest() {
        assertEquals(expectedPrice, ing.getPrice(), 0);
    }
    
    @Test
    public void getIngredientType() {
        assertEquals(expectedType, ing.getType());
    }
}
