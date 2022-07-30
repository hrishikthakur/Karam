public class Solution {

    int globalDia = 0;
    public int dfs(ArrayList<Integer>[] adj, int root){

        int maxHeight = 0, secondMaxHeight = 0;
        // dfs from every node
        for(Integer vtx : adj[root]){
            int height = dfs(adj, vtx);
            if(height > maxHeight){
                secondMaxHeight = maxHeight;
                maxHeight = height;
            }else if(height > secondMaxHeight){
                secondMaxHeight = height;
            }
        }

        globalDia = Math.max(globalDia, maxHeight + secondMaxHeight + 1);
        return maxHeight + 1;
    }


    // the nodes of tree are in range [0, A.length - 1]
    // i denotes the value of node,
    // A[i] is the parent of i
    public int solve(int[] A) {
        // To create adjacency List
        ArrayList<Integer>[] adj = new ArrayList[A.length];
        for(int i = 0; i < adj.length; i++){
            adj[i] = new ArrayList<>();
        }

        int root = 0;
        for(int vtx = 0; vtx < A.length; vtx++){
            int par = A[vtx];
            if(par == -1) root = vtx;
            else adj[par].add(vtx);
        }

        dfs(adj, root);
        return globalDia - 1;
    }
}
