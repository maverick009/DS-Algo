package main;

class BinarySearch {
	/*
	 * Given a sorted array of N distinct elements. Find a key in the array using least number of comparisons.
	 */
	
	public int search(int []arr, int l, int r, int key) {
		while(r - l > 1) {
			int m = l + (r-l)/2;
			if(key <= arr[m])
				r = m;
			else
				l = m;
		}
		
		if(arr[r] == key)
			return r;
		else return -1;
	}
	
	/*
	 * Given an array of N distinct integers, find floor value of input ‘key’. 
	 */
	
	public int search_floor(int []arr, int l, int r, int key) {
		
		while(r-l>1) {
			int m = l + (r-l)/2;
			if(key <= arr[m])
				r = m;
			else 
				l = m;
		}
		return l;
	}
	
	/*
	 * Given an array of N distinct integers, find Ceil value of input ‘key’. 
	 */
	
	public int search_ceil(int []arr, int l, int r, int key) {
		while(r-l>1) {
			int m = l + (r-l)/2;
			if(key <= arr[m])
				r=m;
			else
				l=m;
		}
		return r;
	}
	
	/*
	 * Given a sorted array with possible duplicate elements. 
	 * Find number of occurrences of input ‘key’ in log N time.
	 */
	public int GetRightPosition(int arr[], int l, int r, int key) {
		
		while(r-l >1) {
			int m = l + (r-l)/2;
			if(key < arr[m])
				r = m;
			else
				l = m;
		}
		return l;
	}
	
	public int GetLeftPosition(int arr[], int l, int r, int key) {
		while(r-l>1) {
			int m = l + (r-l)/2;
			if(key <= arr[m])
				r = m;
			else
				l = m;
		}
		return r;
	}
	
	public int search_duplicates(int []arr, int l, int r, int key) {
		
		int left = GetLeftPosition(arr, l, r, key);
		int right = GetRightPosition(arr, l, r, key);
		return (arr[left] == key && arr[right] == key)?right-left+1:0;
	}
}

public class Main {

	public static void main(String[] args) {
		int []arr = {2,5,8,12,16,23,38,56,72,91};
		System.out.println(new BinarySearch().search(arr, 0, arr.length-1, 56));
		System.out.println(new BinarySearch().search_floor(arr, 0, arr.length-1, 24));
		System.out.println(new BinarySearch().search_ceil(arr, 0, arr.length-1, 42));
		int []arr1 = {2,5,8,23,23,23,38,56,72,91};
		System.out.println(new BinarySearch().search_duplicates(arr1, 0, arr1.length-1, 23));
	}
}