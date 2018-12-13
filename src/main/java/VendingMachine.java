import java.util.List;

public class VendingMachine {
    private MoneyUtil moneyUtil;
    private MachineInitializer machineInitializer;
    private List<Drink> drinks;
    private List<Coin> machineCoinsPool;

    public VendingMachine() {
        this.moneyUtil = new MoneyUtil();
        this.machineInitializer = new MachineInitializer();
        this.drinks = machineInitializer.initializeDrinkTypes();
        this.machineCoinsPool = machineInitializer.initializeCoinsPool();
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Coin> getMachineCoinsPool() {
        return machineCoinsPool;
    }

    public List<Coin> buyDrinkAndCollectChange(Integer drinkNumber, List<Coin> userCoins) {

        Integer price = drinks.get(drinkNumber - 1).getPrice();
        Integer drinksInStock = drinks.get(drinkNumber - 1).getQuantity();
        Integer userMoney = moneyUtil.sumUpCoins(userCoins);
        Integer change = userMoney - price;
        List<Coin> changeCoins = userCoins;

        if ((moneyUtil.checkDenomination(userCoins)) && (userMoney >= price) && (drinksInStock > 0)) {

            changeCoins = moneyUtil.collectChange(change);

            if (moneyUtil.isPoolFull(userCoins, machineCoinsPool) || moneyUtil.isPoolEmpty(changeCoins, machineCoinsPool)) {
                System.out.println("Problem with coins, try later");
            } else {
                drinks.get(drinkNumber - 1).setQuantity(drinksInStock - 1);
                System.out.println("You bought drink number: " + drinkNumber);
            }
        } else {
            System.out.println("Not enough money, wrong coin denomination or no drinks in stock");
        }
        return changeCoins;
    }

    public void emptyDrinkSlots() {
        drinks.forEach(drink -> drink.setQuantity(0));
    }

    public void fillDrinkSlots() {
        drinks.forEach(drink -> drink.setQuantity(drink.getMAX_QUANTITY()));
    }

    public void emptyCoinsSlots() {
        machineCoinsPool.forEach(coin -> coin.setQuantity(0));
    }

    public void fillCoinSlots() {
        machineCoinsPool.forEach(coin -> coin.setQuantity(coin.getMAX_QUANTITY()));
    }
}