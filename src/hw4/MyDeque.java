package hw4;

import java.util.LinkedList;

public class MyDeque {
    private LinkedList deque;

    public MyDeque() {
        deque = new LinkedList();
    }

    public void pushBack(Object elem) {
        deque.addLast(elem);
    }

    public  void pushFront(Object elem){
        deque.addFirst(elem);
    }

    public Object popFront() {
        return deque.removeFirst();
    }

    public Object popBack() {
        return deque.removeLast();
    }

    public Object peekFront() {
        return deque.getFirst();
    }

    public Object peekBack() {
        return deque.getLast();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public int size() {
        return deque.size();
    }

    public void clear(){
        deque.clear();
    }
}

