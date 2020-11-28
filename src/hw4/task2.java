package hw4;

public class task2 {
    public static void main(String[] args) {
        /*
         Задание 4.2
            На основе данных объектного списка из задания 3.4 реализуйте простую очередь и его базовые методы.
            Реализуйте вспомогательные методы.
            Оцените время выполнения операций с помощью базового метода System.nanoTime().
         */
        MyQueue myQueue = new MyQueue(1);

        MyInt newElem = new MyInt(1);
        long start = System.nanoTime();
        myQueue.insert(newElem);
        long stop = System.nanoTime();
        System.out.println("insert: " + (stop - start));

        start = System.nanoTime();
        myQueue.remove();
        stop = System.nanoTime();
        System.out.println("remove: " + (stop - start));

        start = System.nanoTime();
        myQueue.peek();
        stop = System.nanoTime();
        System.out.println("peek: " + (stop - start));

        start = System.nanoTime();
        myQueue.isEmpty();
        stop = System.nanoTime();
        System.out.println("isEmpty: " + (stop - start));

        start = System.nanoTime();
        myQueue.isFull();
        stop = System.nanoTime();
        System.out.println("isFull: " + (stop - start));
    }
}
