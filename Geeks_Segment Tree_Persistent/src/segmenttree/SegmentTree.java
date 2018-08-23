package segmenttree;

public class SegmentTree 
{
	public class Node
	{
		public int data;
		public Node left,right;
		
		public Node(int data,Node left,Node right)
		{
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	public Node root;
	int []st;
	public Node []version;
	public SegmentTree(int []arr)
	{
		st = new int[arr.length];
		for(int i = 0;i < arr.length;i++)
			st[i] = arr[i];
		version = new Node[arr.length];
		for(int i = 0;i < arr.length;i++)
			version[i] = null;
		//constructUtil(arr, 0, arr.length - 1, 0);
	}
	
	public int mid(int start,int end)
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
		int mid = mid(start, end);
		st[index] = constructUtil(arr, start, mid, index * 2 + 1) + constructUtil(arr, mid + 1, end, index * 2 + 2);
		return st[index];
	}
	
	public void build(Node node,int low,int high)
	{
		if(low == high)
		{
			node.data = st[low];
			return;
		}
		int mid = mid(low, high);
		node.left = new Node(0,null,null);
		node.right = new Node(0,null,null);
		build(node.left, low, mid);
		build(node.right, mid + 1, high);
		node.data = node.left.data + node.right.data;
	}
	
	public void upgrade(Node prev,Node curr,int low,int high,int value,int index)
	{
		if(index > high || index < low || low > high)
			return;
		if(low == high)
		{
			curr.data = value;
			return;
		}
		int mid = mid(low, high);
		if(index <= mid)
		{
			curr.right = prev.right;
			curr.left = new Node(0,null,null);
			upgrade(prev.left, curr.left, low, mid, value, index);
		}
		else
		{
			curr.left = prev.left;
			curr.right = new Node(0,null,null);
			upgrade(prev.right, curr.right, mid + 1, high, value, index);
		}
		curr.data = curr.left.data + curr.right.data;
	}
	
	public int query(Node node,int low,int high,int l,int h)
	{
		if(l > high || h < low || low > high)
			return 0;
		if(l <= low && h >= high)
			return node.data;
		int mid = mid(low, high);
		int p1 = query(node.left, low, mid, l, h);
		int p2 = query(node.right, mid + 1, high, l, h);
		return p1 + p2;
	}
}
