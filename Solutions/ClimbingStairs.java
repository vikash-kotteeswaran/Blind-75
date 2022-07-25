class Solution {
    
//     Notes: Checkout Binets Method and also - https://leetcode.com/problems/climbing-stairs/discuss/1851337/9-Approaches-or-Fibonacci-or-The-Most-Complete-or-All-In-One
//     Notes: Binet's Formula - https://artofproblemsolving.com/wiki/index.php/Binet%27s_Formula
    
//     approach 1: Permutations - Not accurate as the calculations in perm return inaccurate answers
    
//     public double perm(double x, double y, double z, double memo){
//         if(x<=1){
//             return memo;
//         }
        
//         y = y<=1? 1 : y;
//         z = z<=1? 1 : z;
        
//         return perm(x-1, y <= 1? 1 : y-1, z <= 1? 1 : z-1, memo*x/y/z);
//     }
    
//     public int climbStairs(int n) {
//         double N = n;
//         int maxTwoSteps = n/2;
//         int waysForNSteps = 0;
//         for(int i = 0; i <= maxTwoSteps; i++){
//             waysForNSteps += (int) perm((N - i*2) + i , i, N - i*2, 1);
//         }
        
//         return waysForNSteps;
//     }
    
    
//     approach 2: Bottom-Up DP
    
    public int climbStairs(int n) {
        if(n<=2) {
            return n;
        }
        
        int WaysFor2StairCase = 2;
        int WaysFor1StairCase = 1;
        int WaysForNStairCase = 0;
        
        for(int i = 2; i < n; i++) {
            WaysForNStairCase = WaysFor1StairCase + WaysFor2StairCase;
            int temp = WaysFor2StairCase;
            WaysFor2StairCase = WaysForNStairCase;
            WaysFor1StairCase = temp;
        }
        
        return WaysForNStairCase;
    }
    
//     approach 3: Top-Down DP - Time Limit Exceeds due to multiple branching and multiple computations
    
//     public int climbStairs(int n){
//         if(n<=3) return n;
//         return climbStairs(n - 1) + climbStairs(n - 2);
//     }
    
}
