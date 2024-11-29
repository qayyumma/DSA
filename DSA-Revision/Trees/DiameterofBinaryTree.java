class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTreeDiameter {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root); // Start the recursive calculation
        return diameter;
    }

    private int calculateHeight(TreeNode node) {
        if (node == null) {
            return -1; // Height of a null node is -1
        }

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        // Update diameter with the current node's diameter
        diameter = Math.max(diameter, leftHeight + rightHeight + 2);

        // Return the height of the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        // Example Binary Tree:
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        BinaryTreeDiameter tree = new BinaryTreeDiameter();
        int diameter = tree.diameterOfBinaryTree(root);

        System.out.println("Diameter of the Binary Tree: " + diameter);
    }
}
