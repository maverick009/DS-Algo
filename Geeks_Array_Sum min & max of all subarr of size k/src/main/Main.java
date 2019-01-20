package main;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
	public void maxk(int []arr, int k) {
		Deque<Integer> max_dq = new LinkedList<>();
		Deque<Integer> min_dq = new LinkedList<>();
		//For Max Deque
		for(int i = 0;i < k;i++) {
			while(!max_dq.isEmpty() && arr[i] >= arr[max_dq.peekLast()])
				max_dq.pollLast();
			max_dq.addLast(i);
		}
		
		//For Min Deque
		for(int i = 0;i < k;i++) {
			while(!min_dq.isEmpty() && arr[i] <= arr[min_dq.peekLast()])
				min_dq.pollLast();
			min_dq.addLast(i);
		}
		
		int sum = 0;
		for(int i = k;i < arr.length;i++) {
			//System.out.println(arr[max_dq.peekFirst()] + "\t" + arr[min_dq.peekFirst()]);
			sum += arr[max_dq.peekFirst()] + arr[min_dq.peekFirst()];
			//Max Deque
			while(!max_dq.isEmpty() && i - max_dq.peekFirst() >= k)
				max_dq.pollFirst();
			while(!max_dq.isEmpty() && arr[i] >= arr[max_dq.peekLast()])
				max_dq.pollLast();
			max_dq.addLast(i);
			
			//Min Deque
			while(!min_dq.isEmpty() && i - min_dq.peekFirst() >= k)
				min_dq.pollFirst();
			
			while(!min_dq.isEmpty() && arr[i] <= arr[min_dq.peekLast()])
				min_dq.pollLast();
			min_dq.addLast(i);			
		}
		//System.out.println(arr[max_dq.peekFirst()] + "\t" + arr[min_dq.peekFirst()]);
		sum += arr[max_dq.pollFirst()] + arr[min_dq.pollFirst()];
		System.out.println(sum);
	}
}

public class Main {

	public static void main(String[] args) {
		//int []arr = {12, 5, -10, 70, 300, -15, -25};
		int arr[] = {2, 5, -1, 7, -3, -1, -2};
		for(int i : arr)
			System.out.print(i + " ");
		System.out.println();
		new Solution().maxk(arr, 4);
	}
}