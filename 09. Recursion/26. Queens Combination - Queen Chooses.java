public class Main {

    public static void queensCombinations(int qpsf, int totalQueens, Character[][] chess, int lastQueenCell) {
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
        
        for(int cellNo = lastQueenCell + 1; cellNo < totalQueens * totalQueens; cellNo++){
            int i = cellNo / totalQueens;
            int j =  cellNo % totalQueens;
            chess[i][j] = 'q';
            queensCombinations(qpsf + 1, totalQueens, chess, cellNo);
            chess[i][j] = '-';
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Character[][] chess = new Character[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                chess[i][j] = '-';
        queensCombinations(0, n, chess, -1);
    }
}
