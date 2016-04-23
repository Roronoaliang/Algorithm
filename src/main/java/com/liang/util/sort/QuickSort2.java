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
	 * @param arr
	 */
	public static void sort(int arr[]) {
		quickSort(arr, 0, arr.length - 1);// 初始化调用快排
	}

	/**
	 * 快排递归过程
	 * 
	 * @param arr
	 * @param low
	 * @param high
	 */
	private static void quickSort(int arr[], int low, int high) {
		int pivotkey;
		if ((high - low) > Threshold) { // 优化方式三：如果序列长度大于阀值则使用快排，否则使用直接插入排序
			while (low < high) {
				pivotkey = partition(arr, low, high); // 划分成两部分
				quickSort(arr, low, pivotkey - 1); // 对左子表递归进行快排
				low = pivotkey + 1; // 优化方式四：使用尾递归减少递归次数
			}
		} else {
			insertSort(arr);
		}
	}

	/**
	 * 快排的一次划分过程，并返回中轴值下标
	 * 
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 */
	private static int partition(int arr[], int low, int high) {
		int pivotkey = calculPivot(arr, low, high); // 三数取中优选中轴值
		int pivotvalue = arr[pivotkey]; // 设置辅助变量存储中轴值

		while (low < high) { // 从序列的两端交替向中间扫描
			while (low < high && arr[high] >= pivotvalue) { // 注意后边的条件必须是大于等于，否则可能会造成死循环，从左边扫描也是如此
				high--;
			}
			arr[low] = arr[high]; // 优化方式二：改交换为直接替换
			while (low < high && arr[low] <= pivotvalue) {
				low++;
			}
			arr[high] = arr[low]; // 直接替换
		}
		arr[low] = pivotvalue; // 将中轴值替换回去
		return low;
	}

	/**
	 * 优化快排方式1：优选中轴值下标<br/>
	 * 这里采用三数取中的方法，也可以换成六数取中、九数取中的实现
	 * 
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 */
	private static int calculPivot(int arr[], int low, int high) {
//		int mid = low + (high - low) / 2;// 计算数组中间元素下标
		int mid = (low + high) / 2; // 计算数组中间元素下标
		// 使high的元素最大，low的元素居中，mid的元素最小
		if (arr[low] > arr[high]) {
			swap(arr, low, high);
		}
		if (arr[mid] > arr[high]) {
			swap(arr, mid, high);
		}
		if (arr[low] < arr[mid]) {
			swap(arr, low, mid);
		}
		return low;
	}

	/**
	 * 交换数组中的两个数
	 * 
	 * @param arr
	 * @param a
	 * @param b
	 */
	private static void swap(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	/**
	 * 直接插入排序
	 * 
	 * @param arr
	 */
	private static void insertSort(int arr[]) {
		int i, j, k;
		for (i = 1; i < arr.length; i++) {
			k = arr[i];
			for (j = i - 1; j >= 0 && k < arr[j]; j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = k;
		}
	}

}
