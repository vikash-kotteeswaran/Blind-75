# Solution

## [Problem](https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits/)

## Approach

The approach is same as the one for [Counting Bits](https://github.com/vikash-kotteeswaran/Blind-75/blob/main/Solutions/CountingBits.md)
- Find the `Bit count of Indexes` of the Array through every iteration of the Array Indexes, add the values associated with indexes with bit count `1` to a `sum`

### Code
```
class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        int numsLen = nums.size();
        int[] bitCount = new int[numsLen];
        for (int idx = 0; idx < numsLen; idx++) {
            bitCount[idx] = bitCount[idx>>1] + idx%2;
            if (bitCount[idx] == k) {
                sum += nums.get(idx);;
            }
        }

        return sum;
    }
}
```

### Complexity 
- Time Complexity - O(n)
- Space Complexity - O(1)
