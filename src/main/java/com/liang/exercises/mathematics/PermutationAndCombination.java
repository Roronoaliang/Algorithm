package com.liang.exercises.mathematics;

/**
 * @Description 排列与组合
 * @Date 2016年4月4日 上午9:48:46
 */
public class PermutationAndCombination {

	/**
	 * 排列公式：A(n, m) = n!/(n-m)!, 如A(5, 2) = (5*4*3*2*1)/(3*2*1) = 20
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	public static int pailie(int n, int m) {
		int result = 1;
		for (int i = n, j = 0; j < m; i--, j++) {
			result *= i;
		}
		return result;
	}

	/**
	 * 组合公式: C(n, m) = = A(n, m) / m! = n!/(m!*(n-m)!), 如C(5, 2) = 10
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	public static int zuhe(int n, int m) {
		int result = pailie(n, m);
		for (int i = m; i > 1; i--) {
			result /= m;
		}
		return result;
	}

}
