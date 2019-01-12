package main;

import java.util.Arrays;

class Solution {
	public int platform(int []start, int []end) {
		int platform = 0, counter = 0;
		int i = 0, j = 0;
		Arrays.sort(start);
		Arrays.sort(end);
		while(i < start.length && j < end.length) {
			if(start[i] < end[j]) {
				counter++;
				i++;
			} else {
				counter--;
				j++;
			}
			platform = Math.max(platform, counter);
		}
		return platform;
	}
}

public class Main {

	public static void main(String[] args) {
		int start[] = {900, 940, 950, 1100, 1500, 1800}; 
	    int end[] = {910, 1200, 1120, 1130, 1900, 2000};
	    System.out.println(new Solution().platform(start, end));
	}
}