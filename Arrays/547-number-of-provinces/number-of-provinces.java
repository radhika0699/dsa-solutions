class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length; //3
        boolean[] visited = new boolean[n + 1]; //
        int ct = 0;
        for (int i = 0; i < n; i++) // 0 -> 2
        {
            if (!visited[i]) {
                dfs(i, isConnected, visited);
                ct++;
            }
        }
        return ct;
    }

    public void dfs(int v, int[][] isConnected, boolean[] visited) {
        visited[v]= true;
        for(int i = 0; i < isConnected.length;i++)
        {
            if(isConnected[v][i] == 1 && !visited[i])
            {
                dfs(i, isConnected , visited);
            }
        }
    }
}