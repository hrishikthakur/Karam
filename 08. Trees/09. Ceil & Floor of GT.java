static int ceil = Integer.MAX_VALUE;
static int floor = Integer.MIN_VALUE;
public static void ceilAndFloor(Node node, int data) {
  if(node.data > data){
      // ceil
      if(ceil > node.data){
          ceil = node.data;
      }
  }else if(node.data < data){
      // floor
      if(floor < node.data){
          floor = node.data;
      }
  }
  for(Node child : node.children){
      ceilAndFloor(child, data);
  }
}
