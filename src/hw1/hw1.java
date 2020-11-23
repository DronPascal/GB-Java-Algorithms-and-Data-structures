package hw1;

/*
    Задание 1.3
    Напишите программный код, в котором все данные хранятся только в переменных трех типов данных: Ссылочные, примитивные и своего класса содержащего: конструктор и метод отображения данных.
    Выведите написанные данные.
    Задание 1.4
    Дополните предыдущий код сравнением ваших данных с другой переменной, данный код должен имитировать простейший поиск перебором.
    Оцените время выполнения алгоритма с помощью базового метода System.nanoTime().
 */
public class hw1 {
    public static void main(String args[]) {
        //ПРИМИТИВНЫЕ ТИПЫ
        byte b = 103;
        short s = 54;
        int i = 87956;
        long l = 870L;
        float f = 760.69f;
        double d = 46.456454;
        boolean bool = true;
        char c = 'A';

        //ССЫЛОЧНЫЕ ТИПЫ
        //при необходимости даже примитивные типы данных могут быть инкапсулированы внутри объектов, предоставляемых библиотекой.
        //может показаться, что они бесполезны, но это не так. Вот лучшее доказательство https://riptutorial.com/ru/java/example/19399/%D1%81%D1%81%D1%8B%D0%BB%D0%BA%D0%B8-%D0%BD%D0%B0-%D0%BE%D0%B1%D1%8A%D0%B5%D0%BA%D1%82%D1%8B-%D0%BA%D0%B0%D0%BA-%D0%BF%D0%B0%D1%80%D0%B0%D0%BC%D0%B5%D1%82%D1%80%D1%8B-%D0%BC%D0%B5%D1%82%D0%BE%D0%B4%D0%B0
        Byte bs = 103;
        Byte bs2 = 103;
        Short ss = 54;
        Integer is = 87956;
        Long ls = 870L;
        Float fs = 760.69f;
        Double ds = 46.456454;
        Boolean bools = true;
        Character cs = 'A';
        String str = "Str";
        //в языке программирования Java массив - это реальный объект с представлением во время выполнения.
        int[] ints = new int[10];  //любые массивы
        myInt myInt = new myInt(1);  //любые классы (т.к. класс - ТИП объекта)

        //благодаря тому, что все типы в java имеют метод toString, мы можем сделать так
        System.out.println("Примитивные: " + b + " " + s + " " + i + " " + l + " " + f + " " + d + " " + bool + " " + c);
        System.out.println("Ссылочные : " + bs + " " + ss + " " + is + " " + ls + " " + fs + " " + ds + " " + bools + " " + cs + " " + str + " " + ints + " " + myInt);

        //хотя bs и bs2 - разные объекты, но их класс реализует интерфейс Comparable, поэтому при их сравнении используется примитивный тип, хранящийся внутри, поэтому результатом будет true
        System.out.println("Bool: " + (bs == bs2));

        //String
        String str2 = "Str";  //ранее было написало String str = "Str";
        System.out.println("String: " + (str == str2));  //true
        String str3 = new String("Str");
        System.out.println("String: " + (str == str3));  //false
        String str4 = str3;
        System.out.println("String: " + (str3 == str4));  //false

        //Случай когда: переменные не ссылаютя на одну ячейку памяти и их класс не реализует интерфейс Comparable -> результатом будет false
        myInt myInt2 = new myInt(1);  //ранее было написано myInt myInt = new myInt(1);
        System.out.println("myInt: " + (myInt == myInt2));

        //так можно сослаться на объект
        myInt myInt3 = myInt;
        System.out.println("myInt: " + (myInt == myInt3) + " (" + myInt + "=" + myInt3 + ")");

        //ОСТАЛИСЬ ВОПРОСЫ.
        // Что за зверь такой String?
        // Почему не выполняют свою задачу классы-обертки над примитивными типами?

        //КАКАЯ ИММИТАЦИЯ ПЕРЕБОРА? ЧТО ЗА БРЕДОВОЕ ЗАДАНИЕ? FACEPALM
        //получите распишитесь
        System.out.println("\nsearch started");
        boolean isFounded = false;
        long start = System.nanoTime();
        if (str == "s") {
        } else if (str == "st") {
        } else if (str == "str") {
        } else if (str == "stR") {
        } else if (str == "sTr") {
        } else if (str == "Str") {
            isFounded = true;
        } else if (str == "sTR") {
        } else { //...
        }
        long finish = System.nanoTime();
        System.out.println("search done in " + (finish - start) + "ns");
    }
}
