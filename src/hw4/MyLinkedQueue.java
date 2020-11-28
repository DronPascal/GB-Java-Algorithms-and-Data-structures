package hw4;

import java.util.LinkedList;

public class MyLinkedQueue {
    private LinkedList queue;

    public MyLinkedQueue() {
        queue = new LinkedList();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void insert(Object elem) {
        queue.addLast(elem);
    }

    public Object delete() {
        return queue.removeFirst();
    }

    public Object peek() {
        return queue.getFirst();
    }
}
