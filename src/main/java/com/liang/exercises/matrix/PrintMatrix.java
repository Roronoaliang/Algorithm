package com.liang.exercises.matrix;

/**
 * @Description 打印矩阵 
 * @Date 2016年3月20日 下午10:10:58
 */
public class PrintMatrix {

	public static void main(String[] args) {
		int[][] a = { { 4, 46, 89 }, { 28, 66, 99 }, { 26, 21, 71 } };
		Circleprint(a, 3, 3);
	}

	/**
	 * 顺时针绕圈打印矩阵并返回存储该顺序的数组
	 * TODO 错误
	 * @param mat
	 * @param n
	 * @param m
	 * @return
	 */
	public static int[] Circleprint(int[][] mat, int n, int m) {
		int li = 0, lj = 0, ri = n - 1, rj = m - 1;
		int temp[] = new int[n * m];
		int index = 0;

		while (index < temp.length) {
			if (li == ri && lj == rj) {
				temp[index++] = mat[li][lj];
				break;
			}
			// 遍历上边界
			for (int i = lj; i < rj; i++) {
				temp[index++] = mat[li][i];
			}
			// 遍历右边界
			for (int i = li; i < ri; i++) {
				temp[index++] = mat[i][rj];
			}
			// 遍历下边界
			for (int i = rj; i > lj; i--) {
				temp[index++] = mat[ri][i];
			}
			// 遍历左边界
			for (int i = ri; i > li; i--) {
				temp[index++] = mat[i][lj];
			}
			// 定位新矩阵边界
			li++;
			lj++;
			ri--;
			rj--;
		}
		// 打印数组值
		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i] + "\t");
		}
		return temp;
	}

	/**
	 * 按行的顺序打印矩阵
	 * 
	 * @param data
	 */
	public static void print(int[][] data) {
	}
}
