package hackerRank.linkedlist;

import java.io.*;
import java.util.*;


public class InsertNodeAtSpecificPosition {

	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
			}

			this.tail = node;
		}
	}

	public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
		while (node != null) {
			bufferedWriter.write(String.valueOf(node.data));

			node = node.next;

			if (node != null) {
				bufferedWriter.write(sep);
			}
		}
	}

	class Result {

		/*
		 * Complete the 'insertNodeAtPosition' function below.
		 *
		 * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
		 * The function accepts following parameters:
		 *  1. INTEGER_SINGLY_LINKED_LIST llist
		 *  2. INTEGER data
		 *  3. INTEGER position
		 */

		/*
		 * For your reference:
		 *
		 * SinglyLinkedListNode {
		 *     int data;
		 *     SinglyLinkedListNode next;
		 * }
		 *
		 */

		public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
			
			// Write your code here
			SinglyLinkedListNode myNode = new SinglyLinkedListNode(data);
			SinglyLinkedListNode temp = llist;
			
			while(position>1) {
				temp = temp.next;
				position--;
			}
			SinglyLinkedListNode temp2 = temp.next;
			temp.next = myNode;
			myNode.next = temp2;
			
			return llist;
		}

	}
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		SinglyLinkedList llist = new SinglyLinkedList();

		int llistCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < llistCount; i++) {
			int llistItem = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			llist.insertNode(llistItem);
		}

		int data = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int position = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		SinglyLinkedListNode llist_head = Result.insertNodeAtPosition(llist.head, data, position);

		scanner.close();
	}
}

