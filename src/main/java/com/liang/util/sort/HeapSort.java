package com.liang.util.sort;


/**
 * 堆是一棵有特殊要求的完全二叉树，要么每个结点的值都大于或等于左右孩子结点的值（大顶堆），要么每个结点的值都小于或等于左右孩子结点的值（小顶堆）。
 * 对于完全二叉树按照层序遍历从上到小从左到右进行编号后能得出一些规律，比如编号为k的结点如果有左右孩子那么左右孩子的编号就是2k和2K+1(编号从1开始),
 * 所以我们可以把堆通过层序遍历与数组之间进行转换，数组头就是根结点，数组尾就是最后一个叶子结点,这样就能用顺序结构表示逻辑上的树形结构
 */

/**
 * @Description 堆排序：利用堆的特点，每次交换堆的根结点到最后一个结点，然后分离最后一个结点出堆，重新调整堆，直到堆只剩一个结点
 * 				调整（大顶）堆的过程：假设只有三个结点，那么调整成堆的过程就是先比较左右孩子的大小，取出大的与父结点比较，如果比父结点大则交换。
 * @Date 2016年3月14日 上午10:34:43
 */
public class HeapSort {

	/**
	 * 
	 * @param nums
	 * @param isStart0s
	 *            true表示第0个位置存储真实数据，否则从1开始
	 * @return
	 */
	public static void sort(Integer nums[], boolean isStart0) {
		if (isStart0) {
			start0(nums);
		} else {
			start1(nums);
		}
	}

	/**
	 * 数据从下标1开始，因此结点n的左右孩子结点分别是2*n、2*n+1，父结点是n/2
	 * 
	 * @param nums
	 * @return
	 */
	private static void start1(Integer[] data) {
		int i;
		// 初始化构造堆
		for (i = data.length / 2; i > 0; i--) {
			heapAdjust1(data, i, data.length - 1);
		}
		// 循环交换根结点到堆外，调整堆
		for (i = data.length - 1; i >= 1; i--) {
			int temp = data[1];
			data[1] = data[i];
			data[i] = temp;
			heapAdjust1(data, 1, i - 1);
		}
	}

	/**
	 * 
	 * @param nums
	 *            待调整成堆的序列
	 * @param index
	 *            待调整的结点
	 * @param length
	 *            待调整序列元素个数
	 */
	private static void heapAdjust1(Integer nums[], int index, int lastIndex) {
		int temp = nums[index];
		int j;
		for (j = index * 2; j <= lastIndex; j *= 2) {
			if (j < lastIndex && nums[j] < nums[j + 1]) {
				j++;
			}
			if (nums[j] > temp) {
				nums[index] = nums[j];
				index = j;
			}
		}
		nums[index] = temp;
	}

	/**
	 * 数据从下标0开始
	 * 
	 * @param nums
	 *            待排序序列,下标为0的数组元素存储真实数据，则结点n的左右孩子分别为（2n+1）、（2n+2）,父结点为(n- 1)/2
	 * @return 已按从小到大排序的数组
	 */
	private static void start0(Integer data[]) {
		int i;
		// 从编号为(n-1)/2的结点开始,自下而上的调整，初始化构成一个大顶堆
		for (i = (data.length - 1) / 2; i >= 0; i--) {
			adjustHeap0(data, i, data.length - 1);
		}
		// 交换根结点与最后一个叶子结点，重新调整成大顶堆
		for (i = data.length - 1; i >= 0; i--) {
			int temp = data[i];
			data[i] = data[0];
			data[0] = temp;
			adjustHeap0(data, 0, i - 1);
		}

	}

	/**
	 * 调整堆的过程：从下往上选取编号最大的非叶子结点（结点编号为n/2），把它视为根结点，比较它的左右孩子结点，得到其中较大的那个与当前结点进行比较 ，
	 * 如果比当前结点大就进行交换， 否则不交换；然后用同样的方法将该结点和它的子树构造成堆。一直调整到从根结点开始整棵树都符合堆的定义。
	 * 
	 * @param nums
	 *            待排序序列
	 * @param index
	 *            当前需要调整的结点下标
	 * @param length
	 *            堆结点个数
	 */
	private static void adjustHeap0(Integer nums[], int index, int lastIndex) {
		int temp = nums[index];
		for (int i = 2 * index + 1; i <= lastIndex; i = i * 2 + 1) { // 注意此处左孩子下标为2*i+1
			if (i < lastIndex && nums[i] < nums[i + 1]) { // i<length-1防止i+1越界
				i++; // 用i标识较大的孩子结点
			}
			if (temp < nums[i]) { // 当前结点比左/右孩子小则交换
				nums[index] = nums[i];
				index = i;
			}
		}
		nums[index] = temp;
	}
	
}
