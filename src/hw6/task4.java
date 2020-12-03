package hw6;

public class task4 {
    /*
    Задание 6.4
        Реализуйте базовые методы обхода дерева и метода дисплей.
        Реализуйте поиск максимума и минимума.
     */
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert (2, "Аня");
        tree.insert (4, "Ваня");
        tree.insert (1, "Женя");
        tree.insert (3, "Саша");

        System.out.println("Display:");
        tree.print();

        System.out.println("\nMax & Min:");
        tree.max().print();
        tree.min().print();
    }
}
