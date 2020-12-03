package hw6;

public class task3 {
    /*
    Задание 6.3
        Реализуйте методы поиска и вставки узла в дерево.
     */
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert (2, "Аня");
        tree.insert (4, "Ваня");
        tree.insert (1, "Женя");
        tree.insert (3, "Саша");

        tree.print();
    }
}
