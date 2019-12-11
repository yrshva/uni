package task1;

public class Consumer extends Thread {
    private ProductBuffer buffer;
    private volatile boolean windUp;

    public Consumer(ProductBuffer buffer) {
        this.buffer = buffer;
        this.windUp = false;
    }

    @Override
    public void run() {
        Product toBeUsed = null;
        while(!windUp || toBeUsed != null) {
            toBeUsed = buffer.take();
            if (toBeUsed != null) {
                toBeUsed.use();
            }
        }
    }

    public void windUp() {
        this.windUp = true;
    }
}
