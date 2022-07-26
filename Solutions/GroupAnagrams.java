class Solution {
    
//     Notes: Using Trie - https://leetcode.com/problems/group-anagrams/discuss/2174407/Group-Anagrams-or-Java-or-Trie-or-Easy-Solution-or-22ms
    
//     approach 1: HashMaps
    
//     public List<List<String>> groupAnagrams(String[] strs) {
        
//         HashMap<String, List<String>> dict = new HashMap<>();
        
//         for(String str : strs) {
            
//             int[] alphabets = new int[26];
//             for(char ch: str.toCharArray()) {
//                 alphabets[ch - 'a'] += (ch-'a'+1);
//             }
        
//             String key = "";
//             for(int alpha : alphabets) {
//                 key += alpha;
//             }
            
//             List<String> words = dict.containsKey(key)? dict.get(key) : new ArrayList<>();
//             words.add(str);
//             dict.put(key, words);
//         }
        
//         return new ArrayList<>(dict.values());
//     }
    
//     approach 2: HashMap with sorting
    
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> dict = new HashMap<>();
        
        for(String str : strs) {
            
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            if(dict.containsKey(key)) {
                dict.get(key).add(str);
            } else {
                List<String> words = new ArrayList<>();
                words.add(str);
                dict.put(key, words);
            }
            
        }
        
        return new ArrayList<>(dict.values());
    }
}
