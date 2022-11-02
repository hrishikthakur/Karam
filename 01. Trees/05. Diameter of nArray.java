public class Solution {
    
    int diameter = 0;
    public int dfs(ArrayList<Integer>[] adj, int root){
        int maxHeight = 0, secondMaxHeight = 0;
        // dfs from each child of node
        for(Integer i : adj[root]){
            int height = dfs(adj, i);
            if(height > maxHeight){
                secondMaxHeight = maxHeight;
                maxHeight = height;
            }else if(height > secondMaxHeight){
                secondMaxHeight = height;
            }
        }
        diameter = Math.max(diameter, maxHeight + secondMaxHeight + 1);
        return maxHeight + 1;
    }
    
    public int solve(int[] A) {
        ArrayList<Integer>[] adj = new ArrayList[A.length];
        for(int i = 0; i < A.length; i++)
            adj[i] = new ArrayList<>();
        
        int root = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] == -1){
                // root node
                root = i;
            }else{
                // for every node adj will have a list of all of its children
                adj[A[i]].add(i);
            }
        }
        
        dfs(adj, root);
        return diameter - 1;
    }
}
