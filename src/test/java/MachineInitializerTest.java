import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MachineInitializerTest {
    @Test
    public void initializeDrinkTypesTest() {

        List<Drink> actual = new MachineInitializer().initializeDrinkTypes();

        List<Drink> expected = new ArrayList<>();
        expected.add(new Drink(1, 210));
        expected.add(new Drink(2, 200));
        expected.add(new Drink(3, 190));
        expected.add(new Drink(4, 100));
        expected.add(new Drink(5, 120));

        assertEquals("Lists should be equal", expected, actual);
    }

    @Test
    public void initializeCoinsPoolTest () {

        List<Coin> actual = new MachineInitializer().initializeCoinsPool();

        List<Coin> expected = new ArrayList<Coin>();

        expected.add(new Coin(10, 25));
        expected.add(new Coin(20, 25));
        expected.add(new Coin(50, 25));
        expected.add(new Coin(100, 25));
        expected.add(new Coin(200, 25));

        assertEquals("Lists should be equal", expected, actual);
    }

}