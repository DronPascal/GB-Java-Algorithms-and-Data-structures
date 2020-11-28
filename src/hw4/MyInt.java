package hw4;

public class MyInt {
    private int Int;

    public MyInt(int Int) {
        this.Int = Int;
    }

    public MyInt(MyInt MyInt) {  //конструктор копирования
        this.Int = MyInt.getMyInt();
    }

    public void printMyInt() {
        System.out.println(Int);
    }

    public int getMyInt() {
        return Int;
    }

    public void setMyInt(int MyInt) {
        this.Int = MyInt;
    }
}
