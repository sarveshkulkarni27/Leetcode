class Solution {
    public int findTheWinner(int n, int k) {
        ListNode node = new ListNode(1);
        ListNode temp = node;
        
        ListNode prevNode = node;
        for(int index = 2; index <= n; index++){
            node.next = new ListNode(index);
            node = node.next;
            
            node.prev = prevNode;
            prevNode = node;
        }
        node.next = temp;
        node = node.next;
        node.prev = prevNode;
        // System.out.println(node.val);
        // int counter = 1;
        // while(counter < 8){
        //     System.out.println(node.val);
        //     node = node.next;
        //     counter++;
        // }
        // return 1;
        int currDiff = k;
        while(true){
            if(node.val == node.next.val){
                break;
            }
            
            while(currDiff-- != 1){
                node = node.next;
            }
            
            ListNode nextTemp = node.next;
            ListNode prevTemp = node.prev;
            
            node.prev.next = nextTemp;
            node.next.prev = prevTemp;
            
            node = node.next;
            
            currDiff = k;
        }
        return node.val;
    }
}

public class ListNode {
    int val;
    ListNode next;
    ListNode prev;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}