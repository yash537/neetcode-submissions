class Solution {
     public void dfs(int i,int j,int[][] dist,char[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        dist[i][j]=1;

        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};

        for(int k=0;k<4;k++){
            int newx=i+dx[k];
            int newy=j+dy[k];


            if(newx>=0 && newx<n && newy>=0 && newy<m && grid[newx][newy]=='O' && dist[newx][newy]==0){
                dfs(newx,newy,dist,grid);
            }
        } 
    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;

        int[][] dist=new int[n][m];

        for(int i=0;i<n;i++){

            if(dist[i][0]==0 && board[i][0]=='O'){
                dfs(i,0,dist,board);
            }

            if(dist[i][m-1]==0 && board[i][m-1]=='O'){
                dfs(i,m-1,dist,board);
            }
        }

        for(int j=0;j<m;j++){

            if(dist[0][j]==0 && board[0][j]=='O'){
                dfs(0,j,dist,board);
            }

            if(dist[n-1][j]==0 && board[n-1][j]=='O'){
                dfs(n-1,j,dist,board);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dist[i][j]==0 && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }

    }
}
