package com.liang.exercises.mathematics;

/**
 * @Description 一只青蛙一次可以跳1级台阶，也可以跳2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @Solution1 假设跳到第n阶有f(n)种跳法，那么跳到第n阶可以先跳n-1阶再跳1阶，也可以先跳n-2阶再跳2阶,可以推出
 *            f(n)=f(n-1)+f(n-2);
 * @Solution2 由解法一可知是斐波那契数列，因此也可使用迭代实现
 * @Date 2016年4月4日 上午8:22:38
 */
public class JumpFloor1 {

	public static int solution1(int n) {
		if (n <= 2) {
			return n;
		} else {
			return solution1(n - 1) + solution1(n - 2);
		}
	}

	public static int solution2(int n) {
		if (n <= 2) {
			return n;
		} else {
			int count = 0, oneStep = 1, twoStep = 1;
			for (int i = 2; i <= n; i++) {
				count = oneStep + twoStep; // 相当于求f(n) = f(n-1) + f(n-2)
				twoStep = oneStep;
				oneStep = count;
			}
			return count;
		}
	}

	public static void main(String[] args) {
		System.out.println(solution1(5));
		System.out.println(solution2(5));
	}

}
