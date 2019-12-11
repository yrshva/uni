package task1;

public class Task1 {
    public static void run() {
        run (1, 4, 10);
    }

    public static void run(int consumersAndProducers, int bufferSize, int productionPerProducer) {
        System.out.println("Producer-consumer problem BEGIN");
        int amount = consumersAndProducers;
        ProductBuffer buffer = new ProductBuffer(bufferSize);
        Producer[] producers = new Producer[amount];
        Consumer[] consumers = new Consumer[amount];

        for (int i = 0; i < amount; i++) {
            producers[i] = new Producer(buffer).produce(productionPerProducer);
            consumers[i] = new Consumer(buffer);
            producers[i].start();
            consumers[i].start();
        }
        for (Producer producer : producers) {
            try {
                producer.windUp();
                producer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (Consumer consumer : consumers) {
            try {
                consumer.windUp();
                consumer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Producer-consumer problem END\n");
    }
}
