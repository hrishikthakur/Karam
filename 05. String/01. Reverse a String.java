class Reverse
{
    public static String reverseWord(String str)
    {
        char[] s = str.toCharArray();
        int i = 0; 
        int j = str.length() - 1;
        while(i < j){
            char ch = s[i];
            s[i] = s[j];
            s[j] = ch;
            i++;
            j--;
        }
        return new String(s);
    }
}
