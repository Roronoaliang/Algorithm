package com.liang.util.sort;

public class TempTest {

	/**
	 * 统计k出现的次数
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public int GetNumberOfK(int[] array, int k) {
		if (array == null || array.length == 0) {
			return 0;
		}

		int count = 0;
		int index = binarySearch(array, 0, array.length - 1, k); // 定位k的位置

		if (index == -1) {
			return 0;
		}

		for (int i = 0;; i++) {
			if (array[index + i] == k) {
				count++;
			} else {
				break;
			}
		}

		for (int j = 0; index - j >= 0; j++) {
			if (array[index - j] == k) {
				count++;
			} else {
				break;
			}
		}
		return count - 1;
	}

	/**
	 * 二分查找
	 * 
	 * @param arr
	 * @param low
	 * @param high
	 * @param k
	 * @return
	 */
	public int binarySearch(int arr[], int low, int high, int k) {
		int mid = (low + high) / 2;
		if (low > high) {
			return -1;
		} else {
			if (arr[mid] == k) {
				return mid;
			} else if (arr[mid] > k) {
				return binarySearch(arr, low, mid - 1, k);
			} else {
				return binarySearch(arr, mid + 1, high, k);
			}
		}
	}

	public static void main(String[] args) {
		TempTest tempTest = new TempTest();
		int[] array = { 3,3,3,3,4,5 };
		int count = tempTest.GetNumberOfK(array, 3);
		System.out.println(count);
	}
}
