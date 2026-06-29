class Solution {

        static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

        public static int BFS(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;

        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, (int) 1e9);
        dist[0][0] = 1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i], ny = y + dy[i];

                if (isValid(nx, ny, grid)) {
                    if (dist[nx][ny] > dist[x][y] + 1) {
                        dist[nx][ny] = dist[x][y] + 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return dist[n - 1][n - 1] == (int) 1e9 ? -1 : dist[n - 1][n - 1];
    }

    public static boolean isValid(int x, int y, int[][] grid) {
        int n = grid.length;
        return x >= 0 && y >= 0 && x < n && y < n && grid[x][y] == 0;
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        return BFS(grid);
    }


}
