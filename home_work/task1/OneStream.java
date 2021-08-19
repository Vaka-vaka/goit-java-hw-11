package home_work.task1;

public class OneStream extends Thread{
    MainStream mainStream;
    int currentSec;

    public OneStream(MainStream mainStream) {
        this.mainStream = mainStream;
    }

    @Override
    public void run() {
        while (mainStream.isAlive()) {
            try {
                currentSec = mainStream.getCount();
                if (currentSec % 5 == 0 & currentSec != 0) {
                    System.out.println(Thread.currentThread().getName() + " Прошло 5 секунд");
                    sleep(2000);
                }
            } catch (IllegalStateException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finish : " + Thread.currentThread().getName());
    }

}
