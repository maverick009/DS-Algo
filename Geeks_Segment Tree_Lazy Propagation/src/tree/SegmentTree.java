package tree;

public class SegmentTree 
{
	int []st;
	int []lazy;
	
	public int mid(int start,int end)
	{
		return start + (end - start)/2;
	}
	
	public SegmentTree(int []arr)
	{
		int h = (int)Math.ceil(Math.log10(arr.length)/Math.log10(2));
		int size = (int)Math.pow(2, h+1) - 1;
		st = new int[size];
		lazy = new int[size];
		constructUtil(arr, 0, arr.length - 1, 0);
	}
	
	public int constructUtil(int []arr,int start,int end,int index)
	{
		if(start < 0 || end > arr.length - 1)
			return -1;
		if(start == end)
		{
			st[index] = arr[start];
			return st[index];
		}
		int mid = mid(start, end);
		st[index] = constructUtil(arr, start, mid, index * 2 + 1) + constructUtil(arr, mid + 1, end, index * 2 + 2);
		return st[index];
	}
	
	public int getSum(int []arr,int qstart,int qend)
	{
		if(qstart < 0 || qend > arr.length - 1)
			return -1;
		return sumUtil(0, arr.length - 1, qstart, qend, 0);
	}
	
	public int sumUtil(int start,int end,int qstart,int qend,int index)
	{
		if(lazy[index]!= 0)
		{
			st[index] += (end - start + 1)*lazy[index];
			if(start != end)
			{
				lazy[index*2+1] += lazy[index];
				lazy[index*2+2] += lazy[index];
			}
			lazy[index] = 0;
		}
		if(start > end || start > qend || qstart > end)
			return 0;
		if(qstart <= start && qend >= end)
			return st[index];
		int mid = mid(start, end);
		return sumUtil(start, mid, qstart, qend, index * 2 + 1) + sumUtil(mid + 1, end, qstart, qend, index * 2 + 2);
	}
	
	public void update(int []arr,int index,int new_value)
	{
		if(index < 0 || index > arr.length - 1)
			return;
		int diff = new_value - arr[index];
		arr[index] = new_value;
		updateUtil(0, arr.length - 1, index, diff, 0);
	}
	
	public void updateUtil(int start,int end,int index,int diff,int temp)
	{
		if(index < start || index > end)
			return;
			st[temp] += diff;
		if(start != end)
		{
			int mid = mid(start, end);
			updateUtil(start, mid, index, diff, temp * 2 + 1);
			updateUtil(mid + 1, end, index, diff, temp * 2 + 2);
		}
	}
	//Lazy Propagation
	public void updateRange(int []arr,int qstart,int qend,int new_value)
	{
		if(qstart < 0 || qend > arr.length - 1)
			return;
		updateRangeUtil(0, arr.length -1, qstart, qend, new_value, 0);
	}
	
	public void updateRangeUtil(int start,int end,int qstart,int qend,int diff,int index)
	{
		if(lazy[index] != 0)
		{
			st[index] += (end - start + 1) * lazy[index];
			
			if(start != end)
			{
				lazy[index * 2 + 1] += lazy[index]; 
				lazy[index * 2 + 2] += lazy[index]; 
			}
			lazy[index] = 0;
		}

		if(qstart > end || qend < start || start > end)
			return;
		
		if(qstart <= start && qend >= end)
		{
			st[index] += (end - start + 1) * diff;
			if(start != end)
			{
				lazy[index * 2 + 1] += diff; 
				lazy[index * 2 + 2] += diff;
			}
			return;
		}
		int mid = mid(start, end);
		updateRangeUtil(start, mid, qstart, qend, diff, index * 2 + 1);
		updateRangeUtil(mid + 1, end, qstart, qend, diff, index * 2 + 2);
		st[index] = st[index * 2 + 1] + st[index * 2 + 2];
	}
}
