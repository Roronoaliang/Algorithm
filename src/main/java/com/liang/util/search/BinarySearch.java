package com.liang.util.search;


/**
 * @Description 折半查找
 * @Solution
 * @Date 2016年4月7日 下午9:46:40
 */
public class BinarySearch {

	/**
	 * 迭代实现折半查找
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public static int binarySearch(int[] array, int k) {
		int low = 0;
		int high = array.length - 1;

		while (low <= high && low <= array.length - 1
				&& high < array.length - 1) {
			int mid = (low + high) >> 1;
			if (k == array[mid]) {
				return mid;
			} else if (k < array[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return -1;
	}

	/**
	 * 递归实现折半查找
	 * @param arr
	 * @param low
	 * @param high
	 * @param k
	 * @return
	 */
	public static int binarySearch(int arr[], int low, int high, int k) {
		int mid = (low + high) / 2;
		if(low > high) {
			return -1;
		} else{
			if(arr[mid] == k) {
				return mid;
			}
			else if(arr[mid] > k) {
				return binarySearch(arr, low, mid-1, k);
			} else {
				return binarySearch(arr, mid+1, high, k);
			}
		}
	}
}
