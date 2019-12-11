package task4;

import java.util.Random;

public class Customer extends Thread {
    private String name;
    private volatile boolean hasHaircut;
    private Barbershop barbershop;

    public Customer(String name, Barbershop barbershop) {
        this.name = name;
        this.barbershop = barbershop;
        this.hasHaircut = false;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " is going to visit the barbershop soon.");
            sleep(Math.abs(new Random().nextInt()) % 10 * 150);
            if (!barbershop.appoint(this)) {
                System.out.println(name + " saw no free places at the barbershop and left.");
            } else {
                System.out.println(name + " took a place at the barbershop.");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void receiveHaircut() {
        this.hasHaircut = true;
        try {
            sleep(Math.abs(new Random().nextInt()) % 10 * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " received the haircut.");
    }
}
