// Time:O(log2N), Space:O(log2N)
public class Main {
	public static long xpown(long x, long n, long mod) {
		if(n == 0) return 1;
		long xnb2 = (xpown(x, n / 2, mod)) % mod;
		if(n % 2 == 0) return ((xnb2 % mod) * (xnb2 % mod)) % mod;
		return ((((xnb2 % mod) * (xnb2 % mod)) % mod) * (x % mod)) % mod;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner scn = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
			long x = scn.nextInt();
			long n = scn.nextInt();

            long ans = xpown(x,n,1000000007);
			System.out.println(ans);
		}
}
