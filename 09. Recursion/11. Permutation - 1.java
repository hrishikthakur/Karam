public class Main {

  public static void permutations(int[] boxes, int currItem, int totalItems){
    if(currItem > totalItems){
        for(int i : boxes)
            System.out.print(i);
        System.out.println();
        return;
    }
    
    for(int currBox = 0; currBox < boxes.length; currBox++){
        if(boxes[currBox] == 0){
            boxes[currBox] = currItem;
            permutations(boxes, currItem + 1, totalItems);
            boxes[currBox] = 0;
        }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int k = Integer.parseInt(br.readLine());
    int[] boxes = new int[n];
    permutations(boxes, 1, k);
  }
}
