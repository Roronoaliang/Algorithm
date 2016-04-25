package com.liang.util.sort;

import org.junit.BeforeClass;
import org.junit.Test;

import com.liang.util.RandAndPrintUtil;
import com.liang.util.sort.BubbleSort;
import com.liang.util.sort.DirectInsertSort;
import com.liang.util.sort.HeapSort;
import com.liang.util.sort.HillSort;
import com.liang.util.sort.MergeSort;
import com.liang.util.sort.QuickSort;
import com.liang.util.sort.QuickSort2;
import com.liang.util.sort.SimpleSelectSort;

public class SortTest {

	private static Integer nums[][];

	@BeforeClass
	public static void initData() {
		nums = new Integer[10][50];
		Integer a[] = RandAndPrintUtil.randomNumber(50, 1000);
		for (int i = 0; i < 10; i++) {
			nums[i] = a.clone();
		}
	}

	@Test
	public void bubbleTest() {
		BubbleSort.sort(nums[0]);
		RandAndPrintUtil.print("bubbleSort", nums[0]);
	}

	@Test
	public void bubbleTest2() {
		BubbleSort.sortImprove(nums[1]);
		RandAndPrintUtil.print("bubbleSortImprove", nums[1]);
	}

	@Test
	public void simpleSelectTest() {
		SimpleSelectSort.sort(nums[2]);
		RandAndPrintUtil.print("simpleSelect", nums[2]);
	}

	@Test
	public void directInsertTest() {
		DirectInsertSort.sortAsc(nums[3]);
		RandAndPrintUtil.print("directInsert", nums[3]);
	}

	@Test
	public void HillTest() {
		HillSort.sort(nums[4]);
		RandAndPrintUtil.print("hillSort", nums[4]);
	}

	@Test
	public void heapTest() {
		HeapSort.sort(nums[5], true);
		RandAndPrintUtil.print("heapSort", nums[5]);
	}

	@Test
	public void mergeTest() {
		MergeSort.sortWithRecursion(nums[6]);
		RandAndPrintUtil.print("merge_Recursion", nums[6]);
	}

	@Test
	public void mergeTest2() {
		MergeSort.mergeWithIteration(nums[7]);
		RandAndPrintUtil.print("merge_iteration", nums[7]);
	}

	@Test
	public void quickTest() {
		QuickSort.sort(nums[8]);
		RandAndPrintUtil.print("quickSort", nums[8]);
	}

	@Test
	public void quickTest2() {
		QuickSort2.sort(nums[9]);
		RandAndPrintUtil.print("quickSort2", nums[9]);
	}
	
}
