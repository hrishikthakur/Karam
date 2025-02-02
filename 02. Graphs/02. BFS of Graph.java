class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0); // given: Starting from 0
        
        while(q.size() > 0) {
            int vertex = q.remove();
            if(!visited[vertex]) { // Kaam tabhi karro agar visted nahi hai
                visited[vertex] = true; // 1 -> Mark
                res.add(vertex); // 2 -> Print
                ArrayList<Integer> neighbors = adj.get(vertex);
                for(int i = 0; i < neighbors.size(); i++) {
                    q.add(neighbors.get(i)); // 3 -> Add
                }
            }
        }
        return res;
    }
}
