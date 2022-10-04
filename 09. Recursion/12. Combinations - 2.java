public class Main {

  public static void combinations(int[] boxes, int currItem, int totalItems, int lastPlacedBox){
    if(currItem == totalItems){
        for(int i : boxes){
            if(i == 0)System.out.print("-");
            else System.out.print("i");
        }
        System.out.println();
    }
    
    for(int currBox = lastPlacedBox + 1; currBox < boxes.length; currBox++){
        if(boxes[currBox] == 0){
            boxes[currBox] = currItem + 1;
            combinations(boxes, currItem + 1, totalItems, currBox);
            boxes[currBox] = 0;
        }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int k = Integer.parseInt(br.readLine());
    int[] boxes = new int[n];
    combinations(boxes, 0, k, -1);
  }
}
