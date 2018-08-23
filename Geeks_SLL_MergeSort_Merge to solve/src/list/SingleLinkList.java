package list;

public class SingleLinkList
{
	class Node
	{
		int data;
		Node next;
		
		public Node(int data)
		{
			this.data = data;
			next = null;
		}
	}
	
	public Node head;
	
	public void insert(int data)
	{
		Node newnode = new Node(data);
		newnode.next = head;
		head = newnode;
	}
	
	public void print()
	{
		//System.out.println("inside print");
		if(head == null)
			return;
		
		Node temp = head;
		
		while(temp != null)
		{
			System.out.println("element:" + temp.data);
			temp = temp.next;
		}
	}
	
	public int length(Node head)
	{
		if(head == null)
			return 0;
		
		int count = 0;
		
		Node temp = head;
		
		while(temp != null)
		{
			count++;
			temp = temp.next;
		}
		
		return count;
	}
	
	public Node MergeList(Node a, Node b) 
	{
		Node result = null;
		
		if (a == null)
			return b;
		
		if (b == null)
			return a;
		
		if (a.data > b.data) 
		{
			result = b;
			result.next = MergeList(a, b.next);
		} 
		else 
		{
			result = a;
			result.next = MergeList(a.next, b);
		}
		
		return result;
	}
	
	
	public int getLength(Node a) 
	{
		int count = 0;
		Node h = a;
		
		while (h != null) 
		{
			count++;
			h = h.next;
		}
		return count;
	}
	
	public Node mergeSort(Node a) 
	{
		Node oldHead = a;
		// find the length of the linkedlist
		int mid = getLength(a) / 2;
		
		if (a.next == null)
			return a;
		// set one pointer to the beginning of the list and another at the next
		// element after mid
		while (mid - 1 > 0) 
		{
			oldHead = oldHead.next;
			mid--;
		}
		
		Node newHead = oldHead.next;// make newHead points to the beginning of
		// the second half of the list
		oldHead.next = null;// break the list
		oldHead = a;// make one pointer points at the beginning of the first
		// half of the list
		Node t1 = mergeSort(oldHead);//make recursive calls
		Node t2 = mergeSort(newHead);
		return MergeList(t1, t2); // merge the sorted lists
	}
	
	
	
	/*public Node mergeSort(Node head)
	{
		if(head == null)
			return null;
		
		if(head.next == null)
			return head;
		
		System.out.println("length:" + length(head));
		int mid = (length(head) -1)/2;
		System.out.println("mid:" + mid);
		Node temp1 = head,temp2 = null;
		
		int i =0;
		while(i < mid)
		{
			temp1 = temp1.next;
			i++;
		}
		
		temp2 = temp1.next;
		
		temp1.next = null;
		temp1 = head;
		
		Node t1 = mergeSort(temp1);
		Node t2 = mergeSort(temp2);
		
		return merge(t1, t2);
	}
	//Node res = null;
	
	public Node merge(Node node1, Node node2)
	{
		Node res = null;
		
		if(node1 == null)
			return node2;
		
		if(node2 == null)
			return node1;
		
		if(node1.data <= node2.data)
		{
			res = node1;
			res.next = merge(node1.next, node2);
		}
		else
		{
			System.out.println("node.data:" + node2.data);
			res = node2;
			res.next = merge(node1, node2.next);
		}
		
		return res;
	}*/
}