package mergeSort;

public class MergeSort extends java.lang.Object 
{
	public MergeSort()
	{
		super();
	}
	
	protected static void mergeSort(int array[],int low,int high)
	{
		if(low < high)
		{
			int mid = low + (high - low)/2;
			mergeSort(array, low, mid);
			mergeSort(array, mid +1, high);
			merge(array, low, mid, high);
		}
	}
	
	protected static void merge(int array[], int low, int mid, int high)
	{
		int n1 = mid - low + 1;
		int n2 = high - mid;
		
		int l1[] = new int[n1];
		int l2[] = new int[n2];
		
		for(int i =0;i<n1;i++)
			l1[i] = array[low +i];
		
		for(int i =0; i<n2; i++)
			l2[i] = array[mid + i + 1];
		
		int i =0,j=0,k= low;
		
		while(i < n1 && j < n2)
		{
			if(l1[i] <= l2[j])
			{
				array[k] = l1[i];
				i++;
			}
			else
			{
				array[k] = l2[j];
				j++;
			}
			k++;
		}
		
		while(i < n1)
		{
			array[k] = l1[i];
			i++;
			k++;
		}
		
		while(j < n2)
		{
			array[k] = l2[j];
			j++;
			k++;
		}
	}
	
	protected static void print(int []array)
	{
		for(int i = 0;i<array.length;i++)
		{
			System.out.println("data:" + array[i]);
		}
	}
}
