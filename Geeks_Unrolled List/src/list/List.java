package list;

public class List 
{
	public class Node
	{
		public int size;
		public int []a;;
		public Node next;
		public Node(int size)
		{
			this.size = size;
			a = new int[size];
		}
	}
	
	public void print(Node head)
	{
		if(head == null)
			return;
		while(head != null)
		{
			for(int i = 0;i < head.size;i++)
				System.out.print(head.a[i] + " ");
			head = head.next;
		}
	}
}
