// Using ArrayList
public class TwoSum {
    ArrayList<Integer> data;
    boolean isSorted;

    public TwoSum(){
        data = new ArrayList<>();
        isSorted = true;
    }
    
    // O(1)
    public void add(int number) {
        data.add(number);
        isSorted = false;
    }
    
    // O(NlogN + N)
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

// Using HashMap
public class TwoSum {

    HashMap<Integer, Integer> freq;

    public TwoSum(){
        freq = new HashMap<>();
    }
    
    // O(1) in avg & O(N) in worst case
    public void add(int number) {
        freq.put(number, freq.getOrDefault(number, 0) + 1);
    }

    // O(N)
    public boolean find(int k) {
        for(int key : freq.keySet()){
            int complement = k - key;
            int freq_complement = freq.getOrDefault(complement, 0);
            if(complement == key){
                if(freq_complement >= 2) return true;
            }else{
                if(freq_complement >= 1) return true;
            }
        }

        return false;
    }
}
