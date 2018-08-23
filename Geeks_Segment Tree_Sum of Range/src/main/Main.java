package main;

import segmentTree.SegmentTree;

public class Main 
{
	public static void main(String[] args) 
	{
		int []arr = {1,3,5,7,9,11};
        SegmentTree st = new SegmentTree(arr);
        System.out.println("Sum:" + st.getSum(arr, 1, 3));
        st.update(arr, 1, 10);
        System.out.println("Sum:" + st.getSum(arr, 1, 3));
	}
}