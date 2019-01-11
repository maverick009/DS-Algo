package main;

import java.util.Arrays;

class Main {
	
	public static void main(String[] args) throws java.lang.Exception {
		int[] arr = new int[] { 7, 15, 4, 3, 20, 10 };
		printArray(arr);
		System.out.println(getKthSmallestQuickSelectWorstCaseLinearTime(arr, 0, arr.length - 1, 4));
	}

	private static int getKthSmallestQuickSelectWorstCaseLinearTime(int arr[], int low, int high, int k) {

		if (k > 0 && k <= high - low + 1) {
			// number of elements in array
			int n = high - low + 1;

			int i, median[] = new int[(n + 4) / 5];

			for (i = 0; i < median.length - 1; i++) {
				median[i] = getMedian(Arrays.copyOfRange(arr, 5 * i + low, 5 * i + low + 4), 5);
			}

			if (n % 5 == 0) {
				median[i] = getMedian(Arrays.copyOfRange(arr, 5 * i + low, 5 * i + low + 4), 5);
				i++;
			} else {
				median[i] = getMedian(Arrays.copyOfRange(arr, 5 * i + low, 5 * i + low + (n % 5)), n % 5);
				i++;
			}

			int medOfMed = i == 1 ? median[i - 1]
					: getKthSmallestQuickSelectWorstCaseLinearTime(median, 0, i - 1, i / 2);

			int partition = partition(arr, low, high, medOfMed);

			if (partition - low == k - 1) {
				return arr[partition];
			}

			if (partition - low > k - 1) {
				return getKthSmallestQuickSelectWorstCaseLinearTime(arr, low, partition - 1, k);
			}

			return getKthSmallestQuickSelectWorstCaseLinearTime(arr, partition + 1, high, k - (partition + 1) + low);
		}

		return -1;
	}

	/**
	 * this is only for odd size array size
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	private static int getMedian(int arr[], int n) {
		Arrays.sort(arr, 0, arr.length-1);
		return arr[n / 2];
	}

	private static void swap(int[] arr, int i, int index) {
		int temp = arr[i];
		arr[i] = arr[index];
		arr[index] = temp;
	}

	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	private static int partition(int[] arr, int low, int high, int pivot) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == pivot) {
				swap(arr, i, high);
				break;
			}
		}
		int p = arr[high];
		int i = low-1;
		for(int j = low;j <= high;j++)
			if(arr[j] < p)
				swap(arr, ++i, j);
		swap(arr, ++i, high);
		return i;
	}

}