package sort;

public class Sort 
{
	public void print(int []a)
	{
		for(int i = 0;i < a.length;i++)
			System.out.print(a[i] + " ");
	}
	
	public void swap(int []arr,int a,int b)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public int partition(int []a,int low,int high)
	{
		int pivot = a[high];
		int i = low - 1;
		for(int j = low;j <= high - 1;j++)
		{
			if(a[j] <= pivot)
			{
				i++;
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		
		int temp = a[i+1];
		a[i+1] = a[high];
		a[high] = temp;
		return (i+1);
	}
	
	public void quicksort(int []a,int low,int high)
	{
		if(low < high)
		{
			int pivot = partition(a, low, high);
			quicksort(a, low, pivot - 1);
			quicksort(a, pivot + 1, high);
		}
	}
}
