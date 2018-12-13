import java.util.ArrayList;
import java.util.List;

public class MachineInitializer {

    public List<Drink> initializeDrinkTypes() {

        List<Drink> drinks = new ArrayList<>();

        //e.g. data for drinks
        drinks.add(new Drink(1, 210));
        drinks.add(new Drink(2, 200));
        drinks.add(new Drink(3, 190));
        drinks.add(new Drink(4, 100));
        drinks.add(new Drink(5, 120));

        return drinks;
    }

    public List<Coin> initializeCoinsPool() {

        List<Coin> coinsPool = new ArrayList<Coin>();

        //we assume that machine is in half fulfilled with coins when it starts running
        coinsPool.add(new Coin(10, 25));
        coinsPool.add(new Coin(20, 25));
        coinsPool.add(new Coin(50, 25));
        coinsPool.add(new Coin(100, 25));
        coinsPool.add(new Coin(200, 25));

        return coinsPool;
    }
}
