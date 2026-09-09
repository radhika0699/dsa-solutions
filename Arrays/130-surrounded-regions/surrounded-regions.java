class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for(int i = 0; i < rows; i++)
        {
            if(board[i][0] == 'O')
                dfs(i,0,board, visited); 
            if(board[i][cols-1] == 'O')
                dfs(i,cols-1,board, visited);
        }
        for(int j = 1; j < cols-1; j++)
        {
            if(board[0][j] == 'O')
               dfs(0,j,board, visited);
            if(board[rows-1][j] == 'O')
                dfs(rows-1,j,board, visited);
        }
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(!visited[i][j] && board[i][j] == 'O')
                {
                    System.out.print(i+ "" + j);
                    board[i][j] = 'X';
                }
            }
        }

        
    }
    void dfs(int r, int c, char[][] board, boolean[][] visited)
    {
        if(r<0 || r>board.length-1)
            return;
        if(c<0 || c>board[0].length-1)
            return;
        if(visited[r][c] || board[r][c] != 'O')
            return;
        visited[r][c] = true; //3,1 -> 4,1 2,1 3,2 3,0
        dfs(r+1,c,board,visited);
        dfs(r-1,c,board,visited);
        dfs(r,c+1,board,visited);
        dfs(r,c-1,board,visited);
    }
}