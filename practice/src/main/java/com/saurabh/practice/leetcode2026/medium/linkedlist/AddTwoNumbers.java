package com.saurabh.practice.leetcode2026.medium.linkedlist;

import java.util.List;

public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int addition = val1 + val2 + carry;

            if (addition / 10 != 0)
                carry = 1;
            else
                carry = 0;

            builder.append(addition % 10);
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        int finalInteger = Integer.parseInt(builder.reverse().toString());
        if (finalInteger == 0){
            return new ListNode(0);
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (finalInteger != 0) {
            int quotient = finalInteger % 10;
            ListNode newNode = new ListNode(quotient);
            current.next = newNode;
            current = current.next;
            finalInteger = finalInteger / 10;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);


        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);


        new AddTwoNumbers().addTwoNumbers(node1, node2);
    }
}
