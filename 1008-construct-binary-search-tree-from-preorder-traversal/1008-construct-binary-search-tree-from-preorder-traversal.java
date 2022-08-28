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
        
        for(int index = 1; index < preorder.length; index++){
            formBst(root, preorder[index]);
        }
        
        return root;
    }
    
    public void formBst(TreeNode root, int value){
        if(value <= root.val){
            if(root.left != null){
                formBst(root.left, value);
            }else{
                root.left = new TreeNode(value);
            }
        }else{
            if(root.right != null){
                formBst(root.right, value);
            }else{
                root.right = new TreeNode(value);
            }            
        }
    }
}