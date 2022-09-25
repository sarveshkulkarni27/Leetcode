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
    public List<Integer> rightSideView(TreeNode root) {
        return getDFS(1, root, new ArrayList<Integer>());
    }
    
    public List<Integer> getDFS(int depth, TreeNode root, List<Integer> rightSideViewList){
        if(root == null){
            return rightSideViewList;
        }
        if(rightSideViewList.size() < depth){
            rightSideViewList.add(root.val);
        }
        getDFS(depth + 1, root.right, rightSideViewList);
        getDFS(depth + 1, root.left, rightSideViewList);
        return rightSideViewList;
    }
}