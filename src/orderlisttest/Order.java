package orderlisttest;

public abstract class Order {

    private Integer number;
    protected Integer value;
    private Boolean delivered;
    protected Boolean refunded;
    protected Boolean paid;

    public Order(Integer number, Integer value) {
        this.value = value;
        this.delivered = false;
        this.refunded = false;
        this.number = number;
        this.paid = false;
    }

    public String toString() {
        String orderDetails = new String();
        orderDetails += String.format("%-10d", this.number);
        if (this instanceof CashOrder) {
            orderDetails += String.format("%-10s", "Cash");
        } else {
            orderDetails += String.format("%-10s", "Credit");
        }
        orderDetails += String.format("%10d%15s%15s", this.value, this.delivered.toString(), this.refunded.toString());
        return orderDetails;
    }

    public abstract void refund();

    public void deliverOrder() {
        this.delivered = true;
    }

    public void refundOrder() {
        this.refunded = true;
    }

    public void payOrder() {
        this.paid = true;
    }

    public Integer getNumber() {
        return this.number;
    }

}
