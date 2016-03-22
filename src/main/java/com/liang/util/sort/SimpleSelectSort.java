package com.liang.util.sort;

/**
 * @Description 简单选择排序
 * @Date 2016年3月14日 上午8:56:51
 */
public class SimpleSelectSort {

	/**
	 * 时间复杂度：O（n²）, 交换次数少，略优于冒泡
	 * @param nums
	 * @return
	 */
	public static void sort(int data[]) {
		int i, j, k, min;
		for(i = 0; i < data.length-1; i++) {
			min = i;
			for(j = i+1; j < data.length; j++) { //找出本趟排序最小的元素，标记出下标
				if(data[min] > data[j]) {
					min = j;
				}
			}
			//与第i个元素交换位置
			k = data[min];
			data[min] = data[i];
			data[i] = k;
		}
	}
}
