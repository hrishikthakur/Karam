class Solution {
    void segregateEvenOdd(int arr[], int n) {
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(arr[i] % 2 == 0) even.add(arr[i]);
            else odd.add(arr[i]);
        }
        Collections.sort(even);
        Collections.sort(odd);
        int k = 0;
        for(Integer i : even){
            arr[k++] = i;
        }
        for(Integer i : odd){
            arr[k++] = i;
        }
    }
}
