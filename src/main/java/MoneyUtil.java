import java.util.ArrayList;
import java.util.List;

public class MoneyUtil {

    public List<Coin> collectChange(Integer change) {

        List<Coin> changeCoins = new ArrayList<>();
        changeCoins.add(new Coin(50));
        changeCoins.add(new Coin(20));
        changeCoins.add(new Coin(10));

        // 'change-making problem' algorithm (greedy version) was used to give back change money to user
        while (change > 0) {
            int maxCoinDenomination = 0;

            for (int i = 0; i < changeCoins.size() ; i++) {
                if ((changeCoins.get(i).getValueInCents() <= change) && (changeCoins.get(i).getValueInCents() > maxCoinDenomination)) {
                    maxCoinDenomination = changeCoins.get(i).getValueInCents();
                    changeCoins.get(i).setQuantity(changeCoins.get(i).getQuantity() + 1);
                }
            }
            change -= maxCoinDenomination;
        }
        return changeCoins;
    }



    public boolean checkDenomination(List<Coin> userCoins) {
        boolean isCorrect = true;
        int incorrectValues = 0;

        // we only support those denomination values:
        Integer[] values = {200, 100, 50, 20, 10};

        // if it finds more than 4 incorrect values then one of coins has wrong denomination
        for (Integer value: values) {
            incorrectValues = 0;
            for (Coin coin: userCoins) {
                if (!value.equals(coin.getValueInCents())) {
                    incorrectValues++;
                }
                if (incorrectValues > 4) {
                    isCorrect = false;
                }
            }
        }
        return isCorrect;
    }

    public Integer sumUpCoins(List<Coin> coins) {
        Integer sum = Integer.valueOf(0);

        for (Coin coin: coins) {
            sum += coin.getValueInCents()*coin.getQuantity();
        }
        return sum;
    }

    public boolean isPoolFull(List<Coin> userCoins, List<Coin> machineCoinsPool) {
        addUserCoinsToPool(userCoins, machineCoinsPool);

        boolean isFull = false;

        for (Coin coin: machineCoinsPool) {
            if (coin.getQuantity() > coin.getMAX_QUANTITY()) {
                isFull = true;
            }
        }
        return isFull;
    }

    public void addUserCoinsToPool(List<Coin> usersCoins, List<Coin> machineCoinsPool) {
        for (Coin coin: machineCoinsPool) {
            for (Coin userCoin: usersCoins) {
                if (coin.getValueInCents().equals(userCoin.getValueInCents())) {
                    Integer newValue = coin.getQuantity() + userCoin.getQuantity();
                    coin.setQuantity(newValue);
                }
            }
        }
    }

    public boolean isPoolEmpty(List<Coin> changeCoins, List<Coin> machineCoinsPool) {
        removeUserCoinsFromPool(changeCoins, machineCoinsPool);

        boolean isEmpty = false;

        for (Coin coin: machineCoinsPool) {
            if (coin.getQuantity() <= 0) {
                isEmpty = true;
            }
        }
        return isEmpty;
    }

    public void removeUserCoinsFromPool(List<Coin> changeCoins, List<Coin> machineCoinsPool) {
        for (Coin coin: machineCoinsPool) {
            for (Coin userCoin: changeCoins) {
                if (coin.getValueInCents().equals(userCoin.getValueInCents())) {
                    Integer newValue = coin.getQuantity() - userCoin.getQuantity();
                    coin.setQuantity(newValue);
                }
            }
        }
    }
}
