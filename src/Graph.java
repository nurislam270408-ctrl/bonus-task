import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
    private int vertices;
    private List<List<Edge>> adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int dest, int weight) {
        adjList.get(source).add(new Edge(dest, weight));
    }

    // Realization of Dijkstra algorithm (without PriorityQueue)
    public void dijkstra(int start) {
        int[] dist = new int[vertices];
        boolean[] visited = new boolean[vertices];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 0; i < vertices - 1; i++) {
            int u = findMinDistanceVertex(dist, visited);

            if (u == -1) break;

            visited[u] = true;

            for (Edge edge : adjList.get(u)) {
                int v = edge.getDest();
                int weight = edge.getWeight();

                if (!visited[v] && dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        printDijkstraResults(start, dist);
    }

    private int findMinDistanceVertex(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < vertices; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Output
    private void printDijkstraResults(int start, int[] dist) {
        System.out.println("Shortest paths from vertex " + start + ":");
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < vertices; i++) {
            String distanceStr = (dist[i] == Integer.MAX_VALUE) ? "Unreachable" : String.valueOf(dist[i]);
            System.out.println(i + " \t\t " + distanceStr);
        }
    }
}