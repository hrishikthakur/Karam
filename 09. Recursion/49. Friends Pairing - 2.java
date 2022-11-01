public class Main {
    
  static int counter = 1;
  
  public static void pair(int friend, int totalFriends, boolean[] vis, String asf) {
    if(friend > totalFriends){
        System.out.println(counter + "." + asf);
        counter += 1;
        return;
    }
    
    // What is this for ?!?
    if(vis[friend] == true){
        pair(friend + 1, totalFriends, vis, asf);
        return;
    }
    
    vis[friend] = true;
    pair(friend + 1, totalFriends, vis, asf + "(" + friend + ") ");
    
    for(int i = friend + 1; i <= totalFriends; i++){
        if(vis[i] == false){
            vis[i] = true;
            pair(friend + 1, totalFriends, vis, asf + "(" + friend + "," + i + ") ");
            vis[i] = false;
        }
    }
    vis[friend] = false;
  }

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    boolean[] used = new boolean[n + 1];
    pair(1, n, used, "");
  }
}
