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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        int count = 0;
        ListNode brokenList = new ListNode();
        ListNode temp = new ListNode();
        temp.next = list1;
        while(list1 != null){
            count++;
            
            if(count == a){
                brokenList.next = list1.next;
                brokenList = brokenList.next;
                list1.next = list2;
                break;
            }
            
            list1 = list1.next;
            
        }
        
        while(list1.next != null){
            list1 = list1.next;
        }
        
        
        while(brokenList != null){
            if(count == b){
                list1.next = brokenList.next;
                break;
            }
            brokenList = brokenList.next;
            count++;
        }
        
        return temp.next;
        
    }
}