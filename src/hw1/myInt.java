package hw1;

public class myInt {
    private int Int;

    public myInt(int Int) {
        this.Int = Int;
    }
    public  myInt(myInt myInt){  //конструктор копирования
        this.Int = myInt.getMyInt();
    }

    public void printMyInt() {
        System.out.println(Int);
    }

    public int getMyInt() {
        return Int;
    }

    public void setMyInt(int myInt) {
        this.Int = myInt;
    }
}
