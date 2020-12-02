package hw5;

public class task3 {
    /*
    Задание 5.3
        Приведите пример изображающий стек вызова и стек вызова с рекурсией.
     */

    public static void main(String[] args) {
        m1();  //стек вызова
        recursion(0);  //стек вызова с рекурсией
    }

    private static void recursion(int layer) {
        if (layer < 5) {
            recursion(layer + 1);
            System.out.println("recursion layer: " + layer);
        }
    }

    static void m1() {
        m2();
        System.out.println("m1 done");
    }

    static void m2() {
        m3();
        System.out.println("m2 done");
    }

    static void m3() {
        System.out.println("m3 done");
    }
}
