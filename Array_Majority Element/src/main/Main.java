package main;

class Solution {
	public int majority(int []arr) {
		int key = boyer_moore(arr);
		return (ismajority(arr, key))?key:-1;
	}
	
	public int boyer_moore(int []arr) {
		int c = 0, maj = 0;
		
		for(int i = 1;i < arr.length;i++) {
			if(arr[i] == arr[maj])
				c++;
			else
				c--;
			if(c == 0) {
				maj = i;
				c = 1;
			}
		}
		return arr[maj];
	}
	
	public boolean ismajority(int []arr, int key) {
		int c = 0;
		for(int i = 0;i < arr.length;i++) {
			if(arr[i] == key)
				c++;
		}
		return (c > arr.length/2)?true:false;
	}
}

public class Main {

	public static void main(String[] args) {
		//int []arr= {3,3,4,2,4,4,2,4,4};
		int []arr = {3,3,4,2,4,4,2,4};
		System.out.println(new Solution().majority(arr));
	}
}