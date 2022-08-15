class Solution
{
    
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void sort012(int a[], int n)
    {
    
        int i = 0; // 1st unknown
        int j = 0; // 1st '1'
        int k = n - 1; // "after k" all are '2s'
        while(i <= k){
            if(a[i] == 0){
                swap(a, i, j);
                i++;
                j++; 
            }else if(a[i] == 2){
                swap(a, i, k);
                k--;
            }else{
                i++;
            }
        }
    }
}
