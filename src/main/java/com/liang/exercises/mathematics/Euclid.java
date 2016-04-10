package com.liang.exercises.mathematics;

/**
 * @Description 欧几里得求两个数的最大公约数:两个数的最大公约数等于较小的数与两个数的相除余数的最大公约数
 * @Date 2016年3月22日 下午4:15:32
 */
public class Euclid {

	public static int euclid(int a, int b) {
		if (b == 0) {
			return a;
		}
		while (b != 0) {
			int r = b;
			b = a % b;
			a = r;
		}
		return a;
	}

}
