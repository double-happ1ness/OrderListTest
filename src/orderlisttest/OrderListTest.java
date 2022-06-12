package orderlisttest;

import java.util.Scanner;
import java.util.InputMismatchException;

public class OrderListTest {

    public static void main(String[] args) {
        Integer orderListSize = Input.getInteger("order list size: ");
        OrderList orders = new OrderList(orderListSize);
        Integer orderNumber;
        Integer option;
        do {
            System.out.println("0: quit");
            System.out.println("1: add order");
            System.out.println("2: deliver order");
            System.out.println("3: refund order");
            System.out.println("4: pay order");
            System.out.println("5: display unpaid credit orders");
            System.out.println("6: display orders");
            option = Input.getInteger("option: ");
            switch (option) {
                case 0:
                    System.out.println("quitting program");
                    break;
                case 1:
                    System.out.println("1: credit order");
                    System.out.println("2: cash order");
                    Integer type = Input.getInteger("order type: ");
                    Integer number = Input.getInteger("number: ");
                    Integer value = Input.getInteger("value");
                    if (type == 1) {
                        try {
                            System.out.print("Paid? y/n");
                            Scanner scan = new Scanner(System.in);
                            String input = scan.nextLine();
                            if (input.equalsIgnoreCase("y")) {
                                orderNumber = selectOrder(orders);
                                orders.payOrder(orderNumber);
                                System.out.println("Paid");
                            } else if (input.equalsIgnoreCase("n")) {
                                System.out.println("Not paid");
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input!");
                        }
                        orders.addCreditOrder(number, value);
                    } else {
                        Boolean discountApplied = true;
                        orders.addCashOrder(number, value, discountApplied);
                    }

                    break;
                case 2:
                    orderNumber = selectOrder(orders);
                    orders.deliverOrder(orderNumber);
                    break;
                case 3:
                    orderNumber = selectOrder(orders);
                    orders.refundOrder(orderNumber);
                    break;
                case 4:
                    orderNumber = selectOrder(orders);
                    orders.payOrder(orderNumber);
                    break;
                case 5:
                    // self assessment 7 add code here

                    break;
                case 6:
                    System.out.println(orders);
                    break;
                default:
                    System.out.println("invalid option");
            }
        } while (option != 0);
    }

    private static Integer selectOrder(OrderList orders) {
        Integer order;
        System.out.println(orders);
        order = Input.getInteger("order: ");
        return order;
    }
}
