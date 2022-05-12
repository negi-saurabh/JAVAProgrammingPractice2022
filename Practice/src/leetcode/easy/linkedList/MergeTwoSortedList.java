package leetcode.easy.linkedList;

public class MergeTwoSortedList {
	
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		
		if(list1.val>list2.val) {
			
		}
		return list2;
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

