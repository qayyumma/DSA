public void inorderTraversal(TreeNode root) {
    if (root == null) return;
    inorderTraversal(root.left);
    System.out.print(root.val + " ");
    inorderTraversal(root.right);
}

================================================

public void inorderTraversalIterative(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode current = root;

    while (current != null || !stack.isEmpty()) {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
        current = stack.pop();
        System.out.print(current.val + " ");
        current = current.right;
    }
}

================================================

# Example Tree:
#       1
#      / \
#     2   3
#    / \
#   4   5

Inorder Traversal: 4 2 5 1 3
