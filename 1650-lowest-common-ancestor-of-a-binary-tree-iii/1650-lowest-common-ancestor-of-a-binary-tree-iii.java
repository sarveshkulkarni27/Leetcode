/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    Node ancestor;
    Set<Integer> commonAncestor = new HashSet<>();    
    public Node lowestCommonAncestor(Node p, Node q) {
        this.ancestor = p;
        getAncestor(p, q);
        return ancestor;
    }
    
    public void getAncestor(Node p, Node q){
        if(p != null && q != null){
            if(p.val == q.val){
                ancestor = p;
            }
            else if(!commonAncestor.contains(p.val) && !commonAncestor.contains(q.val)){
                commonAncestor.add(p.val);
                commonAncestor.add(q.val);
                getAncestor(p.parent, q.parent);
            }else if(commonAncestor.contains(p.val)){
                ancestor = p;
            }else{
                ancestor = q;
            }
        }else if(p != null){
            if(!commonAncestor.contains(p.val)){
                commonAncestor.add(p.val);
                getAncestor(p.parent, q);
            }else{
                ancestor = p;
            }            
        }else{
            if(!commonAncestor.contains(q.val)){
                commonAncestor.add(q.val);
                getAncestor(p, q.parent);
            }else{
                ancestor = q;
            }            
        }
    }
}