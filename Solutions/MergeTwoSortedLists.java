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
    
//     approach 1: merge sort - DP
    
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
//         if(list1 == null && list2 == null) return null;
        
//         int i = 0, j = 0, k = 0;
//         ListNode res = new ListNode();
//         ListNode temp = res;
        
//         while(list1 != null && list2 != null) {
//             if(list1.val > list2.val) {
//                 temp.val = list2.val;
//                 temp.next = new ListNode();
//                 list2 = list2.next;
//             } else {
//                 temp.val = list1.val;
//                 temp.next = new ListNode();
//                 list1 = list1.next;
//             }
//             temp = temp.next;
//         }
        
//         if(list1 != null) {
//             temp.val = list1.val;
//             temp.next = list1.next;
//         }
        
//         if(list2 != null) {
//             temp.val = list2.val;
//             temp.next = list2.next;
//         }
        
//         return res;
//     }
    
//     approach 2: merge sort - recursion
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1 == null && list2 == null) return null;
        
        ListNode head = new ListNode();
        if(list1.val > list2.val) {
            head = list2;
            list2 = list2.next;
        } else {
            head = list1;
            list1 = list1.next;
        }
        
        head.next = mergeTwoLists(list1, list2);
        
        return head;
    }
    
}
