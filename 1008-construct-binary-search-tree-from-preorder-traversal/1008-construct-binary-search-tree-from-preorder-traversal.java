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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        if(preorder.length > 1){
            getBST(preorder, root);
        }
        return root;
    }
    
    public void getBST(int[] preorder, TreeNode root){
        for(int index = 1; index < preorder.length; index++){
            insertNode(preorder[index], root);
        }
    }
    
    public void insertNode(int target, TreeNode root){
        if(target <= root.val){
            if(root.left == null){
                root.left = new TreeNode(target);
            }else{
                insertNode(target, root.left);
            }
        }else{
            if(root.right == null){
                root.right = new TreeNode(target);
            }else{
                insertNode(target, root.right);
            }            
        }
    }
}