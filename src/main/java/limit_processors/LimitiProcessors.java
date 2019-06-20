package limit_processors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LimitiProcessors {
    public static void main (String arg[]) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();

        ExecutorService service = Executors.newFixedThreadPool(availableProcessors);

        for (int i=0; i< 1_00000; i++) {
            service.execute(new CpuIntesiveTask(i));
        }
    }

    static class CpuIntesiveTask implements Runnable {
        private volatile int quantidade;
        public CpuIntesiveTask(int quantidade) {
            quantidade = quantidade;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(100);
                ++quantidade;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ " Qntdade: " + quantidade);
        }
    }

}
