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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        
        return buildHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private TreeNode buildHelper(int[] pre, int preStart, int preEnd,
                            int[] in, int inStart, int inEnd,
                            Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;
        
        int rootVal = pre[preStart];
        TreeNode root = new TreeNode(rootVal);
        
        
        int inRootIdx = inMap.get(rootVal);
        int leftSubtreeSize = inRootIdx - inStart;
        
        root.left = buildHelper(pre, preStart + 1, preStart + leftSubtreeSize,
                in, inStart, inRootIdx - 1, inMap);
        
        root.right = buildHelper(pre, preStart + leftSubtreeSize + 1, preEnd, 
                in, inRootIdx + 1, inEnd, inMap);
        
        return root;
    }
}
