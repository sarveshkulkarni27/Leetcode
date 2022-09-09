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
    int count = 0;
    public int goodNodes(TreeNode root) {
        getGoodNodesCount(root, root.val);
        return count;
    }
    
    public void getGoodNodesCount(TreeNode root, int currentMax){
        if(root == null){
            return;
        }
        if(root.val >= currentMax){
            count++;
        }
        getGoodNodesCount(root.left, Math.max(root.val, currentMax));
        getGoodNodesCount(root.right, Math.max(root.val, currentMax));
    }
}