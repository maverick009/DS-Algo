package heap;

public class Heap 
{
	public boolean max(int []arr,int a,int b)
	{
		return((arr[a] >= arr[b])?true:false);
	}
	
	public void swap(int []arr,int a,int b)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public void heapify(int []a,int size,int index)
	{
		int largest = index;
		if((index * 2 + 1 < size) && (index * 2 + 2 < size))
		{
			if(max(a, index*2+1, index*2+2))
			{
				if(a[index*2+1] > a[index])
					largest = index * 2 + 1;
			}
			else
				if(a[index*2+2] > a[index])
					largest = index * 2 + 2;
		}
		if(largest != index)
		{
			swap(a, largest, index);
			heapify(a, size, index);
		}
	}
	
	public void heapSort(int []a)
	{
		if(a.length == 0)
			return;
		
		for(int i = (a.length - 1)/2;i >= 0;i--)
			heapify(a, a.length , i);
		
		for(int i = a.length -1;i >= 0;i--)
		{
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			
			heapify(a,i, 0);
		}
	}
}
