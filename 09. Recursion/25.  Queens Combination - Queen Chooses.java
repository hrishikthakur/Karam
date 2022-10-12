// Queen on level
public class Main {

    // here, qpsf == currQueen
    public static void queensCombinations(int qpsf, int totalQueens, Character[][] chess, int lastQueenRow, int lastQueenCol){
        if(qpsf == totalQueens){
            for(int i = 0; i < totalQueens; i++){
                for(int j = 0; j < totalQueens; j++){
                    System.out.print(chess[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        
        for(int j = lastQueenCol + 1; j < totalQueens; j++){
            chess[lastQueenRow][j] = 'q';
            queensCombinations(qpsf + 1, totalQueens, chess, lastQueenRow, j);
            chess[lastQueenRow][j] = '-';
        }
        for(int i = lastQueenRow + 1; i < totalQueens; i++){
            for(int j = 0; j < totalQueens; j++){
                chess[i][j] = 'q';
                queensCombinations(qpsf + 1, totalQueens, chess, i, j);
                chess[i][j] = '-';
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Character[][] chess = new Character[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                chess[i][j] = '-';
        queensCombinations(0, n, chess, 0, -1); // row cannot be -1
    }
}
