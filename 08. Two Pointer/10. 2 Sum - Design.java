// Using ArrayList
public class TwoSum {
    ArrayList<Integer> data;
    boolean isSorted;

    public TwoSum(){
        data = new ArrayList<>();
        isSorted = true;
    }
    
    O(
    public void add(int number) {
        data.add(number);
        isSorted = false;
    }

    public boolean find(int k) {
        if(isSorted == false){
            Collections.sort(data);
            isSorted = true;
        }

        int lo = 0, hi = data.size() - 1;
        while(lo < hi){
            int sum = data.get(lo) + data.get(hi);
            if(sum == k){
                return true;
            }else if(sum < k){
                lo++;
            }else{
                hi--;
            }
        }

        return false;
    }
}
