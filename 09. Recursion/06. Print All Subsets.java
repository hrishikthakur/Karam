// Time:O(2^N), SSpace:O(2^N)

// Using String -> No backtracking 
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        printSS(str, 0, "");
    }

    public static void printSS(String str, int idx, String asf) {
        if(str.length() == idx){
            System.out.println(asf);
            return;
        }
        printSS(str, idx + 1, asf + str.charAt(idx));
        printSS(str, idx + 1, asf);
    }
}

// Using ArrayList<> -> Backtracking required
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        ArrayList<Character> asf = new ArrayList<>();
        printSS(str, 0, asf);
    }

    public static void printSS(String str, int idx, ArrayList<Character> asf) {
        if(idx == str.length()){
            for(Character c : asf){
                System.out.print(c);
            }
            System.out.println();
            return;
        }
        // yes_call
        asf.add(str.charAt(idx));
        printSS(str, idx + 1, asf);
        asf.remove(asf.size() - 1); // backtrack
        // no_call
        printSS(str, idx + 1, asf);
    }
}
