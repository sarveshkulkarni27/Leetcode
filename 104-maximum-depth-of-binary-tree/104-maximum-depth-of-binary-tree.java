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
        return getMaxDepth(root, 1);
    }
    
    public int getMaxDepth(TreeNode root, int depth){
        if(root == null){
            return depth - 1;
        }
        int leftDepth = getMaxDepth(root.left, depth + 1);
        int rightDepth = getMaxDepth(root.right, depth + 1);
        return Math.max(leftDepth, rightDepth);
    }
}