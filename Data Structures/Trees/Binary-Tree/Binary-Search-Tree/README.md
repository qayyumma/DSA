## Binary Search Tree (BST)

A Binary Search Tree (BST) is a binary tree that maintains a specific property: for each node, all keys in the left subtree are less than the node's key, and all keys in the right subtree are greater than the node's key. This property makes BSTs efficient for searching, insertion, and deletion operations.

```
       Balanced Binary Tree
           └── Binary Search Tree (BST)
                 ├── AVL Tree
                 ├── Red-Black Tree
                 ├── Splay Tree
                 ├── Treap
                 └── Tango Tree
```

**Properties**

**Binary Tree Structure:** Each node has at most two children.

**Ordering Property:**

For any given node with value N:

All values in the left subtree are less than N.

All values in the right subtree are greater than N.

No Duplicates: Typically, BSTs do not allow duplicate values.

**Operations**

Search

Insertion

Deletion

Traversal

**1. Search**

**Purpose:** To find whether a given key exists in the BST.

**Algorithm:**

Start at the root.

Compare the key with the current node's key.

If they are equal, the search is successful.

If the key is less than the current node's key, search the left subtree.

If the key is greater, search the right subtree.

Repeat until the key is found or the subtree is null.

Time Complexity: O(h), where h is the height of the tree.

Example Code (Java):
```
public boolean search(Node root, int key) {
    if (root == null) {
        return false;
    }
    if (root.key == key) {
        return true;
    }
    return key < root.key ? search(root.left, key) : search(root.right, key);
}
```

**2. Insertion**

Purpose: To add a new key to the BST.

Algorithm:

Start at the root.

Compare the key with the current node's key.

If the key is less, insert it into the left subtree.

If the key is greater, insert it into the right subtree.

Repeat until you reach a null position where the new node can be inserted.

Time Complexity: O(h), where h is the height of the tree.

Example Code (Java):
```
public Node insert(Node root, int key) {
    if (root == null) {
        return new Node(key);
    }
    if (key < root.key) {
        root.left = insert(root.left, key);
    } else if (key > root.key) {
        root.right = insert(root.right, key);
    }
    return root;
}
```

**3. Deletion**

Purpose: To remove a key from the BST.

Cases:

Node with no children: Simply remove the node.

Node with one child: Remove the node and connect its parent directly to its child.

Node with two children: Find the in-order successor (smallest value in the right subtree) or in-order predecessor (largest value in the left subtree), replace the node's key with it, and delete the successor.

Algorithm:

Start at the root and find the node to be deleted.

Handle the three cases mentioned above.

Time Complexity: O(h), where h is the height of the tree.

Example Code (Java):

```
public Node deleteNode(Node root, int key) {
    if (root == null) {
        return root;
    }
    if (key < root.key) {
        root.left = deleteNode(root.left, key);
    } else if (key > root.key) {
        root.right = deleteNode(root.right, key);
    } else {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }
        root.key = minValue(root.right);
        root.right = deleteNode(root.right, root.key);
    }
    return root;
}

private int minValue(Node root) {
    int minValue = root.key;
    while (root.left != null) {
        root = root.left;
        minValue = root.key;
    }
    return minValue;
}
```

**4. Traversal**

Types:

In-order Traversal: Left subtree -> Root -> Right subtree

Produces sorted order of keys.

Pre-order Traversal: Root -> Left subtree -> Right subtree

Post-order Traversal: Left subtree -> Right subtree -> Root

Example Code (Java):

```
public void inorder(Node root) {
    if (root != null) {
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }
}

public void preorder(Node root) {
    if (root != null) {
        System.out.print(root.key + " ");
        preorder(root.left);
        preorder(root.right);
    }
}

public void postorder(Node root) {
    if (root != null) {
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.key + " ");
    }
}
```

**Applications**

**Searching:** Efficient for searching elements due to the binary search property.

**Sorting:** In-order traversal gives elements in sorted order.

**Dynamic Sets:** Can be used to maintain a dynamic set of numbers (e.g., in databases, dictionaries).

**Range Queries:** Useful in querying ranges of values efficiently.

**Performance**

Average Case: O(log n) for search, insert, and delete.

Worst Case: O(n), which occurs when the tree becomes a degenerate tree (like a linked list).

To avoid the worst-case scenario, self-balancing BSTs like AVL trees and Red-Black trees are used, which maintain a balanced height to ensure O(log n) operations.

Example Implementation of a BST in Java

Here's a complete example of a Binary Search Tree in Java, including search, insert, delete, and traversal operations:

```
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class BinarySearchTree {
    Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    // Insert a key
    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    // Search a key
    boolean search(int key) {
        return searchRec(root, key);
    }

    boolean searchRec(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.key == key) {
            return true;
        }
        return key < root.key ? searchRec(root.left, key) : searchRec(root.right, key);
    }

    // Delete a key
    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            root = root.left;
            minValue = root.key;
        }
        return minValue;
    }

    // Inorder traversal
    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Preorder traversal
    void preorder() {
        preorderRec(root);
    }

    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Postorder traversal
    void postorder() {
        postorderRec(root);
    }

    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

    // Driver code
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Print inorder traversal of the BST
        System.out.println("Inorder traversal:");
        tree.inorder();
        System.out.println();

        // Print preorder traversal of the BST
        System.out.println("Preorder traversal:");
        tree.preorder();
        System.out.println();

        // Print postorder traversal of the BST
        System.out.println("Postorder traversal:");
        tree.postorder();
        System.out.println();

        // Search for a key in the BST
        int key = 40;
        if (tree.search(key)) {
            System.out.println("Key " + key + " found in the BST.");
        } else {
            System.out.println("Key " + key + " not found in the BST.");
        }

        // Delete a key from the BST
        tree.deleteKey(20);
        System.out.println("Inorder traversal after deleting 20:");
        tree.inorder();
        System.out.println();

        tree.deleteKey(30);
        System.out.println("Inorder traversal after deleting 30:");
        tree.inorder();
        System.out.println();

        tree.deleteKey(50);
        System.out.println("Inorder traversal after deleting 50:");
        tree.inorder();
    }
}
`````

**Explanation of the Code**

**Node Class:** Represents each node in the BST, containing the key and pointers to the left and right children.

**BinarySearchTree Class:** Contains methods for inserting, searching, deleting, and traversing the BST.

**Insertion Method:** Inserts a new key into the BST, maintaining the BST property.

**Search Method:** Searches for a key in the BST, returning true if found and false otherwise.

**Deletion Method:** Deletes a key from the BST, handling the three cases (no children, one child, two children).

**Traversal Methods:** Prints the keys of the BST in in-order, pre-order, and post-order sequences.

**Main Method:** Demonstrates inserting nodes into the BST, performing various traversals, searching for a key, and deleting keys.
