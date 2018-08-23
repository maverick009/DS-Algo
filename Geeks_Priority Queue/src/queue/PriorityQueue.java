package queue;

public class PriorityQueue 
{
	class Node
	{
		String job;
		int priority;
		
		public Node(String job,int priority)
		{
			this.job = job;
			this.priority = priority;
		}
	}
	
	private Node[] maxheap;
	private int size;
	private int position;
	
	public PriorityQueue(int size)
	{
		this.size = size;
		maxheap = new Node[size+1];
		position = 0;
		maxheap[0] = new Node(null, 0);
	}
	
	public void swap(int a,int b)
	{
		Node temp = maxheap[a];
		maxheap[a] = maxheap[b];
		maxheap[b] = temp;
	}
	
	public boolean max(int a,int b)
	{
		return ((maxheap[a].priority > maxheap[b].priority)?true:false);
	}
	
	public void display()
	{
		for(int i = 1;i < position;i++)
			System.out.println("Job:" + maxheap[i].job + "\tPriority:" + maxheap[i].priority);
	}
	
	public void offer(String job,int priority)
	{
		Node newnode = new Node(job, priority);
		if(position == 0)
		{
			maxheap[position + 1] = newnode;
			position = 2;
		}
		else
		{
			maxheap[position] = newnode;
			heapifyup(position);
			position++;
		}
	}	
	
	public void heapifyup(int index)
	{
		if(index > 1 && maxheap[index].priority > maxheap[index/2].priority)
		{
			swap(index, index/2);
			index /= 2;
			heapifyup(index);
		}
	}
	
	public void sinkdown(int index)
	{
		int largest = index;
		if((index*2 < position) && (index*2 +1 < position))
		{
			if(max(index*2, index*2+1))
			{
				if(maxheap[index*2].priority > maxheap[index].priority)
					largest = index * 2;
			}
			else
			{
				if(maxheap[index*2+1].priority > maxheap[index].priority)
					largest = index * 2 + 1;
			}
		}
		
		if(largest != index)
		{
			swap(largest, index);
			sinkdown(largest);
		}
	}
	
	public void poll()
	{
		Node temp = maxheap[1];
		maxheap[1] = maxheap[position - 1];
		maxheap[position - 1] = new Node(null, 0);
		position--;
		sinkdown(1);
		System.out.println("Job:" + temp.job + "\tpriority:" + temp.priority);
	}
	
	public void peek()
	{
		if(maxheap[1].priority != 0)
			System.out.println("Job:" + maxheap[1].job + "\tPriority:" + maxheap[1].priority);
	}
	
	public int getSize()
	{
		return position; 
	}
}
