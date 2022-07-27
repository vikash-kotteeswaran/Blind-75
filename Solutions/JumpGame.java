class Solution {
    
//     approach 1: DP & Array memoization - O(n*k) where k is the weights at each indices
    
//     public boolean canJump(int[] nums) {
//         int len = nums.length;
//         boolean[] res = new boolean[len];
//         res[0] = true;
        
//         for(int i = 0; i < len; i++){
//             if(res[i]) {
//                 for(int j = i+1; j <= (i + nums[i] < len? i+nums[i] : len - 1); j++) {
//                     res[j] = true;
//                 }
//             }
//         }
        
//         return res[len-1];
//     }
    
//     approach 2: DP & Optimized memoization - O(n)
    
    public boolean canJump(int[] nums) {
        
//         approach 2.1: Forwards with double checking including Math.max checking
        
//         int len = nums.length - 1;
//         int reached = 0;
//         for(int i = 0; i <= len; i++){
//             if(i<=reached) {
//                 reached = Math.max(reached, i + nums[i]); //Greedy
//                 if(reached >= len) return true;
//             }
//         }
//         return false;
        
//         approach 2.2: Forwards with triple checking including Math.max checking
        
//         int len = nums.length - 1;
//         int reached = 0;
//         for(int i = 0; i <= len; i++){
//             if(reached >= len) return true;
//             if(i > reached) return false;
//             reached = Math.max(reached, i + nums[i]); //Greedy
//         }
//         return false;
        
//         approach 2.3: Backwards with single checking
//         Notes: https://leetcode.com/problems/jump-game/discuss/1429371/Java-1ms-faster-than-100-O(n)-with-comment
        
        int depth = nums.length - 1;
        for(int i = depth; i >= 0; i--){
            depth = depth <= i + nums[i] ? i : depth; //Greedy
        }    
        return depth<=0;
    }
}
