package dnf;

import java.util.Random;

public class DNF 
{
	public void swap(int []a,int x,int y)
	{
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	public void print(int []a)
	{
		for(int i = 0;i < a.length;i++)
			System.out.print(a[i] + " ");
	}
	
	public void sort012(int []a)
	{
		int low = 0,high = a.length - 1,mid = 0;
		while(mid <= high)
		{
			switch(a[mid])
			{
				case 0:	
						swap(a,low,mid);
						low++;
						mid++;
						break;
				case 1:
						mid++;
						break;
				case 2:
						swap(a,mid,high);
						//mid++;
						high--;
						break;
			}
		}
	}
	
	public void shuffleArray(int []a)
	{
		Random r = new Random();
		for(int i = a.length - 1;i > 0;i--)
		{
			int index = r.nextInt(i+1);
			swap(a, i, index);
		}
	}
	
	public void partition(int []a,int low,int high)
	{
		if(high <= low)
			return;
		
		int l = low,h = high,pivot = a[low],i = low + 1;
		while(i <= h)
		{
			if(a[i] < pivot)
				swap(a, i++,l++);
			else if(a[i] == pivot)
				i++;
			else
				swap(a,i,h--);
		}
		partition(a, low, l - 1);
		partition(a, h + 1, high);
	}
	
	public void quicksort(int []a)
	{
		//shuffleArray(a);
		partition(a, 0,a.length - 1);
	}
}
