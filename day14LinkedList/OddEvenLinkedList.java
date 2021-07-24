package week4day1;

import org.junit.Test;

import week4day1.PrintOddNodes.Node;

public class OddEvenLinkedList {
	public class Node{
			int value;
			Node next;
			Node(int value){
				this.value = value;
				next = null;
			}
			
			Node(){
				//this.value = value;
				next = null;
			}
		}
		public Node addNode(int key) {
			return new Node(key);
		}
		public void printAllNodes(Node node) {
			while(node != null) {
				System.out.println(node.value);
				node = node.next;
			}
		}
		
		public Node oddNodes(Node node) {
			Node oddNodes = new Node();
			Node evenNodes = new Node();
			Node odd = oddNodes, even = evenNodes;
			while(node!=null) {
				odd.next = node;
				even.next = node.next;
				if(node.next!=null)
					node = node.next.next;
				else
					node = node.next;
				odd = odd.next;
				even = even.next;
			}
			odd.next = evenNodes.next;
			return oddNodes.next;
		}
		
		public Node evenNodes(Node node) {
			Node evenNodes = new Node();
			Node current = evenNodes;
			while(node!=null) {
				current.next = node.next;
				if(node.next!=null)
					node = node.next.next;
				else
					node = node.next;
				current = current.next;
			}
			return evenNodes.next;
		}
		
		@Test
		 public void test() {
	        Node head = addNode(1);
	        head.next = addNode(2);
	        head.next.next = addNode(3);
	        head.next.next.next = addNode(4);
	        head.next.next.next.next = addNode(5);
	        head.next.next.next.next.next = addNode(6);
	        head.next.next.next.next.next.next = addNode(7);
	        Node oddEvenNode = oddNodes(head);
//	        Node evenNode = evenNodes(head);
//	        oddNode.next = evenNode;
	        printAllNodes(oddEvenNode);
	    }
	
}
