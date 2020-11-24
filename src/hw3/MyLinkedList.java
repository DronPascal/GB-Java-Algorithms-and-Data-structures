package hw3;

import java.util.AbstractList;
import java.util.LinkedList;

class ListElement<E> {
    ListElement next;  // указатель на следующий элемент
    E data;  // данные
}

class MyList<E> extends AbstractList {
    private ListElement head;
    private ListElement tail;

    void addFront(E data) {  //добавить спереди
        ListElement a = new ListElement();  //создаём новый элемент
        a.data = data;
        if (head == null) {  //если список пуст
            head = a;
            tail = a;
        } else {
            a.next = head;
            head = a;
        }
    }

    public boolean add(Object data) {  //добавление в конец списка
        ListElement a = new ListElement();  //создаём новый элемент
        a.data = data;
        if (tail == null) {
            head = a;
            tail = a;
        } else {
            tail.next = a;
            tail = a;
        }
        return true;
    }

    void printList() {
        ListElement t = head;
        while (t != null) {
            System.out.print(t.data + " ");
            t = t.next;
        }
    }

    public boolean remove(Object data) { //удаление элемента
        if (head == null)
            return false;
        if (head == tail) {
            head = null;
            tail = null;
            return false;
        }
        if (head.data == data) {
            head = head.next;
            return false;
        }
        ListElement cur = head;
        while (cur.next != null) {
            if (cur.next.data == data) {
                if (tail == cur.next)
                    tail = cur;
                cur.next = cur.next.next;
                return false;}
            cur = cur.next;
        }
        return true;
    }

    @Override
    public Object get(int index) {
        if (head == null) return null;
        ListElement cur = head;
        int count = 0;
        while (count != index && cur.next != null) {
            count++;
            cur = cur.next;
        }
        return count == index ? cur.data : 0;
    }

    @Override
    public int size() {
        if (head == null) return 0;
        ListElement cur = head;
        int count = 1;
        while (cur.next != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    private class LinkedListIterator
            implements java.util.Iterator<E> {
        private ListElement<E> current = head;

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public E next() {
            E e = current.data;
            current = current.next;
            return e;
        }
    }
}

class My2LinkedList<E> extends LinkedList {
}
