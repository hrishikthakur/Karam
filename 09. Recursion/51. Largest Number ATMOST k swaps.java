static String maxString;

public static String swap(int i, int j, String str){
      String res = "";
      for(int k = 0; k < str.length(); k++){
          if(k == i) res += str.charAt(j);
          else if(k == j) res += str.charAt(i);
          else res += str.charAt(k);
      }
      return res;
  }

public static void findMaximum(String str, int k) {
  if(str.compareTo(maxString) > 0) maxString = str;
      if(k == 0) return;
      for(int i = 0; i < str.length() - 1; i++){
          for(int j = i + 1; j < str.length(); j++){
              if(str.charAt(i) < str.charAt(j)){
                  str = swap(i, j, str);
                  findMaximum(str, k - 1);
                  str = swap(i, j, str);
              }
          }
      }
}
