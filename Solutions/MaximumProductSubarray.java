class Solution {
        
//         Notes: similar to Kadane's - https://medium.com/@aliasav/algorithms-maximum-product-subarray-b09e520b4baf
    
//         Notes: It is also possible with Divide & Conquer - https://leetcode.com/problems/maximum-product-subarray/discuss/1608928/Java-or-Divide-and-Conquer-or-O(n*logn)
    
//         approach 1: DP
    
//     public int maxProduct(int[] nums) {
        
//         int max = nums[0], min = nums[0];
//         int prod = nums[0];
        
//         for(int i = 1; i < nums.length; i++) {
//             if(nums[i] < 0) {
//                 int temp = min;
//                 min = max;
//                 max = temp;
//             }
            
//             min = Math.min(nums[i], nums[i]*min);
//             max = Math.max(nums[i], nums[i]*max);
            
//             prod = Math.max(max, prod);
//         }
        
//         return prod;
//     }
    
//     approach 2: two pointers - I was Wowed at how easy and intuitive it was
    
//     Notes: https://leetcode.com/problems/maximum-product-subarray/discuss/1608862/JAVA-or-3-Solutions-or-Detailed-Explanation-Using-Image
    
    public int maxProduct(int[] nums) {
        int l = 1, r = 1, prod = nums[0], len = nums.length;
        
        for(int i = 0; i < len; i++){
            
            l = l==0? 1 : l;
            r = r==0? 1 : r;
            
            l *= nums[i];
            r *= nums[len - 1 - i];
            
            prod = Math.max(prod, Math.max(l, r));
        }
        
        return prod;
    }
}
