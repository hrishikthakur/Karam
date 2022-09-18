// 2-D to 1-D -> Time:O(n * m), Space:O(1)
public static int solve(int[][] num1, int[][] num2, int k) {
    int n1 = num1.length;
    int m1 = num1[0].length;
    int n2 = num2.length;
    int m2 = num2[0].length;

    int count = 0;
    int i = 0, j = n2 * m2 - 1;
    while(i < n1 * m1 && j >= 0){
        int i1 = i / m1, j1 = i % m1;
        int i2 = j / m2, j2 = j % m2;
        if(num1[i1][j1] + num2[i2][j2] == k) {
            count++;
            i++;
            j--;
        }
        else if(k < num1[i1][j1] + num2[i2][j2]){
            i++;
        }else{
            j--;
        }
    }

    return count;
}
