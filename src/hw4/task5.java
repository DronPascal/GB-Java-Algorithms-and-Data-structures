package hw4;

public class task5 {
    public static void main(String[] args) {
        /*Задание 4.5
            На основе данных из задания 4.1 и 4.2, реализуйте стек и очередь на базе связанного списка.
            Оцените время выполнения операций с помощью базового метода System.nanoTime().
         */
        System.out.println("MyLinkedStack");
        MyLinkedStack myLinkedStack = new MyLinkedStack();

        MyInt newElem = new MyInt(1);
        long start = System.nanoTime();
        myLinkedStack.push(newElem);
        long stop = System.nanoTime();
        System.out.println("push: "+(stop-start));

        start = System.nanoTime();
        myLinkedStack.peek();
        stop = System.nanoTime();
        System.out.println("peek: "+(stop-start));

        start = System.nanoTime();
        myLinkedStack.pop();
        stop = System.nanoTime();
        System.out.println("pop: "+(stop-start));

        start = System.nanoTime();
        myLinkedStack.isEmpty();
        stop = System.nanoTime();
        System.out.println("isEmpty: "+(stop-start));



        System.out.println("\nMyLinkedQueue");
        MyLinkedQueue myLinkedQueue = new MyLinkedQueue();

        MyInt newElem2 = new MyInt(10);
        start = System.nanoTime();
        myLinkedQueue.insert(newElem);
        stop = System.nanoTime();
        System.out.println("insert: "+(stop-start));

        start = System.nanoTime();
        myLinkedQueue.peek();
        stop = System.nanoTime();
        System.out.println("peek: "+(stop-start));

        start = System.nanoTime();
        myLinkedQueue.delete();
        stop = System.nanoTime();
        System.out.println("pop: "+(stop-start));

        start = System.nanoTime();
        myLinkedQueue.isEmpty();
        stop = System.nanoTime();
        System.out.println("isEmpty: "+(stop-start));
    }
}
