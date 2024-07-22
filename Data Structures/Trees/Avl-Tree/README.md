## AVL Tree

Binary Search Trees (BSTs) have several potential drawbacks that can lead to inefficiencies, particularly in terms of time complexity for operations such as insertion, deletion, and searching. The primary issues with BSTs include:

**Skewed Trees:** If the elements are inserted in a sorted or nearly sorted order, the BST can become skewed (i.e., it degenerates into a linked list). This causes the height of the tree to be O(n), where n is the number of nodes, making the time complexity for basic operations (search, insert, delete) O(n) instead of 𝑂(log 𝑛).

**Balancing Issues:** BSTs do not automatically balance themselves. Without specific balancing mechanisms, the tree's performance can degrade significantly in worst-case scenarios.

**To address these drawbacks, AVL (Adelson-Velsky and Landis) trees were introduced. AVL trees are a type of self-balancing binary search tree. The key features and advantages of AVL trees include:**

**Self-Balancing:** AVL trees automatically maintain their balance by ensuring that the heights of the two child subtrees of any node differ by at most one. This balance condition is checked and maintained after every insertion and deletion operation.

**Balanced Height:** Because AVL trees are balanced, the height of the tree is guaranteed to be 𝑂(log 𝑛 ) This ensures that all basic operations (search, insert, delete) have a time complexity of O(logn), providing better performance guarantees compared to unbalanced BSTs.

**Rebalancing Operations:** To maintain balance, AVL trees use rotations (single and double rotations) during insertion and deletion operations. These rotations adjust the structure of the tree to ensure that the balance condition is preserved.

**Key Advantages of AVL Trees over BSTs:**

**Improved Worst-Case Performance:** The self-balancing property of AVL trees ensures that the tree remains balanced, preventing the worst-case 𝑂(𝑛) time complexity of skewed BSTs.

**Predictable Performance:** Since the height of an AVL tree is strictly 𝑂 (logn), the performance of AVL trees is more predictable and consistent, especially for large datasets.

**Automatic Balancing:** AVL trees handle balancing automatically, reducing the need for manual interventions to maintain tree structure and performance.

By addressing the potential issues of skewed and unbalanced trees, AVL trees offer a more robust and efficient solution for scenarios where balanced search tree performance is critical.

### AVL Tree Node Class

First, we define the node class for our AVL tree. Each node will store a value, references to its left and right children, and a height attribute.

```
class AVLNode {
    int value;
    AVLNode left, right;
    int height;

    AVLNode(int value) {
        this.value = value;
        this.height = 1; // New node is initially added at leaf
    }
}
```

### AVL Tree Class

Next, we define the AVL tree class that includes the methods to perform insertion, rotation, and balance operations.

```
class AVLTree {
    private AVLNode root;

    // A utility function to get the height of the tree
    int height(AVLNode node) {
        if (node == null)
            return 0;
        return node.height;
    }

    // A utility function to right rotate subtree rooted with y
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Get Balance factor of node N
    int getBalance(AVLNode node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    // Recursive function to insert a value in the subtree rooted
    // with node and returns the new root of the subtree.
    AVLNode insert(AVLNode node, int value) {
        // Perform the normal BST insertion
        if (node == null)
            return (new AVLNode(value));

        if (value < node.value)
            node.left = insert(node.left, value);
        else if (value > node.value)
            node.right = insert(node.right, value);
        else // Duplicate values not allowed
            return node;

        // Update height of this ancestor node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get the balance factor of this ancestor node to check whether
        // this node became unbalanced
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there are 4 cases

        // Left Left Case
        if (balance > 1 && value < node.left.value)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && value > node.right.value)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && value > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && value < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Return the (unchanged) node pointer
        return node;
    }

    // Function to insert a value
    public void insert(int value) {
        root = insert(root, value);
    }

    // A utility function to print the preorder traversal of the tree.
    // The function also prints the height of every node
    void preOrder(AVLNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // Function to print the preorder traversal of the tree
    public void preOrder() {
        preOrder(root);
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        /* Constructing tree given in the above figure */
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
        System.out.println("Preorder traversal" +
                " of constructed tree is : ");
        tree.preOrder();
    }
}

```

**Explanation**

AVLNode Class:

Represents a node in the AVL tree.

Stores value, left and right children, and height of the node.

**AVLTree Class:**

height(AVLNode node): Utility function to get the height of a node.

rightRotate(AVLNode y): Performs a right rotation around the given node.

leftRotate(AVLNode x): Performs a left rotation around the given node.

getBalance(AVLNode node): Computes the balance factor of a node.

insert(AVLNode node, int value): Recursively inserts a value into the subtree and balances the tree.

insert(int value): Public method to start the insertion process.

preOrder(AVLNode node): Utility function to print the tree in preorder traversal.

preOrder(): Public method to start preorder traversal.

**Running the Code**

The main method constructs an AVL tree by inserting nodes and then prints the preorder traversal of the tree. The rotations ensure the tree remains balanced after each insertion.
