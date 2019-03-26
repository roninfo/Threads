import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class appRunnable {

    static class Runner implements Runnable {

        public void run() {

            for (int i = 0 ; i < 1000; i++) {
                System.out.println("Hello " + i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runner());
        Thread t2 = new Thread(new Runner());

        Date date = new Date();
        ThreadFactory build = new ThreadFactoryBuilder().setNameFormat("5555: iniciado: " + date.toString()).build();

        ExecutorService executorService = Executors.newFixedThreadPool(2, build);
        executorService.submit(t1);
        executorService.submit(t2);
    }

}
