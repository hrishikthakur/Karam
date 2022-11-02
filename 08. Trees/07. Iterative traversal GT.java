public static class Pair{
    Node node;
    int state;
    
    Pair(Node node, int state){
        this.node = node;
        this.state = state;
    }
}

  public static void IterativePreandPostOrder(Node node) {
      
    Stack<Pair> stk = new Stack<>();
    stk.push(new Pair(node, -1));
    
    String pre = "";
    String post = "";
    while(stk.size() > 0){
        Pair top = stk.peek();
        if(top.state == -1){
            // preorder
            pre += top.node.data + " ";
            top.state++;
        }else if(top.state == top.node.children.size()){
            // postorder
            post += top.node.data + " ";
            stk.pop();
        }else{
            // 0 <= top.state <= parent.node.children.size() - 1
            stk.push(new Pair(top.node.children.get(top.state), -1));
            top.state++;
        }
    }
    System.out.println(pre);
    System.out.println(post);
  }
