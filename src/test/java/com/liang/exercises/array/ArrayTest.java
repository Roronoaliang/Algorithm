package com.liang.exercises.array;

import org.junit.Test;

import com.liang.util.RandAndPrintUtil;

/**
 * @Description 数组练习题测试
 * @Date 2016年4月11日 上午10:36:49
 */
public class ArrayTest {

	@Test
	public void sumOfArray() {
		SumOfArray soa = new SumOfArray();
		Integer arr[] = RandAndPrintUtil.randomNumber(10, 10);
		int sum = soa.sumOfArray(arr, arr.length);
		RandAndPrintUtil.print("data", arr);
		System.out.println("the sum is : " + sum);
	}

	@Test
	public void maxAndMin() {
		MaxAndMin mam = new MaxAndMin();
		Integer arr[] = RandAndPrintUtil.randomNumber(10, 50);
		RandAndPrintUtil.print("data", arr);
		mam.solution1(arr);
		mam.solution2(arr);
	}
	
	@Test
	public void moreThanHalf() {
		Integer arr[] = RandAndPrintUtil.randomNumber(7, 3);
		MoreThanHalf mth = new MoreThanHalf();
		int result = mth.solution1(arr);
		RandAndPrintUtil.print("data", arr);
		System.out.println("超过一半的数是：  " + result);
		result = mth.solution2(arr);
		System.out.println("超过一半的数是：  " + result);
	}
}
