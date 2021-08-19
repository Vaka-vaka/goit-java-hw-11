package home_work.task2;

/*
 *  #2
 * Напишите программу, которая выводит в консоль строку, состоящую из чисел от 1 до n, но с заменой некоторых значений:
 * если число делится на 3 - вывести "fizz"
 * если число делится на 5 - вывести "buzz"
 * если число делится на 3 и на 5 - вывести "fizzbuzz"
 *
 * Например, для n = 15, ожидаемый результат:
 * 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz.
 *
 * Программа должна быть многопоточной, работать с 4 потоками:
 * Поток A вызывает fizz() чтобы проверить делимость на 3 и вывести fizz.
 * Поток B вызывает buzz() чтобы проверить делимость на 5 и вывести buzz.
 * Поток C вызывает fizzbuzz() чтобы проверить делимость на 3 и 5 и вывести fizzbuzz.
 * Поток D вызывает number() чтобы вывести число.
 *
 *
 * */

import java.util.function.IntConsumer;

public class Main {
    public static void main(String[] args) {

        FizzBuzz fizzBuzz = new FizzBuzz(15);
        Runnable printFizz = () -> System.out.println("fizz");
        Runnable printBuzz = () -> System.out.println("buzz");
        Runnable printFizzBuzz = () -> System.out.println("fizzbuzz");
        IntConsumer printNumber = System.out::println;

        new Thread(() -> fizzBuzz.fizz(printFizz)).start();
        new Thread(() -> fizzBuzz.buzz(printBuzz)).start();
        new Thread(() -> fizzBuzz.fizzbuzz(printFizzBuzz)).start();
        new Thread(() -> fizzBuzz.number(printNumber)).start();
    }

}


