package com.liang.util.sort;

/**
 * @Description 快速排序
 * @Date 2016年3月21日 下午12:17:30
 */
public class QuickSort {

	public static void sort(Integer nums[]) {
		quickSort(nums, 0, nums.length - 1); // 初始调用快排
	}

	/**
	 * 快排递归的整体过程
	 * 
	 * @param nums
	 * @param low
	 * @param high
	 */
	private static void quickSort(Integer nums[], int low, int high) {
		if (low < high) { // 注意这里是if，不是while
			int pivotkey = partition(nums, low, high); // 将序列划分为两部分
			quickSort(nums, low, pivotkey - 1);// 递归调用划分左序列
			quickSort(nums, pivotkey + 1, high);// 递归调用划分右序列
		}
	}

	/**
	 * 快排的一次划分过程
	 * 
	 * @param nums
	 * @param low
	 * @param high
	 * @return 中轴数的位置
	 */
	private static int partition(Integer nums[], int low, int high) {

		int pivotkey = nums[low]; // 取第1个元素作为中轴值
		while (low < high) {
			while (low < high && nums[high] >= pivotkey) { // 从high处开始移动指针
				high--;
			}
			// 交换小的数据到中轴值左边
			swap(nums, low, high);
			while (low < high && nums[low] <= pivotkey) {// 转而从low处开始移动指针
				low++;
			}
			// 交换大的数据到中轴值右边
			swap(nums, low, high);
		}
		return low; // 返回中轴值下标
	}

	/**
	 * 交换数组中的两个数
	 * 
	 * @param nums
	 * @param a
	 * @param b
	 */
	private static void swap(Integer nums[], int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

}
