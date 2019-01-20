package main;

class Solution {
	public int paper(int a, int b) {
		int min, max, sq = 0;
		if(a < b) {
			min = a;max=b;
		} else {
			max = a;min = b;
		}
		while(min >= 1) {
			sq += max/min;
			int temp = max%min;
			max = min;
			min = temp;
		}
		if(min == 1)
			sq += max-min+1;
		return sq;
	}
}

public class Main {
	public static void main(String[] args) {
		int a = 29, b = 13;
		System.out.println(new Solution().paper(a, b));
	}
}