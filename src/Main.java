public class Main {
    public static void main(String[] presidential) {
        // Create graph with 5 vertices (0, 1, 2, 3, 4)
        Graph graph = new Graph(5);

        graph.addEdge(0, 1, 9);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(0, 4, 3);

        graph.addEdge(2, 1, 2);
        graph.addEdge(2, 3, 4);

        // Running Dijkstra from vertex 0
        graph.dijkstra(0);
    }
}