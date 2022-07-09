public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

public static void iterativePrePostInTraversal(Node node) {
      
    Stack<Pair> stk = new Stack<>();
    stk.add(new Pair(node, 1));
    
    String pre = "";
    String in = "";
    String post = "";
    while(stk.size() > 0){
        Pair top = stk.peek();
        if(top.state == 1){
            // preorder
            pre += top.node.data + " ";
            top.state++;
            if(top.node.left != null) stk.push(new Pair(top.node.left, 1));
        }else if(top.state == 2){
            // inorder
            in += top.node.data + " ";
            top.state++;
            if(top.node.right != null) stk.push(new Pair(top.node.right, 1));
        }else{
            // postorder
            post += top.node.data + " ";
            stk.pop();
        }
    }
    
    System.out.println(pre);
    System.out.println(in);
    System.out.println(post);
  }
