package bit;

public class BIT 
{
	public int []bit;
	
	public BIT(int []arr)
	{
		bit = new int[arr.length + 1];
		bit[0] = Integer.MIN_VALUE;
		for(int i = 0;i < arr.length;i++)
			update(arr, i, arr[i]);
	}
	
	public void display(int []arr)
	{
		for(int i = 0;i < arr.length;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	public void update(int []arr, int index, int val)
	{	
		index += 1;
		while(index <= arr.length)
		{
			bit[index] += val;
			index += index & (-index);
		}
	}
	
	public int getSum(int []arr, int index)
	{
		index += 1;
		int sum = 0;
		while(index > 0)
		{
			sum += bit[index];
			index -= index &(-index);
		}
		return sum;
	}
	
	public void updateRange(int []arr, int index1, int index2, int val)
	{
		update(arr, index1, val);
		update(arr, index2 + 1, -val);
	}
}