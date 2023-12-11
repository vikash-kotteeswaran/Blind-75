# Concepts
## Graph
- **Topological Sort**
  - [Kahn's Algorithm](https://mohammad-imran.medium.com/understanding-topological-sorting-with-kahns-algo-8af5a588dd0e)
  - [Plain DFS](https://www.youtube.com/watch?v=eL-KzMXSXXI)

## Queue
- **Priority Queue**
  - A Queue where all the nodes has a priority and are **sorted** by **priority**
  - A **Priority Queue** can be formed using an **Array, LinkedList and a Heap (Min or Max Heap)**
  - **Min Heap** is where the child nodes are always lesser than the parent node
  - **Max Heap** is where the child nodes are always greater than the parent node
 
## Binary Tree
- [Binary Tree Types](https://www.geeksforgeeks.org/types-of-binary-tree/)
- **Special Types of Tree**
  - **Binary Search Tree**
    - Left Child Node which will lesser than Parent Node and Right Child Node which will greater than the Parent Node
    - Elements in the Left Sub-Tree will always be lesser than its parent node and Elements in the Right Sub-Tree will always be greater than its parent node.
  - [AVL Tree](https://www.cs.auckland.ac.nz/software/AlgAnim/AVL.html)
  - [Red-Black Tree](https://www.cs.auckland.ac.nz/software/AlgAnim/red_black_op.html)

## HashSets
- LookUp of a string in a HashSet or a HashMap is not O(1) but O(m) where m is the length of the string
  - Looking up a string requires hashing of the string and looking up the hashcode in the HashSet.
  - Hashing of a string needs to consider/process all the characters in the string thus taking up O(m) time complexity.

## Arithmetic Concepts
- Diagonal elements in a matrix have the same index sums (row_index + col_index)

## Binary Concepts
- A number XOR-ing itself will return 0, any number XOR-ing with 0 will stay unchanged.
