class Solution {
    List<Integer> res;
    public void helper(int ourNum, int n){
        if(ourNum > n) return;
        res.add(ourNum);
        for(int i = 0; i < 10; i++){
            // ourNum = (ourNum * 10) + i; this is wrong in terms of logic
            helper((ourNum * 10) + i, n);
        }
    }
    public List<Integer> lexicalOrder(int n) {
        res = new ArrayList<>();
        for(int onesDigit = 1; onesDigit < 10; onesDigit++)
            helper(onesDigit, n);
        return res;
    }
}
