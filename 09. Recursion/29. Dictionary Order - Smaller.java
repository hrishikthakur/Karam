public class Main {
	
	public static void permute(boolean[] vis, String permutation, String sorted, String input){
		if(permutation.length() == input.length()){
			if(permutation.compareTo(input) < 0){
				System.out.println(permutation);
			}
			return;
		}

		for(int i = 0; i < sorted.length(); i++){
			if(vis[i] == false){
				vis[i] = true;
				permute(vis, permutation + sorted.charAt(i), sorted, input);
				vis[i] = false;
			}
		}
	}

    public static void main(String args[]) {
        Scanner scn  = new Scanner(System.in);
	String input = scn.nextLine();
	char[] arr = input.toCharArray();
	Arrays.sort(arr);
	String sorted = new String(arr);

	boolean[] vis = new boolean[input.length()];
	permute(vis, "", sorted, input);
    }
}
