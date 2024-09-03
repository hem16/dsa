package org.example.leetcode;

/*
    Check if the LL is cyclic
    Input: head = [3,2,0,-4], pos = 1
    Output: true
 */
   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

public class CyclicLinkedList {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast !=null && fast.next != null) {
            slow = head.next;
            fast = head.next.next;

            if (slow == fast) {
                return Boolean.TRUE;
            }

        }
        return Boolean.FALSE;

    }

    public static void main(String[] args) {
        CyclicLinkedList list = new CyclicLinkedList();
        ListNode linkedList = new ListNode(3);

    }
}
