
class Solution {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, (int) 1e9);

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                    dist[i][j] = 0; 
                }
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValid(nx, ny, grid) && dist[nx][ny] == (int) 1e9) {
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        int maxTime = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    if (dist[i][j] == (int) 1e9) return -1;
                    maxTime = Math.max(maxTime, dist[i][j]);
                }
            }
        }

        return maxTime;
    }

    public static boolean isValid(int x, int y, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        return x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 1;
    }
}