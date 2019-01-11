package main;

class SLL {
	public class Node {
		int val;
		Node next;
		public Node(int val) {
			this.val = val;
		}
	}
	
	public Node head;
	
	public void display(Node head) {
		if(head == null)
			return;
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
	 
	public Node convert(Node head) {
		if(head == null || head.next == null || head.next.next == null)
			return head;
		
		Node prev = null, curr = head, next = head.next, res = null;
		boolean flag = true;
		
		while(curr != null && curr.next != null) {
			if((flag && curr.val > curr.next.val) || (!flag && curr.val < curr.next.val)) {
				if(res == null)
					res = curr.next;
				
				next = curr.next.next;
				if(prev != null)
					prev.next = curr.next;
				
				curr.next.next = curr;
				curr.next = next;
				
				if(prev != null)
					prev = prev.next;
				else
					prev = res;
			} else {
				if(res == null)
					res = curr;
				prev = curr;
				if(curr != null)
					curr = curr.next;
			}
			flag = !flag;
		}
		return res;
	}
}

public class Main {

	public static void main(String[] args) {
		SLL s = new SLL();
		s.head = s.new Node(11);
		s.head.next = s.new Node(15);
		s.head.next.next = s.new Node(20);
		s.head.next.next.next = s.new Node(5);
		s.head.next.next.next.next = s.new Node(10);
		
		s.display(s.head);
		s.head = s.convert(s.head);
		s.display(s.head);
	}
}