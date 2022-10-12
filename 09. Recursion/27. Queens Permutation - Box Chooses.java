// 2D as 2D
public class Main {
    public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
        if(row == tq){
            if(qpsf == tq){
                System.out.println(asf);
                System.out.println();
            }
            return;
        }
        
        if(col % tq == tq - 1){
            for(int currQueen = 0; currQueen < tq; currQueen++){
                if(queens[currQueen] == false){
                    queens[currQueen] = true;
                    queensPermutations(qpsf + 1, tq, row + 1, 0, asf + 'q' + (currQueen + 1) + "\t\n", queens);
                    queens[currQueen] = false;
                }
            }
            queensPermutations(qpsf, tq, row + 1, 0, asf + '-' + "\t\n", queens);
        }else{
            for(int currQueen = 0; currQueen < tq; currQueen++){
                if(queens[currQueen] == false){
                    queens[currQueen] = true;
                    queensPermutations(qpsf + 1, tq, row, col + 1, asf + 'q' + (currQueen + 1) + '\t', queens);
                    queens[currQueen] = false;
                }
            }
            queensPermutations(qpsf, tq, row, col + 1, asf + '-' + '\t', queens);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] queens = new boolean[n];
        queensPermutations(0, n, 0, 0, "", queens);
    }
}
