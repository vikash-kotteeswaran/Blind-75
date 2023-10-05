# Solution

## [Problem](https://leetcode.com/problems/search-in-rotated-sorted-array/)

## Approach 1 - My Solution

**Perform Binary Search in a way that alters start and end indexes appropriately**

In the case of a sorted and rotated array, Binary Search implementation differs when nums[start] >= nums[end] and nums[start] < nums[end]
  - **When nums[start] >= nums[end]***
    - The array pattern could be $[\ A_{n-3},\ A_{n-2},\ A_{n-1},\ A_1,\ A_2,...,\ A_{n-4}\ ]$
    - If `target > nums[mid]`, then the start, target and mid either be present in the gaps $[\ [\ A_{n-3},\ A_{n-2},\ A_{n-1}],\ [\ A_1,\ A_2,...,\ A_{n-4}\ ],\ [\ A_{n-2},\ A_{n-1},\ A_1,\ A_2,...,\ A_{n-4}\ ]\ ]$
      - For the first two `(nums[mid] >= nums[start])`, the order is monotonous between start, mid and target, `start can be updated to mid + 1`
      - For the last one `(nums[start] > nums[mid])`, the order is not monotonaous between start, mid and target, so `start can be updated to mid + 1` only if `target < nums[start]` otherwise only `end can update end to mid - 1`

    - If `target <= nums[mid]`, then the start, target and mid either be present in the gaps $[\ [A_{n-3},\ A_{n-2},\ A_{n-1}],\ [\ A_1,\ A_2,...,\ A_{n-4}\ ],\ [\ A_{n-2},\ A_{n-1},\ A_1,\ A_2,...,\ A_{n-4}\ ]\ ]$
      - For the first two `(nums[mid] < nums[start])`, the order is not monotonous between start, target and mid, `end can be updated to mid - 1`
      - For the last one `(nums[mid] >= nums[start])`, the order is not monotonous between start, mid and target, so `start can be updated to mid + 1` only if `target < nums[mid]` otherwise only `end can update end to mid - 1`
  - **When nums[start] < nums[end]**
    - It is the normal binary search in a non rotated array
   
      
### Code
```
class Solution {
    public int search(int[] nums, int target) {
        int numsLen = nums.length;
        int start = 0, end = numsLen - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;
            
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[start] >= nums[end]){
                if (target > nums[mid]) {
                    if (nums[mid] >= nums[start]) {
                        start = mid + 1;
                    } else {
                        if (target >= nums[start]) {
                            end = mid - 1;
                        } else {
                            start = mid + 1;
                        }
                    }
                } else {
                    if (nums[mid] >= nums[start]) {
                        if (target >= nums[start]) {
                            end = mid - 1;
                        } else {
                            start = mid + 1;
                        }
                    } else {
                        end = mid - 1;
                    }
                }
            } else {
                if (nums[mid] == target) {
                    return mid;
                } else if (target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}
```

### Simplified Code
```
class Solution {
    public int search(int[] nums, int target) {
        int numsLen = nums.length;
        int start = 0, end = numsLen - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;
            
            if (nums[mid] == target) {
                return mid;
            }

            if (target > nums[mid] && nums[mid] >= nums[start] ) {
                start = mid + 1;
            } else if (target > nums[mid] && target >= nums[start]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else if (nums[mid] >= nums[start] && target >= nums[start]) {
                end = mid - 1;
            } else if (nums[mid] >= nums[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
```

### Much More Simplified Code

- Condition `(target > nums[mid] &&  nums[mid] >= nums[start])` is for the structure `(start, mid, targetIdx)` -> Consider `(start, mid, targetIdx)` = `(0, 3, 5)` in `[4, 5, 6, 7, 8, 9, 1, 2]`
- Condition `(target > nums[mid] && target < nums[start])` is for the structure `(start, mid, targetIdx)` -> Consider `(start, mid, targetIdx)` = `(1, 3, 6)` in `[7, 8, 9, 1, 2, 3, 4, 5, 6]`
- Condition `(target < nums[start] &&  nums[mid] >= nums[start])` is  for the structure `(start, mid, targetIdx)` -> Consider `(start, mid, targetIdx)` = `(2, 5, 8)` in `[5, 6, 7, 8, 9, 10, 11, 1, 2, 3, 4]`
  - If any one of these is satisfied then it is evident to move the starting pointer to mid + 1 (i.e) `start = mid + 1`
  - Otherwise move the ending pointer to mid - 1 (i.e) `end = mid - 1`

```
class Solution {
    public int search(int[] nums, int target) {
        int numsLen = nums.length;
        int start = 0, end = numsLen - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;
            
            if (nums[mid] == target) {
                return mid;
            }

            if ((target > nums[mid] && nums[mid] >= nums[start]) || (target > nums[mid] && target < nums[start]) || (target < nums[start] && nums[mid] >= nums[start])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
```


## Approach 2 - Split and Binary Search

**Find Lowest and Binary Search**

- First find the starting lowest point of the Array, split the Array into two parts carrying $[A_{n-3}, A_{n-2}, A_{n-1}], [A_1, A_2,...,A_{n-4}]$
- Then perform Binary Search on the first Array, if not found, perform it on the second Array, if not found, return -1

### Code

```
class Solution {
    public static int binarySearch(int nums[],int start,int end,int target){
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if (nums[mid]>target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }
    public static int splt(int nums[]){
        int start = 0,mid = 0,end = nums.length-1;
        while(start<end){
            mid = start+(end-start)/2;
            if(nums[mid]>nums[mid+1]){
                return mid+1;
            }
            else if(nums[mid]<nums[start]){
                end = mid;
            }
            else{
                start = mid+1;
            }
        }
        return 0;
    }
    public int search(int[] nums, int target) {
        int start = 0,mid = 0,end = nums.length-1;
        if(nums[start]<nums[end]){
            return binarySearch(nums,start,end,target);
        }
        else{
            int spl = splt(nums);
            int res = binarySearch(nums,start,spl,target);
            if(res!=-1){
                return res;
            }
            return binarySearch(nums,spl,nums.length-1,target);
        }
    }
}
```

#### Complexity Analysis

Here, nnn be the number of courses and mmm be the size of `prerequisites`.

*   Time complexity: O(m+n)O(m + n)O(m+n)
    
    *   Initializing the `adj` list takes O(m)O(m)O(m) time as we go through all the edges. The `indegree` array take O(n)O(n)O(n) time.
    *   Each queue operation takes O(1)O(1)O(1) time, and a single node will be pushed once, leading to O(n)O(n)O(n) operations for nnn nodes. We iterate over the neighbors of each node that is popped out of the queue iterating over all the edges once. Since there are total of `m` edges, it would take O(m)O(m)O(m) time to iterate over the edges.
*   Space complexity: O(m+n)O(m + n)O(m+n)
    
    *   The `adj` arrays takes O(m)O(m)O(m) space. The `indegree` array takes O(n)O(n)O(n) space.
    *   The queue can have no more than nnn elements in the worst-case scenario. It would take up O(n)O(n)O(n) space in that case.

* * *
