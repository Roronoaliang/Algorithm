package com.liang.util.sort;

/**
 * @Description 希尔排序
 * @Date 2016年3月14日 上午9:28:19
 */
public class HillSort {

	/**
	 * 希尔排序：相当于直接插入排序的改进版<br/>
	 * 基本做法是选取一个增量，按增量将原序列分成若干组，这样每个子序列待排序的元素就少了，
	 * 然后分别在这些子序列中应用直接插入排序,减小增量重复这样的操作直到增量为1算法结束<br/>
	 * 时间复杂度与增量的选取有关,属于非稳定排序
	 * 
	 * @param nums
	 * @return
	 */
	public static void sort(int data[]) {
		int i, j, k;
		int increment = data.length;
		while (increment > 1) {
			increment = increment / 3 + 1; // 增量公式可以自定义,但必须最终能使increment等于1
			//下面其实就是直接插入排序，只不过"相邻"元素之间间隔为increment
			for (i = increment; i < data.length; i++) { 
				k = data[i];
				for (j = i - increment; j >= 0 && k < data[j]; j -= increment) {
					data[j + increment] = data[j];// 移位操作
				}
				data[j + increment] = k;
			}
		}
	}

}
