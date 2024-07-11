## TREE DATA STRUCTURE

**Tree data structure**  is a specialized data structure to store data in hierarchical manner. It is used to organize and store data in the computer to be used more effectively. It consists of a central node, structural nodes, and sub-nodes, which are connected via edges. We can also say that tree data structure has roots, branches, and leaves connected.

The data in a tree are not stored in a sequential manner i.e., they are not stored linearly. Instead, they are arranged on multiple levels or we can say it is a hierarchical structure. For this reason, the tree is considered to be a non-linear data structure.

One reason to use trees might be because you want to store information that naturally forms a hierarchy. For example, the file system on a computer.

![Time Complexity](images/Introduction-to-tree-.webp)

### Basic Terminologies In Tree Data Structure:

**Parent Node:** The node which is a predecessor of a node is called the parent node of that node. {B} is the parent node of {D, E}.

**Child Node:** The node which is the immediate successor of a node is called the child node of that node. Examples: {D, E} are the child nodes of {B}.

**Root Node:** The topmost node of a tree or the node which does not have any parent node is called the root node. {A} is the root node of the tree. A non-empty tree must contain exactly one root node and exactly one path from the root to all other nodes of the tree.

**Leaf Node or External Node:** The nodes which do not have any child nodes are called leaf nodes. {K, L, M, N, O, P, G} are the leaf nodes of the tree.

**Ancestor of a Node:** Any predecessor nodes on the path of the root to that node are called Ancestors of that node. {A,B} are the ancestor nodes of the node {E}

**Descendant:** A node x is a descendant of another node y if and only if y is an ancestor of x.

**Sibling:** Children of the same parent node are called siblings. {D,E} are called siblings.

**Level of a node:** The count of edges on the path from the root node to that node. The root node has level 0.

**Internal node:** A node with at least one child is called Internal Node.

**Neighbour of a Node:** Parent or child nodes of that node are called neighbors of that node.

**Subtree:** Any node of the tree along with its descendant.

### Properties of Tree Data Structure:

**1. Number of Edges**

Definition: An edge is a connection between two nodes.

Property: If a tree has 𝑁 nodes, it will have N−1 edges.

Example: A tree with 5 nodes will have 4 edges.

**2. Depth of a Node**

Definition: The depth of a node is the number of edges from the root node to that specific node.

Property: It measures how far down the tree the node is from the root.

Example: If a node is directly connected to the root, its depth is 1.

**3. Height of a Node**

Definition: The height of a node is the length of the longest path from that node to any leaf node.

Property: It shows how far the furthest leaf node is from the current node.

Example: If a node's longest path to a leaf has 3 edges, its height is 3.

**4. Height of the Tree**

Definition: The height of a tree is the length of the longest path from the root node to any leaf node.

Property: It measures the overall "tallness" of the tree.

Example: If the longest path from the root to a leaf is 4 edges, the height of the tree is 4.

**5. Degree of a Node**

Definition: The degree of a node is the number of subtrees (or children) directly connected to that node.

Property: It counts how many immediate connections a node has.

Example: A node with 3 children has a degree of 3.

Special Case: A leaf node, which has no children, has a degree of 0.

**6. Degree of the Tree**

Definition: The degree of the tree is the maximum degree of any node in the tree.

Property: It identifies the node with the most connections in the tree.

Example: If the highest degree among all nodes is 4, then the degree of the tree is 4.

### Applications of Tree Data Structure:

**File System:**  This allows for efficient navigation and organization of files.

**Data Compression:** Huffman coding is a popular technique for data compression that involves constructing a binary tree where the leaves represent characters and their frequency of occurrence. The resulting tree is used to encode the data in a way that minimizes the amount of storage required.

**Compiler Design:** In compiler design, a syntax tree is used to represent the structure of a program. 

**Database Indexing:** B-trees and other tree structures are used in database indexing to efficiently search for and retrieve data. 

### INSERTION, DELETION, SEARCHING of Binary tree.

**Creation of Node in Binary Tree**

Class Node
```
class Node
{   
    int key;
    Node left;
    Node right;
    
    Node(int val)
    {   
        key = val;
        left = null;
        right = null;
    }
}

```

**Purpose:** Represents a single node in the binary search tree (BST).

**Fields:**

**int key:** The value stored in the node.

**Node left:** Reference to the left child node.

**Node right:** Reference to the right child node.

**Constructor:** Initializes a node with a value val and sets both child nodes (left and right) to null


**Method insert**

```
    public Node insert(Node root, int val)
    {
        if(root == null)
            return new Node(val);
        else if(root.key < val)
            root.right = insert(root.right,val);
        else if(root.key > val)
            root.left = insert(root.left,val);
        return root;
    }

```

**Purpose:** Inserts a new value into the BST.

**Parameters:**

**Node root:** The current root of the subtree where we want to insert the new value.

**int val:** The value to be inserted.

**Logic:**

If root is null, create a new node with val and return it.

If val is greater than root.key, insert it in the right subtree.

If val is less than root.key, insert it in the left subtree.

Return the root of the modified subtree.

**Method search**

```
public boolean search(Node root, int key)
{
    if (root == null)
        return false;
    if (root.key == key)
        return true;
    else if (root.key > key)
        return search(root.left, key);
    else
        return search(root.right, key);
}
```

**Purpose:** Searches for a node with the given key in the BST.

**Parameters:**

**Node root:** The current root of the subtree where we want to search for the key.

**int key:** The key to be searched.

**Logic:**

If root is null, return false (key not found).

If root.key is equal to the key, return true (key found).

If the key is less than root.key, search in the left subtree.

If the key is greater than root.key, search in the right subtree.

**Method getRightMin**

```
    public int getRightMin(Node root)
    {
        Node temp = root;

        while(temp.left != null)
        {
            temp = temp.left;
        }

        return temp.key;
    }

```

**Purpose:** Finds the minimum value in the right subtree.

**Parameters:**

**Node root:** The root of the right subtree.

**Logic:**

Traverse to the leftmost node of the subtree (minimum value).

Return the key of the leftmost node.



**Method Delete**

```
    public Node removeNode(Node root, int val)
    {
        if(root == null)
            return null;
        if(root.key < val)
            root.right = removeNode(root.right,val);
        else if(root.key > val)
            root.left = removeNode(root.left,val);
        else
        {
            if(root.left == null && root.right == null)
                return null;
            else if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            else
            {
                int rightMin = getRightMin(root.right);
                root.key = rightMin;
                root.right = removeNode(root.right,rightMin);
            }
        }
        return root;
    }
```
Deletion in a Binary Search Tree (BST) involves removing a node while ensuring the tree remains a valid BST. There are three main cases to handle during deletion:

Deleting a Leaf Node (node with no children)

Deleting a Node with One Child

Deleting a Node with Two Children

**Case 1:** Deleting a Leaf Node

A leaf node is a node with no children. This is the simplest case.

Steps:

Simply remove the node from the tree.

Example:

Node to be deleted: 20
```
Tree before deletion:

markdown

   10
     \
      20

Tree after deletion:

Copy code
   10
```

**Case 2:** Deleting a Node with One Child

A node with one child has either a left child or a right child.

Steps:

Remove the node and connect its parent directly to its child.
Example:

Node to be deleted: 30

```
Tree before deletion:

    10
      \
       30
         \
          40
Tree after deletion:
markdown
Copy code
    10
      \
       40
```

**Case 3:** Deleting a Node with Two Children

This is the most complex case. The node to be deleted has both left and right children.

Steps:

Find the node's in-order successor (the smallest node in its right subtree) or in-order predecessor (the largest node in its left subtree).

Replace the node’s key with the in-order successor’s (or predecessor's) key.

Delete the in-order successor (or predecessor), which will now have at most one child.
Example:

Node to be deleted: 20

Tree before deletion:
```
    15
   /  \
  10   20
       / \
      17  25
Choose in-order successor: 25

Replace 20 with 25

Delete 25

Tree after deletion:

markdown
Copy code
    15
   /  \
  10   25
       /
      17
```

### Tree Traversal 
A Tree Data Structure can be traversed in following ways:

Depth First Search or DFS

- Inorder Traversal

- Preorder Traversal

- Postorder Traversal

Level Order Traversal or Breadth First Search or BFS

### 
