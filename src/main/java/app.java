public class app {

    static class Runner extends Thread {
        @Override
        public void run() {

            for (int i = 0 ; i < 10; i++) {
                System.out.println("Hello " + i);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.start();
    }

}
