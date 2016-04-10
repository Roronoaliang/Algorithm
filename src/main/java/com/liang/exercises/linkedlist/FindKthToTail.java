package com.liang.exercises.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 输入一个链表，输出该链表中倒数第k个结点。
 * @Solution1 
 *             对于单链表无法在遍历到末尾后进行回溯，那么可以用一个变量记录单链表的长度，即每遍历一个结点就使变量值+1，并把结点值存入一个数组中;
 *             最终就能将单链表转换成数组并得到其长度，那么倒数第k个元素就是数组的第n-k+1个元素。<br/>
 *             、
 * @Solution2 另一种思路是使用快慢指针：利用两个指针,第一个指针先前进k-1,然后从k-1开始两个指针同时向前移进，
 *             当前面的指针走到最后一个结点时后面的指针刚好在倒数第n个结点处
 *             （快慢指针也可以用来求链表的中间结点——一个指针移动一步，一个指针移动两步，当fast指针移动到末尾的时候slow指针即指向中间结点）
 * @Date 2016年3月26日 下午9:58:56
 */

public class FindKthToTail {

	public ListNode sulution1(ListNode head, int k) {
		List<ListNode> list = new ArrayList<ListNode>();
		int count = 0;
		ListNode p = head;

		while (p != null) {
			count++;
			list.add(p);
			p = p.next;
		}
		if (k < 1 || count < k) {
			return null;
		}
		return list.get(count - k);
	}
	
	public ListNode solution2(ListNode head, int k) {
		ListNode front = head, behind = head;
		//前面的指针先走k-1步
		for(int i = 0; i < k; i++) {
			if(front == null) {
				return null;
			}
			front = front.next;
		}
		//前面与后面的指针同时走直到前面的指针走到末尾
		while(front != null) {
			front = front.next;
			behind = behind.next;
		}
		return behind;
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(0);
		ListNode head = node;
		for (int i = 0; i < 10; i++) {
			node.next = new ListNode(i * 2 + 1);
			node = node.next;
		}
		FindKthToTail fktt = new FindKthToTail();
		ListNode no = fktt.sulution1(head, 1);
		System.out.println(no.val);
	}
}
