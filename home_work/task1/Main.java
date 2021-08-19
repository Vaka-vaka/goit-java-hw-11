package home_work.task1;

public class Main {

    public static void main(String[] args) {

        MainStream mainStream = new MainStream();
        OneStream oneStream = new OneStream(mainStream);

        mainStream.start();
        oneStream.start();
    }

}
