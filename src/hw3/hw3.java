package hw3;

import hw1.myInt;

import java.util.ArrayList;
import java.util.Random;

public class hw3 {
    /*
Задание 3.2
На основе списка из задания 3.1 реализуйте основные методы добавления, удаления и получения объекта или элемента из списка.
Оценить выполненные методы с помощью базового класса System.nanoTime().
Задание 3.3
Реализуйте простой односвязный список и его базовые методы.
Задание 3.4
На основе списка из задания 3.1 реализуйте простой двусторонний список и его базовые методы.
Реализуйте список заполненный объектами из вашего класса из задания 1.3
Задание 3.5
Реализуйте итератор на основе связанных списков из задания 3.4 и выполните базовые операции итератора.
Оцените время выполнения операций с помощью базового метода System.nanoTime()

     */
    public static void main(String[] args) {
      /*
        Задание 3.1
        На основе массива из домашнего задания 2.1 реализуйте простой список и коллекцию.
        Оцените время выполнения преобразования.
       */
        ArrayList<myInt> arr = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < arr.length; i++)
            arr.add(random.nextInt());

        for (myInt arr : ArrayList)
    }
}
