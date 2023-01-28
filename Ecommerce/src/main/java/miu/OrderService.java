package miu;

import java.util.concurrent.Callable;

public class OrderService implements Callable<String> {

    public Integer num;

    public OrderService(Integer num){
        this.num = num;
    }

    public  String createOrder(Integer num){
        switch (num){
            case 0 :
                return "Apple Screen";
            case 1 :
                return "Apple Watch";

            case 2:
                return "Samasung Galaxy";

            case 3:
                return "Samsung ear pod";

            case 4:
                return "Apple 14";

            case 5:
                return "Apple 14 pro max";

            case 6:
                return "Apple 13 pro max";

            default:
                return "No item matching";

        }
    }

    @Override
    public String call() throws Exception {
        return createOrder(num);
                //Thread.currentThread().getName();
    }
}
