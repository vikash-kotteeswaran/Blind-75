# Concepts
## Graph
- **Topological Sort**
  - [Kahn's Algorithm](https://mohammad-imran.medium.com/understanding-topological-sorting-with-kahns-algo-8af5a588dd0e)
  - [Plain DFS](https://www.youtube.com/watch?v=eL-KzMXSXXI)
  - Topological Sort Implementation [link](https://www.youtube.com/watch?v=6kTZYvNNyps)
- **Union Find**
  - Union And Find Operations. Union Rank Purpose For Optimization. [link](https://youtu.be/0jNmHPfA_yE?si=Ixt1riBt8-x6eK5A)
  - Union Find Path Compression [link](https://youtu.be/VHRhJWacxis?si=K_t_7RjecdWT-9hE)
  - Union Find Data Structure Code Implementation [link](https://youtu.be/KbFlZYCpONw?si=gSG70cDsHom372iE)
- **Reference**
  - Top 5 Graph Algorithms [link](https://youtu.be/utDu3Q7Flrw?si=M79XHg_8tXL4N4Vn)

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
- $Int(log_2(n)) + 1$ gives the number of digits in a binary number.
- range of numbers from a bit array. 'n' is the size of the bit. Range -> $-2^{n - 1}$ to $2^{n-1} - 1$
- $n\ \\&\ (n-1)$ removes the right most bit of the number 'n' and gives the result as the decimal number that is removed of its right most bit's decimal value.
- $n\ \\&\ (-n)$ gets the right most bit of the number 'n' in decimal form (atleast when it comes to java)
- **Reference**
  - Kunal Kushwaha's video on Bit Manipulations [link](https://www.youtube.com/watch?v=fzip9Aml6og&t=6959s)

## Java Data Structures
- _String_ class has their values in a _String pool_, when a _String_ invoked by `intern()`, it checks for a _String instance_ with same value as the invoker and points _old instance value_ to the _invoker String_.
- `valueOf()` method of _Integer_ and _Long_ caches the values and when invoked with a value that is already cached, it points the cached value to the _newly to be created Class instance_.
