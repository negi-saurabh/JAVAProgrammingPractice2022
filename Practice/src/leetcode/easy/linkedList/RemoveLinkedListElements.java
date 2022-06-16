package leetcode.easy.linkedList;

import datastructures.ListNode;

public class RemoveLinkedListElements {

	public static ListNode removeElements(ListNode head, int val) {
		ListNode helper = new ListNode(0);
		helper.next = head ;
		ListNode p = helper;
		while(p.next != null) {
			if(p.next.val == val) {
				p.next = p.next.next;
			}else {
				p = p.next;
			}
		}
		return helper.next;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(20);
		head.next = new ListNode(20);
		head.next.next = new ListNode(5);
		head.next.next.next  = new ListNode(6);
		head.next.next.next.next  = new ListNode(10);
		head.next.next.next.next.next  = new ListNode(6);
		head.next.next.next.next.next.next  = new ListNode(20);
		head.next.next.next.next.next.next.next  = new ListNode(20);
		ListNode temp = removeElements(head, 20);
		printList(temp);
	}

	public static void printList(ListNode head) {
		while(head != null) {
			System.out.println("value:" +  head.val);
			head = head.next;
		}
	}
}
