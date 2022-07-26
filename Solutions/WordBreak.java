class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
//         Notes: Using Trie - https://leetcode.com/problems/word-break/discuss/43879/Beat-90-JavaC%2B%2B-Trie-DP-Solution-36-lines-7ms3msJava-Set-DP-solution-31-lines-7ms)
        
//         Notes: Dfs - https://leetcode.com/problems/word-break/discuss/43970/Concise-DFS-(backtracking)-solution
        
//         approach 1: DP
        
        int len = s.length();
        boolean[] res = new boolean[len+1];
        res[0] = true;
        s = "0" + s;
        
        for(int i = 1; i <= len+1; i++){
            for(String word : wordDict) {
                int wordLen = word.length();
                if(i <= (len + 1 - wordLen) && s.substring(i, i + wordLen).equals(word) && res[i-1]){
                    res[i+wordLen-1] = true;
                }
            }
        }
        
        return res[len];
    }
}
