# Solution

## [Problem](https://leetcode.com/problems/course-schedule-ii/)

## Approach 1 - My Solution

**Solution is same as the solution for Course Schedule I Problem**
- Follow Topological Sort via Kahn's Algorithm or DFS
  - Follow Kahn's Algorithm and Keep track of the Nodes with incomings "zero" in a List
  - Follow DFS and keep track of all the leaf nodes in a order while traversing every node in a list

### Code
```
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] incomingsCount = new int[numCourses];
        List<List<Integer>> outgoings = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            outgoings.add(new ArrayList<>());
        }
        int[] sortedList = new int[numCourses];
        int sortNumber = 0;
        Queue<Integer> sourcePointQueue = new LinkedList<Integer>();

        for (int idx = 0; idx < prerequisites.length; idx++) {
            int depCourse = prerequisites[idx][0], indepCourse = prerequisites[idx][1];
            incomingsCount[depCourse]++;
            outgoings.get(indepCourse).add(depCourse);
        }

        for (int courseIdx = 0; courseIdx < numCourses; courseIdx++) {
            if (incomingsCount[courseIdx] == 0) sourcePointQueue.offer(courseIdx);
        }

        while (sourcePointQueue.size() > 0) {
            int sourcePoint = sourcePointQueue.poll();
            List<Integer> sourceOutgoingPoints = outgoings.get(sourcePoint);
            for (int outGoingPoint : sourceOutgoingPoints) {
                incomingsCount[outGoingPoint]--;
                if (incomingsCount[outGoingPoint] == 0) sourcePointQueue.offer(outGoingPoint);
            }
            sortedList[sortNumber++] = sourcePoint;
        }

        return sortNumber == numCourses ? sortedList : new int[]{};
    }
}
```
