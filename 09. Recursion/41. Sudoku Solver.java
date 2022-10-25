class Solution {
    
    public boolean isValid(int r, int c, char ch, char[][] board){
        // Row valid
        for(int j = 0; j < 9; j++)
            if(board[r][j] == ch) return false;
        // Col valid
        for(int i = 0; i < 9; i++)
            if(board[i][c] == ch) return false;
        // Submatrix valid
        int subR0 = (r / 3) * 3, subC0 = (c / 3) * 3;
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                if(board[subR0 + i][subC0 + j] == ch) return false;
        return true;
    }
    
    public boolean helper(int r, int c, char[][] board){
        if(r == 9) return true; // +ve base case
        
        int nextRow = (c + 1 == 9) ? r + 1 : r;
        int nextCol = (c + 1 == 9) ? 0 : c + 1;
        
        if(board[r][c] == '.'){
            for(int i = 1; i <= 9; i++){
                if(isValid(r, c, (char)(i + '0'), board)){
                    board[r][c] = (char)(i + '0');
                    boolean ans = helper(nextRow, nextCol, board);
                    if(ans) return true; // Why!?! -> So that we do not backtrack on the once the BC is hit
                    board[r][c] = '.';
                }
            }
        }else{
            boolean ans = helper(nextRow, nextCol, board);
            if(ans) return true; // Why!?! -> So that we do not backtrack on the once the BC is hit
        }
        
        return false;
    }
    
    public void solveSudoku(char[][] board) {
        helper(0, 0, board);
    }
}
