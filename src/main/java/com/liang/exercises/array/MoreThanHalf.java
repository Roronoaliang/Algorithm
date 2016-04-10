package com.liang.exercises.array;

import com.liang.util.RandAndPrintUtil;

/**
 * @Description
 * @Solution
 * @Date 2016年4月7日 下午1:12:12
 */
public class MoreThanHalf {

	// 打擂台方式
	public int MoreThanHalfNum_Solution(int[] array) {
		//容错判断
		if (array == null || array.length == 0) {
			return 0;
		}
		//只有一个元素的特殊情况
		if(array.length == 1) {
			return array[0];
		}
		
		int target = array[0]; //擂台数
		int count = 1; //初始出现次数
		int lastCount = 0; //考虑到奇数个数的序列，有可能删到最后剩下最后一个元素,但其出现次数没有达到一半以上
		for (int i = 1; i < array.length; i++) {
			if(array[i] == array[array.length -1]) { //单独统计最后一个元素出现的次数
				lastCount++;
			}
			//打擂台
			if (array[i] == target) { 
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				target = array[i+1];
			}
		}
		//偶数个数的序列且没有满足条件的数则最后count等于0
		if(count == 0) {
			return 0;
		}
		//如果剩下的数刚好是最后的一个数，需要进一步判断
		if(target == array[array.length - 1]) {
			if(lastCount > array.length /2) {
				return target;
			}
			return 0;
		}
		return target;
	}

	public static void main(String[] args) {
		MoreThanHalf m = new MoreThanHalf();
//		int a[] = RandAndPrintUtil.randomNumber(7, 3);
		int a[] = {2,2,2,2,2,1,3,4,5}; 
		int c = m.MoreThanHalfNum_Solution(a);
		RandAndPrintUtil.print("", a);
		System.out.println(c);
	}
}
