package miu;

import java.util.concurrent.Callable;

public class NotificationService implements Callable<String> {

    private String orderSummary;
    public NotificationService(String orderSummary){
        this.orderSummary = orderSummary;
    }

    public String print(String orderSummary){
        System.out.println(orderSummary);
        return orderSummary;
    }

    @Override
    public String call() {
        return print(orderSummary);
    }
}
