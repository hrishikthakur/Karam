// Using Two Pointer -> O(nlogn + n)
public static List<List<Integer>> twoSum(int[] nums, int k) {
    Arrays.sort(nums);
    int i = 0, j = nums.length - 1;
    List<List<Integer>> res = new ArrayList<>();
    while(i < j){

        if(i > 0 && nums[i - 1] == nums[i]){
            i++;
            continue;
        }

        if(nums[i] + nums[j] == k){
            List<Integer> pair = new ArrayList<>();
            pair.add(nums[i]);
            pair.add(nums[j]);
            res.add(pair);
            i++;
            j--;
        }else if(k < nums[i] + nums[j]){
            j--;
        }else{
            i++;
        }
    }

    return res;
}
