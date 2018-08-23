//Solve for Arrays of Different Sizes
package main;

class Median
{
	public void print(int []arr)
	{
		for(int i = 0;i < arr.length;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	//Naive Method
	public int getMedian(int []arr1, int []arr2)
	{
		int i = 0, j = 0, m1 = -1, m2 = -1;
		for(int x = 0;x <= arr1.length;x++)
		{
			if(i == arr1.length)
			{
				m1 = m2;
				m2 = arr2[0];
				break;
			}
			
			else if(j == arr1.length)
			{
				m1 = m2;
				m2 = arr1[0];
				break;
			}
			
			else if(arr1[i] < arr2[j])
			{
				m1 = m2;
				m2 = arr1[i];
				i++;
			}
			else
			{
				m1 = m2;
				m2 = arr2[j];
				j++;
			}	
		}
		return (m1 + m2)/2;
	}
	//O(n) Solution	
	public float getmedian(int []arr, int s, int e)
	{
		int len = e - s + 1;
		//System.out.println("median" + "\ts:" + s + "\te:" + e + "\tlen:" + len);
		if((e - s + 1) % 2 == 0)
			return (arr[s + len/2] + arr[s + len/2 +1]) / 2;
		else
			return arr[s + len/2];
	}
	
	public float median(int []arr1, int []arr2)
	{
		return medianUtil(arr1, 0, arr1.length - 1, arr2, 0, arr2.length - 1);
	}
	
	public float medianUtil(int []arr1, int s1, int e1, int []arr2, int s2, int e2)
	{
		//System.out.println("s1:" + s1 + "\te1:" + e1 + "\ts2:" + s2 + "\te2:" + e2);
		int len = e1 - s1 + 1;
		if(len <= 0)
			return -1;
		if(len == 1)
			return (arr1[s1] + arr2[s2]) / 2;
		if(len == 2)
			return (Math.max(arr1[s1], arr2[s2]) + Math.min(arr1[e1], arr2[e2])) / 2;
		
		float m1 = getmedian(arr1, s1, e1);
		float m2 = getmedian(arr2, s2, e2);
		//System.out.println("m1:" + m1 + "\tm2:" + m2);
		if(m1 == m2)
			return m1;
		
		else if(m1 < m2)
		{
			if(len % 2 == 0)
				return medianUtil(arr1, s1 + len/2, e1, arr2, s2, s2 + len/2);
			return medianUtil(arr1, s1 + len/2, e1, arr2, s2, s2 + len/2);
		}
		else
		{
			if(len % 2 == 0)
				return medianUtil(arr1, s1, s1 + len/2, arr2, s2 + len/2, e2);
			return medianUtil(arr1, s1, s1 + len/2, arr2, s2 + len/2, e2);
		}
	}
}

public class Main 
{	
	public static void main(String[] args) 
	{
		int arr1[] = {1, 12, 15, 26, 38};
        int arr2[] = {2, 13, 17, 30, 45};
        //System.out.println("median:" + new Median().getMedian(arr1, arr2));
        System.out.println("Median:" + new Median().median(arr1, arr2));
	}
}
