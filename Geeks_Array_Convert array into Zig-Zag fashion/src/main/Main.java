package main;

class Array {
	public void quicksort(int []arr, int l, int h) {
		if(l < h) {
			int p = partition(arr, l, h);
			quicksort(arr, l, p-1);
			quicksort(arr, p+1, h);
		}
	}
	
	public int partition(int []arr, int l, int h) {
		int p = arr[h];
		int i = l-1;
		for(int j = l;j < h;j++) {
			if(arr[j] < p)
				swap(arr, ++i, j);
		}
		swap(arr, ++i, h);
		return i;
	}
	
	public void swap(int []arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public void print(int []arr) {
		for(int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}
	
	//0(NlgN) approach
	/*public void convert(int []arr) {
		if(arr.length == 0 || arr.length == 1)
			return;
		quicksort(arr, 0, arr.length-1);
		
		for(int i = 1;i < arr.length;i += 2) {
			swap(arr, i, i+1);
		}
	}*/
	
	//0(N) solution
	/*
	 * Flag true for '<' else false
	 */
	public void convert(int []arr) {
		boolean flag = true;
		for(int i = 0;i <= arr.length-2;i++) {
			if(flag) {
				if(arr[i] > arr[i+1])
					swap(arr, i, i+1);
			} else {
				if(arr[i] < arr[i+1])
					swap(arr, i, i+1);
			}
			flag = !flag;
		}
	}
}

public class Main {

	public static void main(String[] args) {
		//int []arr = {24, 76, 1, 89, 14};
		int []arr = {4, 3, 7, 8, 6, 2, 1};
		Array a = new Array();
		/*a.print(arr);
		a.quicksort(arr, 0, arr.length-1);*/
		a.print(arr);
		a.convert(arr);
		a.print(arr);
	}
}