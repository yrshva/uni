package task3;

import java.util.Random;

public class Philosopher extends Thread {
    private String name;
    private Cutlery leftCutlery;
    private Cutlery rightCutlery;
    private boolean isSatisfied;

    public Philosopher(String name, Cutlery leftCutlery, Cutlery rightCutlery) {
        this(leftCutlery, rightCutlery);
        this.name = name;
    }

    public Philosopher(Cutlery leftCutlery, Cutlery rightCutlery) {
        this.leftCutlery = leftCutlery;
        this.rightCutlery = rightCutlery;
        this.isSatisfied = false;
    }

    @Override
    public void run() {
        while(!isSatisfied) {
            if (leftCutlery.take()) {
                System.out.println(name + " took the left cutlery piece.");
                if (rightCutlery.take()) {
                    System.out.println(name + " took the right cutlery piece.");
                    eat();
                    leftCutlery.put();
                    rightCutlery.put();
                } else {
                    System.out.println(name + " could not take the right cutlery piece.");
                    leftCutlery.put();
                    think();
                }
            }  else {
                System.out.println(name + " could not take the left cutlery piece.");
                think();
            }
        }
    }

    private void eat() {
        try {
            sleep(Math.abs(new Random().nextInt()) % 10 * 100);
            this.isSatisfied = true;
            System.out.println(name + " ate.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void think() {
        try {
            System.out.println(name + " is thinking.");
            sleep(Math.abs(new Random().nextInt()) % 10 * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
