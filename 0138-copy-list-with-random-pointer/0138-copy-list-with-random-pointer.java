/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> trackCopyNodes = new HashMap<>();
        Map<Node, Node> randomTrack = new HashMap<>();
        Node newNode = new Node(0);
        Node temp = newNode;
        while(head != null){
            randomTrack.put(head, head.random);
            newNode.next = new Node(head.val);
            newNode = newNode.next;
            trackCopyNodes.put(head, newNode);
            head = head.next;
        }

        for(Node key : randomTrack.keySet()){
            Node currentNode = trackCopyNodes.get(key);
            currentNode.random = trackCopyNodes.get(randomTrack.get(key));
        }
        
        return temp.next;
    }
}