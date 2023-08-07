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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        removeLeafNodeValues(root, target, false, false);
        if(root.left == null && root.right == null && root.val == target){
            root = null;
        }
        return root;
    }
    
    public boolean removeLeafNodeValues(TreeNode root, int target, boolean left, boolean right){
        if(root.left != null){
            left = removeLeafNodeValues(root.left, target, left, right);
        }
        if(root.right != null){
            right = removeLeafNodeValues(root.right, target, left, right);
        }
        if(left){
            root.left = null;
        }
        if(right){
            root.right = null;
        }
        if(root.val == target && root.left == null && root.right == null){
            return true;
        }
        return false;
    }
}