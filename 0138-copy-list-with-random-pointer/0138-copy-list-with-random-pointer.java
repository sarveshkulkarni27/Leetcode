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
        // Map<Node, Integer> randomCount = new HashMap<>();
        Node newNode = new Node(0);
        Node temp = newNode;
        int position = 0;
        while(head != null){
            randomTrack.put(head, head.random);
            // randomCount.put(head, position++);
            newNode.next = new Node(head.val);
            newNode = newNode.next;
            // System.out.println(head.val + " " + newNode.val);
            trackCopyNodes.put(head, newNode);
            head = head.next;
            // System.out.println(head.val + " " + newNode.val);
        }
        // System.out.println(randomTrack);
        // System.out.println(trackCopyNodes);
        // return temp.next;
        for(Node key : randomTrack.keySet()){
            Node currentNode = trackCopyNodes.get(key);
            // System.out.println(currentNode.val);
            // Node trackedNode = trackCopyNodes.get(randomTrack.get(head));
            // System.out.println(trackedNode);
            currentNode.random = trackCopyNodes.get(randomTrack.get(key));
        }
        
        return temp.next;
    }
}