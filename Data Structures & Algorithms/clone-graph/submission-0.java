/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node,Node> mp=new HashMap<>();

        return dfs(node,mp);
    }

    public Node dfs(Node node,HashMap<Node,Node> mp){
        if(node==null) return null;

        if(mp.containsKey(node)){
            return mp.get(node);
        }


        Node newnode=new Node(node.val);
        mp.put(node,newnode);

        for(Node neighor:node.neighbors){
            newnode.neighbors.add(dfs(neighor,mp));
        }

        return newnode;
    }
}