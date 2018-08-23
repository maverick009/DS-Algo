package quickselect;

public class QuickSelect
{
	public void swap(int []arr, int a, int b)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public int partition(int []arr, int low, int high)
	{
		int p = arr[high];
		int i = low;
		for(int j = low;j < high - 1;j++)
		{
			if(arr[j] <= p)
			{
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, i, high);
		return i;
	}
	
	public int kthsmallest(int []arr, int low, int high, int k)
	{
		if(k > 0 && k <= high - low + 1)
		{			
			int partition = partition(arr, low, high);
			System.out.println("k:" + k + "\tpar:" + partition);
			if(partition - low == k - 1)
				return arr[partition];
			
			if(partition - low > k - 1)
				return kthsmallest(arr, low, partition  -1, k);
			else
				return kthsmallest(arr, partition + 1, high, k - partition + low - 1);
		}
		return Integer.MAX_VALUE;
	}
}
