package main;

import java.util.*;
import javafx.util.*;

class Solution {
	
	class PairComparator implements Comparator<Pair<Integer, Pair<Integer, Integer>>>{

		@Override
		public int compare(Pair<Integer, Pair<Integer, Integer>> o1, Pair<Integer, Pair<Integer, Integer>> o2) {
			return o1.getKey() - o2.getKey();
		}	
	}
	
	
	public List<Integer> mergeKArrays(int [][]arr) {
		List<Integer> res = new ArrayList<>();
		PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> pq = new PriorityQueue<>(arr.length, new PairComparator()); 
		
		for(int i = 0;i < arr.length;i++)
			pq.add(new Pair<Integer, Pair<Integer,Integer>>(arr[i][0], new Pair<>(i, 0)));
		
		while(!pq.isEmpty()) {
			Pair<Integer, Pair<Integer, Integer>> p = pq.poll();
			int i = p.getValue().getKey();
			int j = p.getValue().getValue();
			
			res.add(p.getKey());
			if(j+1 < arr[i].length)
				pq.add(new Pair<Integer, Pair<Integer,Integer>>(arr[i][j+1], new Pair<>(i, j+1)));
		}		
		return res;
	}
}

public class Main {

	public static void main(String[] args) {
		int [][]arr = { { 2, 6, 12 }, 
                { 1, 9 }, 
                { 23, 34, 90, 2000 } };
		List<Integer> output = new Solution().mergeKArrays(arr);
		for(int i : output)
			System.out.print(i + " ");
		System.out.println();
	}
}