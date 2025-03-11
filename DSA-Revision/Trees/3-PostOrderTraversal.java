public void postorderTraversal(TreeNode root) {
    if (root == null) return;
    postorderTraversal(root.left);
    postorderTraversal(root.right);
    System.out.print(root.val + " ");
}

=====================================================


public void postorderTraversalIterative(TreeNode root) {
    if (root == null) return;

    Stack<TreeNode> stack1 = new Stack<>();
    Stack<TreeNode> stack2 = new Stack<>();
    stack1.push(root);

    while (!stack1.isEmpty()) {
        TreeNode node = stack1.pop();
        stack2.push(node);
        if (node.left != null) stack1.push(node.left);
        if (node.right != null) stack1.push(node.right);
    }

    while (!stack2.isEmpty()) {
        System.out.print(stack2.pop().val + " ");
    }
}


=========================================================


# Example Tree:
#       1
#      / \
#     2   3
#    / \
#   4   5

Postorder Traversal: 4 5 2 3 1
