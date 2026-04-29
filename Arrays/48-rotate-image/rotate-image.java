class Solution {
    public void rotate(int[][] matrix) {  
    /*
    4-way swap:
    1. Transpose first and
    2. Reverse each row
    */
        int n = matrix.length;
        for(int i = 0 ; i< n; i++)
        {
            for(int j = i;j < n;j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] =  matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0;i < n;i++)
        {
            int left = 0,  right= n-1;
            while(left < right)
            {
                int temp = matrix[i][left];
                matrix[i][left] =  matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
