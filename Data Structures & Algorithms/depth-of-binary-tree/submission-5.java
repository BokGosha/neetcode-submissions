/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int level = 0;
        Queue<TreeNode> d = new LinkedList<>();
        d.offer(root);

        while (!d.isEmpty()) {
            int len = d.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = d.poll();
                if (node.left != null) {
                    d.offer(node.left);
                }
                if (node.right != null) {
                    d.offer(node.right);
                }
            }

            level++;
        }

        return level;
    }
}
