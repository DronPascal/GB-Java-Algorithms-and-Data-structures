package hw8;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public class task2_3_4 {
    /*
    Задание 8.2
        Приведите примеры ключей и коллизий.
        Если уменьшить размер хэш таблицы, либо увеличить число переменных, хранящихся в ней, то произойдет коллизия, с которой данная хэш-таблица не справляется
        Ключ в данном случае - значение, полученное на выходе хэш-функции и по совместительству являющееся индексом элемента в массиве хэш-таблицы
    Задание 8.3
        Приведите примеры популярных и эффективных хеш-функций.
    */
    // Стандартные методы java
    public static int hash8(String val) throws UnsupportedEncodingException, UnsupportedEncodingException {
        return hash8(String.valueOf(val.getBytes("UTF-8")));
    }

    static int hash1(int k) {
        return String.valueOf(k).hashCode();
    }

    // На основе бинарных сдвигов
    static int hash2(int h) {
        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    static int hash3(int h, int length) {
        return h & (length-1);
    }

    // Примитивный остаток от деления
    static int hashFunc(int key, int size) {
        return key % size;
    }
    /*
    Задание 8.4
        На основе данных массива из задания 2.3 реализуйте хеш-таблицу с помощью открытой адресации, а конкретнее метода линейного пробирования
     */
    public static void main(String[] args) {
        Item aDataItem;
        int aKey;
        int size = 66;

        HashTable hTable = new HashTable(size);
        Random rand = new Random();

        for (int j = 0; j < 15; j++) {
            aKey = rand.nextInt(999);
            aDataItem = new Item(aKey);
            hTable.insert(aDataItem);

        }

        hTable.insert(new Item(999));
        hTable.insert(new Item(203));

        hTable.display();

        System.out.println(hashFunc(999, 66));
        System.out.println(hTable.find(999).getKey());

        hTable.delete(203);

        System.out.println("\n\n2й Вывод ++++++++++++++++++++++++++");
        hTable.display();
    }
}


class Item {
    private int data;

    public Item(int data) {
        this.data = data;
    }

    public int getKey() {
        return this.data;
    }
}

class HashTable {
    private Item[] hashArr;
    private int arrSize;
    private Item nonItem;

    HashTable(int size) {
        this.arrSize = size;

        hashArr = new Item[arrSize];
        nonItem = new Item(-1);
    }


    public void display() {
        for (int i = 0; i < arrSize; i++) {
            if (hashArr[i] != null) {
                System.out.println(hashArr[i].getKey());
            } else {
                System.out.println("***");
            }
        }
    }

    public int hashFunc(int key) {
        return key % arrSize;
    }

    public void insert(Item item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);
        while (hashArr[hashVal] != null && hashArr[hashVal].getKey() != -1) {
            ++hashVal;
            hashVal %= arrSize;
        }
        hashArr[hashVal] = item;
    }

    public Item delete(int key) {
        int hashVal = hashFunc(key);

        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getKey() == key) {
                Item temp = hashArr[hashVal];
                hashArr[hashVal] = nonItem;
                return temp;
            }
            ++hashVal;
            hashVal %= arrSize;
        }
        return null;
    }

    public Item find(int key) {
        int hashVal = hashFunc(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getKey() == key) {
                return hashArr[hashVal];
            }
            ++hashVal;
            hashVal %= arrSize;
        }
        return null;
    }
}