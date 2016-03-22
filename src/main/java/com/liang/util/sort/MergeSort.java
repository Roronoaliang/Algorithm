package com.liang.util.sort;

/**
 * @Description 归并排序
 * @Date 2016年3月18日 下午9:53:14
 */
public class MergeSort {

	/**
	 * 递归实现归并排序
	 */
	public static void sortWithRecursion(int nums[]) {
		mergeSort(nums, 0, nums.length - 1);
	}

	/**
	 * 递归划分左右子序列使其分别有序，然后调用归并方法归并两个子序列
	 * 
	 * @param nums
	 * @param firstIndex
	 *            起始下标
	 * @param lastIndex
	 *            最末下标
	 */
	private static void mergeSort(int nums[], int firstIndex, int lastIndex) {
		if (firstIndex == lastIndex) {
			return;
		}
		int mid = (firstIndex + lastIndex) / 2;
		mergeSort(nums, firstIndex, mid);// 递归使左序列有序
		mergeSort(nums, mid + 1, lastIndex);// 递归使右序列有序
		merge(nums, firstIndex, mid, lastIndex);// 合并两个序列
	}

	/**
	 * 归并两个有序序列
	 * 
	 * @param nums
	 * @param firstIndex
	 * @param midIndex
	 * @param lastIndex
	 */
	private static void merge(int nums[], int firstIndex, int midIndex,
			int lastIndex) {
		int lSize = midIndex + 1 - firstIndex;
		int rSize = lastIndex - midIndex;
		int left[] = new int[lSize]; // 存放左序列
		int right[] = new int[rSize]; // 存放右序列
		// 复制到左序列
		for (int i = firstIndex; i <= midIndex; i++) {
			left[i - firstIndex] = nums[i];
		}
		// 复制到右序列
		for (int i = midIndex + 1; i <= lastIndex; i++) {
			right[i - midIndex - 1] = nums[i];
		}
		// 将左右两个序列归并回原数组中
		int i = 0, j = 0, k = firstIndex;
		while (i < lSize && j < rSize) {
			if (left[i] < right[j]) {
				nums[k++] = left[i++];
			} else {
				nums[k++] = right[j++];
			}
		}
		while (i < lSize) {
			nums[k++] = left[i++];
		}
		while (j < rSize) {
			nums[k++] = right[j++];
		}
	}

	/**
	 * 迭代实现归并排序
	 * 
	 * @param data
	 */
	public static void mergeWithIteration(int[] data) {
		// 声明临时数组和四个变量指示左右子序列的边界
		int temp[] = new int[data.length];
		int lMin, lMax, rMin, rMax;
		int step;
		for (step = 1; step < data.length; step *= 2) {// 外层循环依次扩大步长：1、2、4、8...直到大于等于数组长度
			{
				for (lMin = 0; lMin < data.length - step; lMin = rMax) { // 在每趟归并过程中从0号元素开始根据当前的步长依次划分两个子序列，并进行归并
					// 划分子序列的边界
					rMin = lMax = lMin + step;
					rMax = rMin + step;
					// 防止右序列右边界越界
					if (rMax > data.length) {
						rMax = data.length;
					}
					// 归并两个有序序列
					int index = 0;
					while (lMin < lMax && rMin < rMax) {
						if (data[lMin] < data[rMin]) {
							temp[index++] = data[lMin++];
						} else {
							temp[index++] = data[rMin++];
						}
					}
					// 如果左边还有没遍历到的说明左边剩下的都是比temp数组中的数要大，则在原始数组中按原来的顺序复制到右边子序列中(如果右边还有没遍历到的说明都是比temp数组中的数要大的，但是只要待在原位就行了，不需要移动)
					while (lMin < lMax) {
						data[--rMin] = data[--lMax];
					}
					// 把temp数组中的数据复制回原始数组中
					while (index > 0) {
						data[--rMin] = temp[--index];
					}
				}
			}
		}

	}

}
