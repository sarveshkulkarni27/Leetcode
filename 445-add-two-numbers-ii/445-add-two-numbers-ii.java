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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> list1 = new Stack<Integer>();
        Stack<Integer> list2 = new Stack<Integer>();
        while(l1 != null || l2 != null){
            if(l1 != null){
                list1.push(l1.val);
                l1 = l1.next;
            }
            if(l2 != null){
                list2.push(l2.val);
                l2 = l2.next;
            }            
        }

        int carry = 0;
        ListNode temp = new ListNode();
        while(!list1.isEmpty() || !list2.isEmpty()){
            int val1 = 0;
            int val2 = 0;
            if(!list1.isEmpty()){
                val1 = list1.pop();
            }
            if(!list2.isEmpty()){
                val2 = list2.pop();
            } 
            int total = val1 + val2 + carry;
            if(total >= 10){
                total %= 10;
                carry = 1;
            }else{
                carry = 0;
            }
            ListNode currentNode = new ListNode(total);
            ListNode temp1 = temp.next;
            temp.next = currentNode;
            temp.next.next = temp1;
        }
        if(carry == 1){
            ListNode currentNode = new ListNode(carry);
            ListNode temp1 = temp.next;
            temp.next = currentNode;
            temp.next.next = temp1;            
        }
        return temp.next;
    }
}