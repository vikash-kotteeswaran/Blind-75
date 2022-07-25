class Solution {
//     Notes: Checkout - https://leetcode.com/problems/maximum-subarray/discuss/1595186/Java-oror-Kadane-ororDivide-and-Conquer-oror-Dp
        
//         approach 1 : DP - O(n)
    
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], locSum = nums[0];
        for(int i = 1; i<nums.length; i++){
            locSum = Math.max(nums[i], nums[i] + locSum);
            maxSum = Math.max(maxSum, locSum);
        }
        
        return maxSum;
    }
        
    
//         approach 2 : Kadane's Algorithm
        
//     public int maxSubArray(int[] nums) {
//         int maxSum = Integer.MIN_VALUE;
//         int sum = 0;
        
//         for(int num : nums){
//             sum += num;
//             maxSum = Math.max(maxSum, sum);
//             sum = Math.max(sum, 0);
//         }
        
//         return maxSum;
//     }
        
    
//         approach 3: divide and conquer
        
//     public int maxSubArray(int[] nums) {
//         return maxSubArrayHelper(nums, 0, nums.length-1);
//     }
    
//     public int maxSubArrayHelper(int[] nums, int st, int end) {
        
//         if(st == end) return nums[st];
            
//         int mid = st + (end - st)/2;
//         int leftOrRightSum = Math.max(maxSubArrayHelper(nums, st, mid), maxSubArrayHelper(nums, mid+1, end));
        
//         int leftMidSum = Integer.MIN_VALUE, rightMidSum = Integer.MIN_VALUE;

//         int sum = 0;
//         for(int i = mid; i >= st; i--) {
//             sum += nums[i];
//             leftMidSum = Math.max(leftMidSum, sum);
//         }

//         sum = 0;
//         for(int i = mid+1; i <= end; i++) {
//             sum += nums[i];
//             rightMidSum = Math.max(rightMidSum, sum);
//         }
        
//         return Math.max(leftMidSum + rightMidSum, leftOrRightSum);

//     }
}
