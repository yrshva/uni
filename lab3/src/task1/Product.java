package task1;

import java.lang.Thread;
import java.util.Random;

public class Product {

    public Product() {
        try {
            Thread.sleep(Math.abs(new Random().nextInt()) % 10 * 100);
            System.out.println("Product produced");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void use() {
        try {
            Thread.sleep(Math.abs(new Random().nextInt()) % 10 * 100);
            System.out.println("Product used");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
