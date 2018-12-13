public class Drink {
    private Integer drinkNumber;
    private Integer price;
    private Integer quantity;
    private final Integer MAX_QUANTITY;

    public Drink(Integer drinkNumber, Integer price) {
        this.drinkNumber = drinkNumber;
        this.price = price;
        //we assume that vending machine is full of drinks when it starts running
        this.quantity = 20;
        this.MAX_QUANTITY = 20;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getMAX_QUANTITY() {
        return MAX_QUANTITY;
    }

    @Override
    public String toString() {
        return "Drink Number = " + drinkNumber + ", Price = " + price +", Quantity = " + quantity + " \n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Drink drink = (Drink) o;

        if (drinkNumber != null ? !drinkNumber.equals(drink.drinkNumber) : drink.drinkNumber != null) return false;
        if (price != null ? !price.equals(drink.price) : drink.price != null) return false;
        return quantity != null ? quantity.equals(drink.quantity) : drink.quantity == null;
    }

    @Override
    public int hashCode() {
        int result = drinkNumber != null ? drinkNumber.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }
}
