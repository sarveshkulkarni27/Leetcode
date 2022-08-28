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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        traverseTree(root, nodes);
                
        return generateBST(nodes, 0, nodes.size() - 1, new TreeNode());
    }
    
    public void traverseTree(TreeNode root, List<Integer> nodes){
        if(root == null){
            return;
        }
        traverseTree(root.left, nodes);
        nodes.add(root.val);
        traverseTree(root.right, nodes);
    }
    
    
    public TreeNode generateBST(List<Integer> nodes, int left, int right, TreeNode balancedTree){
        if(left > right){
            return null;
        }
        
        int index = (left + right) / 2;
        balancedTree = new TreeNode(nodes.get(index));
        
        balancedTree.left = generateBST(nodes, left, index - 1, balancedTree);
        balancedTree.right = generateBST(nodes, index + 1, right, balancedTree);
        
        return balancedTree;
    }    
}