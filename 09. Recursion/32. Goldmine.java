class Solution {
    
    static int[] x = {1, 0, 0, -1}; // D, L, R, U
    static int[] y = {0, -1, 1, 0}; // D, L, R, U
    
    public int DFS(int sr, int sc, int[][] grid){
        if(sr == -1 || sc == grid[0].length || sr == grid.length || sc == -1) return 0;
        if(grid[sr][sc] == 0 || grid[sr][sc] == -1) return 0;
        
        int val = grid[sr][sc];
        grid[sr][sc] = -1; // mark visited
        
        int maxGold = 0;
        for(int i = 0; i < 4; i++){
            maxGold = Math.max(maxGold, DFS(sr + x[i], sc + y[i], grid));
        }
        grid[sr][sc] = val; // mark unvisited
        
        return grid[sr][sc] + maxGold;
    }
    
    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                maxGold = Math.max(maxGold, DFS(i, j, grid));
            }
        }
        return maxGold;
    }
}
