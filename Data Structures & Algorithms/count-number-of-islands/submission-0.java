class Solution {
    public void dfs(int i,int j,int[][] dist,char[][] grid,int cnt){
        int n=grid.length;
        int m=grid[0].length;
        dist[i][j]=cnt;

        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};

        for(int k=0;k<4;k++){
            int newx=i+dx[k];
            int newy=j+dy[k];


            if(newx>=0 && newx<n && newy>=0 && newy<m && grid[newx][newy]=='1' && dist[newx][newy]==0){
                dfs(newx,newy,dist,grid,cnt);
            }
        } 
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int[][] dist=new int[n][m];
        int cnt=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && dist[i][j]==0){
                    cnt++;
                    dfs(i,j,dist,grid,cnt);
                }
            }
        }

        return cnt;
    }
}
