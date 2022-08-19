// Recursion -> O(Jumps^N + Jumps*N) Time, O(N) Space
public static int climbStairs(int src, int dest, int[] arr){
    if(src == dest) return 1;
    if(src > dest) return 0;
    int ans = 0;
    for(int jmp = 1; jmp <= arr[src]; jmp++){
        ans += climbStairs(src + jmp, dest, arr);
    }
    return ans;
}

// Memoization -> O(Jumps*N) Time, O(N) Space
public static int climbStairs(int src, int dest, int[] arr, int[] dp){
    if(src == dest) return 1;
    if(src > dest) return 0;
    if(dp[src] != -1) return dp[src];
    int ans = 0;
    for(int jmp = 1; jmp <= arr[src]; jmp++){
        ans += climbStairs(src + jmp, dest, arr, dp);
    }
    dp[src] = ans;
    return dp[src];
}

// Tabulation -> O(N*Jumps) Time, O(N) Space
public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
        arr[i] = scn.nextInt();
    }
    int[] dp = new int[n + 1];
    dp[n] = 1;
    for(int i = n - 1; i >= 0; i--){
        int ans = 0;
        for(int jmp = 1; jmp <= arr[i]; jmp++){
                if(i + jmp <= n){
                        ans += dp[i + jmp];
                }
        }
        dp[i] = ans;
    }
    System.out.println(dp[0]);
}

// Space Optimization is NOT POSSIBLE due to non-limited previous states.
