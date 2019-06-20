package wait_and_notify;

public class App {

    final static Processor processor = new Processor();

    public static void main (String[] args) throws InterruptedException{

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    processor.produce();
                } catch (InterruptedException exc) {

                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    processor.consume();
                } catch (InterruptedException exc) {

                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
