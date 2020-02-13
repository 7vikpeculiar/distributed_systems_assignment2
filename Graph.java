import java.util.*;

public class Graph {
    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        public void print() {
            System.out.println(Integer.toString(this.src) + " -> " + Integer.toString(this.dest) + " -> "
                    + Integer.toString(this.weight));
        }

        @Override
        public int compareTo(Edge emp) {
            // let's sort the employee based on an id in ascending order
            // returns a negative integer, zero, or a positive integer as this employee id
            // is less than, equal to, or greater than the specified object.
            return (this.weight - emp.weight);
        }
    };

    String id;
    int edges = 0;
    int vertices;

    Graph(int nodes_count) {
        this.vertices = nodes_count;
    }

    List<Edge> EdgeList = new ArrayList<Edge>();

    public void addEdge(int src, int dest, int weight) {
        System.out.println("Add Edge");
        Edge new_edge = new Edge(src, dest, weight);
        int index = Collections.binarySearch(this.EdgeList, new_edge);
        System.out.println("Index is :");
        System.out.println(index);
        if (index < 0) {
            this.EdgeList.add(Math.abs(index) - 1, new_edge);
        } else {
            this.EdgeList.add(index, new_edge);
        }
        // this.EdgeList.add(new_edge);
        this.edges++;
    }

    public void print() {
        System.out.println("Graph printing");
        System.out.println(this.edges);
        for (int i = 0; i < edges; i++) {
            this.EdgeList.get(i).print();
        }
    }

}
