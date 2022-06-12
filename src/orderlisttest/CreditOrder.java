package orderlisttest;

public class CreditOrder extends Order {

    private Boolean paid;

    public CreditOrder(Integer number, Integer value) {
        super(number, value);
        this.paid = false;
    }

    public String toString() {
        String creditOrderDetails = new String();
        creditOrderDetails += super.toString();
        creditOrderDetails += String.format("%30s", this.paid.toString());
        return creditOrderDetails;
    }

    public void pay() {
        this.paid = true;
    }

    public void refund() {
        if (this.paid) {
            this.refunded = true;
        }
    }

    // self assessment 7 add code here
}
