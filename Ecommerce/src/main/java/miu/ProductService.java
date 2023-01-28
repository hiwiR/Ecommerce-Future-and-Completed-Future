package miu;

import java.util.Random;
import java.util.concurrent.Callable;

public class ProductService implements Callable<Integer> {


    public static Integer returnProduct(){
        return new Random().nextInt(6);
    }

    @Override
    public Integer call() throws Exception {
        return returnProduct();
        //return Thread.currentThread().getName();
    }
}
