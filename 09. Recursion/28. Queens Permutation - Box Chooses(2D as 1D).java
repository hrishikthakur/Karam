public class Main {
    public static void queensPermutations(int qpsf, int tq, int cellNo, String asf, boolean[] queens) {
        if(cellNo == tq * tq){
            if(qpsf == tq){
                System.out.println(asf);
                System.out.println();
            }
            return;
        }
        
        // "\n" was required to mark end of row hence the if-else is required

        if(cellNo % tq == tq - 1){
            for(int currQueen = 0; currQueen < tq; currQueen++){
                if(queens[currQueen] == false){
                    queens[currQueen] = true;
                    queensPermutations(qpsf + 1, tq, cellNo + 1, asf + 'q' + (currQueen + 1) + "\t\n", queens);
                    queens[currQueen] = false;
                }
            }
            queensPermutations(qpsf, tq, cellNo + 1, asf + '-' + "\t\n", queens);
        }else{
            for(int currQueen = 0; currQueen < tq; currQueen++){
                if(queens[currQueen] == false){
                    queens[currQueen] = true;
                    queensPermutations(qpsf + 1, tq, cellNo + 1, asf + 'q' + (currQueen + 1) + '\t', queens);
                    queens[currQueen] = false;
                }
            }
            queensPermutations(qpsf, tq, cellNo + 1, asf + '-' + '\t', queens);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] queens = new boolean[n];
        queensPermutations(0, n, 0, "", queens);
    }
}
