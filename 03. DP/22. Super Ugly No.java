class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n == 1) return 1;
        
        long[] ugly = new long[n + 1];
        ugly[0] = -1;
        ugly[1] = 1;
        
        // pointer to nth ugly number
        int[] ptr = new int[primes.length];
        Arrays.fill(ptr, 1);
        
        for(int i = 2; i <= n; i++){
            // Finding the next Smallest Ugly No
            long min = Integer.MAX_VALUE;
            for(int j = 0; j < ptr.length; j++)
                min = Math.min(min, ugly[ptr[j]] * primes[j]);
            
            ugly[i] = min;
            
             // Updating All Pointers Pointing to Min
            for (int j = 0; j < primes.length; j++)
                if (ugly[ptr[j]] * primes[j] == min)
                    ptr[j]++;
        }
        
        return (int) ugly[n];  
    }
}
