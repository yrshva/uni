package task4;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Barbershop extends LinkedList<Customer> {
    private Semaphore used;

    private int waitingSeats;

    public Barbershop() {
        this.waitingSeats = 1;
    }

    public Barbershop(int waitingSeats) {
        this.waitingSeats = waitingSeats;
        this.used = new Semaphore(waitingSeats);
    }

    public boolean appoint(Customer customer) {
        try {
            this.used.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            if (this.size() >= waitingSeats) {
                return false;
            }
            this.push(customer);
        } finally {
            this.used.release();
        }
        return true;
    }

    public Customer serve() {
        Customer customer = null;
        try {
            this.used.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            while (size() <= 0) {
                System.out.println("Barber went sleeping");
                try {
                    Thread.sleep(Math.abs(new Random().nextInt()) % 10 * 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Barber was woken up");
            }
            customer = this.removeFirst();
        } finally {
            this.used.release();
        }
        return customer;
    }

}
