import groovyjarjarpicocli.CommandLine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class BurgerReceiptTypeTest {
    @Parameterized.Parameters(name = "Тип {0} выводится в чеке в нижнем регистре")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {IngredientType.SAUCE},
                {IngredientType.FILLING}
        });
    }

    private final IngredientType type;

    public BurgerReceiptTypeTest(IngredientType type) {
        this.type = type;
    }

    @Test
    public void getReceiptRendersIngredientTypeInLowerCase() {
        Burger burger = new Burger();
        burger.setBuns(new Bun("bun", 10));
        burger.addIngredient(new Ingredient(type, "test", 5));

        String receipt = burger.getReceipt();
        String expectedLine = "= " + type.name().toLowerCase() + " test =";

        assertTrue("Ожидалась строка '" + expectedLine + "' в чеке:\n" + receipt,
                receipt.contains(expectedLine));
    }
}
