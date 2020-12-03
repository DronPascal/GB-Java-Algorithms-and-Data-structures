package hw7;

public class hw7 {
    /*
    Задание 7.2
        Реализуйте базовые методы графа.
    Задание 7.3
        В программный код из задания 7.2 добавьте реализацию метода обхода в глубину.
        Выполните оценку времени с помощью System.nanoTime().
    Задание 7.4
        В базовом графе из задания 7.2 реализуйте метод обхода в ширину.
        Выполните оценку времени с помощью System.nanoTime().
     */
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('H');


        graph.addEdge(0, 1); //AB
        graph.addEdge(1, 2); //BC
        graph.addEdge(0, 3); //AD
        graph.addEdge(3, 4); //DE
        graph.addEdge(0, 5); //AH

        long start = System.nanoTime();
        graph.dfs(0);
        long stop = System.nanoTime();
        System.out.println("\ngraph.dfs(0) done in "+ (stop-start)+ "ns\n");

        graph.setVertexNotVisited();

        start = System.nanoTime();
        graph.bfs(0);
        stop = System.nanoTime();
        System.out.println("\ngraph.bfs(0) done in "+ (stop-start)+ "ns\n");
    }
}

class Vertex {
    public char label;
    public boolean wasVisited;

    public Vertex(char label) {
        this.label = label;
        this.wasVisited = false;
    }
}

class Graph {
    private final int MAX_VERTS = 32;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int size;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        size = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    public void setVertexNotVisited(){
        for (int i=0; i< size; i++)
            vertexList[i].wasVisited=false;
    }

    public void addVertex(char label) {
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int vertex) {
        System.out.println(vertexList[vertex].label);
    }

    private int getAdjUnvisitedVertex(int ver) {
        for (int i = 0; i < size; i++) {
            if (adjMat[ver][i] == 1 && vertexList[i].wasVisited == false) {
                return i;
            }
        }
        return -1;
    }

    // Поиск в глубину
    public void dfs(int f) {
        vertexList[f].wasVisited = true;

        for (int i = 0; i < size; i++) {
            int v = getAdjUnvisitedVertex(f);
            if (!vertexList[i].wasVisited && v != -1) {
                fullDisplayVertex(f, v);
                dfs(i);
            }
        }
    }

    // Поиск в ширину
    public void bfs(int v) {
        int[] queue = new int[size];
        int qH = 0;
        int qT = 0;

        vertexList[0].wasVisited = true;
        queue[qT++] = v;
        displayVertex(0);
        int v2;

        while (qH < qT) {
            v = queue[qH++];

            for (int i = 0; i < size; i++) {
                v2 = getAdjUnvisitedVertex(v);
                if (!vertexList[i].wasVisited && v2 != -1) {
                    vertexList[i].wasVisited = true;
                    displayVertex(qT);
                    queue[qT++] = i;
                }
            }
        }
        for (int i = 0; i < size; i++)
            vertexList[i].wasVisited = false;
    }


    void fullDisplayVertex(int vertex1, int vertex2) {
        System.out.println("Вершины " + vertexList[vertex1].label + "-" + vertexList[vertex2].label);
    }
}