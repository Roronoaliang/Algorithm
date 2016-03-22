package com.liang.util.sort;

/**
 * @Description 优化常规快排<br/>
 *              1.优选中轴值 <br/>
 *              2.减少交换的过程，将交换改为直接替换，需要借助一个辅助变量存储中轴值<br/>
 *              3.设置阀值，当小于阀值时对小序列改用直接插入排序<br/>
 *              4.实施尾递归优化递归操作
 * @Date 2016年3月22日 上午8:20:12
 */
public class QuickSort2 {

	private static final int Threshold = 10; // 设置阀值

	/**
	 * 快排函数入口
	 * 
	 * @param nums
	 */
	public static void sort(int nums[]) {
		quickSort(nums, 0, nums.length - 1);// 初始化调用快排
	}

	/**
	 * 快排递归过程
	 * 
	 * @param nums
	 * @param low
	 * @param high
	 */
	private static void quickSort(int nums[], int low, int high) {
		int pivotkey;
		if ((high - low) > Threshold) { // 优化方式三：如果序列长度大于阀值则使用快排，否则使用直接插入排序
			while (low < high) {
				pivotkey = partition(nums, low, high); // 划分成两部分
				quickSort(nums, low, pivotkey - 1); // 对左子表递归进行快排
				low = pivotkey + 1; // 优化方式四：使用尾递归减少递归次数
			}
		} else {
			insertSort(nums);
		}
	}

	/**
	 * 快排的一次划分过程，并返回中轴值下标
	 * 
	 * @param nums
	 * @param low
	 * @param high
	 * @return
	 */
	private static int partition(int nums[], int low, int high) {
		int pivotkey = calculPivot(nums, low, high); // 三数取中优选中轴值
		int pivotvalue = nums[pivotkey]; // 设置辅助变量存储中轴值

		while (low < high) { // 从序列的两端交替向中间扫描
			while (low < high && nums[high] >= pivotvalue) { // 注意后边的条件必须是大于等于，否则可能会造成死循环，从左边扫描也是如此
				high--;
			}
			nums[low] = nums[high]; // 优化方式二：改交换为直接替换
			while (low < high && nums[low] <= pivotvalue) {
				low++;
			}
			nums[high] = nums[low]; // 直接替换
		}
		nums[low] = pivotvalue; // 将中轴值替换回去
		return low;
	}

	/**
	 * 优化快排方式1：优选中轴值下标<br/>
	 * 这里采用三数取中的方法，也可以换成六数取中、九数取中的实现
	 * 
	 * @param nums
	 * @param low
	 * @param high
	 * @return
	 */
	private static int calculPivot(int nums[], int low, int high) {
		int mid = low + (high - low) / 2;// 计算数组中间元素下标
		// 使high的元素最大，low的元素居中，mid的元素最小
		if (nums[low] > nums[high]) {
			swap(nums, low, high);
		}
		if (nums[mid] > nums[high]) {
			swap(nums, mid, high);
		}
		if (nums[low] < nums[mid]) {
			swap(nums, low, mid);
		}
		return low;
	}

	/**
	 * 交换数组中的两个数
	 * 
	 * @param nums
	 * @param a
	 * @param b
	 */
	private static void swap(int nums[], int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

	/**
	 * 直接插入排序
	 * 
	 * @param nums
	 */
	private static void insertSort(int nums[]) {
		int i, j, k;
		for (i = 1; i < nums.length; i++) {
			k = nums[i];
			for (j = i - 1; j >= 0 && k < nums[j]; j--) {
				nums[j + 1] = nums[j];
			}
			nums[j + 1] = k;
		}
	}

}
