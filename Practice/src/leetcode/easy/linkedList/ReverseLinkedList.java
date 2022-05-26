package leetcode.easy.linkedList;

public class ReverseLinkedList {

	public static ListNode reverseList(ListNode head) {


		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(20);

		head.next = new ListNode(20);
		head.next.next = new ListNode(5);
		head.next.next.next  = new ListNode(6);

		reverseList(head);
		printList(head);
	}
	
	
	private static void printList(ListNode head) {
		while(head != null) {
			System.out.println("value:" +  head.val);
			head = head.next;
		}

	}
}
