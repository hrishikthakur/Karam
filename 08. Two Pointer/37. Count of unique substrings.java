// Time:O(2N), Space:O(N)
import java.util.*;

public class Main {

  public static int solution(String str) {
      
    int left = 0, count_subs = 0;
    HashMap<Character, Integer> freq = new HashMap<>();
    for(int right = 0; right < str.length(); right++){
        char inc = str.charAt(right);
        freq.put(inc, freq.getOrDefault(inc, 0) + 1);
        
        while(freq.get(inc) > 1){
            char exc = str.charAt(left);
            if(freq.get(exc) == 1) freq.remove(exc);
            else freq.put(exc, freq.get(exc) - 1);
            left++;
        }
        count_subs += right - left + 1;
    }
    return count_subs;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    System.out.println(solution(str));
  }

}
