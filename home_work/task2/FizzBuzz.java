package home_work.task2;

import java.util.function.IntConsumer;

public class FizzBuzz {
    private final int endingValue;
    private int currentValue = 1;

    public FizzBuzz(int number) {
        this.endingValue = number;
    }

    public synchronized void fizz(Runnable printFizz) {

        while (currentValue <= endingValue) {

            if (currentValue % 3 == 0 && currentValue % 5 != 0) {
                printFizz.run();
                currentValue++;
                notifyAll();
            } else {
                exceptions();
            }
        }

    }

    public synchronized void buzz(Runnable printBuzz) {

        while (currentValue <= endingValue) {

            if (currentValue % 5 == 0 && currentValue % 3 != 0) {
                printBuzz.run();
                currentValue++;
                notifyAll();
            } else {
                exceptions();
            }
        }

    }

    public synchronized void fizzbuzz(Runnable printFizzBuzz) {

        while (currentValue <= endingValue) {

            if (currentValue % 15 == 0) {
                printFizzBuzz.run();
                currentValue++;
                notifyAll();
            } else {
                exceptions();
            }
        }

    }

    public synchronized void number(IntConsumer printNumber) {

        while (currentValue <= endingValue) {

            if (currentValue % 3 != 0 && currentValue % 5 != 0) {
                printNumber.accept(currentValue);
                currentValue++;
                notifyAll();
            } else {
                exceptions();
            }

        }

    }

    public void exceptions() {

        try {
            wait();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }

}




