import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Database;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DatabaseBunsTest {
    @Parameterized.Parameters(name = "Булка #{0}: {1}, {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {0, "black bun", 100f},
                {1, "white bun", 200f},
                {2, "red bun",   300f}
        });
    }

    private final int index;
    private final String name;
    private final float price;

    public DatabaseBunsTest(int index, String name, float price) {
        this.index = index;
        this.name = name;
        this.price = price;
    }

    @Test
    public void bunAtIndexHasExpectedData() {
        List<Bun> buns = new Database().availableBuns();

        assertEquals(3, buns.size());
        Bun bun = buns.get(index);
        assertEquals(name, bun.getName());
        assertEquals(price, bun.getPrice(), 0.001f);
    }
}
