package Polyaeva;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final int stringLength = 100_000;
        final int numberOfTexts = 10_000;

        Thread thread = new Thread(() ->
        {
            int i = 0;
            while (i < numberOfTexts) {
                try {
                    String string = (Generator.generateText("abc", stringLength));
                    Process.first.put(string);
                    Process.second.put(string);
                    Process.third.put(string);
                    i++;
                } catch (InterruptedException e) {
                    return;
                }
            }
        });
        thread.start();
        Thread threadA = new Thread(() ->
        {
            for (int i = 0; i < numberOfTexts; i++) {
                try {
                    Process.maxA();
                } catch (InterruptedException e) {
                    return;
                }
            }
        });
        threadA.start();
        Thread threadB = new Thread(() -> {
            for (int i = 0; i < numberOfTexts; i++) {
                try {
                    Process.maxB();
                    ;
                } catch (InterruptedException e) {
                    return;
                }
            }
        });
        threadB.start();
        Thread threadC = new Thread(() -> {
            for (int i = 0; i < numberOfTexts; i++) {
                try {
                    Process.maxC();
                } catch (InterruptedException e) {
                    return;
                }
            }
        });
        threadC.start();

        thread.join();
        threadA.join();
        threadB.join();
        threadC.join();

        System.out.println("Letter a is met maximum " + Process.numberForLetterA + " times in one text.");
        System.out.println("Letter b is met maximum " + Process.numberForLetterB + " times in one text.");
        System.out.println("Letter c is met maximum " + Process.numberForLetterC + " times in one text.");

    }
}