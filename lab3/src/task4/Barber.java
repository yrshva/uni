package task4;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Barber extends Thread {
    private String name;
    private Barbershop barbershop;
    private volatile boolean windUp;
    private ReentrantLock busy;

    public Barber(Barbershop barbershop) {
        this.barbershop = barbershop;
        this.windUp = false;
    }

    public Barber(String name, Barbershop barbershop) {
        this(barbershop);
        this.name = name;
    }

    @Override
    public void run() {
        Customer customer = null;
        while (!windUp ||  barbershop.size() > 0) {
            customer = barbershop.serve();
            if (customer !=null) {
                customer.receiveHaircut();
            }
        }
    }


    private void sleep() {
        try {
            System.out.println("Barber " + name + " is sleeping.");
            sleep(Math.abs(new Random().nextInt()) % 10 * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void windUp() {
        this.windUp = true;
    }

    public ReentrantLock getBusy() {
        return busy;
    }
}
