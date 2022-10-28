class Solution {
    
    boolean[][] vis;
    int[] row;
    int[] col;
    public boolean helper(int sr, int sc, char[][] board, String word, int idx){
        if(idx == word.length()){
            return true;
        }
        for(int i = 0; i < 4; i++){
            int x = sr + row[i], y = sc + col[i];
            if(x >= 0 && x < board.length && y >= 0 && y < board[0].length && vis[x][y] == false && board[x][y] == word.charAt(idx)){
                vis[x][y] = true;
                boolean ans = helper(x, y, board, word, idx + 1);
                vis[x][y] = false;
                if(ans) return true;
            }
        }
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        row = new int[]{-1, 0, 1, 0};
        col = new int[]{0, 1, 0, -1};
        vis = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == word.charAt(0)){
                    vis[i][j] = true;
                    boolean ans = helper(i, j, board, word, 1);
                    if(ans) return true;
                    vis[i][j] = false;
                }
            }
        }
        return false;
    }
}
