// TC => O(N^2)

class Solution {
    
    public void segregateElements(int arr[], int n)
    {
        // Count negative numbers
        int count_negative = 0;
        for (int i = 0; i < n; i++)
            if (arr[i] < 0)
                count_negative++;
 
        // Run a loop until all
        // negative numbers are
        // moved to the beginning
        int i = 0, j = i + 1;
        while (i != count_negative)
        {
 
            // If number is negative,
            // update position of next
            // positive number.
            if (arr[i] < 0)
            {
                i++;
                j = i + 1;
            }
 
            // If number is positive, move
            // it to index j and increment j.
            else if (arr[i] > 0 && j < n)
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }
}
