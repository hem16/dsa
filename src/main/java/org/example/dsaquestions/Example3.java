package org.example.dsaquestions;

/*
    merge-two-sorted-lists and return the head of newly linked list
    Input: a: 5->10->15, b: 2->3->20
    Output: 2->3->5->10->15->20

    Input: a: 1->1, b: 2->4
    Output: 1->1->2->4
*/

import java.util.*;

/* Definition for singly-linked list. */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Example3 {
    ListNode head;
    ListNode tail;
    int length = 0;

    Example3(int val){
        ListNode node = new ListNode(val);
        head = node;
        tail = node;
        length++;
    }

    Example3(){

    }

    public ListNode append(int val){
        ListNode node = new ListNode(val);
        if(length ==0){
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        length++;
        return node;
    }

    public void printList(){
        System.out.println("Print LinkedList..");
        ListNode temp = head;
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
    public void mergeTwoLists(Example3 ll1, Example3 ll2) {
        ArrayList list = new ArrayList();
        ListNode tmp1 = ll1.head;
        while(tmp1 != null) {
            list.add(tmp1.val);
            tmp1 = tmp1.next;
        }
        ListNode tmp2 = ll2.head;
        while(tmp2 != null) {
            list.add(tmp2.val);
            tmp2 = tmp2.next;
        }
        Collections.sort(list);
        //Create a Linked list from this
        for (int i=0; i< list.size();i++) {
            append((Integer) list.get(i));
        }
        printList();
        System.out.println("head "+head.val);
        System.out.println("tail "+tail.val);
    }

    public static void main(String[] args) {
        //Append List - 1
        Example3 list1 = new Example3();
        list1.append(5);
        list1.append(10);
        list1.append(15);
        //Append List - 2
        Example3 list2 = new Example3();
        list2.append(2);
        list2.append(3);
        list2.append(20);

        //print list
        list1.printList();
        list2.printList();

        //Merge 2 List and print
        Example3 merge= new Example3();
        merge.mergeTwoLists(list1,list2);
    }
}

