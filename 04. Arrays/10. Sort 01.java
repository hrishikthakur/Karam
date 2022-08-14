class Solution {
    void segregate0and1(int[] arr, int n) {
        int i = 0, j = 0;
        while(i < n && j < n){
            if(arr[i] == 0){
                // swap with the 1st 1
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                
                j++;
            }
            
            i++;
        }
    }

}
