package task2;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class Task2 {

  private static final ReentrantLock writeLock = new ReentrantLock();
  private static AtomicInteger readCount = new AtomicInteger(0);

  static class Read implements Runnable {
    @Override
    public void run() {
      try {
        sleep(new Random().nextInt(100) % 5 * 10);
        synchronized (writeLock) {
          while (writeLock.isLocked()) {
            writeLock.wait();
          }
        }
        readCount.incrementAndGet();

        System.out.println("Thread " + Thread.currentThread().getName() + " is READING");
        sleep(150);
        System.out.println("Thread " + Thread.currentThread().getName() + " has FINISHED READING");


        readCount.decrementAndGet();
      } catch (InterruptedException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  static class Write implements Runnable {
    @Override
    public void run() {
      try {
        sleep(new Random().nextInt(100) % 5 * 10);
        writeLock.lock();
        while(readCount.get()>0){
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " is WRITING");
        sleep(250);
        System.out.println("Thread " + Thread.currentThread().getName() + " has finished WRITING");
        synchronized (writeLock) {
          writeLock.notifyAll();
          writeLock.unlock();
        }
      } catch (InterruptedException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  public static void run(int readersCount, int writersCount) {
    System.out.println("Readers and writers problem BEGIN");
    Thread[] readers = new Thread[readersCount];
    Thread[] writers = new Thread[writersCount];

    for (int i = 0; i < readersCount; i++) {
      readers[i] = new Thread(new Read());
    }

    for (int i = 0; i < writersCount; i++) {
      writers[i] = new Thread(new Write());
    }

    for (Thread t : writers) {
      t.start();
    }
    for (Thread t : readers) {
      t.start();
    }

    for (Thread t : readers) {
      try {
        t.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    for (Thread t : writers) {
      try {
        t.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("Readers and writers problem END");

  }
}