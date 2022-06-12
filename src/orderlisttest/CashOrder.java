package orderlisttest;

public class CashOrder extends Order {

    private Boolean discountApplied;

    public CashOrder(Integer number, Integer value, Boolean discountApplied) {
        super(number, value);
        this.discountApplied = discountApplied;
    }

    public String toString() {
        String cashOrderDetails = new String();
        cashOrderDetails += super.toString();
        cashOrderDetails += String.format("%15s", this.discountApplied.toString());
        return cashOrderDetails;
    }

    public void refund() {
        this.refunded = true;
    }
}
