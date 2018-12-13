import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MoneyUtilTest {

    @Test
    public void  giveChangeTest() {
        MoneyUtil moneyUtil = new MoneyUtil();

        List<Coin> actual = moneyUtil.collectChange(80);

        List<Coin> expected = new ArrayList<>();
        expected.add(new Coin(50));
        expected.add(new Coin(20));
        expected.add(new Coin(10));

        expected.get(0).setQuantity(1);
        expected.get(1).setQuantity(1);
        expected.get(2).setQuantity(1);

        assertEquals("Lists should be equal", expected, actual);
    }

    @Test
    public void checkCoinsDenominationTest(){
        MoneyUtil moneyUtil = new MoneyUtil();

        List<Coin> userCoins = new ArrayList<>();
        userCoins.add(new Coin(200));
        userCoins.add(new Coin(100));
        userCoins.add(new Coin(50));
        userCoins.add(new Coin(30));
        userCoins.add(new Coin(10));


        boolean actual = moneyUtil.checkDenomination(userCoins);
        boolean expected = false;

        assertEquals("Should be false", expected, actual);

    }

    @Test
    public void sumUpCoinsTest() {
        MoneyUtil moneyUtil = new MoneyUtil();

        List<Coin> userCoins = new ArrayList<>();
        userCoins.add(new Coin(200));
        userCoins.add(new Coin(100, 1));
        userCoins.add(new Coin(50, 2));
        userCoins.add(new Coin(20));
        userCoins.add(new Coin(10));

        Integer actual = moneyUtil.sumUpCoins(userCoins);
        Integer expected = Integer.valueOf(200);

        assertEquals("Should return 200", expected, actual);
    }

    @Test
    public void isCoinPoolFullTest () {
        MoneyUtil moneyUtil = new MoneyUtil();

        List<Coin> machineCoinsPool = new ArrayList<>();
        machineCoinsPool.add(new Coin(200, 49));;
        machineCoinsPool.add(new Coin(50, 48));

        List<Coin> userCoins = new ArrayList<>();
        userCoins.add(new Coin(50, 2));
        userCoins.add(new Coin(200, 1));

        boolean expexted = moneyUtil.isPoolFull(userCoins, machineCoinsPool);

        assertEquals("Should be false", expexted, false);
    }

    @Test
    public void isCoinsPoolEmptyTest () {
        MoneyUtil moneyUtil = new MoneyUtil();

        List<Coin> machineCoinsPool = new ArrayList<>();
        machineCoinsPool.add(new Coin(50));
        machineCoinsPool.add(new Coin(10));

        List<Coin> changeForUser = new ArrayList<>();
        changeForUser.add(new Coin(50, 2));
        changeForUser.add(new Coin(10, 1));

        boolean expexted = moneyUtil.isPoolEmpty(changeForUser, machineCoinsPool);

        assertEquals("Should be true", expexted, true);
    }

    @Test
    public void addUserCoinsToPoolTest() {
        MoneyUtil moneyUtil = new MoneyUtil();

        List<Coin> machineCoinsPool = new ArrayList<>();
        machineCoinsPool.add(new Coin(10));
        machineCoinsPool.add(new Coin(200));


        List<Coin> userCoins = new ArrayList<>();
        userCoins.add(new Coin(10, 3));
        userCoins.add(new Coin(200, 4));

        moneyUtil.addUserCoinsToPool(userCoins, machineCoinsPool);

        List<Coin> expected = new ArrayList<>();
        expected.add(new Coin(10, 3));
        expected.add(new Coin(200, 4));

        assertEquals("Lists should be equal", expected, machineCoinsPool);
    }

    @Test
    public void removeUsersCoinsFromPoolTest() {
        MoneyUtil moneyUtil = new MoneyUtil();

        List<Coin> machineCoinsPool = new ArrayList<>();
        machineCoinsPool.add(new Coin(10, 10));
        machineCoinsPool.add(new Coin(200, 10));

        List<Coin> changeInCoinsForUser = new ArrayList<>();
        changeInCoinsForUser.add(new Coin(10, 3));
        changeInCoinsForUser.add(new Coin(200, 4));

        moneyUtil.removeUserCoinsFromPool(changeInCoinsForUser, machineCoinsPool);

        List<Coin> expected = new ArrayList<>();
        expected.add(new Coin(10, 7));
        expected.add(new Coin(200, 6));

        assertEquals(expected, machineCoinsPool);
    }

}