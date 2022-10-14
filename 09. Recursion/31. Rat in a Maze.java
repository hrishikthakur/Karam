class Solution {
    public static void findPath(ArrayList<String> res, String psf, boolean[][] vis, int[][] mat, int srcRow, int srcCol){
        // -ve base cases
        if(srcRow == -1 || srcCol == mat.length || srcRow == mat.length || srcCol == -1 || mat[srcRow][srcCol] == 0 || vis[srcRow][srcCol] == true) return;
        // +ve base case
        if(srcRow == mat.length - 1 && srcCol == mat.length - 1){
            res.add(psf);
            return;
        }
        
        vis[srcRow][srcCol] = true;
        
        // Lexicographical order of calls
        findPath(res, psf + 'D', vis, mat, srcRow + 1, srcCol);
        findPath(res, psf + 'L', vis, mat, srcRow, srcCol - 1);
        findPath(res, psf + 'R', vis, mat, srcRow, srcCol + 1);
        findPath(res, psf + 'U', vis, mat, srcRow - 1, srcCol);
        
        vis[srcRow][srcCol] = false;
    }
    
    public static ArrayList<String> findPath(int[][] mat, int n) {
        boolean[][] vis = new boolean[n][n];
        ArrayList<String> res = new ArrayList<>();
        findPath(res, "", vis, mat, 0, 0);
        return res;
    }
}

// Using for loop -> without hard coding the calls
// using the matrix itself as a visited matrix
class Solution {
    
    static ArrayList<String> res;
    static int[] x = {1, 0, 0, -1};
    static int[] y = {0, -1, 1, 0};
    static Character[] c = {'D', 'L', 'R', 'U'};
    
    public static void findPath(int sr, int sc, String psf, int[][] mat){
        if(sr == -1 || sc == mat[0].length || sr == mat.length || sc == -1) return;
        // out of matrix
        if(mat[sr][sc] == 0 || mat[sr][sc] == -1) return;
        // blockage node || visited node
        if(sr == mat.length - 1 && sc == mat[0].length - 1){
            res.add(psf);
            return;
        }
        
        mat[sr][sc] = -1; // mark visited
        for(int i = 0; i < 4; i++)
            findPath(sr + x[i], sc + y[i], psf + c[i], mat);
        mat[sr][sc] = 1; // mark unvisited
    }
    
    public static ArrayList<String> findPath(int[][] mat, int n) {
        res = new ArrayList<>();
        findPath(0, 0, "", mat);
        return res;
    }
}
