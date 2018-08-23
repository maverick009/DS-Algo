package main;
import heap.Heap;



public class Main 
{
	public static void main(String[] args) 
	{
		int []a = {3,2,1,7,8,4,10,16,12};
		System.out.println("Original Array");
		for(int i = 0;i < a.length; i++)
			System.out.print(a[i] + " ");
		//System.out.println("\n");
		
		Heap minHeap = new Heap(a.length);
		minHeap.create(a);
		System.out.println("\nHeap");
		minHeap.display();
		
		for(int i = 0;i < a.length;i++)
		{
			System.out.print("\nMin:" + minHeap.getMin() + " ");
			System.out.print("\n");
			minHeap.display();
		}
		
		
		/*System.out.println("The Min Heap is ");
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(7);
        minHeap.insert(8);
        minHeap.insert(4);
        minHeap.insert(10);
        minHeap.insert(16);
        minHeap.insert(12);
        minHeap.minHeap();
 
        minHeap.print();
        System.out.println("The Min val is " + minHeap.remove());
        System.out.println("The Min val is " + minHeap.remove());
        System.out.println("The Min val is " + minHeap.remove());
        System.out.println("The Min val is " + minHeap.remove());
        System.out.println("The Min val is " + minHeap.remove());
        System.out.println("The Min val is " + minHeap.remove());
        System.out.println("The Min val is " + minHeap.remove());
        System.out.println("The Min val is " + minHeap.remove());
        System.out.println("The Min val is " + minHeap.remove());
*/        	
	}
}
