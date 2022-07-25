class Solution {
    public int[] twoSum(int[] nums, int target) {
        
//         approach 1: Hashmap
        
        HashMap<Integer, Integer> dict = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            Integer tarIdx = dict.get(target - nums[i]);
            if(tarIdx != null && tarIdx != i){
                return new int[]{tarIdx, i};
            }
            dict.put(nums[i], i);
        }
        
        return new int[]{-1, -1};
        
        
//         approach 2: two pointer
        
//         int N = nums.length;
//         int[][] pointerArr = new int[N][2];
//         for(int i = 0; i<N; i++){
//             pointerArr[i][0] = nums[i];
//             pointerArr[i][1] = i;
//         }
//         Arrays.sort(pointerArr, (a, b) -> a[0] - b[0]);
        
//         int l = 0, r = N-1;
//         while(l<=r){
//             if(pointerArr[l][0] + pointerArr[r][0] > target) {
//                 r--;
//             } else if(pointerArr[l][0] + pointerArr[r][0] < target) {
//                 l++;
//             } else {
//                 return new int[]{pointerArr[l][1], pointerArr[r][1]};
//             }
//         }
        
//         return new int[]{-1, -1};
    }
}
