import java.util.*;

class VerticalTraversal {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            TreeNode node = current.node;
            int col = current.col;

            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(node.val);

            if (node.left != null) queue.offer(new Pair(node.left, col - 1));
            if (node.right != null) queue.offer(new Pair(node.right, col + 1));
        }

        return new ArrayList<>(map.values());
    }

    static class Pair {
        TreeNode node;
        int col;

        Pair(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        VerticalTraversal vt = new VerticalTraversal();
        System.out.println(vt.verticalTraversal(root)); // Output: [[9], [3, 15], [20], [7]]
    }
}
