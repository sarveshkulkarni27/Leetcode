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
    int findNodeAtDepth = -1;
    boolean flag = false;
    TreeNode result = null;
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        if(root.val == u.val){
            return null;
        }
        result = getNearestRightNode(root, u, 0);
        return result;
    }
    
    public TreeNode getNearestRightNode(TreeNode root, TreeNode u, int depth){
        if(flag){
            return result;
        }
        if(root == null){
            return null;
        }
        if(findNodeAtDepth != -1 && depth == findNodeAtDepth){
            result = root;
            flag = true;
            return result;
        }
        if(root.val == u.val){
            findNodeAtDepth = depth;
            return null;
        }
        result = getNearestRightNode(root.left, u, depth + 1);
        result = getNearestRightNode(root.right, u, depth + 1);
        return result;
    }
}