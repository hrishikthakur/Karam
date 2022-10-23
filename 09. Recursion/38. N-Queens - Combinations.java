// Branch & Bound
class Solution {
    
    boolean[] col;
    boolean[] ld;
    boolean[] rd;
    List<List<String>> res = new ArrayList<>();
    
    public boolean isQueenSafe(int r, int c, boolean[][] chess){
        int n = chess.length;
        return ((col[c] == true) || (ld[r - c + n - 1] == true) || (rd[r + c] == true)) ? false : true; 
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
                chess[r][j] = col[j] = ld[(r - j + chess.length - 1)] = rd[r + j] = true;
                queenCombinations(r + 1, chess);
                chess[r][j] = col[j] = ld[r - j + (chess.length - 1)] = rd[r + j] = false;
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        ld = new boolean[2 * n - 1];
        rd = new boolean[2 * n - 1];
        
        boolean[][] chess = new boolean[n][n];
        queenCombinations(0, chess);
        return res;
    }
}
