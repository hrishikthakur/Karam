// Using BitSet
class Solution {
    
    BitSet col, ld, rd;
    
    public boolean isQueenSafe(int r, int c, boolean[][] chess){
        int n = chess.length;
        return ((col.get(c) == true) || (ld.get(r - c + n - 1) == true) || (rd.get(r + c) == true)) ? false : true;
    }
    
    public int queenCombinations(int r, boolean[][] chess){
        int n = chess.length;
        
        if(r == n){
            return 1;
        }
        
        int count = 0;
        for(int j = 0; j < n; j++){
            if(isQueenSafe(r, j, chess)){
                chess[r][j] = true;
                col.set(j);
                ld.set(r - j + n - 1);
                rd.set(r + j);
                
                count += queenCombinations(r + 1, chess);
                
                chess[r][j] = true;
                col.set(j, false);
                ld.set(r - j + n - 1, false);
                rd.set(r + j, false);
            }
        }
        
        return count;
    }
    
    public int totalNQueens(int n) {
        col = new BitSet(n);
        ld = new BitSet(2 * n - 1);
        rd = new BitSet(2 * n - 1);
        
        boolean[][] chess = new boolean[n][n];
        return queenCombinations(0, chess);
    }
}
