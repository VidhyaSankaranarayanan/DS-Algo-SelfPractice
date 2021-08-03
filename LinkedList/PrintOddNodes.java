package week4day1;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class PrintOddNodes {
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
	public int countNodes(Node node) {
		int count = 0;
		while(node!=null) {
			node = node.next;
			count++;
		}
		return count;
	}
	
	public Node findUniqueNodes(Node node) {
		Node unique = new Node();
		Node current = unique;
		Set<Integer> set = new HashSet<Integer>();
		while(node!=null) {
			if(!set.contains(node.value)) {
				set.add(node.value);
				current.next = node;
				node=node.next;
				current = current.next;
			}
			else {
				node = node.next;
			}
		}
		return unique.next;
	}
	
	public Node printOddNodes(Node node, int length) {
		Node oddNodes = new Node();
		Node current = oddNodes;
		while(node!=null) {
			current.next = node;
			if(node.next!=null)
				node = node.next.next;
			else
				node = node.next;
			current = current.next;
		}
		if(length%2==0)
			current.next=null;
		return oddNodes.next;
		
	}
	
	public Node printOddNodesUsingRecursion(Node node) {
		
		if(node==null)
			return null;
		
		return	node.next = printOddNodesUsingRecursion(node.next.next);
		
		
	}
	
	public Node reverseNodes(Node node) {
		Node current = node, prev = null, next = null;
		while(current!=null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;			
		}
		return prev;
	}
	
	@Test
	 public void test() {
        Node head1 = addNode(3);
        head1.next = addNode(2);
        head1.next.next = addNode(3);
        head1.next.next.next = addNode(2);
        head1.next.next.next.next = addNode(5);
        head1.next.next.next.next.next = addNode(6);
        head1.next.next.next.next.next.next = addNode(7);
//        int length = countNodes(head1);
//        Node node = printOddNodes(head1, length);
//        Node reverseNode = reverseNodes(head1);
        Node node = findUniqueNodes(head1);
        printAllNodes(node);
//        printAllNodes(reverseNode);
	}
}
