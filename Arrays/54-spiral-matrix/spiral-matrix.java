class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();

        int rowSt = 0, colSt = 0, rowEnd = m, colEnd = n;
        while(rowSt < rowEnd && colSt < colEnd)
        {
            for(int i = colSt; i < colEnd; i++)
            {
                ans.add(matrix[rowSt][i]); //1 2 3 // 123 69 87 4 5
            }
            rowSt++;
            for(int i = rowSt; i < rowEnd; i++)
            {
                ans.add(matrix[i][colEnd-1]); // 123 69 
            }
            colEnd--;
            if(rowSt < rowEnd)
                for(int i = colEnd - 1; i >= colSt; i--) // 123 69 87  
                {
                    ans.add(matrix[rowEnd-1][i]);
                }
            rowEnd--;
            if(colSt < colEnd)
                for(int i = rowEnd - 1; i >= rowSt;i--) // 123 69 87 4
                {
                    ans.add(matrix[i][colSt]);
                }
            colSt++;
        }
        return ans;
    }
}