public static void partition(int[] nums, int pivot){
    int i = 0; // 1st unvisited 
        int j = 0; // 1st element greater than pivot
        while(i < nums.length){
            if(nums[i] <= pivot){
                swap(nums, i, j);
                
                i++;
                j++;
            }else{
                i++;
            }
        }
  }
