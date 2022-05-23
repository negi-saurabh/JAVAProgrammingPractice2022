package leetcode.easy.linkedList;

public class MergeTwoSortedList {

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if(list1 == null)
			return list2;
		if(list2 == null)
			return list1;

		ListNode newNode  = new ListNode();
		ListNode result  = newNode;
		
		while(list1 != null && list2 != null) {
			if(list1.val < list2.val) {
				newNode.next = list1;
				list1 = list1.next;
			}else {
				newNode.next = list2;
				list2 = list2.next;
			}
			newNode = newNode.next;
		}

		while(list1 != null) {
			newNode.next = list1;
			list1 = list1.next;
			newNode = newNode.next;
		}
		while(list2 != null) {
			newNode.next = list2;
			list2 = list2.next;
			newNode = newNode.next;
		}
		return result.next;
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		node1.next = new ListNode(2);
		node1.next.next = new ListNode(3);
		
		ListNode node2 = new ListNode(1);
		node2.next = new ListNode(3);
		node2.next.next = new ListNode(4);
		
		mergeTwoLists(node1, node2);
	}
}

class ListNode { 
	int val; 
	ListNode next; 
	ListNode() {} 
	ListNode(int val) { 
		this.val = val; 
	} 
	ListNode(int val, ListNode next) {
		this.val = val; this.next = next; 
	} 
}

