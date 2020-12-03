package hw6;

public class task5 {
    /*
    Задание 6.5
        Реализуйте метод удаления узла и выполните оценку времени базовых методов дерева с помощью System.nanoTime().
     */
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert(2, "Аня");
        tree.insert(4, "Ваня");
        tree.insert(1, "Женя");
        tree.insert(3, "Саша");

        tree.print();
        long start = System.nanoTime();
        tree.delete(1);
        long stop = System.nanoTime();
        System.out.println("\ntree.delete(1) done in "+ (stop-start)+ "ns\n");
        tree.print();

        start = System.nanoTime();
        tree.insert(10, "Олег");
        stop = System.nanoTime();
        System.out.println("\ntree.insert(10, \"Олег\") done in "+ (stop-start)+ "ns");

        start = System.nanoTime();
        tree.min();
        stop = System.nanoTime();
        System.out.println("tree.min() done in "+ (stop-start)+ "ns");

        start = System.nanoTime();
        tree.max();
        stop = System.nanoTime();
        System.out.println("tree.max() done in "+ (stop-start)+ "ns");

        start = System.nanoTime();
        tree.find(10);
        stop = System.nanoTime();
        System.out.println("tree.find(10) done in "+ (stop-start)+ "ns");

        start = System.nanoTime();
        tree.postOrder();
        stop = System.nanoTime();
        System.out.println("tree.postOrder() done in "+ (stop-start)+ "ns");

        start = System.nanoTime();
        tree.preOrder();
        stop = System.nanoTime();
        System.out.println("tree.preOrder() done in "+ (stop-start)+ "ns");

        start = System.nanoTime();
        tree.inOrder();
        stop = System.nanoTime();
        System.out.println("tree.inOrder() done in "+ (stop-start)+ "ns");
    }
}
