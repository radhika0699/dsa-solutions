class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int islands = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if(grid[r][c] == '1')
                {
                    dfs(grid,r,c);
                    islands++;
                }
            }
        }
        return islands;
    }
    private void dfs(char[][] grid, int r, int c) {
        if(r<0 || r>grid.length)
            return;
        if(c<0 || c>grid[0].length)
            return;
        if(grid[r][c] == '0')
            return;
        grid[r][c] = '0';
        
        if(r>0)
            dfs(grid, r-1,c);
        if(r<grid.length-1)
            dfs(grid, r+1,c);
        if(c>0)
            dfs(grid, r,c-1);
        if(c<grid[0].length-1)
            dfs(grid, r,c+1);
    }
}