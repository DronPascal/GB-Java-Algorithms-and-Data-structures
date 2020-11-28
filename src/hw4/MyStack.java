package hw4;

public class MyStack {
    private int maxSize;
    private MyInt[] stack;
    private int top;

    public MyStack(int size) {
        this.maxSize = size;
        this.stack = new MyInt[this.maxSize];
        this.top = -1;
    }

    public void push(MyInt elem) {
        this.stack[++this.top] = elem;
    }

    public MyInt pop() {
        return this.stack[this.top--];
    }

    ;

    public MyInt peek() {
        return this.stack[this.top];
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return (this.top == this.maxSize - 1);
    }
}
