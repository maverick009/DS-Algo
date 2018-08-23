package heap;

public class Heap 
{
	int []minheap;
	int position, size;
	
	public void swap(int a, int b)
	{
		int temp = minheap[a];
		minheap[a] = minheap[b];
		minheap[b] = temp;
	}
	
	public boolean isLower(int a, int b)
	{
		return (minheap[a] <= minheap[b])?true:false;
	}
	
	public void bubbleUp(int index)
	{
		while((index > 0) && (minheap[index] <= minheap[index/2]))
		{
			swap(index, index/2);
			index /= 2;
		}
	}
	
	public void display()
	{
		for(int i = 0;i < minheap.length/2;i++)
		{
			if(i * 2 + 2 < minheap.length - 1)
				System.out.println("Parent:" + minheap[i] + "\tLeft Child:" + minheap[i * 2 + 1] + "\tRight Child:"
					+ minheap[i * 2 + 2]);
			else
				System.out.println("Parent:" + minheap[i] + "\tLeft Child:" + minheap[i * 2 + 1]);				
		}
	}	
	
	public void insert(int []arr)
	{
		if(arr.length == 0)
			return;
		
		for(int i = 0;i < arr.length;i++)
			create(arr[i]);
	}
	
	public void create(int val)
	{
		minheap[position] = val;
		position++;
		bubbleUp(position - 1);
	}
	
	public void sinkdown(int index)
	{
		int largest = index;
		if((index * 2 + 1 < position) && (index * 2 + 2 < position))
		{
			if(isLower(index * 2 + 2, index * 2+1))
			{
				if(isLower(index * 2 + 2, index))
					largest = index * 2 + 2;
			}
			else
			{
				if(isLower(index * 2 + 1, index))
					largest = index * 2 + 1;
			}
		}
		
		if(largest != index)
		{
			swap(largest, index);
			sinkdown(largest);
		}
	}
	
	public int getMin()
	{
		int min = minheap[0];
		minheap[0] = minheap[position - 1];
		minheap[position - 1] = 0;
		position--;
		sinkdown(0);
		return min;
	}
	
	public int replaceMin(int val)
	{
		int min = minheap[0];
		minheap[0] = val;
		sinkdown(0);
		return min;
	}
	
	public int [] sortK(int []arr, int k)
	{
		int []res = new int[arr.length];
		minheap = new int[k + 1];
		this.size = k + 1;
		this.position = 0;
		
		int index = 0, j = 0;
		for(int i = 0;i <= k;i++,index++)
			create(arr[i]);
		
		for(int i = index;i < arr.length;i++,j++)
			res[j] = replaceMin(arr[i]);
		
		for(int i = 0;i < index;i++,j++)
			res[j] = getMin();
		
		return res;
	}
}