package assessment2;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class RemoveDuplicateNodesCondensedList {
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
	
	@Test
	 public void test() {
       Node head1 = addNode(3);
       head1.next = addNode(2);
       head1.next.next = addNode(3);
       head1.next.next.next = addNode(2);
       head1.next.next.next.next = addNode(5);
       head1.next.next.next.next.next = addNode(6);
       head1.next.next.next.next.next.next = addNode(7);
       Node node = findUniqueNodes(head1);
       printAllNodes(node);
	}
}
	