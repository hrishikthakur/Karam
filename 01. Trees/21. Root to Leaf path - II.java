public static void pathToLeafFromRoot(Node node, String psf, int sum, int lo, int hi){
  if(node == null) return;
  if(node.left == null && node.right == null){
      sum += node.data;
      if(sum >= lo && sum <= hi){
          System.out.println(psf + node.data);
      }
      return;
  }
  pathToLeafFromRoot(node.left, psf + node.data + " ", sum + node.data, lo, hi);
  pathToLeafFromRoot(node.right, psf + node.data + " ", sum + node.data, lo, hi);
}
