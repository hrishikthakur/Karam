// Box on level
class Solution {
    
    List<List<String>> res = new ArrayList<>();
    
    public boolean isQueenSafe(int r, int c, boolean[][] chess){
        for(int j = 0; j < c; j++)
            if(chess[r][j] == true) return false;
        for(int i = 0; i < r; i++)
            if(chess[i][c] == true) return false;
        int i = r, j = c;
        while(i >= 0 && j >= 0){
            if(chess[i][j] == true) return false;
            i--; j--;
        }
        i = r; j = c;
        while(i >= 0 && j < chess[0].length){
            if(chess[i][j] == true) return false;
            i--; j++;
        }
        return true;
    }

    public void queenCombinations(int r, int c, int qpsf, boolean[][] chess){
        if(qpsf == chess.length){
           List<String> ans = new ArrayList<>(); 
           for(int i = 0; i < chess.length; i++){
               String currRow = "";
               for(int j = 0; j < chess.length; j++){
                   if(chess[i][j] == true) currRow += "Q";
                   else currRow += ".";
               }
               ans.add(currRow);
           }
           res.add(ans);
           return; 
        }
        
        // -ve base case
        if(r == chess.length) return;
        
        if(isQueenSafe(r, c, chess)){
            chess[r][c] = true;
            if(c + 1 == chess[0].length) queenCombinations(r + 1, 0, qpsf + 1, chess);
            else queenCombinations(r, c + 1, qpsf + 1, chess);
            chess[r][c] = false;
        }
        
        if(c + 1 == chess[0].length) queenCombinations(r + 1, 0, qpsf, chess);
        else queenCombinations(r, c + 1, qpsf, chess);
    }
    
    public List<List<String>> solveNQueens(int n) {
        boolean[][] chess = new boolean[n][n];
        queenCombinations(0, 0, 0, chess);
        return res;
    }
}
