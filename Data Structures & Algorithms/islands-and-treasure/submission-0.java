class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int[][] dist=new int[n][m];
        for(int[] d:dist)Arrays.fill(d,(int)1e9);

        Queue<int[]>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j});
                    dist[i][j]=0;
                }
            }
        }

        while(!q.isEmpty()){
            int[] currnode=q.poll();
            int u=currnode[0];
            int v=currnode[1];

            int[] dx={-1,0,1,0};
            int[] dy={0,1,0,-1};

            for(int k=0;k<4;k++){
                int newx=u+dx[k];
                int newy=v+dy[k];


                if(newx>=0 && newx<n && newy>=0 && newy<m && grid[newx][newy]!=-1){
                    if(dist[newx][newy]>dist[u][v]+1){
                        dist[newx][newy]=dist[u][v]+1;
                        q.offer(new int[]{newx, newy});
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != -1 && grid[i][j] != 0) {
                    grid[i][j] = dist[i][j] == (int)1e9 ? (int)1e9 : dist[i][j];
                }
            }
        }
    }
}
