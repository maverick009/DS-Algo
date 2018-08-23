package bt;

/*import java.util.Map;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
*/
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

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
	
	public class QItem
	{
		Node node;
		int hd;
		
		public QItem(Node node,int hd)
		{
			this.node = node;
			this.hd = hd;
		}
	}
	
	public Node root = null;
	
	public void topView(Node root)
	{
		if(root == null)
			return;
		
		HashSet<Integer> set = new HashSet<>();
		Queue<QItem> queue = new LinkedList<>();
		queue.offer(new QItem(root, 0));
		
		while(queue.size() != 0)
		{
			QItem q = queue.poll();
			Node node = q.node;
			int hd = q.hd;
			
			if(!set.contains(hd))
			{
				set.add(hd);
				System.out.print(node.data + " ");
			}
			if(node.left != null)
				queue.offer(new QItem(node.left, hd - 1));
			if(node.right != null)
				queue.offer(new QItem(node.right, hd + 1));
		}
	}
}


//Hash Table preorder order different
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
	public Node root;
	Map<Integer, ArrayList<Integer>> map = new HashMap<>();
	public void inorder(Node root,int hd)
	{
		if(root == null)
			return;
		
		ArrayList<Integer> a = new ArrayList<>();
		a.add(root.data);
		if(map.containsKey(hd))
		{
			ArrayList<Integer> a1 = map.get(hd);
			a.addAll(0,a1);
		}
		map.put(hd, a);
		inorder(root.left,hd - 1);
		inorder(root.right, hd + 1);
	}

	public void topView(Node root)
	{
		if(root == null)
			return;
		inorder(root, 0);
		for(Map.Entry<Integer, ArrayList<Integer>> ht : map.entrySet())
		{
			System.out.print(ht.getKey() + ":");
			System.out.print(ht.getValue().get(0));
			System.out.println();
		}
	}
}*/