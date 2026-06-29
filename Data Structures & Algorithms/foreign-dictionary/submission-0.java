class Solution {
      public int[] toposort(int numCourses, ArrayList<Integer>[] adj, int[] indegree) {
        int[] topo = new int[numCourses];
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int count = 0;
        
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            topo[count] = curr;
            count++;
            
            for(int neig : adj[curr]) {
                indegree[neig]--;
                if(indegree[neig] == 0) {
                    queue.offer(neig);
                }
            }
        }
        
        if(count != numCourses) {
            return new int[0];  // Cycle detected
        }
        
        return topo;
    }
    public String foreignDictionary(String[] words) {
        // code here
          int n = words.length;
        
        // Use 26 for all lowercase letters
        ArrayList<Integer>[] adj = new ArrayList[26];
        int[] indegree = new int[26];
        boolean[] present = new boolean[26];  // Track which characters exist
        
        // Initialize adjacency list
        for(int i = 0; i < 26; i++) {
            adj[i] = new ArrayList<>();
        }
        
        // Mark which characters are present
        for(String word : words) {
            for(char ch : word.toCharArray()) {
                present[ch - 'a'] = true;
            }
        }
        
        // Build the graph
        for(int i = 0; i < n - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            
            int len = Math.min(s1.length(), s2.length());
            boolean foundDiff = false;
            
            for(int j = 0; j < len; j++) {
                if(s1.charAt(j) != s2.charAt(j)) {
                    int u = s1.charAt(j) - 'a';
                    int v = s2.charAt(j) - 'a';
                    adj[u].add(v);
                    indegree[v]++;
                    foundDiff = true;
                    break;
                }
            }
            
            // Edge case: "abc" before "ab" is invalid
            if(!foundDiff && s1.length() > s2.length()) {
                return "";
            }
        }
        
        // Count how many unique characters we have
        int uniqueChars = 0;
        for(int i = 0; i < 26; i++) {
            if(present[i]) uniqueChars++;
        }
        
        // Get topological order
        int[] topo = toposort(26, adj, indegree);
        
        // If cycle detected
        if(topo.length == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            if(present[topo[i]]) {
                sb.append((char)(topo[i] + 'a'));
            }
        }
        
        return sb.toString(); 
    }
}
