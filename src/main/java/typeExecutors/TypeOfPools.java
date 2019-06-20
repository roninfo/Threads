package typeExecutors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TypeOfPools {

//    #one pool-1-thread-1
//    ##two pool-1-thread-2
//    ###three pool-1-thread-3
//    ##two pool-1-thread-1
//    ###three pool-1-thread-2
//    ##two pool-1-thread-4
//    ###three pool-1-thread-3
//    ##two pool-1-thread-5
//    ###three pool-1-thread-1
//    ##two pool-1-thread-6
//    ###three pool-1-thread-2

    public static void main(String arg[]) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

        //task to run after 10 seconds delay
        service.schedule(new NewTask("#one"), 10, TimeUnit.SECONDS);

        // task to run repeatedly every 10 seconds
        service.scheduleAtFixedRate(new NewTask("##two"), 15, 10, TimeUnit.SECONDS);

        // task to run repeatedly 10 seconds after previous task completes
        service.scheduleWithFixedDelay(new NewTask("###three"), 15, 10, TimeUnit.SECONDS);

    }

    static class NewTask implements Runnable {
        public NewTask(String name) {
            this.name = name;
        }

        String name;

        @Override
        public void run() {
            System.out.println(name +" "+Thread.currentThread().getName());
        }
    }
}
