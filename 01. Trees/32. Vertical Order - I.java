class Solution
{
    static class Pair{
        Node node;
        int vLevel;
        Pair(Node node, int vLevel){
            this.node = node;
            this.vLevel = vLevel;
        }
    }
    
    static ArrayList <Integer> verticalOrder(Node root)
    {
        // BFS -> with Queue<Pair>
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0));
        
        int vLevelMin = 0, vLevelMax = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
      
        while(q.size() > 0){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Pair popped = q.remove();
                vLevelMin = Math.min(vLevelMin, popped.vLevel);
                vLevelMax = Math.max(vLevelMax, popped.vLevel);
                map.putIfAbsent(popped.vLevel, new ArrayList<>());
                map.get(popped.vLevel).add(popped.node.data);
                if(popped.node.left != null) q.add(new Pair(popped.node.left, popped.vLevel - 1));
                if(popped.node.right != null) q.add(new Pair(popped.node.right, popped.vLevel + 1));
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = vLevelMin; i <= vLevelMax; i++){
            for(Integer val : map.get(i))
                res.add(val);
        }
        return res;
    }
}
