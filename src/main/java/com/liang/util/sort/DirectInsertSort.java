package com.liang.util.sort;

/**
 * @Description 直接插入排序
 * @Date 2016年3月14日 上午9:09:51
 */
public class DirectInsertSort {
	
	/**
	 * 适用于数据量少，基本有序的场景
	 * 时间复杂度：O（n²）， 性能比冒泡和简单选择好
	 * @param nums
	 * @return
	 */
	public static void sort(int nums[]) {
		int i, j, k;
		for(i = 1; i < nums.length; i++) { //外层循环遍历无序集合，将第一个元素视为有序集合故无序集合从下标1开始
			k = nums[i]; //记录待排序元素防止被移位操作覆盖掉 
			for(j = i-1; j >= 0 && k < nums[j]; j--) { //内层循环遍历有序集合与当前待排序元素比较
				nums[j+1] = nums[j]; //移位操作
			}
			//找到了合适的位置插入,注意插入位置是j+1而不是j
			nums[j+1] = k;
		}
	}
}
