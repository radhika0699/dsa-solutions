class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        int fresh = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    q.offer(new int[] { r, c });
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();

                int r = curr[0];
                int c = curr[1];
                if (r > 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    fresh--;
                    q.offer(new int[] { r - 1, c });
                }
                if (r < grid.length - 1 && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    fresh--;
                    q.offer(new int[] { r + 1, c });
                }
                if (c > 0 && grid[r][c - 1] == 1) {
                    grid[r][c - 1] = 2;
                    fresh--;
                    q.offer(new int[] { r, c - 1 });
                }
                if (c < grid[0].length - 1 && grid[r][c + 1] == 1) {
                    {
                        grid[r][c + 1] = 2;
                        fresh--;
                        q.offer(new int[] { r, c + 1 });
                    }
                }
            }
            time++;
        }
        if (fresh > 0) {
            return -1;
        }
        return time;
    }
}