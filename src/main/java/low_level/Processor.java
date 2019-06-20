package low_level;

import java.util.LinkedList;

public class Processor {

    private LinkedList<Integer> list = new LinkedList<>();
    private final int LIMIT = 10;
    private Object lock = new Object();

    public void produce() throws InterruptedException {
        int value = 0;

        while (true) {
            synchronized (lock) {

                while (list.size() == LIMIT) {
                    lock.wait();
                }
                list.add(value++);
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                System.out.println("Size list: " + list.size());
                int value = list.removeFirst();
                System.out.println("; value is " + value);
                lock.notify();
            }
        }
    }
}
