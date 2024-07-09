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

