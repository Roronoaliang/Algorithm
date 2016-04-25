package com.liang.util;

import java.util.Random;

public class RandAndPrintUtil {

	/**
	 * 产生一个指定长度的随机整型数组
	 * @param length
	 * @return
	 */
	public static Integer[] randomNumber(int length) {
		Random r = new Random();
		Integer nums[] = new Integer[length];
		for(int i = 0; i < length; i++) {
			nums[i] = r.nextInt(100*length);
		}
		return nums;
	}
	
	/**
	 * 产生一个指定长度，并且在指定范围的整型数组
	 * @param length
	 * @param range
	 * @return
	 */
	public static Integer[] randomNumber(int length, int range) {
		Random r = new Random();
		Integer nums[] = new Integer[length];
		for(int i = 0; i < length; i++) {
			nums[i] = r.nextInt(range);
		}
		return nums;
	}
	
	/**
	 * 遍历输出整型数组
	 * @param name
	 * @param nums
	 */
	public static void print(String name, Integer nums[]) {
		System.out.print(name + " :\n\t\t ");
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + "\t");
		}
		System.out.println();
	}
}
