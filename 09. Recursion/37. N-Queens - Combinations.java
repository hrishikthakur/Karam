// Using Backtracking
// Row on level, Cols as options
// Each row can contains atmost 1 queen

class Solution {
    
    List<List<String>> res = new ArrayList<>();
    
    public boolean isQueenSafe(int r, int c, boolean[][] chess){
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
    
    public void queenCombinations(int r, boolean[][] chess){
        if(r == chess.length){
            List<String> ans = new ArrayList<>();
            for(int i = 0; i < chess.length; i++){
                String currRow = "";
                for(int j = 0; j < chess[0].length; j++){
                    if(chess[i][j] == true) currRow += "Q";
                    else currRow += ".";
                }
                ans.add(currRow);
            }
            res.add(ans);
        }
        
        for(int j = 0; j < chess[0].length; j++){
            if(isQueenSafe(r, j, chess)){
                chess[r][j] = true;
                queenCombinations(r + 1, chess);
                chess[r][j] = false;
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        boolean[][] chess = new boolean[n][n];
        queenCombinations(0, chess);
        return res;
    }
}
