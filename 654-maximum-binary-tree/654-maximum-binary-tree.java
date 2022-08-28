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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        return constructBTree(nums, 0, nums.length - 1);
    }
    
    public TreeNode constructBTree(int[] nums, int left, int right){
        if(left > right){
            return null;
        }
        
        int maxVal = -1;
        int currentIndex = 0;
        for(int index = left; index <= right; index++){
            if(nums[index] > maxVal){
                maxVal = nums[index];
                currentIndex = index;
            }
        }
        
        TreeNode root = new TreeNode(maxVal);
        
        root.left = constructBTree(nums, left, currentIndex - 1);
        root.right = constructBTree(nums, currentIndex + 1, right);
        
        return root;
    }
}