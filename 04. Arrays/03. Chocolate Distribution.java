class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        Collections.sort(a);
        long diff = Integer.MAX_VALUE;
        // i + m - 1 < n => I got this wrong
        for(int i = 0; i + m - 1 < n; i++){
            long currDiff = a.get(i + m - 1) - a.get(i);
            diff = Math.min(currDiff, diff);
        }
        
        return diff;
    }
}
