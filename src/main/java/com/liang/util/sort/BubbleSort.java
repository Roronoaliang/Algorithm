package com.liang.util.sort;


/**
 * @Description 冒泡排序 : 通过相邻两个元素两两比较，逐步交换使当前未排序的最大或最小的元素上升到指定位置
 * @Date 2016年3月13日 下午11:04:09
 */
public class BubbleSort {
	
	/**
	 * 常规冒泡
	 * 时间复杂度：O(n²)
	 * @param nums
	 */
	public static void sort(int nums[]){
		int i, j, k;
		for(i = 0; i < nums.length; i++) {
			for(j = nums.length - 2; j >= i; j--) {
				if(nums[j] > nums[j+1]) {
					k = nums[j+1];
					nums[j+1] = nums[j];
					nums[j] = k;
				}
			}
		}
	}
	
	/**
	 * 改进冒泡，对基本有序的序列在达到有序的目的之后能尽早结束循环比较。
	 * @param nums
	 */
	public static void sortImprove(int nums[]) {
		int i, j, k;
		boolean flag = true;
		for(i = 0; i < nums.length && flag; i++) {
			flag = false;
			for(j = nums.length - 2; j >= i; j--) {
				if(nums[j] > nums[j+1]) {
					k = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = k;
					flag = true;
				}
			}
		}
	}
}
