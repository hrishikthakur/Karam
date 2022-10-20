public class Main {

    public static void solution(int idx, String input, int count_consecutive_nos, String asf){
        if(idx == input.length()){
            if(count_consecutive_nos > 0) asf += count_consecutive_nos;
            System.out.println(asf);
            return;
        }
        
        // yes
        char ch = input.charAt(idx);
        solution(idx + 1, input, 0, asf + ((count_consecutive_nos == 0) ? "" : count_consecutive_nos) + ch);
        // if(count_consecutive_nos > 0) {
        //     solution(idx + 1, input, 0, asf + count_consecutive_nos + input.charAt(idx));
        // }else{
        //     solution(idx + 1, input, 0, asf + input.charAt(idx));
        // }
        
        // no
        solution(idx + 1, input, count_consecutive_nos + 1, asf);
    }
    
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(0, str, 0, "");
    }
}
