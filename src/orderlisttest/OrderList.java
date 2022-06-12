package orderlisttest;

public class OrderList {

    private Order[] orders;
    private Integer numberOfOrders;
    private Integer number;

    public OrderList(Integer orderListSize) {
        this.orders = new Order[orderListSize];
        this.numberOfOrders = 0;
        this.number = 1;
    }

    public String toString() {
        String orderListDetails = new String();
        if (this.numberOfOrders != 0) {
            orderListDetails += String.format("%-10s%-10s%10s%15s%15s%15s%15s\n", 
                    "NUMBER", "TYPE", "VALUE", "DELIVERED", "REFUNDED", "DISCOUNTED", "PAID");
            for (Integer order = 0; order < this.numberOfOrders; order++) {
                orderListDetails += this.orders[order] + "\n";
            }
        } else {
            orderListDetails += "order list is empty";
        }
        return orderListDetails;
    }

    public void addCreditOrder(Integer number, Integer value) {
        this.orders[this.numberOfOrders] = new CreditOrder(number, value);
        this.numberOfOrders++;
    }

    public void addCashOrder(Integer number, Integer value, Boolean discountApplied) {
        this.orders[this.numberOfOrders] = new CashOrder(number, value, discountApplied);
        this.numberOfOrders++;
    }

    public void deliverOrder(Integer number) {
        Order order = this.getOrder(number);
        order.deliverOrder();
    }

    public void refundOrder(Integer number) {
        Order order = this.getOrder(number);
        order.refundOrder();
    }

    public void payOrder(Integer number) {
        Order order = this.getOrder(number);
        order.payOrder();
    }

    private Order getOrder(Integer number) {
        Order order = null;
        Integer index = 0;
        while (order == null) {
            if (number.equals(this.orders[index].getNumber())) {
                order = this.orders[index];
            } else {
                index++;
            }
        }
        return order;
    }
    // self assessment 7 add code here
}
