// Two Pointer -> Time:O(n), Space:O(1)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        int[] res = new int[2];
        while(i < j){
            if(numbers[i] + numbers[j] == target){
                res[0] = i + 1;
                res[1] = j + 1;
                return res;
            }else if(target < numbers[i] + numbers[j]){
                j--;
            }else{
                i++;
            }
        }
        
        return res;
    }
}
