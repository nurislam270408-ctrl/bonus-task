public class Edge {
    private int dest;
    private int weight;

    public Edge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }

    public int getDest() {
        return dest;
    }

    public int getWeight() {
        return weight;
    }
}