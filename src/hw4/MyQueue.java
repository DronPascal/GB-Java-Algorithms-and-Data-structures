package hw4;

public class MyQueue {
    private int maxSize;
    private MyInt[] queue;
    private int first;
    private int rear;
    private int elemCount;

    public MyQueue(int size) {
        maxSize = size;
        queue = new MyInt[maxSize];
        first = 0;
        rear = -1;
        elemCount = 0;
    }

    public void insert(MyInt elem) {
        if (rear == maxSize - 1) rear = -1;
        queue[++rear] = elem;
        elemCount++;
    }

    public MyInt remove() {
        MyInt cur = queue[first++];
        if (first == maxSize)
            first = 0;
        elemCount--;
        return cur;
    }

    public MyInt peek() {
        return queue[first];
    }

    public boolean isEmpty() {
        return elemCount == 0;
    }

    public boolean isFull() {
        return elemCount == maxSize;
    }

    public int size() {
        return elemCount;
    }
}
