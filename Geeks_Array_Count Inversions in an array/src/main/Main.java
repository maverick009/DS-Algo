package main;

class Solution {
	public int count_inverisons(int []arr) {
		int []temp = new int[arr.length];
		return mergesort(arr, temp, 0, arr.length -1);
	}
	
	public int mergesort(int []arr, int []temp, int l, int h) {
		int inversion_count = 0;
		if(l < h) {
			int m = l + (h-l)/2;
			inversion_count = mergesort(arr, temp, l, m);
			inversion_count += mergesort(arr, temp, m+1, h);
			inversion_count += merge(arr, temp, l, m, h);
		}
		return inversion_count;
	}
	
	public int merge(int []arr, int []temp, int l, int m, int h) {
		int inv_count = 0;
		int i = l, j = m+1, k = l;
		
		while((i <= m-1) && (j <= h)) {
			if(arr[i] < arr[j])
				temp[k++] = arr[i++];
			else {
				temp[k++] = arr[j++];
				inv_count += m-i;
			}
		}
		
		while(i <= m-1)
			temp[k++] = arr[i++];
		while(j <= h)
			temp[k++] = arr[j++];
		for(i = 0;i < arr.length;i++)
			arr[i] = temp[i];
		return inv_count;
	}
}

public class Main {
	public static void main(String[] args) {
		int arr[] = new int[] { 1, 20, 6, 4, 5 };
		System.out.println(new Solution().count_inverisons(arr));
	}
}