public boolean DFS(ArrayList<Integer> adj[], boolean[] vis, int src, int dest){
        if(src == dest) return true;
        
        vis[src] = true;
        for(int nbr : adj[src]){
            if(vis[nbr] == false){
                if(DFS(adj, vis, nbr, dest)) return true;
            }
        }
        
        return false;
    }
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        // STEP-1 create a 'visited array'
        boolean[] vis = new boolean[n];
        
        // STEP-2 create an 'adjacency list'
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < adj.length; i++)
            adj[i] = new ArrayList<>();
        for(int[] e : edges){
            adj[e[0]].add(e[1]); // agar '0' se '1' ek edge hai ...
            adj[e[1]].add(e[0]); // toh '1' se '0' bhi ek edge hai
        }
        
        // STEP-3 apply DFS on all of the neighbouring vertices
        return DFS(adj, vis, source, destination);
    }
}
