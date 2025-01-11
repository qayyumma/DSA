public void preorderTraversal(TreeNode root) {
    if (root == null) return;
    System.out.print(root.val + " ");
    preorderTraversal(root.left);
    preorderTraversal(root.right);
}

===============================================

public void preorderTraversalIterative(TreeNode root) {
    if (root == null) return;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        System.out.print(node.val + " ");
        if (node.right != null) stack.push(node.right);
        if (node.left != null) stack.push(node.left);
    }
}
