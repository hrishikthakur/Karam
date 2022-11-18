// Using BFS -> Easy
// Time:O(N), Space:O(N)
class Tree
{
    ArrayList<Integer> leftView(Node root)
    {
      ArrayList<Integer> res = new ArrayList<>();
      if(root == null) return res;
      Queue<Node> q = new ArrayDeque<>();
      q.add(root);
      while(q.size() > 0){
          int size = q.size();
          for(int i = 0; i < size; i++){
              Node popped = q.remove();
              if(i == 0) res.add(popped.data);
              if(popped.left != null) q.add(popped.left);
              if(popped.right != null) q.add(popped.right);
          }
      }
      return res;
    }
}

// Using DFS -> important
class Tree
{
    ArrayList<Integer> leftView;
    void DFS(Node root, int level){
        if(root == null) return;
        if(leftView.size() <= level) leftView.add(root.data);
        DFS(root.left, level + 1);
        DFS(root.right, level + 1);
    }
    ArrayList<Integer> leftView(Node root)
    {
      leftView = new ArrayList<>();
      if(root == null) return leftView;
      DFS(root, 0);
      return leftView;
    }
}
