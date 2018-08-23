package main;

public class Main 
{
	public static void main(String[] args) 
	{
		int []a = {64,25,12,22,11};
		System.out.println("Original Array");
		for(int i = 0;i < a.length;i++)
			System.out.print(a[i] + " ");
		int low = 0,high = a.length -1;
		
		/*while(low <= high)
		{
			int min = low;
			for(int i = low +1;i<= high;i++)
			{
				if(a[i] < a[min])
					min = i;
			}
			
			int temp = a[min];
			a[min] = a[low];
			a[low] = temp;
			low++;
		}*/
		for(int i = 0;i < a.length;i++)
		{
			int min = i,j;
			for(j = i + 1;j < a.length;j++)
			{
				if(a[j] < a[min])
					min = j;
			}
			int temp = a[min];
			a[min] = a[i];
			a[i] = temp;
		}
		
		System.out.println("\nSorted Array");
		for(int i = 0;i < a.length;i++)
			System.out.print(a[i] + " ");

	}

}
