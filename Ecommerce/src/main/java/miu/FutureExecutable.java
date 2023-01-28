package miu;

import java.lang.reflect.InaccessibleObjectException;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class FutureExecutable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Long strt = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            Future<Integer> productNum = executorService.submit(new ProductService());
            Future<String> orderSummary = executorService.submit(new OrderService(productNum.get()));
            Future<String> print = executorService.submit(new NotificationService(orderSummary.get()));
            //System.out.println(orderSummary.get());
        }
        executorService.shutdown();
        System.out.println(System.currentTimeMillis()-strt);
    }
}
