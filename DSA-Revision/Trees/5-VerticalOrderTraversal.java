/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {


    static class pair {
        Integer level;
        TreeNode node;

        public pair(Integer level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }



    public int[][] verticalOrderTraversal(TreeNode A) {

        Queue<pair> queue = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        int max = 0;
        int min = 0;

        pair curr = new pair(0, A);
        queue.offer(curr);

        // BFS traversal to populate the map
        while (!queue.isEmpty()) {
            curr = queue.poll();

            if (curr.node.left != null) {
                pair temp = new pair(curr.level - 1, curr.node.left);
                queue.offer(temp);
            }

            if (curr.node.right != null) {
                pair temp = new pair(curr.level + 1, curr.node.right);
                queue.offer(temp);
            }

            // Add node value to the list corresponding to the current level
            if (!map.containsKey(curr.level)) {
                map.put(curr.level, new ArrayList<Integer>());
            }
            map.get(curr.level).add(curr.node.val);

            min = Math.min(min, curr.level);
            max = Math.max(max, curr.level);
        }

        int len = max - min + 1; // Total number of levels from min to max
        int[][] ans = new int[len][];

        // Populate the result 2D array
        for (int i = 0; i < len; i++) {
                int level = min + i;
                ArrayList<Integer> nodesAtLevel = map.get(level);
                ans[i] = new int[nodesAtLevel.size()];
                for (int j = 0; j < nodesAtLevel.size(); j++) {
                    ans[i][j] = nodesAtLevel.get(j);
                }
        }

        return ans;
    }

}
