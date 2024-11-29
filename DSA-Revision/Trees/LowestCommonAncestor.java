class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class LowestCommonAncestor {
    public TreeNode findLCA(TreeNode root, TreeNode node1, TreeNode node2) {
        // Base case: if root is null or matches either of the nodes, return root
        if (root == null || root == node1 || root == node2) {
            return root;
        }

        // Recursively search for the target nodes in the left and right subtrees
        TreeNode leftLCA = findLCA(root.left, node1, node2);
        TreeNode rightLCA = findLCA(root.right, node1, node2);

        // Determine the LCA based on the search results
        if (leftLCA != null && rightLCA != null) {
            return root; // Current root is the LCA
        }

        // If one subtree contains both nodes, return that subtree's result
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    public static void main(String[] args) {
        // Example Binary Tree:
        //        3
        //       / \
        //      5   1
        //     / \ / \
        //    6  2 0  8
        //      / \
        //     7   4

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        LowestCommonAncestor lcaFinder = new LowestCommonAncestor();

        TreeNode node1 = root.left; // Node 5
        TreeNode node2 = root.left.right.right; // Node 4

        TreeNode lca = lcaFinder.findLCA(root, node1, node2);
        System.out.println("Lowest Common Ancestor of " + node1.val + " and " + node2.val + " is: " + lca.val);
    }
}
