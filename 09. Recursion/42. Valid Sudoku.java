class Solution {
    
    public boolean isValid(int r, int c, char ch, char[][] board){
        for(int j = 0; j < 9; j++)
            if(board[r][j] == ch && j != c) return false;
        for(int i = 0; i < 9; i++)
            if(board[i][c] == ch && i != r) return false;
        int subR0 = (r / 3) * 3, subC0 = (c / 3) * 3;
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                if(board[subR0 + i][subC0 + j] == ch && (subR0 + i) != r && (subC0 + j) != c) return false;
        return true;
    }
    
    public boolean helper(int r, int c, char[][] board){
        if(r == 9) return true;
        
        int nextRow = (c + 1 == 9) ? r + 1 : r;
        int nextCol = (c + 1 == 9) ? 0 : c + 1;
        
        if(board[r][c] != '.'){
            if(isValid(r, c, board[r][c], board) == false) return false;
        }
        return helper(nextRow, nextCol, board);
    }
    
    public boolean isValidSudoku(char[][] board) {
        return helper(0, 0, board);
    }
}
