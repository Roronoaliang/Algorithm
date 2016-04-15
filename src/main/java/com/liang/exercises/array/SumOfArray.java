package com.liang.exercises.array;

/**
 * @Description 数组求和,要求只能用一句代码,规定数组为空时和为0
 * @Solution 常规求和需要遍历一遍数组,如果只用一句代码则考虑使用递归,容易得出sum(n) = n+sum(n-1);
 * @Date 2016年4月11日 上午10:32:07
 */
public class SumOfArray {

	public int sumOfArray(int[] arr, int len) {
		return len == 0 ? 0 : arr[len - 1] + sumOfArray(arr, len - 1);
	}
}
