public class Main {

    public static void queensCombinations(int qpsf, int tq, int cellNo, String asf){
        if(cellNo == tq * tq){
            if(qpsf == tq) System.out.println(asf);
            return;
        }
        if(qpsf > tq) return;
        
        if(cellNo % tq == tq - 1){
            queensCombinations(qpsf + 1, tq, cellNo + 1, asf + 'q' + '\n');
            queensCombinations(qpsf, tq, cellNo + 1, asf + '-' + '\n');
        }else{
            queensCombinations(qpsf + 1, tq, cellNo + 1, asf + 'q');
            queensCombinations(qpsf, tq, cellNo + 1, asf + '-');
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        queensCombinations(0, n, 0, "");
    }
}
