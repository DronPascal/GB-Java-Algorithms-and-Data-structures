package hw4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class task1 {
    public static void main(String[] args) {
        Random random = new Random();
        List<MyInt> myIntsList = new ArrayList<MyInt>();
        for (int i =0; i<10; i++) {
            int newInt = random.nextInt(10);
            myIntsList.add(new MyInt(newInt));
            System.out.print(newInt+" ");
        }
        System.out.println();
        /*
            Задание 4.1
            На основе данных объектного списка из задания 3.4 реализуйте простой стек и его базовые методы.
            Оцените время выполнения операций с помощью базового метода System.nanoTime().
         */
        MyStack myStack = new MyStack(10);
        for (MyInt i:myIntsList) {
            myStack.push(i);
            System.out.print(myStack.peek().getMyInt()+" ");
        }
        System.out.println();

        long start = System.nanoTime();
        myStack.pop();
        long stop = System.nanoTime();
        System.out.println("pop: "+(stop-start));

        MyInt myInt = new MyInt(4);
        start = System.nanoTime();
        myStack.push(myInt);
        stop = System.nanoTime();
        System.out.println("push: "+(stop-start));

        start = System.nanoTime();
        myStack.peek();
        stop = System.nanoTime();
        System.out.println("peek: "+(stop-start));

        start = System.nanoTime();
        myStack.isEmpty();
        stop = System.nanoTime();
        System.out.println("isEmpty: "+(stop-start));

        start = System.nanoTime();
        myStack.isFull();
        stop = System.nanoTime();
        System.out.println("isFull: "+(stop-start));

    }
}


