// Time:O(2N), Space:O(N)
public static int solution(String str, int k) {
  HashMap<Character, Integer> freq = new HashMap<>();
  int left = 0, count_subs = 0;

  for(int right = 0; right < str.length(); right++){
      char inc = str.charAt(right);
      freq.put(inc, freq.getOrDefault(inc, 0) + 1);
      while(freq.size() > k){
          char exc = str.charAt(left);
          if(freq.get(exc) == 1) freq.remove(exc);
          else freq.put(exc, freq.get(exc) - 1);
          left++;
      }
      count_subs += right - left + 1;
  }
  return count_subs;
}
