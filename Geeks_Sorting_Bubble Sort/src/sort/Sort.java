package sort;

public class Sort 
{
	public void print(int []a)
	{
		for(int i = 0;i < a.length;i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
	
	public void bubblesort(int []a)
	{
		if(a.length == 0)
			return;
		
		for(int i = 0;i < a.length;i++)
		{
			for(int j = 0;j < a.length - i - 1;j++)
			{
				if(a[j+1] <= a[j])
				{
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
			print(a);
		}
	}
	
}
