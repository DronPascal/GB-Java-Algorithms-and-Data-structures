package hw5;

public class task4 {
    /*
    Задание 5.4
        Реализуйте простой алгоритм использующий цикл и простой алгоритм использующий рекурсию.
        Оцените два алгоритма с помощью базового метода System.nanoTime().
     */
    public static void main(String[] args) {

        long start = System.nanoTime();
        long sum1 = cycle(1, 5000);
        long finish = System.nanoTime();
        long forTime = (finish - start);
        System.out.println("For result: " + sum1);
        System.out.println("for time: " + forTime + "ns");

        start = System.nanoTime();
        long sum2 = recursion(1, 5000);
        finish = System.nanoTime();
        System.out.println("Recursion result: " + sum2);
        System.out.println("recursion time: " + (finish - start) + "ns");

        System.out.println("recursion spend " + ((finish - start) - forTime) + "ns more then for");
    }

    static long cycle(int cur, int last) {
        long sum = 0;
        for (int i = cur; i <= last; i++) {
            sum += i;
        }
        return sum;
    }

    static long recursion(int cur, int last) {
        if (cur <= last) {
            return (cur + recursion(cur + 1, last));
        }
        return 0;
    }
}
