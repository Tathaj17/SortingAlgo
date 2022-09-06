package io.file.task1;

/**
 * 
 * Quick Sort Taking first element is pivot point Not stable In place Recursive
 * algorithm Space complexity O(LOGN) Worse time complexity O(n^2) Average and
 * Best case is )(NLOGN)
 *
 */
public class QuickSort {
	int flagStart = 0;
	int flagEnd = 0;

	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		// int arr[]= {22,2,55,5,6,0};//passed
		// int arr[]= {1,2,4,5,6,7};//passed
		// int arr[]= {7,6,5,4,3,2};//passed
		// int arr[]= {2,200,55,5,6,88};//passed
		int arr[] = { -2, -200, -55, 5, 6, -88 };// passed
		qsort(arr, 0, arr.length - 1, qs);
		printArray(arr);
	}

	private static void qsort(int[] arr, int start, int end, QuickSort qs) {
		if (start < end) {
			int p = partition(arr, start, end, qs);
			qsort(arr, start, p - 1, qs);
			qsort(arr, p + 1, end, qs);
		}
	}

	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	/**
	 * return pivot element
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 * @param qs
	 * @return intiger
	 */
	private static int partition(int[] arr, int start, int end, QuickSort qs) {
		int pivot = start;
		start++;
		while (start <= end) {
			setFlagValueToTrue(arr, start, end, qs, pivot);
			start = increamentStart(start, qs);
			end = decrementEnd(end, qs);
			if (qs.flagStart == 1 && qs.flagEnd == 1)
				swap(arr, start, end, qs);
		}

		return swapppedByPivotElement(arr, pivot, end);

	}

	/**
	 * set flag is true according to the given conditon if array of start > array of
	 * Pivot and array of end < array of pivot
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 * @param qs
	 * @param pivot
	 */
	protected static void setFlagValueToTrue(int[] arr, int start, int end, QuickSort qs, int pivot) {
		if (toCheckStartGreaterThanPivotPoint(arr, start, pivot)) {
			qs.flagStart = 1;
		}
		if (toCheckEndLessThanPivotPoint(arr, end, pivot)) {
			qs.flagEnd = 1;
		}
	}

	/**
	 * Which element is in the end position that is lesser than pivot element if
	 * true then it returns true
	 * 
	 * @param arr
	 * @param end
	 * @param pivot
	 * @return boolean
	 */
	private static boolean toCheckEndLessThanPivotPoint(int[] arr, int end, int pivot) {
		return arr[end] < arr[pivot];
	}

	/**
	 * Which element is in the start position that is greater than pivot element if
	 * true then it returns true
	 * 
	 * @param arr
	 * @param start
	 * @param pivot
	 * @return boolean
	 */
	private static boolean toCheckStartGreaterThanPivotPoint(int[] arr, int start, int pivot) {
		return arr[start] > arr[pivot];
	}

	/**
	 * decrement end flag is false or zero
	 * 
	 * @param end
	 * @param qs
	 * @return end
	 */
	private static int decrementEnd(int end, QuickSort qs) {
		if (qs.flagEnd == 0) {
			end--;
		}
		return end;
	}

	/**
	 * increament start if flag is false or zero
	 * 
	 * @param start
	 * @param qs
	 * @return start
	 */
	private static int increamentStart(int start, QuickSort qs) {
		if (qs.flagStart == 0) {
			start++;
		}
		return start;
	}

	/**
	 * swapppedByPivotElement and return the pivot element
	 * 
	 * @param arr
	 * @param pivot
	 * @param end
	 * @return
	 */
	private static int swapppedByPivotElement(int[] arr, int pivot, int end) {
		int temp = arr[pivot];
		arr[pivot] = arr[end];
		arr[end] = temp;
		return end;
	}

	/**
	 * Swap two values into the array
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 * @param qs
	 */
	private static void swap(int arr[], int start, int end, QuickSort qs) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		qs.flagStart = 0;
		qs.flagEnd = 0;
	}
}
