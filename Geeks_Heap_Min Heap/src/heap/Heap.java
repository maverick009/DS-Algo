package heap;

public class Heap 
{
	int []minheap;
	int size,position;
	
	public Heap(int size)
	{
		position = 0;
		minheap = new int[size];
		this.size = size;
	}
	
	public void swap(int a,int b)
	{
		int temp = minheap[a];
		minheap[a] = minheap[b];
		minheap[b] = temp;
	}
	
	public void create(int []arr)
	{
		for(int i = 0;i < arr.length;i++)
			insert(arr[i]);
	}
	
	public void display()
	{
		for(int i = 0;i < minheap.length/2;i++)
			System.out.println("Parent:" + minheap[i] + "\tLeft Child:" + minheap[i * 2 +1] + "\tRight Child:" + minheap[i * 2 + 2]);
		System.out.println();
	}
	
	public void insert(int val)
	{
		minheap[position] = val;
		bubbleup(position);
		position++;
	}
	
	public void bubbleup(int index)
	{
		while(index >= 0 && (minheap[index] < minheap[index/2]))
		{
			swap(index,index/2);
			index /= 2;
		}
	}
	
	void heapify(int i)
	{
		int smallest = i;
		int left = i*2+1;
		int right = i*2+2;
		
		if(i < position && left < position && minheap[i] > minheap[left])
			smallest = left;
		
		if(i < position && right < position && minheap[i] > minheap[right])
			smallest = right;
		
		if(smallest != i)
		{
			swap(smallest, i);
			heapify(smallest);
		}
	}
	
	public void sinkdown(int index)
	{
		if(index > position)
			return;
		
		while((index*2+1 < position) && (index*2+2 < position))
		{
			if(minheap[index*2+1] < minheap[index*2+2] && minheap[index*2+1] < minheap[index])
			{
				swap(index, index*2+1);
				index = index * 2 + 1;
			}
			else if(minheap[index*2+2] < minheap[index])
			{	
				swap(index, index*2+2);
				index = index*2 + 2;
			}
		}
	}
	
	public int getMin()
	{
		int min = minheap[0];
		minheap[0] = minheap[position - 1];
		minheap[position - 1] = 0;
		position--;
		//heapify(0);
		sinkdown(0);
		return min;
	}
}