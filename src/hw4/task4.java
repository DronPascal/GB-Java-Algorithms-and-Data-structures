package hw4;

public class task4 {
    public static void main(String[] args) {
        /*
        Задание 4.4
            Реализуйте приоритетную очередь на основе ссылочных типов данных, например, Integer.
            Оцените время выполнения операций с помощью базового метода System.nanoTime().
         */
        MyPriorityQueue myPriorityQueue = new MyPriorityQueue();

        myPriorityQueue.insert(new Integer(4));
        myPriorityQueue.insert(new Integer(7));
        myPriorityQueue.insert(new Integer(5));
        myPriorityQueue.insert(new Integer(1));

        myPriorityQueue.print();

        long start = System.nanoTime();
        myPriorityQueue.insert(new Integer(20));
        long stop = System.nanoTime();
        System.out.println("insert: " + (stop - start));

        start = System.nanoTime();
        myPriorityQueue.delete();
        stop = System.nanoTime();
        System.out.println("delete: " + (stop - start));

        start = System.nanoTime();
        myPriorityQueue.peek();
        stop = System.nanoTime();
        System.out.println("peek: " + (stop - start));

        start = System.nanoTime();
        myPriorityQueue.isEmpty();
        stop = System.nanoTime();
        System.out.println("isEmpty: " + (stop - start));

        start = System.nanoTime();
        myPriorityQueue.print();
        stop = System.nanoTime();
        System.out.println("print: " + (stop - start));
    }
}
