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

public class ConstructBinaryTreeFromInPost {
    private HashMap<Integer, Integer> inorderMap; // Map to store value-to-index mapping for Inorder traversal
    private int postorderIndex; // Index for traversing Postorder array

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Initialize the map to store the indices of Inorder traversal for quick lookup
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // Start with the last element in the Postorder array
        postorderIndex = postorder.length - 1;

        return buildTreeRecursive(postorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeRecursive(int[] postorder, int inorderStart, int inorderEnd) {
        // Base case: if the Inorder range is invalid
        if (inorderStart > inorderEnd) {
            return null;
        }

        // Get the root value from Postorder array using postorderIndex
        int rootValue = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootValue);

        // Get the index of the root in the Inorder traversal
        int inorderIndex = inorderMap.get(rootValue);

        // Recursively build the right subtree first, then the left subtree
        root.right = buildTreeRecursive(postorder, inorderIndex + 1, inorderEnd);
        root.left = buildTreeRecursive(postorder, inorderStart, inorderIndex - 1);

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
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        ConstructBinaryTreeFromInPost builder = new ConstructBinaryTreeFromInPost();
        TreeNode root = builder.buildTree(inorder, postorder);

        // Print the constructed tree's Inorder traversal for verification
        System.out.print("Constructed Inorder Traversal: ");
        builder.printInorder(root); // Output: 9 3 15 20 7
    }
}
