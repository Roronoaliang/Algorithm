package com.liang.util.search;

import com.liang.util.RandAndPrintUtil;
import com.liang.util.sort.HeapSort;

/**
 * @Description 在一堆海量数据中找出最大的K个数
 * @Date 2016年3月18日 下午10:37:57
 */
public class TopK {
	/**
	 * 首先构建一个具有K个元素的小顶堆，假设这K个数是最大的K个数，而根结点是这K个数中最小的，
	 * 然后遍历剩余的N-K个数，如果比根结点还大则与根结点交换，重新调整成小顶堆
	 */

	public static Integer[] topK(Integer data[], int k) {
		Integer top[] = new Integer[k];
		for (int i = 0; i < k; i++) {
			top[i] = data[i];
		}
		// 构造结点数为k的小顶堆，k-1是top数组的最后一个下标
		for (int j = ((k - 1) - 1) / 2; j >= 0; j--) {
			adjustHeap(top, j, k - 1);
		}
		for (int i = k; i < data.length; i++) {
			if (data[i] > top[0]) {
				int temp = data[i];
				data[i] = top[0];
				top[0] = temp;
				adjustHeap(top, 0, k - 1);
			}
		}
		return top;
	}

	/**
	 * 调整成小顶堆
	 * @param data 待调整序列
	 * @param node 当前结点下标
	 * @param lastIndex 待调整序列的最后一个下标
	 */
	private static void adjustHeap(Integer data[], int node, int lastIndex) {
		int i;
		int temp = data[node];
		for (i = node * 2 + 1; i <= lastIndex; i = i * 2 + 1) {
			if (i < lastIndex && data[i] > data[i + 1]) {
				i++;
			}
			if (data[i] < temp) {
				data[node] = data[i];
				node = i;
			}
		}
		data[node] = temp;
	}

	public static void main(String[] args) {
		Integer data[] = RandAndPrintUtil.randomNumber(10000);
		HeapSort.sort(data, true);
		RandAndPrintUtil.print("data", data);
		RandAndPrintUtil.print("topK", topK(data, 10));

	}
}
