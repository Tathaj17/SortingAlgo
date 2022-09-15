package com.prac.demo1;

import java.util.Objects;

/**
 * CountingSort algo With negative and possitive values
 *
 */
public class CountingSortWithNegativeAndPossitiveValueExample {
	static void findingMaxMinAndSort(int[] arr) {
		if (arr.length > 0) {
			int maxLength = arr[0];
			int minLength = arr[0];
			int maxValueArray[] = null;
			int minValueArray[] = null;
			for (int k = 0; k < arr.length - 1; k++) {
				if (arr[k + 1] > maxLength) {
					maxLength = arr[k + 1];
				} else if (arr[k + 1] < minLength) {
					minLength = arr[k + 1];
				}
			}

			if (minLength < 0) {
				minLength = Math.abs(minLength);
				minValueArray = new int[minLength + 1];
			}
			if (maxLength >= 0) {
				maxValueArray = new int[maxLength + 1];
			}
			storeCountElementAndSort(arr, maxValueArray, minValueArray);
			System.out.println("Sorted sets are: ");
			fetchOutputOfMinValues(minLength, minValueArray);
			fetchOutputOfMaxValues(maxLength, maxValueArray);
		}
	}
	/**
	 * fetch Output Of Max Values
	 * 
	 * @param maxLength
	 * @param maxValueArray
	 */
	protected static void fetchOutputOfMaxValues(int maxLength,
			int[] maxValueArray) {
		for (int i = 0; i < maxLength + 1; i++) {
			if (Objects.nonNull(maxValueArray)) {
				int n = maxValueArray[i];
				for (int f = 0; f < n; f++) {
					System.out.println(i);
				}
			}
		}
	}

	/**
	 * fetch Output Of Min Values
	 * 
	 * @param minLength
	 * @param minValueArray
	 */
	protected static void fetchOutputOfMinValues(int minLength,
			int[] minValueArray) {
		for (int i = minLength; i >= 0; i--) {
			if (Objects.nonNull(minValueArray)) {
				int n = minValueArray[i];
				for (int f = 0; f < n; f++) {
					System.out.println("-" + i);
				}
			}
		}
	}

	/**
	 * @param arr
	 * @param maxValueArray
	 * @param minValueArray
	 */
	protected static void storeCountElementAndSort(int[] arr,
			int[] maxValueArray, int[] minValueArray) {
		int countElement;
		for (int i = 0; i < arr.length; i++) {
			int j = arr[i];
			// to check array element is possitive or not and count
			if (j >= 0) {
				if (maxValueArray[j] >= 1) {
					countElement = maxValueArray[j] + 1;
					maxValueArray[j] = countElement;
				} else {
					maxValueArray[j] = 1;
				}
				countElement = 0;
			} else {
				int k = Math.abs(j);
				if (minValueArray[k] >= 1) {
					countElement = minValueArray[k] + 1;
					minValueArray[k] = countElement;
				} else {
					minValueArray[k] = 1;
				}
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = {3, -2, 3, 4, 0, -2, -1, -2000, -2000, -100};
		findingMaxMinAndSort(arr);
	}
}
