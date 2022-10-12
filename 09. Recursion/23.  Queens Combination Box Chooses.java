// Box on level
public class Main {
    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){
        if(row == tq){
            if(qpsf == tq) System.out.println(asf);
            return;
        }
        if(qpsf > tq) return;
        
        if(col == tq - 1){
            queensCombinations(qpsf + 1, tq, row + 1, 0, asf + 'q' + '\n');
            queensCombinations(qpsf, tq, row + 1, 0, asf + '-' + '\n');
        }else{
            queensCombinations(qpsf + 1, tq, row, col + 1, asf + 'q');
            queensCombinations(qpsf, tq, row, col + 1, asf + '-');
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        queensCombinations(0, n, 0, 0, "");
    }
}
