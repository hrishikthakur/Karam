class Solution {
    
    public void segregateElements(int arr[], int n)
    {
        int k = 0;
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            if(arr[i] > 0){
                res[k++] = arr[i];
            }
        }
        for(int i = 0; i < n; i++){
            if(arr[i] < 0){
                res[k++] = arr[i];
            }
        }
        for(int i = 0; i < n; i++){
            arr[i] = res[i];
        }
    }
}
