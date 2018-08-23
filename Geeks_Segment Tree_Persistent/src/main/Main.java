package main;

import segmenttree.SegmentTree;

public class Main 
{
	public static void main(String[] args) 
	{
		int []arr = {1,2,3,4,5};
		SegmentTree st = new SegmentTree(arr);
		
		//Version 0
		st.root = st.new Node(0,null,null);
		st.build(st.root, 0, arr.length - 1);
		st.version[0] = st.root;
		//Version 1
		st.version[1] = st.new Node(0,null,null);
		st.upgrade(st.version[0], st.version[1], 0, arr.length - 1, 1, 4);
		
		//Version 2
		st.version[2] = st.new Node(0,null,null);
		st.upgrade(st.version[1], st.version[2], 0, arr.length - 1, 10, 2);
		
		System.out.println("Version 1 Query(1,4):" + st.query(st.version[1], 0, arr.length - 1, 0, 4));
		System.out.println("Version 2 Query(3,4):" + st.query(st.version[2], 0, arr.length - 1, 3, 4));
		System.out.println("Version 0 Query(0,3):" + st.query(st.version[0], 0, arr.length - 1, 0, 3));
	}
}
