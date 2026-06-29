class Solution {
    public String mergeAlternately(String word1, String word2) {
        int l1=word1.length();
        int l2=word2.length();
        int w1_l=0,w2_l=0;
        StringBuilder sb=new StringBuilder("");
        while(w1_l<l1 && w2_l<l2){
            sb.append(word1.charAt(w1_l));
            sb.append(word2.charAt(w2_l));
            w1_l++;
            w2_l++;
        }
        while(w1_l<l1){
            sb.append(word1.charAt(w1_l));
            w1_l++;
        }
        while(w2_l<l2){
            sb.append(word2.charAt(w2_l));
            w2_l++;
        }
        return sb.toString();
    }
}