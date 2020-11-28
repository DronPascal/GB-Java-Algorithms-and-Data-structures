package hw4;

import java.util.LinkedList;

public class MyLinkedStack {
    private int maxSize;
    private LinkedList stack;

    public MyLinkedStack() {
        this.stack = new LinkedList();
    }

    public void push(Object elem) {
        stack.add(0, elem);
    }

    public Object pop() {
        return stack.pop();
    }

    public Object peek() {
        return stack.get(0);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
