package sort;

public class InsertionSort 
{
	public void sort(int []a)
	{
		if(a.length == 0)
			return;
		
		for(int i = 0;i < a.length;i++)
		{
			int temp = a[i];
			int j = i - 1;
			//int loc = binarySearch(a, 0, i-1, a[i]);
			while(j >= 0 && a[j] > a[i])
			{
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = temp;
		}
	}
	
	public int binarySearch(int []a,int low,int high,int val)
	{
		while(low <= high)
		{
			int mid = low + (high - low)/2;
			if(val == a[mid])
				return mid;
			else if(val > a[mid])
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}
}
