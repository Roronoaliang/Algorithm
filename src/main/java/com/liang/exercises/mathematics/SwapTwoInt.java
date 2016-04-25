package com.liang.exercises.mathematics;

import com.liang.util.RandAndPrintUtil;

/**
 * @Description 交换两个整型变量的值,以下示例代码不考虑数组越界问题
 * @Date 2016年4月3日 下午3:49:40
 */
public class SwapTwoInt {

	/**
	 * 使用中间变量交换
	 * 
	 * @param arr
	 * @param a
	 * @param b
	 */
	public static void swapWithTemp(Integer arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	/**
	 * 使用加法交换
	 * 
	 * @param arr
	 * @param a
	 * @param b
	 */
	public static void swapWithAddition(Integer arr[], int a, int b) {
		arr[a] = arr[a] + arr[b];
		arr[b] = arr[a] - arr[b];
		arr[a] = arr[a] - arr[b];
	}

	/**
	 * 使用异或运算交换两个数： 异或运算的规则：<br/>
	 * 对于每一个二进制位 1^0=1,0^0=0,1^1=0,即两个二进制不同才等于1<br/>
	 * 因此,任何数异或0仍等于原来的数,任何数与自身异或结果都为0，即a^0=a, b^b=0,<br/>
	 * 因此可以得到异或运算的一条规律：<br/>
	 * a^b^a=b.这也是异或运算的自反性。
	 * 
	 * 如果要交换的两个数指向的地址相同，那么第一步异或结果就为0，导致最终该数只能为0，最终结果就会出错。
	 * 
	 * @param arr
	 * @param a
	 * @param b
	 */
	public static void swapWithXOR(Integer arr[], int a, int b) {
		if(a == b) {
			System.out.println("指向同一个数不能进行异或运算来交换");
			return;
		}
		arr[a] = arr[a] ^ arr[b];
		arr[b] = arr[a] ^ arr[b]; // 相当于b = (a^b^b == a)
		arr[a] = arr[a] ^ arr[b]; // 相当于a = (a^a^b == b)
	}

	/**
	 * 使用乘法进行交换,会存在溢出问题和除0异常
	 * 
	 * @param arr
	 * @param a
	 * @param b
	 */
	public static void swapWithMulti(Integer arr[], int a, int b) {
		if (arr[a] == 0 || arr[b] == 0) {
			System.out.println("交换数中包含0无法交换");
			return;
		}
		try {
			arr[a] = arr[a] * arr[b];
			arr[b] = arr[a] / arr[b];
			arr[a] = arr[a] / arr[b]; // 此处仍有可能产生除0异常，并且会导致原始数据被破坏
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		 Integer arr[] = RandAndPrintUtil.randomNumber(2);
//		Integer arr[] = { 2147483647, -2147483647 };
		RandAndPrintUtil.print("initial data", arr);
		swapWithTemp(arr, 0, 1);
		RandAndPrintUtil.print("swapWithTemp", arr);
		swapWithAddition(arr, 0, 1);
		RandAndPrintUtil.print("swapWithAddtion", arr);
		swapWithXOR(arr, 0, 1);
		swapWithXOR(arr, 0, 0); //如果swap函数不加判断此时会发生错误
		RandAndPrintUtil.print("swapWithXOR", arr);
		swapWithMulti(arr, 0, 1);
		RandAndPrintUtil.print("swapWithMulti", arr);
	}
}
