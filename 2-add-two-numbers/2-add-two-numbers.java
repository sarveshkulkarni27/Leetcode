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
    int carry = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode finalList = new ListNode();
        ListNode temp = finalList;
        
        
        while(l1 != null && l2 != null){
            int answer = l1.val + l2.val + carry;
            finalList = getNext(finalList, answer);
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null){
            int answer = l1.val + carry;
            finalList = getNext(finalList, answer);       
            l1 = l1.next;
        }
        
        while(l2 != null){
            int answer = l2.val + carry;
            finalList = getNext(finalList, answer); 
            l2 = l2.next;
        }
        
        if(carry == 1){
            finalList.next = new ListNode(carry);
        }
        
        return temp.next;
    }
    
    public ListNode getNext(ListNode finalList, int answer){
        if(answer >= 10){
            carry = 1;
            answer -= 10;
        }else{
            carry = 0;
        }
        finalList.next = new ListNode(answer);
        finalList = finalList.next;
        return finalList;
    }
}