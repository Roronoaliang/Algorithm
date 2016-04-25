package com.liang.util.sort;


/**
 * @Description 简单选择排序
 * @Date 2016年3月14日 上午8:56:51
 */
public class SimpleSelectSort {

	/**
	 * 时间复杂度：O（n²）, 交换次数少，略优于冒泡
	 * 
	 * @param nums
	 * @return
	 */
	public static void sort(Integer arr[]) {
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			if (min != i) {
				swap(arr, min, i);
			}
		}
	}

	private static void swap(Integer arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
}
