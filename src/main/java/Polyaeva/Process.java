package Polyaeva;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Process {
    private static final int queueCapacity = 100;
    public static BlockingQueue<String> first = new ArrayBlockingQueue<>(queueCapacity);
    public static BlockingQueue<String> second = new ArrayBlockingQueue<>(queueCapacity);
    public static BlockingQueue<String> third = new ArrayBlockingQueue<>(queueCapacity);
    static int numberForLetterA = 0;
    static int numberForLetterB = 0;
    static int numberForLetterC = 0;
    static String withA = new String();
    static String withB = new String();
    static String withC = new String();

    public static void maxA() throws InterruptedException {
        String string = first.take();
        Integer counter = Math.toIntExact(string.chars().filter(ch -> ch == 'a').count());
        if (counter >= numberForLetterA) {
            numberForLetterA = counter;
            withA = string;
        }
    }

    public static void maxB() throws InterruptedException {
        String string = second.take();
        Integer counter = Math.toIntExact(string.chars().filter(ch -> ch == 'b').count());
        if (counter >= numberForLetterB) {
            numberForLetterB = counter;
            withB = string;
        }
    }

    public static void maxC() throws InterruptedException {
        String string = third.take();
        Integer counter = Math.toIntExact(string.chars().filter(ch -> ch == 'c').count());
        if (counter >= numberForLetterC) {
            numberForLetterC = counter;
            withC = string;
        }
    }
}