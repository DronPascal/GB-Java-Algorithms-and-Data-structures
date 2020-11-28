package hw4;

import java.util.LinkedList;

public class MyPriorityQueue {
    private LinkedList<Integer> queue;

    public MyPriorityQueue() {
        queue = new LinkedList();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void insert(Integer elem) {
        for (int i = 0, size = queue.size(); i<size; i++)
            if (queue.get(i)>elem){
                queue.add(i, elem);
                return;
            }
        queue.addLast(elem);
    }

    public Object delete() {
        return queue.removeFirst();
    }

    public Object peek() {
        return queue.getFirst();
    }

    public void print() {
        System.out.println(queue.toString());
    }
}
