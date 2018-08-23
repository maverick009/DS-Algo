package bt;

import java.util.Map;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//BFS Solution O(n)
public class BT
{
	public class Node
	{
		public int data;
		public Node left,right;
		
		public Node(int data)
		{
			this.data = data;
		}
	}
	
	public class QItem
	{
		public int hd;
		public Node node;
		
		public QItem(Node node,int hd)
		{
			this.node = node;
			this.hd = hd;
		}
	}
	public Node root;
	
	public void varticalOrder(Node root)
	{
		if(root == null)
			return;
		Queue<QItem> queue = new LinkedList<>();
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		queue.offer(new QItem(root, 0));
		while(queue.size() != 0)
		{
			QItem q = queue.poll();
			Node node = q.node;
			int hd = q.hd;
			
			ArrayList<Integer> a = new ArrayList<>();
			a.add(node.data);
			if(map.containsKey(hd))
				a.addAll(0, map.get(hd));
			map.put(hd, a);			
			
			if(node.left != null)
				queue.offer(new QItem(node.left, hd - 1));
			if(node.right != null)
				queue.offer(new QItem(node.right, hd + 1));
		}
		
		for(Entry<Integer, ArrayList<Integer>> ht : map.entrySet())
		{
			System.out.print(ht.getKey() + ":");
			ht.getValue().forEach(System.out::print);
			System.out.println();
		}
	}
}

//Hash Table Solution

/*import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class BT 
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
	Map<Integer, ArrayList<Integer>> ht = new HashMap<>();
	
	public void inorder(Node root)
	{
		if(root == null)
			return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	
	public void preorder(Node root,int hd)
	{
		if(root == null)
			return;
		//One Key Multiple Values
		ArrayList<Integer> a = new ArrayList<>();
		a.add(root.data);
		if(ht.containsKey(hd))
			a.addAll(0,ht.get(hd));
		//other way round gives nullPointerException
		ht.put(hd, a);
		preorder(root.left, hd - 1);
		preorder(root.right, hd + 1);
	}
	
	public void verticalOrder(Node root)
	{
		if(root == null)
			return;
		preorder(root, 0);
		for(Map.Entry<Integer, ArrayList<Integer>> map : ht.entrySet())
		{
			System.out.print(map.getKey() + ":");
			map.getValue().forEach(System.out::print);
			System.out.println();
		}
	}	
}
*/



//O(n2) solution
/*public class BT 
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
	
	class Value
	{
		int min,max;
	}
	
	public Node root;
	Value val = new Value();
	
	public void inorder(Node root)
	{
		if(root == null)
			return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	
	public void findMinMax(Node root,Value min,Value max,int dist)
	{
		if(root == null)
			return;
		
		if(dist < min.min)
			min.min = dist;
		else if(dist > max.max)
			max.max = dist;
		
		findMinMax(root.left, min, max, dist - 1);
		findMinMax(root.right, min, max, dist + 1);
	}
	
	public void printLine(Node root,int line_no,int dist)
	{
		if(root == null)
			return;
		if(line_no == dist)
			System.out.print(root.data + " ");
		printLine(root.left, line_no, dist - 1);
		printLine(root.right, line_no, dist + 1);
	}
	
	public void verticalOrder(Node root)
	{
		if(root == null)
			return;
		findMinMax(root, val, val, 0);
		for(int line_no = val.min; line_no <= val.max;line_no++)
		{
			printLine(root, line_no, 0);
			System.out.println();
		}
	}
}
*/