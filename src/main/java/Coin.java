public class Coin {
    private Integer valueInCents;
    private Integer quantity;
    private final Integer MAX_QUANTITY;

    public Coin(Integer valueInCents) {
        this.valueInCents = valueInCents;
        this.quantity = 0;
        this.MAX_QUANTITY = 50;
    }

    public Coin(Integer valueInCents, Integer quantity) {
        this.valueInCents = valueInCents;
        this.quantity = quantity;
        this.MAX_QUANTITY = 50;
    }

    public Integer getValueInCents() {
        return valueInCents;
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
        return "Coin: Value = " + valueInCents + ", Quantity = " + quantity + " \n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coin coin = (Coin) o;

        if (valueInCents != null ? !valueInCents.equals(coin.valueInCents) : coin.valueInCents != null) return false;
        return quantity != null ? quantity.equals(coin.quantity) : coin.quantity == null;
    }

    @Override
    public int hashCode() {
        int result = valueInCents != null ? valueInCents.hashCode() : 0;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }
}
