package com.liang.exercises.array;

/**
 * @Description 求数组的最大值和最小值
 * @Solution1 类似于选择排序使用两个变量标记最大最小值，遍历一遍数组
 * @Solution2 采用分治的思想,将数组分为两部分然后对左右两部分重复划分直到规模足够小，分别从左右两边查询最大值和最小值，然后再比较两边的最大最小值
 * @Date 2016年4月11日 上午10:44:08
 */
public class MaxAndMin {

	public void solution1(Integer arr[]) {
		if (arr == null || arr.length == 0) {
			System.out.println("数组为空,没有最大最小值");
			return;
		}
		int max = arr[0], min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		System.out.println("最大值: " + max + " ,最小值: " + min);
	}

	public void solution2(Integer arr[]) {
		Integer result[] = getMaxAndMin(arr, 0, arr.length - 1);
		System.out.println("最大值: " + result[0] + " ,最小值: " + result[1]);
	}

	/**
	 * 计算最大最小值,结果存储在int型数组中,0号元素为最大值,1号元素存储最小值
	 * 
	 * @param arr
	 * @param low
	 * @param high
	 * @param temp
	 *            上一步划份得到的最大最小值
	 * @return
	 */
	private Integer[] getMaxAndMin(Integer arr[], int low, int high) {
		Integer[] result = new Integer[2];
		// 只剩一个元素
		if (low == high) {
			result[0] = arr[low];
			result[1] = arr[high];
			return result;
		}
		// 剩两个元素
		if (low + 1 == high) {
			if (arr[low] < arr[high]) {
				result[0] = arr[high];
				result[1] = arr[low];
			} else {
				result[0] = arr[low];
				result[1] = arr[high];
			}
			return result;
		}
		// 多于两个元素，划分成更小的元素
		int mid = (low + high) / 2; // 计算中间下标
		Integer[] leftResult = getMaxAndMin(arr, low, mid); // 计算左部分最大最小值
		Integer[] rightResult = getMaxAndMin(arr, mid + 1, high); // 计算右部分最大最小值
		//计算总的最大值、总的最小值
		if(leftResult[0] < rightResult[0]) {
			result[0] = rightResult[0];
		} else {
			result[0] = leftResult[0];
		}
		if(leftResult[1] < rightResult[1]) {
			result[1] = leftResult[1];
		} else {
			result[1] = rightResult[1];
		}
		return result;
	}
}
