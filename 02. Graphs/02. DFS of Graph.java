class Solution {
    
    public void DFS(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> res){
        
        vis[src] = true;
        res.add(src);
        
        for(Integer vtx : adj.get(src)){
            if(vis[vtx] == false){
                DFS(vtx, adj, vis, res);
            }
        }
    }
    
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean[] vis = new boolean[V];
        
        ArrayList<Integer> res = new ArrayList<>();
        DFS(0, adj, vis, res); // DFS(adj list, visited array, ...);
        return res;
    }
}
