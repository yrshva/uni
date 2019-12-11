package task4;


import com.github.javafaker.Faker;

public class Task4 {
  public static void run() {
    run(15, 5);
  }

  public static void run(int clients, int waitingChairs) {
    Faker faker = new Faker();
    System.out.println("Sleeping barbers problem BEGIN");
    Barbershop barbershop = new Barbershop(waitingChairs);
    Barber barber = new Barber("B1:" + faker.name().firstName(), barbershop);
    barber.start();

    Customer[] customers = new Customer[clients];
    for (int i = 0; i < clients; i++) {
      customers[i] = new Customer("C" + i + ":" + faker.name().firstName(), barbershop);
      customers[i].start();
    }

    try {
      for (Customer customer : customers) {
        customer.join();
      }
      barber.windUp();
      barber.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Sleeping barbers problem END");
  }
}
