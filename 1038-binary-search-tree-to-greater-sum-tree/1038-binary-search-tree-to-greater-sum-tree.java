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
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        getGST(root);
        return root;
    }
    
    public int getGST(TreeNode root){
        if(root == null){
            return 0;
        }
        getGST(root.right);
        sum += root.val;
        root.val = sum;
        getGST(root.left);
        
        return sum;        
    }
}