# 基本排序算法

标签（空格分隔）： 数据结构&算法
---

* [1.冒泡排序](#1)
* [2.简单选择序](#2)
* [3.直接插入排序](#3)
* [4.希尔排序](#4)
* [5.归并排序](#5)
* [6.堆排序](#6)
* [7.快速排序](#7)

### <span id="1">**冒泡排序**<span>
&emsp;&emsp;冒泡排序的思想是通过两两比较交换，在第i趟排序中，将当前未排序中的最小或最大的元素上升到第i个位置。
&emsp;&emsp;时间复杂度：O（n²）
```
public void bubbleSort(int arr[]) {
    for(int i = 0; i < arr.length; i++) {
        for(int j = arr.length - 2; j >= i; j--) {
            if(arr[j] > arr[j+1]) {
                swap(arr, j, j+1);
            }
        }
    }
}

private void swap(int arr[], int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
}
```

&emsp;&emsp;冒泡的优化：对于基本有序的序列，可能会提前达到有序，而导致后面做了很多无用的循环，因此改进点在于在序列达到有序之后能提前结束，退出比较过程。为此设置一个boolean类型的标志变量，在进行一趟扫描前设置为false，如果扫描过程中发生了交换，则修改标志变量为true，当一趟扫描中没有发生任何交换时说明序列已经有序，据此退出排序过程。
```
public void bubbleSort(int arr[]) {
    boolean flag = true; //设置标志变量
    for(int i = 0; i < arr.length && flag; i++) {
        flag = false;
        for(int j = arr.length - 2; j >= i; j++) {
            if(arr[j] > arr[j+1]) {
                swap(arr, j, j+1);
                flag = true;
            }
        }
        if(!flag) { //当一趟扫描没有发生交换则退出排序
           return;
        }
    }
}
```

### <span id="2">**简单选择排序**</span>
&emsp;&emsp;基本思想是在第i趟扫描无序的序列中，记录下最小或者最大的元素的下标，最后与下标为i的元素进行交换。简单选择比冒泡排序略优，因为交换的次数比冒泡排序少。
&emsp;&emsp;时间复杂度:O(n²)
```
public void simpleSelectSort(int arr[]) {
    for(int i = 0; i < arr.length; i++) {
        int min = i;
        for(int j = i+1; j < arr.length; j++) {
            if(arr[j] < arr[min]) {
                min = j;
            }
        }
        if(min != i) {
            swap(arr, min, i);
        }
    }
}
```

### <span id="3">**直接插入排序**</span>
&emsp;&emsp;基本思想是将待排序的元素直接插入到有序的序列中,排序的过程是首先将序列看成有序和无序的两部分，然后每次从无序序列中拿取第一个数从右到左依次与有序序列中的元素进行比较，直到找到合适的插入位置。
&emsp;&emsp;时间复杂度：O(n²)
```
/**
 * 
 *        1.外层循环决定当前判断元素，因为可以第一个元素当成有序集合中的元素，
 *          以此减少一次循环，所以外层循环从集合的第二个元素即下标为1的元素开始循环；
 *        2.外层循环选定的元素用使用一个临时变量进行存储，以免后边移位操作将值覆盖；
 *        3.内层循环确定元素插入的位置，即取外循环选定的元素的上一位开始，
 *          依次与外层循环选定的元素进行比较直到找到插入位置或比较到第一个元素；
 *        4.比较的结果：若内层循环选定的元素比待插入的元素小，则讲当前被比较元素向后移一位，即下标加1；
 *          若内层循环选定的元素比待插入的元素大，则循环结束，并将待排序元素插入到比其大的元素的后一位
 */
public  void directInsertSort(int arr[]) {
   int i, j, k;
   for(i = 1; i < arr.length; i++) { //外层循环遍历无序集合
        k = arr[i];
        for(j = i - 1; j >= 0 && k < arr[j]; j--) { //内层循环遍历有序集合
            arr[j+1] = arr[j]; //移位操作
        }
        arr[j+1] = k;
    }
}
```

![](http://ww4.sinaimg.cn/large/0065HC85gw1f01porh8dqj30i30bzac0.jpg)
![](http://ww3.sinaimg.cn/large/0065HC85gw1f01pq6the7j30i6090jst.jpg)
![](http://ww3.sinaimg.cn/large/0065HC85gw1f01pr78xxxj30hz0613z5.jpg)![](http://ww2.sinaimg.cn/large/0065HC85gw1f01psk8rpqj30hr0j1q5s.jpg)

&emsp;&emsp;以上三种简单排序在相同情况下，效率一般是**直接插入排序>简单选择排序>冒泡排序**，由于三种排序的平均时间复杂度都是O(n²)，当**数据量较小且序列基本有序**的情况下尽量选择直接插入排序，这也是直接插入排序的适用场景，下面的希尔排序与冒泡排序的优化都利用了该特点。

### <span id="4">**希尔排序**</span>
&emsp;&emsp;希尔排序可以说是对直接插入排序的升级，前面我们讲过直接插入排序适用于**数据量较少且基本有序**的场景，那么能不能将数据量大且数据是杂乱无章的序列转化成有利于直接插入排序的情况呢？答案是可以的，希尔排序正是做到了这一点。
&emsp;&emsp;希尔排序采用了分治的思想，将待排序序列根据某个增量分割成若干个子序列，这样每个序列待排序的元素个数就比较少了，然后对每个子序列单独进行直接插入排序，接着缩小增量，继续以上的操作，直到最后增量为1，对整个序列进行一次直接插入排序。

```
public void hillSort(int arr[]) {
    int i, j, k;
    int increment = arr.length;
    while(increment > 1) {
        increment /= 3; //注意增量公式的选取必须要使其最终能小于等于1，否则陷入死循环
        for(i = increment; i < arr.length; i++) {
            k = arr[i];
            for(j = i - increment; i >= 0 && k < arr[j]; i -= increment) {
                arr[j+increment] = arr[j];
            }
            arr[j+increment] = k;
        }
    }
}
```
![希尔排序](http://ww3.sinaimg.cn/large/bc18b842gw1f36zzsm8crj20fu08y3zd.jpg)

&emsp;&emsp;希尔排序的缺点是**效率与增量公式的选取有关**，对于一个序列很难确定选取怎样的公式能使时间复杂度达到最小，并且由于希尔排序是跳跃性的交换元素，所以属于非稳定排序。

### <span id="5">**归并排序**</span>
&emsp;&emsp;归并排序也是一种采用分治思想的排序算法，这里主要介绍“二路归并”，即每一次都是合并两个有序集合为一个有序集合。
&emsp;&emsp;归并排序的基本思路是将含有n个元素的序列看成n个有序子序列，每个子序列只含有一个元素，然后每两个子序列进行合并，变成长度为2或1的有序子序列，然后重复执行两两合并的步骤，一直到合并为长度为n的有序序列。
&emsp;&emsp;归并排序可以使用递归和非递归的方式实现。
&emsp;&emsp;**递归实现**：递归的过程是为了将n个元素的无序集递归划分成n个只含一个元素的有序子集。递归的过程是首先将原始序列划分为左右两部分，然后对左右两部分递归进行划分直至最终每个子序列只剩一个元素。最后从递归栈的底层开始执行归并操作直至栈顶。
&emsp;&emsp;递归的时间复杂度：O(nlogn)，空间复杂度是O(n+logn)——需要n个辅助存储空间存放归并的结果集合logn深度的递归栈空间
```
public void mergeSort(int arr[]) {
		partition(arr, 0, arr.length - 1);
}

// 递归划分子序列
private void partition(int arr[], int low, int high) {
	if (low < high) {
	    int mid = (low + high) / 2;
		partition(arr, low, mid);
		partition(arr, mid + 1, high);
		merge(arr, low, mid, high);
	}
}

// 归并函数
private void merge(int arr[], int low, int mid, int high) {
	// 将两个子序列分别复制到辅助存储数组中
	int[] left = new int[mid - low + 1];
	int[] right = new int[high - mid];
	for (int i = low; i <= mid; i++) {
		left[i - low] = arr[i];
	}
	for (int i = mid + 1; i <= high; i++) {
		right[i - mid - 1] = arr[i];
	}
	// 合并两个子数组回arr
	int k = low;
	int i = 0, j = 0;
	while (i < left.length && j < right.length) {
		if (left[i] <= right[j]) {
			arr[k++] = left[i++];
		} else {
			arr[k++] = right[j++];
		}
	}
	while (i < left.length) {
		arr[k++] = left[i++];
	}
	while (j < right.length) {
		arr[k++] = right[j++];
	}
}
```
&emsp;&emsp;**非递归实现**:采用迭代的方式不需要递归的去拆分序列，而是设置一个变量作为归并的步长，也即记录每次归并的子序列长度，并用四个变量（指针）指示当前归并的两个子序列边界，然后合并这两个子序列，每对完整序列归并完一趟就将步长乘以2，继续下一趟归并，直到归并的步长大于等于序列长度排序完成。
&emsp;&emsp;迭代的方式避免了logn深度的栈空间，空间复杂度只需要O(n)，因此使用迭代的方式优于递归的方式。
```
public void mergeSort(int arr[]) {
		// 声明临时数组和四个变量指示左右子序列的边界
		int[] temp = new int[arr.length];
		int lMin, lMax, rMin, rMax;
		// 外层循环依次扩大步长：1、2、4、8...直到大于等于数组长度
		for (int step = 1; step < arr.length; step *= 2) {
		// 在每趟归并过程中从0号元素开始根据当前的步长依次划分两个子序列，并进行归并
			for (lMin = 0; lMin + step < arr.length; lMin = rMax) { 
				// 划分子序列的边界
				lMax = rMin = lMin + step;
				rMax = rMin + step;
				// 防止右序列右边界越界,注意rMax指向的是最右边元素的下一个，因此是data.length
				if (rMax > arr.length) {
					rMax = arr.length;
				}
				// 归并两个有序序列
				int k = 0;
				while (lMin < lMax && rMin < rMax) {
					if (arr[lMin] <= arr[rMin]) {
						temp[k++] = arr[lMin++];
					} else {
						temp[k++] = arr[rMin++];
					}
				}
			   /**
			    * 如果左边还有没遍历到的说明左边剩下的都是比temp数组中的数要大，则在
				* 原始数组中按原来的顺序复制到右边子序列中(如果右边还有没遍历到的说明
				* 都是比temp数组中的数要大的，但是只要待在原位就行了，不需要移动)
				*/
				while (lMin < lMax) {
					arr[--rMin] = arr[--lMax];
				}
				// 把temp数组中的数据复制回原始数组中
				while (k > 0) {
					arr[--rMin] = temp[--k];
				}
			}
		}
	}
```
![](http://ww3.sinaimg.cn/large/bc18b842gw1f373p77ajij20oh0npq79.jpg)

&emsp;&emsp;**归并排序优点是其最坏和平均时间复杂度都是O(nlogn),并且是稳定排序，适用于要求稳定排序的场景，缺点是递归实现需要O(n+logn)、非递归实现需要O(n)的空间复杂度，不适用与于存资源紧张的场景**。

### <span id="6">**堆排序**<span>
&emsp;&emsp;堆排序与简单选择排序一样属于选择排序类，可以看成是简单选择排序的升级版。其主要是利用堆这种数据结构进行排序。
&emsp;&emsp;**堆**：堆是一棵有特殊性质的完全二叉树，要么每个结点的值都大于等于左右孩子结点的值（大顶堆），要么每个结点的值都小于等于左右孩子结点的值（小顶堆）。由于堆是一棵完全二叉树，因此在数组中对于下标为i的结点，如果其有左右孩子的话，其左孩子下标为 **2*i+1**, 右孩子下标为 **2*i+2** (根结点下标为0的情况下)。
&emsp;&emsp;**堆排序的过程**：堆排序的过程是首先将待排序序列调整成大顶堆或者小顶堆，然后将根结点与堆中最后一个结点交换，将交换后的最后一个结点脱离出堆，对剩余元素重新调整成堆，然后重复交换根结点和最后一个叶子结点、调整成堆的操作，直到堆中无结点。
&emsp;&emsp;**建堆的过程**：从下往上选取编号最大的**非叶子结点**（编号为(n-1)/2），将其标记为当前结点，比较它的左右孩子结点，得到其中较大的那个再与当前结点进行比较，如果比当前结点大就进行交换，否则不交换；然后用同样的方法将该结点和它的子树构造成堆。一直调整到从根结点开始整棵树都符合堆的定义。
&emsp;&emsp;**堆排序的时间复杂度为O(nlogn)，需要一个辅助存储空间存储当前需要调整的结点。其优点是其最坏、平均时间复杂度都是O(nlogn)，空间复杂度也比归并排序小得多，适用于需要保证最坏时间复杂度的情况。缺点是第一次建堆需要比较的次数较多，因此不适合带排序序列个数较少的情况。**

```
public void heapSort(int arr[]) {
	//从下到上构造堆
    for(int i = (arr.length - 1) / 2; i >= 0; i--) {
	   adjustHeap(arr, i, arr.length - 1);
	}
    //不断交换结点，重新调整成堆
    for(int i = arr.length - 1; i >= 0; i--) {
        swap(arr, 0, i);
        adjustHeap(arr, 0, i - 1); 
	}
}

private void adjustHeap(int arr[], int target, int lastIndex) {
    int temp = arr[target];
	for(int i = target*2+1; i <= lastIndex; i = i*2+1) {
	    //选出左右孩子中较大的一个跟当前结点比较
        if(i < lastIndex && arr[i+1] > arr[i]) {
            i++;
	    }
        if(arr[i] > temp) {
            arr[target] = arr[i];
            target = i;
	    }
	}
	arr[target] = temp;
}
```

### <span id="7">**快速排序**</span>
&emsp;&emsp;快速排序也是一种利用**分治**思想进行排序的算法，其排序过程是在每一趟排序过程中选择一个数作为中轴数进行划分， 将比中轴数大的元素放在其右边，比中轴数小的元素放在其左边，然后递归划分左右两个子序列，直到子序列的长度为1。
&emsp;&emsp;**快速排序的平均时间复杂度是O(nlogn)，最坏时间复杂度是O(n²),由于采用递归，所以需要O(logn)的空间复杂度，同时快速排序是一种跳跃交换的排序算法，因此也是不稳定排序。并且对于基本有序或者待排序序列的元素个数较少的情况下由于不能缩小问题的规模，快速排序的效率会大幅度下降，因此快速排序的缺点是在不能缩小问题规模的情况下时间复杂度会下降，不适用与个数少和序列基本有序的情况。**

```
public void quickSort(int arr[]) {
    sort(arr, 0, arr.length - 1);  
}

private void sort(int arr[], int low, int high) {
    if(low < high) {
        int pivot = partition(arr, low, high); //进行一次划分
        sort(arr, low, pivot - 1); //递归划分左子序列
        sort(arr, pivot + 1, high); //递归划分右子序列
    }
}

private int partition(int arr[], int low, int high) {
    int pivot = arr[low]; //选取第一个元素作为中轴值
    while(low < high) {
        while(low < high && arr[high] >= pivot) { // 从high处开始移动指针
            high--;
        }
		swap(nums, low, high); // 交换小的数据到中轴值左边
        while(low < high && arr[low] <= pivot) { // 转而从low处开始移动指针
            low++;
        }
		swap(nums, low, high);// 交换大的数据到中轴值右边
    }
    return low;
}
```

**快排优化**:
> 
1. 优选中轴值：如果每次都取第一个元素作为中轴值，可能无法缩小问题的规模，那么可以采用随机选取中轴值或者“三数取中”、“九数取中”等等方法选取中轴值
2. 减少交换的次数：利用一个临时变量存储中轴值，将交换的操作改为直接覆盖，最后当row指针和high指针重合时，将中轴值替换回row指针处
3. 前面说过快排对小数组和基本有序的序列效率较差，而直接插入排序则适用于这种场合，因此可以设置一个阀值，当子序列长度大于阀值时使用快排，而当子序列长度小于阀值时改用直接插入排序。
4. 利用尾递归优化将最后的两次递归操作改为一次递归操作，减少递归次数。

```
private static final int Threshold = 10; // 设置阀值

public void sort(int arr[]) {
	quickSort(arr, 0, arr.length - 1);
}

private void quickSort(int arr[], int low, int high) {
	int pivotkey;
	if ((high - low) > Threshold) { //优化方式三：如果序列长度大于阀值则使用快排，否则使用直接插入排序
		while (low < high) {
			pivotkey = partition(arr, low, high); // 划分成两部分
			quickSort(arr, low, pivotkey - 1); // 对左子序列递归使用快排
			low = pivotkey + 1; // 优化方式四：使用尾递归减少递归次数
		}
	} else {
		insertSort(arr);
	}
}

private int partition(int arr[], int low, int high) {
	int pivotkey = calculPivot(arr, low, high); // 三数取中优选中轴值
	int pivotvalue = arr[pivotkey]; // 设置辅助变量存储中轴值

	while (low < high) { // 从序列的两端交替向中间扫描
		high--;
	}
	arr[low] = arr[high]; // 优化方式二：改交换为直接替
	while (low < high && arr[low] <= pivotvalue) {
		low++;
	}
	arr[high] = arr[low]; // 直接替换
	arr[low] = pivotvalue; // 将中轴值替换回去
	return low;
}

//优化快排方式1：优选中轴值下标,采用三数取中的方法
private int calculPivot(int arr[], int low, int high) {
	int mid = (low + high) / 2; // 计算数组中间元素下标
	// 使high的元素最大，low的元素居中，mid的元素最小
	if (arr[low] > arr[high]) {
		swap(arr, low, high);
	}
	if (arr[mid] > arr[high]) {
		swap(arr, mid, high);
	}
	if (arr[low] < arr[mid]) {
		swap(arr, low, mid);
	}
	return low;
}


//直接插入排序
private void insertSort(int arr[]) {
	int i, j, k;
	for (i = 1; i < arr.length; i++) {
		k = arr[i];
		for (j = i - 1; j >= 0 && k < arr[j]; j--) {
		arr[j + 1] = arr[j];
		}
		arr[j + 1] = k;
	}
}
```
