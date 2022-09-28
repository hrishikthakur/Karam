// Time:O(2N), Space:O(K)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        int[] res = new int[N - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        
        int idx = 0;
        for(int i = 0; i < N; i++){
            if(q.size() > 0 && q.getFirst() <= i - k) q.removeFirst();
            while(q.size() > 0 && nums[q.getLast()] < nums[i])
                q.removeLast();
            q.addLast(i);
            if(i >= k - 1) res[idx++] = nums[q.getFirst()];
        }
        
        return res;
    }
}
