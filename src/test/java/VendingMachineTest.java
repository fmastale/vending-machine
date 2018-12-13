import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class VendingMachineTest {
    @Test
    public void buyDrinkInVendingMachine() {
        VendingMachine machine = new VendingMachine();

        Integer drinkNumber = 5;

        List<Coin> userCoins = new ArrayList<>();
        userCoins.add(new Coin(50, 1));
        userCoins.add(new Coin(100, 1));

        List<Coin> actual = machine.buyDrinkAndCollectChange(drinkNumber, userCoins);

        List<Coin> expected = new ArrayList<>();
        expected.add(new Coin(50, 0));
        expected.add(new Coin(20, 1));
        expected.add(new Coin(10, 1));

        assertEquals(expected, actual);
    }

    @Test
    public void emptyDrinkSlotsTest () {
        VendingMachine machine = new VendingMachine();
        machine.emptyDrinkSlots();
        List<Drink> actual = machine.getDrinks();

        List<Drink> expected = new MachineInitializer().initializeDrinkTypes();
        expected.forEach(drink -> drink.setQuantity(0));

        assertEquals("Lists should be equal", expected, actual);
    }

    @Test
    public void fillDrinkSlotsTest () {
        VendingMachine machine = new VendingMachine();
        machine.fillDrinkSlots();
        List<Drink> actual = machine.getDrinks();

        List<Drink> expected = new MachineInitializer().initializeDrinkTypes();
        expected.forEach(drink -> drink.setQuantity(drink.getMAX_QUANTITY()));

        assertEquals("Lists should be equal", expected, actual);
    }

    @Test
    public void emptyCoinSlotsTest () {
        VendingMachine machine = new VendingMachine();
        machine.emptyCoinsSlots();
        List<Coin> actual = machine.getMachineCoinsPool();

        List<Coin> expected = new MachineInitializer().initializeCoinsPool();
        expected.forEach(coin -> coin.setQuantity(0));

        assertEquals("Lists should be equal", expected, actual);
    }

    @Test
    public void fillCoinSlotsTest () {
        VendingMachine machine = new VendingMachine();
        machine.fillCoinSlots();
        List<Coin> actual = machine.getMachineCoinsPool();

        List<Coin> expected = new MachineInitializer().initializeCoinsPool();
        expected.forEach(coin -> coin.setQuantity(coin.getMAX_QUANTITY()));

        assertEquals("Lists should be equal", expected, actual);
    }


}