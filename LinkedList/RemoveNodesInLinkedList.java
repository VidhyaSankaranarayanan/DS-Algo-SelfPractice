/**
 * 
 */
package week6day2;

import org.junit.Test;

/**
 * @author Vidhya
 *
 */
public class RemoveNodesInLinkedList {

	/*
		 * Input: Linked list, Integer
		 * Output: Linked list
		 * Constraint: 
		 * Test Data:
		 * Positive: head = [1,2,6,3,4,5,6], val = 6
		 * Output: [1,2,3,4,5]
		 * Negative: head = [], val = 1
		 * Output: []
		 * Edge: [7,7,7,7], val = 7
		 * Output: []
		 * 
		 * Approach: Iterative
		 * 
		 * Time Complexity: O(n)
		 * Space Complexity: O(n)
		 */
	
	/*
	 * Pseudo code
	 * Create 2 nodes, one for iteration
	 * Traverse through the head node until it is not null
	 * 		Assign current node's next as head node
	 * 		If head node's value is given value
	 * 			If head node's next is not null
	 * 				current node's next is node's next
	 * 			else
	 *              current node's next is null
	 *      else
	 *      	current is current node's next
	 *      node equals to node's next
	 * Return updatedNode's next
	 */
	public class Node{
		int value;
		Node next;
		Node(int value){
			this.value = value;
			next = null;
		}
		Node(){
			next = null;
		}
	}
	public Node addNode(int key) {
		return new Node(key);
	}
	private Node removeNodes(Node node, int value) {
		Node updatedNode = new Node();
		Node current = updatedNode;
		while(node!=null) {
			current.next = node;
			if(node.value == value) {
				if(node.next!=null)
					current.next = node.next;
				else
					current.next = null;
			}
			else
				current = current.next;
			node = node.next;
		}
		return updatedNode.next;
	}
	
	private void printNodes(Node node) {
		while(node != null) {
			System.out.println(node.value);
			node = node.next;
		}
	}

	
	@Test
	public void test1() {
		Node head = addNode(1);
		head.next = addNode(2);
		head.next.next = addNode(6);
		head.next.next.next = addNode(3);
		head.next.next.next.next = addNode(4);
		head.next.next.next.next.next = addNode(5);
		head.next.next.next.next.next.next = addNode(6);
        int value = 6;
        Node node = removeNodes(head, value);
        printNodes(node);
	}
	
	@Test
	public void test2() {
		Node head = new Node();
		int value = 1;
        Node node = removeNodes(head.next, value);
        printNodes(node);
	}

	@Test
	public void test3() {
		Node head = addNode(7);
		head.next = addNode(7);
		head.next.next = addNode(7);
		head.next.next.next = addNode(7);
		int value = 7;
        Node node = removeNodes(head, value);
        printNodes(node);
	}
}
