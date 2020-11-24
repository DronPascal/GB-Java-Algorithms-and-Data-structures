package hw3;

import hw1.myInt;

import java.util.*;


public class hw3 {
    public static void main(String[] args) {
      /*
      Задание 3.1
            На основе массива из домашнего задания 2.1 реализуйте простой список и коллекцию.
            Оцените время выполнения преобразования.
       */
        Integer[] arr = new Integer[20];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++)
            arr[i] = random.nextInt(100);

        //нерасширяемый список, arr используется как модель, на него ссылаются, а не копируют.
        List<Integer> arrayList = new ArrayList<>();
        arrayList = Arrays.asList(arr);

        //копировать надо так. arrList - самостоятельный объект
        ArrayList<Integer> arrList = new ArrayList<>();
        long start = System.nanoTime();
        Collections.addAll(arrList, arr);
        long stop = System.nanoTime();
        System.out.println("Collections.addAll(arrList, arr) done in " + (stop - start) + "ns");

        //“Коллекции” — общее название для нескольких структур данных в Java. Данные можно хранить многими разными способами.
        //Список реализвал, реализую тогда еще LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>();
        start = System.nanoTime();
        Collections.addAll(linkedList, arr);
        stop = System.nanoTime();
        System.out.println("Collections.addAll(linkedList, arr) done in " + (stop - start) + "ns");

        /*
        Задание 3.2
              На основе списка из задания 3.1 реализуйте основные методы добавления, удаления и получения объекта или элемента из списка.
              Оценить выполненные методы с помощью базового класса System.nanoTime().
         */
        //добавление в конец
        System.out.println("\n" + arrList.toString());
        start = System.nanoTime();
        arrList.add(200);
        stop = System.nanoTime();
        System.out.println("arrList.add(200) done in " + (stop - start) + "ns " + arrList.toString());
        //добавление в центр
        start = System.nanoTime();
        arrList.add(10, 200);
        stop = System.nanoTime();
        System.out.println("arrList.add(10, 200) done in " + (stop - start) + "ns " + arrList.toString());
        //удаление из конца
        start = System.nanoTime();
        arrList.remove(21);
        stop = System.nanoTime();
        System.out.println("arrList.remove(21) done in " + (stop - start) + "ns " + arrList.toString());
        //удаление из середины
        start = System.nanoTime();
        arrList.remove(10);
        stop = System.nanoTime();
        System.out.println("arrList.remove(10) done in " + (stop - start) + "ns " + arrList.toString());
        //получение по индексу
        start = System.nanoTime();
        arrList.get(10);
        stop = System.nanoTime();
        System.out.println(arrList.get(10) + " arrList.get(10) done in " + (stop - start) + "ns");

        /*
        Задание 3.3
              Реализуйте простой односвязный список и его базовые методы.
         */
        MyList<Integer> myList = new MyList<Integer>();
        myList.add(43);
        myList.add(54);
        myList.remove(myList.get(0));
        System.out.println(myList.get(0));
        /*
        Задание 3.4
            На основе списка из задания 3.1 реализуйте простой двусторонний список и его базовые методы.
            Реализуйте список заполненный объектами из вашего класса из задания 1.3
         */
        My2LinkedList<Integer> my2LinkedList = new My2LinkedList<Integer>();
        my2LinkedList.add(new myInt(21));
        my2LinkedList.add(0, new myInt(1));
        my2LinkedList.remove(new myInt(1));
        System.out.println(my2LinkedList.get(0));
        /*
        Задание 3.5
            Реализуйте итератор на основе связанных списков из задания 3.4 и выполните базовые операции итератора.
            Оцените время выполнения операций с помощью базового метода System.nanoTime()
         */
        MyList<String> letters = new MyList<String>();
        letters.add("a");
        letters.add("b");
        letters.add("c");
        letters.add("d");

        Iterator<String> iter = letters.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }

        iter = letters.iterator();
        //hasNext
        start = System.nanoTime();
        iter.hasNext();
        stop = System.nanoTime();
        System.out.println("\niter.hasNext() done in " + (stop - start) + "ns ");
        //remove
        start = System.nanoTime();
        iter.next();
        stop = System.nanoTime();
        System.out.println("iter.next() done in " + (stop - start) + "ns ");

    }
}


