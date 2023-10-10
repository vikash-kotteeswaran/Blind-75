# Solution

## [Problem](https://leetcode.com/problems/same-tree/)

## Approach 1 - My Solution

**Linearly Scanning**

Scan both the trees Linearly using a Queue and compare each of the Nodes with respect to their sides (right or left)
      
### Code
```
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> pQueue = new LinkedList<>();
        pQueue.offer(p);
        Queue<TreeNode> qQueue = new LinkedList<>();
        qQueue.offer(q);

        Boolean sameTree = true;
        while (!pQueue.isEmpty() && !qQueue.isEmpty()) {
            TreeNode pN = pQueue.poll();
            TreeNode qN = qQueue.poll();

            if (pN == null && qN == null) {
                return true;
            }

            if (!(pN != null && qN != null && pN.val == qN.val)) {
                return false;
            }

            TreeNode pRN = pN.right;
            TreeNode pLN = pN.left;

            TreeNode qRN = qN.right;
            TreeNode qLN = qN.left;
            
            if (pLN != null && qLN != null) {
                pQueue.offer(pLN);
                qQueue.offer(qLN);
            } else if (!(pLN == null && qLN == null)) {
                return false;
            }

            if (pRN != null && qRN != null) {
                pQueue.offer(pRN);
                qQueue.offer(qRN);
            } else if (!(pRN == null && qRN == null)) {
                return false;
            }
        }

        if (pQueue.size() != qQueue.size()) {
            return false;
        }

        return true;
    }
}
```

### Simplified Code
```
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> pQueue = new LinkedList<>();
        pQueue.offer(p);
        Queue<TreeNode> qQueue = new LinkedList<>();
        qQueue.offer(q);

        while (!pQueue.isEmpty() && !qQueue.isEmpty()) {
            TreeNode pN = pQueue.poll();
            TreeNode qN = qQueue.poll();

            if (pN == null && qN == null) {
                continue;
            }

            if (pN == null || qN == null) {
                return false;
            }

            if (pN.val != qN.val) {
                return false;
            }

            pQueue.offer(pN.left);
            qQueue.offer(qN.left);
            pQueue.offer(pN.right);
            qQueue.offer(qN.right);
        }

        return pQueue.size() == qQueue.size();
    }
}
```

#### Complexity Analysis

Time Complexity - O(N)
Space Complexity - O(B)
N - Number of Nodes in the smallest tree
B - Number of Nodes along the breadth of the smallest tree at the deepest level of the smallest tree

## Approach 2 - Recursion

**Recursive Scanning**

- Compare the individual node of the two trees and recurse the same process for the nodes branches

### Code

```
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if (p == null && q == null) return true;
        
        if (p == null || q == null) return false;
        
        return 
            p.val == q.val
            && isSameTree(p.left, q.left) 
            && isSameTree(p.right, q.right); 
    }
}
```

#### Complexity Analysis
Time Complexity - O(N)
Space Complexity - O(1)
N - Number of Nodes in the smallest tree
