/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode node = new ListNode();
        ListNode returnNode = node;
        
        int currentSum = 0;
        
        while(head != null){
            
            if(head.val == 0){
                if(currentSum != 0){
                    node.next = new ListNode(currentSum);
                    node = node.next;
                    currentSum = 0;
                }
            }else{
                currentSum += head.val;
            }
            
            head = head.next;
        }
       return returnNode.next; 
    }
}