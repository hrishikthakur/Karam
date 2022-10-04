// Time:O(2^N)
public class Main {
  public static void combinations(String csf, int count_i, int n, int k){
    if(csf.length() == n){
        if(count_i == k) System.out.println(csf);
        return;
    }
    // yes
    combinations(csf + "i", count_i + 1, n, k);
    // no
    combinations(csf + "-", count_i, n, k);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int k = Integer.parseInt(br.readLine());
    combinations("", 0, n, k);
  }
}
