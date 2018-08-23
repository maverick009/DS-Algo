package bit;

public class BIT 
{
	int bit[][];
	
	public BIT(int [][]arr)
	{
		bit = new int[arr.length + 1][arr.length + 1];
		int [][]aux = new int[arr.length + 1][arr.length + 1];
		constructAUX(arr, aux);
		
		for(int i = 0;i < bit.length;i++)
			for(int j = 0;j < bit.length;j++)
				bit[i][j] = 0;
		
		for(int i = 1;i < bit.length;i++)
		{
			for(int j = 1;j < bit.length;j++)
			{
				int v1 = getSum(i, j);
				int v2 = getSum(i, j - 1);
				int v3 = getSum(i - 1, j - 1);
				int v4 = getSum(i - 1, j);
				update(i, j, aux[i][j] - (v1 - v2 - v4 + v3));
			}
		}
	}
	
	public void constructAUX(int [][]arr, int [][]aux)
	{
		for(int i = 0;i < aux.length;i++)
			for(int j = 0;j < aux.length;j++)
				aux[i][j] = 0;
		
		for(int i = 1;i < aux.length;i++)
			for(int j = 1;j < aux.length;j++)
				aux[i][j] = arr[arr.length - j][i - 1]; 
	}
	
	public void update(int x, int y, int val)
	{
		for(;x < bit.length;x += x & -x)
			for(;y < bit.length;y += y & -y)
				bit[x][y] += val;
	}
	
	public int getSum(int x, int y)
	{
		int sum = 0;
		for(;x > 0;x -= x & -x)
			for(;y > 0;y -= y & - y)
				sum += bit[x][y];
		return sum;
	}
	
	public int sum(int []query)
	{		
		int x1 = query[0] + 1;
		int y1 = query[1] + 1;
		int x2 = query[2] + 1;
		int y2 = query[3] + 1;
		return getSum(x2, y2) - getSum(x2, y1 - 1) - getSum(x1 - 1, y2) + getSum(x1 - 1, y1 - 1);	
	}
	
	public void display()
	{		
		for(int i = 1;i < bit.length;i++)
		{
			for(int j = 1;j < bit.length;j++)
				System.out.print(bit[i][j] + " ");
			System.out.println();
		}
	}
}
