package sort;

public class Sort 
{
	public Sort()
	{
		
	}
	//Using Insertion Sort
	/*public void isort(int []a)
	{
		if(a.length == 0)
			return;
		for(int i = 1;i < a.length;i++)
		{
			int temp = a[i],j = i-1;
			while(j >= 0 && a[j] > temp)
			{
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = temp;			
		}
	}*/
	
	//Method 2:Using Heap
	private int []minheap;
	private int position;
	private int size;
	
	public Sort(int []a)
	{
		this.size = a.length + 1;
		minheap = new int[a.length + 1];
		minheap[0] = Integer.MIN_VALUE;
		position = 0;
	}
	
	public void display()
	{
		for(int i = 1;i < minheap.length;i++)
			System.out.print(minheap[i] + " ");
	}
	
	public void swap(int a,int b)
	{
		int temp = minheap[a];
		minheap[a] = minheap[b];
		minheap[b] = temp;
	}
	
	public boolean min(int a,int b)
	{
		return((a <= b)?true:false);
	}
	
	public void create(int []a)
	{
		if(a.length == 0)
			return;
		for(int i = 0;i < a.length;i++)
			insert(a[i]);
	}
	
	public void insert(int val)
	{
		if(position == 0)
		{
			minheap[position + 1] = val;
			position = 2;
		}
		else
		{
			minheap[position] = val;
			bubbleup(position);
			position++;
		}
	}
	
	public void bubbleup(int position)
	{
		int pos = position;//- 1;
		if(pos > 0 && minheap[pos] < minheap[pos/2])
		{
			swap(pos,pos/2);
			pos /= 2;
			bubbleup(pos);
		}
	}
	
	public void sinkDown(int index)
	{
		int smallest = index;
		
		if(index * 2 < position && index * 2 + 1 < position)
		{
			if(min(minheap[index*2], minheap[index*2+1]))
			{
				if(minheap[index*2] < minheap[index])
					smallest = index *2;
			}
			else
			{
				if(minheap[index*2+1] < minheap[index])
					smallest = index*2+1;
			}
		}
		if(smallest != index)
		{
			swap(index, smallest);
			sinkDown(smallest);
		}
	}
	
	public int getMin()
	{
		int min = minheap[1];
		minheap[1] = minheap[position - 1];
		minheap[position - 1] = 0;
		position--;
		sinkDown(1);
		return min;
	}
}
