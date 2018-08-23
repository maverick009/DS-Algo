package inversion_count;

public class MergeSort 
{
	public int mergesort(int []arr, int low, int high)
	{
		int count = 0;
		if(low < high)
		{
			int mid = low + (high - low)/2;
			count = mergesort(arr, low, mid);
			count += mergesort(arr, mid + 1, high);
			count += merge(arr, low, mid, high);
		}
		return count;
	}
	
	public int merge(int []arr, int low, int mid, int high)
	{
		int count = 0;
		int s1 = mid - low + 1;
		int s2 = high - mid;
		
		int []a1 = new int[s1];
		int []a2 = new int[s2];
		
		for(int i =0;i < s1;i++)
			a1[i] = arr[low + i];
		
		for(int i = 0;i < s2;i++)
			a2[i] = arr[mid + i + 1];
		
		int k = low,i = 0,j = 0;
		while(i < s1 && j < s2)
		{
			if(a1[i] <= a2[j])
				arr[k++] = a1[i++];
			else
			{
				count += mid - i + 1 - low;
				arr[k++] = a2[j++];
			}
		}
		
		while(i < s1)
			arr[k++] = a1[i++];
		
		while(j < s2)
			arr[k++] = a2[j++];
		
		return count;
	}
}