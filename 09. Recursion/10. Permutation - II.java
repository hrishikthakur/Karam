  public static void permutations(int currentBox, int n, int k, boolean[] itemPlaced, String boxes, int itemPlacedCount){
    if(currentBox == n){
        if(itemPlacedCount == k) System.out.println(boxes);
        return;
    }
    
    // current box -> (YES) place an item
    for(int i = 0; i < k; i++){
        if(itemPlaced[i] == false){
            itemPlaced[i] = true;
            permutations(currentBox + 1, n, k, itemPlaced, boxes + (i + 1), itemPlacedCount + 1);
            itemPlaced[i] = false;
        }
    }
    
    // current box -> (NO) do not place an item
    permutations(currentBox + 1, n, k, itemPlaced, boxes + "0", itemPlacedCount);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int k = Integer.parseInt(br.readLine());
    String boxes = "";
    boolean[] itemPlaced = new boolean[k];
    permutations(0, n, k, itemPlaced, boxes, 0);
  }

}
