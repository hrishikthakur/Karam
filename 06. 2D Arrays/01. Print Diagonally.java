class Solution{
    static ArrayList<Integer> downwardDigonal(int n, int A[][])
    {
        ArrayList<Integer> res = new ArrayList<>();
        for(int s = 0; s < n; s++){
            for(int i = 0, j = s; j >= 0; j--, i++){
                res.add(A[i][j]);
            }
        }
        
        for(int s = n; s <= (n - 1) + (n - 1); s++){
            for(int i = s - n + 1, j = n - 1; i < n; i++, j--){
                res.add(A[i][j]);
            }   
        }
        
        return res;
    }
}
