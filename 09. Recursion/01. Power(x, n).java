// Time:O(log2N), Space:O(log2N)
class Solution {
    
    public double power(double x, int n){
        if(n == 0) return 1.0;
        double xnb2 = power(x, n / 2);
        return (n % 2 == 0) ? xnb2 * xnb2 : x * xnb2 * xnb2;
    }
    
    public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        if(n == 1) return x;
        if(x == 0 || x == 1) return x;
        return (n < 0) ? 1.0 / power(x, n) : power(x, n);
    }
}
