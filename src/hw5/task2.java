package hw5;

public class task2 {
    public static void main(String[] args) {
        /*
        Задание 5.2
            Реализуйте простой пример бесконечной рекурсии и обычной рекурсии с условием для выхода.
         */
        recursionIf(2);
        recursionLoop();  // т.к. бесконечная, Exception in thread "main" java.lang.StackOverflowError
    }

    static void recursionLoop() {
        recursionLoop();
    }

    static void recursionIf(int i) {
        if (i > 10) System.out.println(i);
        else recursionIf(i + 1);
    }
}
