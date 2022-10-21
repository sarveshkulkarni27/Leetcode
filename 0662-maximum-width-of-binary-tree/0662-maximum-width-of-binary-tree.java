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
    Map<Integer, int[]> depthAbsoluteDifference = new HashMap<>();
    int maxWidth = 1;
    public int widthOfBinaryTree(TreeNode root) {    
        depthAbsoluteDifference.put(0, new int[]{0, 0});
        getDFS(root, 0, 1);
        return maxWidth;
    }
    
    public void getDFS(TreeNode root, int depth, int currentNodePosition){
        
        int nextDepth = depth + 1;
        if(root.left != null){
            int newPosition = currentNodePosition * 2;
            if(!depthAbsoluteDifference.containsKey(nextDepth)){
                depthAbsoluteDifference.put(nextDepth, new int[]{newPosition, newPosition});
            }else{
                int[] currentPositions = depthAbsoluteDifference.get(nextDepth);
                //currentPositions[0] = Math.min(currentPositions[0], newPosition);
                currentPositions[1] = newPosition;
                maxWidth = Math.max(maxWidth, currentPositions[1] - currentPositions[0] + 1);
                depthAbsoluteDifference.put(nextDepth, currentPositions);
            }
            getDFS(root.left, nextDepth, newPosition);
        }
        if(root.right != null){
            int newPosition = currentNodePosition * 2 + 1;
            if(!depthAbsoluteDifference.containsKey(nextDepth)){
                depthAbsoluteDifference.put(nextDepth, new int[]{newPosition, newPosition});
            }else{
                int[] currentPositions = depthAbsoluteDifference.get(nextDepth);
                //currentPositions[0] = Math.min(currentPositions[0], newPosition);
                currentPositions[1] = newPosition;
                maxWidth = Math.max(maxWidth, currentPositions[1] - currentPositions[0] + 1);
                depthAbsoluteDifference.put(nextDepth, currentPositions);
            }
            getDFS(root.right, nextDepth, newPosition);
        }
    }
//     int max = 1;
//     List<Integer> leftIds = new ArrayList();
//     public int widthOfBinaryTree(TreeNode root) {
//         if(root == null) return 0;
//         traverse(root, 1, 1);
//         return max;
//     }
    
//     private void traverse(TreeNode root, int id, int depth) {
//         if(root == null) return;
//         //for each layer, add the left most node's id in the array.
//         if(leftIds.size() == depth - 1) {
//             System.out.println("Left: " + id);
//             leftIds.add(id);
//         } else {
//             //each depth will only have one left most node
//             max = Math.max(max, id - leftIds.get(depth - 1) + 1);
//         }
//         traverse(root.left, 2 * id, depth + 1);
//         traverse(root.right, 2 * id + 1, depth + 1);
//     }    
}