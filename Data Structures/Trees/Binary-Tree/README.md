## Binary Tree

A binary tree is a tree data structure in which each node has at most two children, referred to as the left child and the right child. Binary trees are a fundamental structure in computer science and form the basis for more complex tree structures.

#### Full Binary Tree

Definition: A binary tree is full if every node has either 0 or 2 children. No node in a full binary tree has only one child.

**Properties:**

All internal nodes have exactly two children.

Leaf nodes have no children.

It is not necessarily balanced.

**Use Cases:** Useful in scenarios where a strict structure is required, such as binary heaps.

Example:
```
        1
       / \
      2   3
     / \
    4   5
In the example, every node has either 0 or 2 children.
```
### Complete Binary Tree

Definition: A binary tree is complete if all levels are completely filled except possibly for the last level, which is filled from left to right.

**Properties:**

All levels except possibly the last are completely filled.

All nodes are as far left as possible.

It ensures minimal height, providing efficient storage and quick access.

Use Cases: Commonly used in binary heaps and for implementing priority queues.

Example:
```
        1
       / \
      2   3
     / \  /
    4  5 6
In the example, all levels are fully filled except for the last level, which is filled from left to right.
```

### Perfect Binary Tree

**Definition:** A binary tree is perfect if all internal nodes have exactly two children and all leaf nodes are at the same level.

**Properties:**

Every level, including the last level, is fully filled.

All leaf nodes are at the same depth.

A perfect binary tree of height h has (2^(h+1) - 1) nodes.

**Use Cases:** Ideal for algorithms that require uniform distribution of nodes, such as certain balanced tree algorithms.

Example:
```
        1
       / \
      2   3
     / \ / \
    4  5 6  7
In the example, every internal node has exactly two children, and all leaf nodes (4, 5, 6, 7) are at the same level.
```

### Degenerate (or Pathological) Tree

**Definition:** A binary tree is degenerate if each parent node has only one child, effectively forming a linear structure similar to a linked list.

**Properties:**

The height of a degenerate tree is equal to the number of nodes.

Performance of tree operations (insert, delete, search) degrades to O(n) in the worst case.

It occurs due to poor balancing in a binary tree.

Use Cases: Rarely used intentionally; represents the worst-case scenario for binary trees.

Example:
```
    1
     \
      2
       \
        3
         \
          4
```

### Balanced Binary Tree**

**Definition:** A binary tree is balanced if the height difference between the left and right subtrees of any node is at most one.

**Properties:**

Ensures operations like insertion, deletion, and search have O(log n) time complexity.

Balancing is maintained through rotations or other restructuring techniques.

**Use Cases:** Used in scenarios where balanced operations are needed, such as AVL trees and Red-Black trees.

Example:
```
        2
       / \
      1   3
In the example, the height difference between the left and right subtrees of each node is at most one.
```

**Types of Balanced Binary Trees:**

**AVL Tree:** A self-balancing binary search tree where the height of the two child subtrees of any node differs by at most one.

**Red-Black Tree:** A self-balancing binary search tree where nodes are colored red or black to ensure balance during insertions and deletions.

**Splay Tree:** A self-adjusting binary search tree where recently accessed elements are quick to access again.

**Treap:** A randomized binary search tree where each node also has a priority, and the tree maintains both BST properties and heap properties.

**Tango Tree:** A type of self-adjusting binary search tree optimized for sequences of operations.
