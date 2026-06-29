class Solution {
    public int findJudge(int n, int[][] trust) {
       int[] dist=new int[n+1];

       for(int[] edge:trust){
        int u=edge[0];
        int v=edge[1];

        dist[u]--;
        dist[v]++;
       }

        int ans=-1;
       for(int j=1;j<=n;j++){
            if(dist[j]==n-1){
                ans=j;
            }
       } 
       return ans;
    }
}