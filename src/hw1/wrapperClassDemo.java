package hw1;

//суть начинается со строчки Integer I = 5;
public class wrapperClassDemo {
    public static void main(String[] arguments) {
        int i = 5;  //примитивный тип
        changeValue(i);  //передается значение
        System.out.println(i);

        Integer I = 5;  //ссылочный тип
        changeValue(I);  //I передается по ссылке
        System.out.println(I+ ", а должно быть 99?");
    }

    static void changeValue(int num) {
        num = 99;
    }

    static void changeValue(Integer num) {
        num = 99;
    }
}

