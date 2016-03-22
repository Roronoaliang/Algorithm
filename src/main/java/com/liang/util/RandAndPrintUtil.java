package com.liang.util;

import java.util.Random;

public class RandAndPrintUtil {

	public static int[] randomNumber(int length) {
		Random r = new Random();
		int nums[] = new int[length];
		for(int i = 0; i < length; i++) {
			nums[i] = r.nextInt(100*length);
		}
		return nums;
	}
	
	public static int[] randomNumber(int length, int range) {
		Random r = new Random();
		int nums[] = new int[length];
		for(int i = 0; i < length; i++) {
			nums[i] = r.nextInt(range);
		}
		return nums;
	}
	
	public static void print(String name, int nums[]) {
		System.out.print(name + " :\n\t\t ");
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + "\t");
		}
		System.out.println();
	}
}
