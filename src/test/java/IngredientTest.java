import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
@RunWith(Parameterized.class)
public class IngredientTest {
    @Parameterized.Parameters(name = "Ingredient({0}, {1}, {2})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {IngredientType.SAUCE,   "hot sauce",   100f},
                {IngredientType.SAUCE,   "sour cream",  200f},
                {IngredientType.SAUCE,   "chili sauce", 300f},
                {IngredientType.FILLING, "cutlet",      100f},
                {IngredientType.FILLING, "dinosaur",    200f},
                {IngredientType.FILLING, "sausage",     300f}
        });
    }

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Test
    public void constructorStoresAllFields() {
        Ingredient ingredient = new Ingredient(type, name, price);

        assertEquals(type, ingredient.getType());
        assertEquals(name, ingredient.getName());
        assertEquals(price, ingredient.getPrice(), 0.001f);
    }

    @Test
    public void ingredientTypeIsAvailable() {
        assertNotNull(type);
    }
}

