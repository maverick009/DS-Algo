package inversion_count;

public class BIT 
{
	int []bit;
	
	public BIT(int []arr)
	{
		bit = new int[arr.length];
		for(int i = 0;i < bit.length;i++)
			update(arr, i, arr[i]);
	}
	
	public void update(int []arr, int index, int val)
	{
		index = index + 1;
		
		while(index < arr.length)
		{
			bit[index] += val;
			index += index & (-index);
		}
	}
	
	public int getSum(int []arr, int index)
	{
		index = index + 1;
		int sum = 0;
		
		while(index > 0)
		{
			sum += bit[index];
			index -= index & (-index);
		}
		return sum;
	}
	
}
