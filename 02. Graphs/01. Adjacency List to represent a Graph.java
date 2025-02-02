import java.util.ArrayList;

public class Main {

    public static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {

        /*
                        (5)
                    0 ------- 1
                            /   \
                      (1)  /     \ (3)
                          /       \
                          2 ------  3
         */

        int V = 5;

        // STEP1: Initialize an array of ArrayList with size as number of vertices
        ArrayList<Edge>[] graph = new ArrayList[V];

        // STEP2: Initialize all arrayLists (currently all are pointing to null)
        for(int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // STEP3: put in the form of vertex -> (src, dest, weight)
        // NOTE that src and vertex are the same thing

        graph[0].add(new Edge(0, 1, 5));
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // TO get neighbours of 1 in O(1) just iterate over ArrayList<edges> stored in at index 2 of the graph
    }
}
