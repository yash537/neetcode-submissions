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

    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int[] parent=new int[n+1];
        Arrays.fill(parent,-1);
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];

            if(union(u,v,parent)){
               return edge;
            }
        }
        return new int[]{};
    }
}
