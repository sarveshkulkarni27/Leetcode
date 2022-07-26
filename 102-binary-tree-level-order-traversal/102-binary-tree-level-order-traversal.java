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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderedList = new ArrayList<>();
        return getLevelOrderedList(root, 0, levelOrderedList);
    }
    
    public List<List<Integer>> getLevelOrderedList(TreeNode root, int depth, List<List<Integer>> levelOrderedList){
        if(root == null){
            return levelOrderedList;
        }
        if(levelOrderedList.size() > depth){
            levelOrderedList.get(depth).add(root.val);
        }else{
            List<Integer> newDepthList = new ArrayList<Integer>();
            newDepthList.add(root.val);
            levelOrderedList.add(newDepthList);
        }
        getLevelOrderedList(root.left, depth + 1, levelOrderedList);
        getLevelOrderedList(root.right, depth + 1, levelOrderedList);
        return levelOrderedList;
    }
}