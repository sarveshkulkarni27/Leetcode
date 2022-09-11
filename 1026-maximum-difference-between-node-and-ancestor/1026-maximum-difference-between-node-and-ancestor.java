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
    int maxDiff = 0;
    public int maxAncestorDiff(TreeNode root) {
        getDFS(root);
        return maxDiff;
    }
    
    public void getDFS(TreeNode root){
        if(root == null){
            return;
        }
        getMaxValueDFS(root.left, root.val);
        getMaxValueDFS(root.right, root.val);
        
        getDFS(root.left);
        getDFS(root.right);
    }
    
    public void getMaxValueDFS(TreeNode root, int rootVal){
        if(root == null){
            return;
        }
        maxDiff = Math.max(maxDiff, Math.abs(root.val - rootVal)); 
        getMaxValueDFS(root.left, rootVal);
        getMaxValueDFS(root.right, rootVal);
    }
}