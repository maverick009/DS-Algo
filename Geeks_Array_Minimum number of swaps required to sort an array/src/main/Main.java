package main;

import javafx.util.Pair;
import java.util.*;

class Solution {
	public void print(int []arr) {
		for(int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}
	
	/*
	 * 0(N*N) method
	 * Not Working
	 */
	/*public int min_swaps(int []arr) {
		ArrayList<Pair<Integer, Integer>> d = new ArrayList<>();
		
		int index = arr.length -1;
		int swap = 0;
		for(int i = 0;i < arr.length -1 ;i++) {
			int max_index = find_max(arr, 0, index);
			swap(arr, 0, max_index);
			swap(arr, 0, index--);
			swap++;
		}
		return swap-1;
		
	}*/
	
	/*
	 * 0(NlgN) solution using Graphs
	 * Swap required for cycle of length l = l-1
	 * https://www.youtube.com/watch?v=f7IIW0HVUcQ
	 */
	
	public int min_swaps(int []arr) {
		List<Pair<Integer, Integer>> temp = new ArrayList<>();
		for(int i = 0;i < arr.length;i++)
			temp.add(new Pair<Integer, Integer>(arr[i], i));
		
		Collections.sort(temp, new Comparator<Pair<Integer, Integer>>() {
			@Override
			public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
				return p1.getKey() - p2.getKey();
			}
		});
		
		boolean []visited = new boolean[arr.length];
		int swaps = 0;
		
		for(int i = 0;i < arr.length;i++) {
			if(visited[i] || temp.get(i).getValue() == i)
				continue;
			
			int cycle = 0;
			int j = i;
			while(!visited[j]) {
				visited[j] = true;
				j = temp.get(j).getValue();
				cycle++;
			}
			if(cycle > 0)
				swaps += cycle-1;
		}		
		return swaps;
	}
	
	/*
	 * Another 0(NlgN) method
	 * keeping swapping until indeices match
	 * Still issues with swapping pairs
	 */
	
	/*public int min_swaps1(int []arr) {
		List<Pair<Integer, Integer>> temp = new ArrayList<>();
		for(int i = 0;i < arr.length;i++)
			temp.add(new Pair<Integer, Integer>(arr[i], i));
		
		for(int i = 0;i < temp.size();i++)
			System.out.println(temp.get(i).getKey() + " " + temp.get(i).getValue());
		System.out.println();
		
		Collections.sort(temp, new Comparator<Pair<Integer, Integer>>() {
			@Override
			public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
				return p1.getKey() - p2.getKey();
			}
		});
		
		for(int i = 0;i < temp.size();i++)
			System.out.println(temp.get(i).getKey() + " " + temp.get(i).getValue());
		System.out.println();
		
		int swaps = 0;
		for(int i = 0;i < arr.length;i++) {
			if(temp.get(i).getValue() == i)
				continue;
			else {
				swap(temp.get(i).getKey(), temp.get(temp.get(i).getValue()).getKey());
				swap(temp.get(i).getValue(), temp.get(temp.get(i).getValue()).getValue());
			}
			
			if(temp.get(i).getValue() != i)
				i--;
			swaps++;
		}
		
		return swaps;
	}*/
	
	/*public int find_max(int []arr, int l, int r) {
		int max = Integer.MIN_VALUE, index = -1;
		for(int i = l;i <= r;i++) {
			max = Math.max(max, arr[i]);
			index = (max == arr[i])?i:index;
		}
		return index;
	}*/
	
	public void swap(int []arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}


public class Main {
	public static void main(String[] args) {
		//int []arr = {4, 3, 2, 1};
		int []arr = {4, 3, 2, 1};
		System.out.println(new Solution().min_swaps(arr));
		//System.out.println(new Solution().min_swaps1(arr));
	}
}