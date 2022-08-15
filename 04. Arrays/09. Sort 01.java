class Solution {
    void segregate0and1(int[] arr, int n) {
        int i = 0; // 1st unvisited
        int j = 0; // 1st '1'
        while(i < n){
            if(arr[i] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                
                i++;
                j++;
            }else{
                i++;
            }
        }
    }

}

