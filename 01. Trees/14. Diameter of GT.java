static int diameter = 0;
public static int calDiaReturnHeight(Node root){
    if(root == null) return 0;
    int firstHeight = -1; // why ? => in terms of edges
    int secondHeight = 0;
    for(Node child : root.children){
        int childHeight = calDiaReturnHeight(child);
        if(childHeight > firstHeight){
            secondHeight = firstHeight;
            firstHeight = childHeight;
        }else if(childHeight > secondHeight){
            secondHeight = childHeight;
        }
    }
    diameter = Math.max(diameter, firstHeight + secondHeight + 2);

    return 1 + firstHeight;
}
