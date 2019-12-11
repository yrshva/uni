package task1;

import java.util.Random;

public class Producer extends Thread {
    private ProductBuffer buffer;
    private volatile int toProduce;
    private volatile boolean windUp;

    public Producer(ProductBuffer buffer) {
        this.buffer = buffer;
        this.windUp = false;
        this.toProduce = 0;
    }

    @Override
    public void run() {
        Product toBeAdded = null;
        while(!windUp || toProduce != 0) {
            if (toBeAdded == null) {
                toBeAdded = new Product();
                toProduce--;
            }
            if (buffer.put(toBeAdded)){
                toBeAdded = null;
            }
        }
    }

    public Producer produce(int toProduce) {
        this.toProduce += toProduce;
        return this;
    }


    public void windUp() {
        this.windUp = true;
    }
}
