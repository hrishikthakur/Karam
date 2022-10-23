// Box on level -> Incorrect order
public class Main {

    public static boolean isQueenSafe(int row, int col, int[][] chess) {
        // row safe
        for(int j = 0; j < col; j++)
            if(chess[row][j] > 0) return false;
        // col safe
        for(int i = 0; i < row; i++)
            if(chess[i][col] > 0) return false;
        // left diagonal safe
        int i = row, j = col;
        while(i >= 0 && j >= 0){
            if(chess[i][j] > 0) return false;
            i--; j--;
        }
        // right diagonal safe
        i = row; j = col;
        while(i >= 0 && j < chess[0].length){
            if(chess[i][j] > 0) return false;
            i--; j++;
        }
        return true;
    }

    public static void nqueens(int r, int c, int qpsf, boolean[] isQueenPlaced, int[][] chess) {
        
        if(qpsf == chess.length){
            for(int i = 0; i < chess[0].length; i++){
                for(int j = 0; j < chess.length; j++){
                    if(chess[i][j] > 0) System.out.print("q" + chess[i][j] + "\t");
                    else System.out.print("-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        
        if(r == chess.length) return;
        
        for(int q = 0; q < isQueenPlaced.length; q++){
            if(isQueenPlaced[q] == false && isQueenSafe(r, c, chess)){
                isQueenPlaced[q] = true;
                chess[r][c] = (q + 1);
                
                if(c == chess[0].length - 1) nqueens(r + 1, 0, qpsf + 1, isQueenPlaced, chess);
                else nqueens(r, c + 1, qpsf + 1, isQueenPlaced, chess);
                
                isQueenPlaced[q] = false;
                chess[r][c] = 0;
            }
        }
        
        if(c + 1 == chess[0].length) nqueens(r + 1, 0, qpsf, isQueenPlaced, chess);
        else nqueens(r, c + 1, qpsf, isQueenPlaced, chess);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];
        boolean[] isQueenPlaced = new boolean[n];
        nqueens(0, 0, 0, isQueenPlaced, chess);
    }
}
