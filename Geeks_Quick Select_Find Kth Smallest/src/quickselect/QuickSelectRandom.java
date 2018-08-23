package quickselect;

public class QuickSelectRandom 
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
		
		for(int j = low;j < high;j++)
		{
			if(arr[j] < p)
			{
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, i, high);
		return i;
	}
	
	public int randompartition(int []arr, int low, int high)
	{
		int n = high - low + 1;
		int random = (int) Math.random() % n;
		swap(arr, random + 1, high);
		return partition(arr, low, high);
	}
	
	public int kthsmallest(int []arr, int low, int high, int k)
	{
		if(low < high)
		{
			int p = randompartition(arr, low, high);
			
			if(p - low == k - 1)
				return arr[p];
			else if(p - low > k - 1)
				return kthsmallest(arr, low, p - 1, k);
			
			return kthsmallest(arr, p + 1, high, k + low - p - 1);
		}
		return Integer.MAX_VALUE;
	}

}
