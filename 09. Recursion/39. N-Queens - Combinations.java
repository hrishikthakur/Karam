// Using BitSet class
import java.util.BitSet;
class Solution {
    
    BitSet col;
    BitSet ld;
    BitSet rd;
    List<List<String>> res = new ArrayList<>();
    
    public boolean isQueenSafe(int r, int c, boolean[][] chess){
        int n = chess.length;
        return ((col.get(c) == true) || (ld.get(r - c + n - 1) == true) || (rd.get(r + c) == true)) ? false : true; 
    }
    
    public void queenCombinations(int r, boolean[][] chess){
        
        int n = chess.length;
        
        if(r == n){
            List<String> ans = new ArrayList<>();
            for(int i = 0; i < n; i++){
                String currRow = "";
                for(int j = 0; j < n; j++){
                    if(chess[i][j] == true) currRow += "Q";
                    else currRow += ".";
                }
                ans.add(currRow);
            }
            res.add(ans);
        }
    
        for(int j = 0; j < n; j++){
            if(isQueenSafe(r, j, chess)){
                chess[r][j] = true;
                col.set(j);
                ld.set(r - j + n - 1);
                rd.set(r + j);
                
                queenCombinations(r + 1, chess);
                
                chess[r][j] = false;
                col.set(j, false);
                ld.set(r - j + n - 1, false);
                rd.set(r + j, false);
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        col = new BitSet(n);
        ld = new BitSet(2 * n - 1);
        rd = new BitSet(2 * n - 1);
        
        boolean[][] chess = new boolean[n][n];
        queenCombinations(0, chess);
        return res;
    }
}
