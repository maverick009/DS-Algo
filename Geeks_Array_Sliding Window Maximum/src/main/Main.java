package main;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
	void maximum(int []arr, int k) {
		if(arr.length < k)
			return;
		Deque<Integer> deq = new LinkedList<>();
		int i;
		for(i = 0;i < k;i++) {
			while(!deq.isEmpty() && arr[deq.peekLast()] <= arr[i])
				deq.pollLast();
			deq.addLast(i);
		}
		
		for(;i < arr.length;i++) {
			System.out.print(arr[deq.peek()] + " ");
			
			while(!deq.isEmpty() && deq.peek() <= i-k)
				deq.pollFirst();
			
			while(!deq.isEmpty() && arr[i] >= arr[deq.peekLast()])
				deq.pollLast();
			
			deq.addLast(i);
		}
		System.out.println(arr[deq.peek()]);
	}
}

public class Main {

	public static void main(String[] args) {
		int []arr = {1,2,3,1,4,5,2,3,6};
		//int arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		int k = 3;
		new Solution().maximum(arr, k);
	}
}