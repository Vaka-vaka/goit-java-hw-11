package home_work.task1;

public class MainStream extends Thread {
    int count;

    public synchronized int getCount() {
        return count;
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                count++;
            }
            System.out.println(Thread.currentThread().getName() + " Second: " + count);
            if (count == 16) {
                break;
            }
        }
        System.out.println("Finish : " + Thread.currentThread().getName());
    }

}
