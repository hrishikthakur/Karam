class Tree
{
     void helper(Node root, int k, ArrayList<Integer> res){
         if(root == null) return;
         if(k == -1) return;
         
         if(k == 0){
             res.add(root.data);
             return;
         }
         
         helper(root.left, k - 1, res);
         helper(root.right, k - 1, res);
     }
     
     ArrayList<Integer> Kdistance(Node root, int k)
     {
          ArrayList<Integer> res= new ArrayList<>();
          helper(root, k, res);
          return res;
     }
}
