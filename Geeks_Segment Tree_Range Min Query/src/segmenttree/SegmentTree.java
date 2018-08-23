/*Any Connection between arr[i] and st[index]
 * How can we find index from given i?
 */
package segmenttree; 

public class SegmentTree 
{
	public class Node
	{
		public int data;
		public Node left,right;
		
		public Node(int data)
		{
			this.data = data;
			left = right = null;
		}
	}
	
	public Node root;
	
	int []st;
	public SegmentTree(int []arr)
	{
		int h = (int)Math.ceil(Math.log10(arr.length)/Math.log10(2));
		int size = (int)Math.pow(2, h+1) - 1;
		st = new int[size];
		constructUtil(arr, 0, arr.length - 1, 0);
	}
	
	public int getMid(int start,int end)
	{
		return start + (end - start)/2;
	}
	
	public int min(int a,int b)
	{
		return (a <= b? a:b);
	}
	
	public int constructUtil(int []arr,int start,int end,int index)
	{
		if(start == end)
		{
			st[index] = arr[start];
			return st[index];
		}
		
		int mid = getMid(start, end);
		st[index] = constructUtil(arr, start, mid, index * 2 + 1) + constructUtil(arr, mid + 1, end, index * 2 + 2);
		return st[index];
	}
	
	public int getSum(int []arr,int qstart,int qend)
	{
		if(qstart < 0 || qend > arr.length - 1)
			return -1;
		return getSumUtil(0, arr.length - 1, qstart, qend, 0);
	}
	
	public int getSumUtil(int start,int end,int qstart,int qend,int index)
	{
		if(qstart > end || qend < start || qstart > qend)
			return 0;
		if(qstart <= start && qend >= end)
			return st[index];
		int mid = getMid(start, end);
		return getSumUtil(start, mid, qstart, qend, index * 2 + 1) + getSumUtil(mid + 1, end, qstart, qend, index * 2 + 2);
	}
	
	public void update(int []arr,int index,int new_value)
	{
		if(index < 0 || index > arr.length - 1)
			return;
		
		int diff = new_value - arr[index];
		arr[index] = new_value;
		updateUtil(0, arr.length - 1, index, diff, 0);
	}
	
	public void updateUtil(int start, int end,int index,int diff,int temp)
	{
		if(index < start || index > end)
			return;
		st[temp] = st[temp] + diff; 
		if(start != end)
		{
			int mid = getMid(start, end);
			updateUtil(start, mid, index, diff, temp * 2 + 1);
			updateUtil(mid + 1, end, index, diff, temp * 2 + 2);
		}
	}
	
	public int findMin(int []arr,int qstart,int qend)
	{
		if(qstart < 0 || qend > arr.length - 1 || qstart > qend)
			return -1;		
		return findMinUtil(0, arr.length - 1, qstart, qend, 0);
	}
	
	public int findMinUtil(int start,int end,int qstart,int qend,int index)
	{
		if(qstart <= start && qend >= end)
			return st[index];
		if(qstart > end || qend < start)
			return Integer.MAX_VALUE;		
		int mid = getMid(start, end);
		return min(findMinUtil(start, mid, qstart, qend, index * 2 + 1), findMinUtil(mid + 1, end, qstart, qend, index * 2 + 2));
	}
	
	public void display()
	{
		for(int i = 0;i < st.length;i++)
			System.out.print(st[i] + " ");
	}
}
