package miu;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class CompletedFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(10);
        Long strt = System.currentTimeMillis();
        Supplier<Integer> productNum = () -> ProductService.returnProduct();
        Function<Integer,String> orderSummary = productNumb -> new OrderService(productNumb).createOrder(productNumb);
        Function<String,String> printService = order -> new NotificationService(order).print(order);

        for(int i=0;i<10000;i++){
            CompletableFuture<String> orderSumm = CompletableFuture.supplyAsync(productNum)
                    .thenApply(productNums -> orderSummary.apply(productNums))
                    .thenApply(orderS -> printService.apply(orderS));
            //System.out.println(orderSumm.get());
        }
        service.shutdown();
        System.out.println(System.currentTimeMillis()-strt);

    }
}
