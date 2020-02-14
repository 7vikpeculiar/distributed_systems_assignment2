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
<<<<<<< HEAD
    int parent[];
    int rank[];
=======
    boolean processing;
>>>>>>> f6f711389bb0448aed7e6498070eb1d52dc4082e

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
        if(node != this.parent[node]) {
            this.parent[node] = find(this.parent[node]);
        }
        // this.parent[initial_node] = node;
        return node;
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
        try{
        System.out.println("MST Started");
        int total_weight = 0;
        this.parent = new int[this.vertices];
        this.rank = new int[this.vertices];
        for (int i = 0; i < this.vertices; i++) {
            this.parent[i] = i;
        }
        int i = 0, picked_edges = 0;
        while (picked_edges < this.vertices - 1) {
            // j++;
            System.out.println("i->"+String.valueOf(i));
            Edge edge_under_consideration = this.EdgeList.get(i);
            i++;
            int src_parent = find(edge_under_consideration.src);
            int dest_parent = find(edge_under_consideration.dest);
            if (src_parent != dest_parent) {
                total_weight += edge_under_consideration.weight;
                union(edge_under_consideration.src, edge_under_consideration.dest);
                picked_edges++;
            }
        }
        return total_weight;}
        catch (Exception e) 
        { 
            // printStackTrace method 
            // prints line numbers + call stack 
            e.printStackTrace(); 
              
            // Prints what exception has been thrown 
            System.out.println(e); 
            return 0;
        } 
    }

}
