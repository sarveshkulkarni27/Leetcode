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
    public int pairSum(ListNode head) {
        List<Integer> twinList = new ArrayList<>();
        int maxTwinSum = 0;
        
        while(head != null){
            twinList.add(head.val);
            head = head.next;
        }
        
        // System.out.println(twinList.size());
        
        for(int index = 0; index < twinList.size() / 2; index++){
            // System.out.println(twinList.get(index) + " " + twinList.get(twinList.size() - index - 1));
            maxTwinSum = Math.max(maxTwinSum, twinList.get(index) + twinList.get(twinList.size() - index - 1));
        }
        return maxTwinSum;
    }
}