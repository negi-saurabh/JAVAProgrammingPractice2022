package leetcode.medium.linkedList;

import datastructures.ListNode;

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int number1 = 0;
		int number2 = 0;
		ListNode finalNode = new ListNode(0);
		ListNode pNode = new ListNode(0);
		pNode.next = finalNode;
		StringBuffer firstNum = new StringBuffer();
		StringBuffer secondNum = new StringBuffer();

		while(l1 != null) {
			firstNum.append(l1.val);
			l1 = l1.next;
		}
		while(l2 != null) {
			secondNum.append(l2.val);
			l2 = l2.next;
		}
		number1 = Integer.parseInt(firstNum.reverse().toString());
		number2 = Integer.parseInt(secondNum.reverse().toString());
		String num = Integer.toString(number1+number2);

		for (int i = num.length() - 1; i >= 0 ; i--) {
			finalNode.next = new ListNode(Integer.parseInt(Character.toString(num.charAt(i)))) ;
			finalNode = finalNode.next;
		}
		return pNode.next;
	}


	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		ListNode head2 = new ListNode(5);
		head2.next = new ListNode(6);
		head2.next.next = new ListNode(4);

		ListNode result = new AddTwoNumbers().addTwoNumbers(head, head2);
	}

}
