/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        // if(root == null){
        //     return null;
        // }
        // Queue<Node> treeQueue = new LinkedList<Node>();
        // treeQueue.add(root);
        // getBFS(root, treeQueue);
        getDFS(root);
        return root;
    }
    
    public void getDFS(Node root){
        if(root == null){
            return;
        }
        if(root.left != null){
            root.left.next = root.right;
        }
        if(root.next != null && root.next.left != null){
            root.right.next = root.next.left;
        }
        getDFS(root.left);
        getDFS(root.right);
    }
    
    public void getBFS(Node root, Queue<Node> treeQueue){
        while(!treeQueue.isEmpty()){
            int size = treeQueue.size();
            Node currentNode = treeQueue.poll();
            for(int currentSize = 0; currentSize < size; currentSize++){
                if(currentNode.left != null){
                    treeQueue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    treeQueue.add(currentNode.right);
                }                
                if(currentSize < size - 1){
                    currentNode.next = treeQueue.peek();
                    currentNode = treeQueue.poll();
                }               
                
            }
            
        }
    }
}