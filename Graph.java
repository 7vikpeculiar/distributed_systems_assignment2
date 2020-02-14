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
            System.out.println(Integer.toString(this.src) + " -> " + Integer.toString(this.dest) + " : "
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
    int parent[];
    int rank[];
    boolean processing;
    int MST_wt = -1;
    boolean unchanged = false;
    boolean MST_processing = false;

    Graph(int nodes_count) {
        this.vertices = nodes_count;
        this.processing = false;
    }

    List<Edge> EdgeList = new ArrayList<Edge>();

    public void addEdge(int src, int dest, int weight) {
        while (this.processing == true) {
        }
        this.processing = true;
        System.out.println("Add Edge");
        Edge new_edge = new Edge(src, dest, weight);
        int index = Collections.binarySearch(this.EdgeList, new_edge);
        System.out.println("Index is :" + String.valueOf(index));
        if (index < 0) {
            this.EdgeList.add(Math.abs(index) - 1, new_edge);
        } else {
            this.EdgeList.add(index, new_edge);
        }
        // this.EdgeList.add(new_edgfinde);
        this.edges++;
        this.unchanged = false;
        this.processing = false;
    }

    public void print() {
        System.out.println("Graph printing");
        System.out.println(this.edges);
        for (int i = 0; i < edges; i++) {
            this.EdgeList.get(i).print();
        }
    }

    public int find(int node) {
        // int initial_node = node;
        // If node == parent or parent == parent's parent
        if (this.parent[this.parent[node]] == this.parent[node]) {
            return this.parent[node];
        } else {
            this.parent[node] = find(this.parent[node]);
        }
        return this.parent[node];
    }

    public void union(int node1, int node2) {
        int node1_parent = find(node1);
        int node2_parent = find(node2);
        if (this.rank[node1_parent] < this.rank[node2_parent]) {
            this.parent[node1_parent] = node2_parent;
        } else if (this.rank[node1_parent] > this.rank[node2_parent]) {
            this.parent[node2_parent] = node1_parent;
        } else {
            this.parent[node1_parent] = node2_parent;
            this.rank[node1_parent]++;
        }
    }

    public int MST() {
        // Already sorted
        // System.out.println("MST Started");
        while (this.MST_processing == true) {
        }
        this.MST_processing = true;
        if (unchanged) {
            System.out.println("Unchanged");
            return this.MST_wt;
        }
        if (this.edges < this.vertices - 1) {
            // MST not possible
            // System.out.println("Case 1");
            this.MST_wt = -1;
            this.unchanged = true;
            this.MST_processing = false;
            return -1;
        }
        int total_weight = 0;
        this.parent = new int[this.vertices];
        this.rank = new int[this.vertices];
        for (int i = 0; i < this.vertices; i++) {
            this.parent[i] = i;
        }
        int i = 0, picked_edges = 0;

        while (picked_edges < this.vertices - 1) {
            // j++;
            // System.out.println("i -> " + String.valueOf(i));
            Edge edge_under_consideration = this.EdgeList.get(i);
            i++;
            int src_parent = find(edge_under_consideration.src);
            int dest_parent = find(edge_under_consideration.dest);
            if (src_parent != dest_parent) {
                total_weight += edge_under_consideration.weight;
                union(edge_under_consideration.src, edge_under_consideration.dest);
                picked_edges++;
            }
            if (i >= this.edges) {
                break;
            }
        }
        if (picked_edges < this.vertices - 1) {
            this.MST_wt = -1;
            this.unchanged = true;
            this.MST_processing = false;
            return -1;
        }

        this.MST_wt = total_weight;
        this.unchanged = true;
        this.MST_processing = false;
        return total_weight;
    }

}
