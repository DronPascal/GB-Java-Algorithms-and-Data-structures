package hw4;

public class task3 {
    public static void main(String[] args) {
        /*
        Задание 4.3
            На основе данных объектного списка из задания 3.4 реализуйте простой дек и его базовые методы.
            Оцените время выполнения операций с помощью базового метода System.nanoTime().
         */
        MyDeque myDeque = new MyDeque();

        MyInt newElem = new MyInt(1);
        MyInt newElem2 = new MyInt(10);

        long start = System.nanoTime();
        myDeque.pushFront(newElem);
        long stop = System.nanoTime();
        System.out.println("pushFront: " + (stop - start));

        start = System.nanoTime();
        myDeque.pushBack(newElem2);
        stop = System.nanoTime();
        System.out.println("pushBack: " + (stop - start));

        start = System.nanoTime();
        myDeque.popFront();
        stop = System.nanoTime();
        System.out.println("popFront: " + (stop - start));

        start = System.nanoTime();
        myDeque.popBack();
        stop = System.nanoTime();
        System.out.println("popBack: " + (stop - start));

        start = System.nanoTime();
        myDeque.isEmpty();
        stop = System.nanoTime();
        System.out.println("isEmpty: " + (stop - start));

        start = System.nanoTime();
        myDeque.clear();
        stop = System.nanoTime();
        System.out.println("clear: " + (stop - start));
    }
}
