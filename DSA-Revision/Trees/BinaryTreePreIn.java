import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class ConstructBinaryTree {
    private HashMap<Integer, Integer> inorderMap; // To store the index of each value in the inorder traversal
    private int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Initialize the map to store inorder indices for quick lookup
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        preorderIndex = 0;
        return buildTreeRecursive(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeRecursive(int[] preorder, int inorderStart, int inorderEnd) {
        // Base case: if the inorder range is invalid
        if (inorderStart > inorderEnd) {
            return null;
        }

        // Get the root value from preorder array using preorderIndex
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Get the index of the root in inorder traversal
        int inorderIndex = inorderMap.get(rootValue);

        // Recursively build the left and right subtrees
        root.left = buildTreeRecursive(preorder, inorderStart, inorderIndex - 1);
        root.right = buildTreeRecursive(preorder, inorderIndex + 1, inorderEnd);

        return root;
    }

    // Helper function to print the tree in Inorder (for verification)
    public void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        // Example Input:
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        ConstructBinaryTree builder = new ConstructBinaryTree();
        TreeNode root = builder.buildTree(preorder, inorder);

        // Print the constructed tree's Inorder traversal for verification
        System.out.print("Constructed Inorder Traversal: ");
        builder.printInorder(root); // Output: 9 3 15 20 7
    }
}
