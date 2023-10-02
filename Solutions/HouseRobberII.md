# Solution

## [Problem](https://leetcode.com/problems/house-robber-ii/)

## Approach 1 - My Solution

**Dynamic Programming Approach**

Adapting the solution from [House Robber I](). In this case "nums" is a closed loop. And so nums[0] and nums[n-1] are neighbours. So the max amt cannot include amount of nums[0]
and nums[n-1]. So there will be two sequences of max amts, 
- One is the sequence that includes only nums[0] and not nums[n-1]. Sometimes nums[n-1] could be larger than this sequence's max robbed amt.
- Another is the sequence that includes only nums[n-1] and not nums[0]. Sometimes nums[0] could be larger than this sequence's max robbed amt.

Atlast the max from both the sequence is taken to get the final answer.

### Code
```
class Solution {
    public int rob(int[] nums) {
        int numHouses = nums.length;
        if (numHouses <= 0) return 0;
        if (numHouses == 1) return nums[0];

        // "nums" lives in a loop [house 0, house 1,..., house n -1, house 0]
        // house 1 -> house 2 -> ....... -> house x
        //   |                                |
        // house n - 1                      house x + 1
        //   |                                |
        //  ...                              ...
        // house z <- house y + 1 <- ... <- house y

        int prevAmt2 = 0, prevAmt1 = nums[0], prevAmt2_1 = 0, prevAmt1_1 = nums[1];
        for (int houseIdx = 1; houseIdx < numHouses; houseIdx++) {
            // Finding the max amt for the sequence [house 0, house 1,..., house n - 1]
            int currHouseAmt = nums[houseIdx],
            temp = prevAmt1;
            prevAmt1 = Math.max(prevAmt1, prevAmt2 + currHouseAmt);
            prevAmt2 = temp;

            // Finding the max amt for the sequence [house 1, house 2,..., house n - 1, house 0]
            if (houseIdx > 1) {
                temp = prevAmt1_1;
                prevAmt1_1 = Math.max(prevAmt1_1, prevAmt2_1 + currHouseAmt);
                prevAmt2_1 = temp;
            }
        }

        // "first" indicates the max amt for the first sequence
        // "second" indicates the max amt for the second sequence
        int first = Math.max(nums[numHouses-1], prevAmt2);
        int second = Math.max(nums[0], prevAmt1_1);
        int total = Math.max(first, second);

        return  total > -1 ? total : 0;
    }
}
```
