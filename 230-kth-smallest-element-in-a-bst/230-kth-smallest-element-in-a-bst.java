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
    int nodeValue = -1;
    public int kthSmallest(TreeNode root, int k) {
        getKthSmallest(root, k, 0);
        return nodeValue;
    }
    
    public int getKthSmallest(TreeNode root, int k, int count){
        if(nodeValue != -1){
            return count;
        }
        if(root == null){
        return count;
        }
        count = getKthSmallest(root.left, k, count);
        count++;
        if(count == k){
            nodeValue = root.val;
        }
        count = getKthSmallest(root.right, k, count);
        return count;
    }
}