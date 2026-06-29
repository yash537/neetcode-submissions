class Solution {
    
    public int find(int x,int[] parent){
        if(parent[x]<0) return x;
        return parent[x]=find(parent[x],parent);
    }


    public boolean union(int x,int  y,int[] parent){
        int rootx=find(x,parent);
        int rooty=find(y,parent);


        if(rootx==rooty){
            return true; // cycle
        }
        else{
            if(rootx<rooty){
                parent[rootx]+=parent[rooty];
                parent[rooty]=rootx;
            }else{
                parent[rooty]+=parent[rootx];
                parent[rootx]=rooty;
            }
        }
        return false;
    }
    public int countComponents(int n, int[][] edges) {
        int[] parent=new int[n];
        Arrays.fill(parent,-1);

        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];

            union(u,v,parent);
        }

        int ans=0;
        for(int i=0;i<n;i++){
            if(parent[i]<0){
                ans++;
            }
        }
        return ans;
    }
}
