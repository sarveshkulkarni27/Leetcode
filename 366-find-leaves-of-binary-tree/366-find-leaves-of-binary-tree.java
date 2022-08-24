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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> leavesList = new ArrayList<>();
        while(root != null){
            List<Integer> currentLeaves = new ArrayList<>();
            root = getLeaves(root, currentLeaves);
            leavesList.add(currentLeaves);
        }
        return leavesList;
    }
    
    public TreeNode getLeaves(TreeNode root, List<Integer> currentLeaves){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            currentLeaves.add(root.val);
            return null;
        }
        root.left = getLeaves(root.left, currentLeaves);
        root.right = getLeaves(root.right, currentLeaves);
        return root;
    }
    
}