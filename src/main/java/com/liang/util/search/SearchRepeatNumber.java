package com.liang.util.search;

import com.liang.util.RandAndPrintUtil;

/**
 * @Description 
 *              1-1000放在含有1001个元素的数组中，只有唯一的一个元素值重复，其它均只出现一次。每个数组元素只能访问一次，设计一个算法，将它找出来
 *              ；不用辅助存储空间
 * 
 * @Solution1 将所有数累加,减去1到1000累加，得到的结果就是重复的数。（如果不是1-1000而是更大的数可能会有溢出问题）
 * 
 * @Solution2 使用异或运算的自反性,将所有数进行异或运算，然后在异或上1到1000，最终得到的结果就是重复了的数
 * 
 * @Date 2016年4月3日 下午4:58:31
 */
public class SearchRepeatNumber {

	public static int solution1(Integer arr[]) {
		int sum = 0;
		// 计算所有数的和
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		// 等差数列求和公式计算1到1000的和
		int sum1 = 1000*1 + 1000*999/2;
		return sum - sum1;

	}

	public static int solution2(Integer arr[]) {
		int result = 0;
		for(int i = 0; i < arr.length; i++) {
			result ^= arr[i];
		}
		for(int i = 1; i <= 1000; i++) {
			result ^= i;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Integer arr[] = new Integer[1001];
		for (int i = 0; i < 500; i++) {
			arr[i] = i + 1;
		}
		arr[500] = 500;
		for (int i = 501; i < 1001; i++) {
			arr[i] = i;
		}

		RandAndPrintUtil.print("initialData", arr);

		System.out.println("the repeat number is: " + solution1(arr));
		System.out.println("the repeat number is: " + solution2(arr));
	}

	/**
	 * 等差数列通项公式：an = a1 + (n-1)*d;<br/>
	 * 等差数列求和公式：Sn = (a1+an)*n/2 = n*a1 + n(n-1)*d/2
	 */
}
