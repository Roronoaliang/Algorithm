package com.liang.exercises.array;

import com.liang.util.sort.QuickSort2;

/**
 * @Description 求数组中出现次数超过一半的数
 * @Solution1 采用打擂台方式,首先取第一个元素作为擂台数,并初始化擂台数出现次数为1,
 *            从第二个元素开始遍历数组,当遍历到的值等于擂台数则擂台数出现次数加1,
 *            当遍历到的数不等于擂台数,则擂台数出现次数减1,任何时刻当擂台数出现次数小于0时,更新擂台数为当前遍历到的数;
 *            考虑到奇数个数的序列，有可能删到最后剩下最后一个元素,但其出现次数没有达到一半以上,因此对于最后一个元素需要进一步验证是否满足要求
 * 
 * @Solution 
 *           先对数组进行排序,如果存在满足条件的数,那么该数一定是中位数,此时再以中位数为中心,向左右延伸统计中位数出现的次数看是否满足大于数组长度的一半
 * 
 * @Date 2016年4月7日 下午1:12:12
 */
public class MoreThanHalf {

	// 打擂台方式
	public int solution1(int[] array) {
		// 容错判断
		if (array == null || array.length == 0) {
			return Integer.MIN_VALUE; // 没有满足条件的数返回整型的最小值
		}
		// 只有一个元素的特殊情况
		if (array.length == 1) {
			return array[0];
		}

		int target = array[0]; // 擂台数
		int count = 1; // 初始出现次数
		int lastCount = 0; // 考虑到奇数个数的序列，有可能删到最后剩下最后一个元素,但其出现次数没有达到一半以上
		for (int i = 1; i < array.length; i++) {
			if (array[i] == array[array.length - 1]) { // 单独统计最后一个元素出现的次数
				lastCount++;
			}
			// 打擂台
			if (array[i] == target) {
				count++;
			} else {
				count--;
				if (count < 0) {
					target = array[i];
					count = 1;
				}
			}
		}
		// 偶数个数的序列且没有满足条件的数则最后count等于0
		if (count == 0) {
			return Integer.MIN_VALUE;
		}
		// 如果剩下的数刚好是最后的一个数，需要进一步判断
		if (target == array[array.length - 1]) {
			if (lastCount > array.length / 2) {
				return target;
			}
			return Integer.MIN_VALUE;
		}
		return target;
	}

	public int solution2(int arr[]) {
		QuickSort2.sort(arr); // 排序
		int mid = arr.length / 2;
		int count = 1;
		// 从中心位置向左右扩展统计次数
		for (int i = 1; mid - i >= 0 && arr[mid - i] == arr[mid]; i++) {
			count++;
		}
		for (int i = 1; mid + i < arr.length && arr[mid + i] == arr[mid]; i++) {
			count++;
		}
		if (count > arr.length / 2) {
			return arr[mid];
		}
		return Integer.MIN_VALUE;
	}
}
