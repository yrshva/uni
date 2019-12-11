package task3;

import java.util.concurrent.Semaphore;

public class Cutlery {
    public Semaphore item;

    public Cutlery() {
        item = new Semaphore(1);
    }

    public boolean take(){
        return item.tryAcquire();
    }

    public void put(){
        item.release();
    }
}
