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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int len = q.size();
            List<Integer> valuesLevel = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    valuesLevel.add(node.val);
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
            
            if (!valuesLevel.isEmpty()) {
                res.add(valuesLevel);
            }
        }

        return res;
    }
}
