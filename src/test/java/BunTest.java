import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Database;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private Bun bun;
    private String expectedName;
    private float expectedPrice;
    private static Database db = new Database();

    public BunTest(Bun bun, String expectedName, float expectedPrice) {
        this.bun = bun;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return new Object[][] {
                {db.availableBuns().get(0), db.availableBuns().get(0).name, db.availableBuns().get(0).price},
                {db.availableBuns().get(1), db.availableBuns().get(1).name, db.availableBuns().get(1).price},
                {db.availableBuns().get(2), db.availableBuns().get(2).name, db.availableBuns().get(2).price}
        };
    }

    @Test
    public void getBunName() {
        assertEquals(expectedName, bun.getName());
    }

    @Test
    public void getBunPrice() {
        assertEquals(expectedPrice, bun.getPrice(), 0);
    }
}
