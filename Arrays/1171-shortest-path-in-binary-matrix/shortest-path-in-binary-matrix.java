class Solution {
    public int shortestPathBinaryMatrix(int[][] mat) {
        int[][] visited = new int[mat.length][mat[0].length];
        Queue<int[]> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        int ct=0;
        if(mat[0][0] == 1 || mat[m-1][n-1] == 1)
            return -1;
         if (m==1 && n == 1) {
            return 1;
        }

        q.offer(new int[]{0,0,1});
        visited[0][0] = 1;
        int[][] directions = new int[][] {
                { -1, 0 }, // up
                { 1, 0 }, // down
                { 0, -1 }, // left
                { 0, 1 }, // right
                { -1, -1 }, 
                { 1, 1 }, 
                { -1, 1 }, 
                { 1, -1 }
        };


        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int distance = curr[2];
            for (int i = 0; i < directions.length; i++) {
                int nr = curr[0] + directions[i][0];
                int nc = curr[1] + directions[i][1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == 0 && visited[nr][nc] == 0) {
                    visited[nr][nc] = 1;
                    q.offer(new int[] { nr, nc, curr[2]+1 });
                }
            }
            if(curr[0] == m-1 && curr[1] == n-1)
                return curr[2];
        }
        return -1;
    }
}