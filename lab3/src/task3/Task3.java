package task3;

import com.github.javafaker.Faker;

public class Task3 {
  public static void run() {
    run(5);
  }

  public static void run(int philosophersAndCutleryPieces) {
    Faker faker = new Faker();
    System.out.println("Eating philosophers problem BEGIN");
    int amount = philosophersAndCutleryPieces; // How many philosophers and cutlery pieces should be there
    Cutlery[] cutleries = new Cutlery[amount];
    Philosopher[] philosophers = new Philosopher[amount];
    for (int i = 0; i < amount; i++) {
      cutleries[i] = new Cutlery();
    }
    for (int i = 0; i < amount - 1; i++) {
      philosophers[i] = new Philosopher(faker.name().lastName() + ":" + i, cutleries[i], cutleries[i + 1]);
    }
    philosophers[amount - 1] = new Philosopher(faker.name().lastName() + ":" + (amount - 1), cutleries[amount - 1], cutleries[0]);

    for (Philosopher philosopher : philosophers) {
      philosopher.start();
    }
    for (Philosopher philosopher : philosophers) {
      try {
        philosopher.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("Eating philosophers problem END\n");
  }
}
