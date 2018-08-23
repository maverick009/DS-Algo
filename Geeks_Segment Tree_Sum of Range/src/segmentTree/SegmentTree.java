package segmentTree;

public class SegmentTree 
{
	int []st;
	
	public SegmentTree(int []arr)
	{
		int height = (int)Math.ceil(Math.log10(arr.length)/Math.log10(2));
		int num = (int)(Math.pow(2, height+1) - 1);
		st = new int[num];
		constructUtil(arr, 0, arr.length - 1, 0);
	}
	
	public int getMid(int start, int end)
	{
		return start + (end - start)/2;
	}
	
	public int constructUtil(int []arr,int start,int end,int index)
	{
		if(start == end)
		{
			st[index] = arr[start];
			return st[index];
		}
		
		int mid = getMid(start, end);
		st[index] = constructUtil(arr, start, mid, index*2 + 1) + constructUtil(arr, mid + 1, end, index*2 + 2);
		return st[index];
	}
	
	public int getSum(int []arr,int qstart,int qend)
	{
		if(qstart < 0 || qend > arr.length - 1 || qstart > qend)
			return -1;
		
		return getSumUtil(0,arr.length - 1, qstart, qend, 0);
	}
	
	public int getSumUtil(int start,int end,int qstart,int qend,int index)
	{
		if(qstart > end || qend < start)
			return 0;
		if(qstart <= start && qend >= end)
			return st[index];
		
		int mid = getMid(start, end);
		return getSumUtil(start, mid, qstart, qend, index*2 + 1) + getSumUtil(mid+1, end, qstart, qend, index*2 + 2);
	}
	
	public void update(int []arr,int index,int new_val)
	{
		if(index < 0 || index > arr.length - 1)
			return;
		int diff = new_val - arr[index];
		arr[index] = new_val;
		updateUtil(0, arr.length - 1, index, diff, 0);
	}
	
	public void updateUtil(int start,int end,int index,int diff,int temp)
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
}
