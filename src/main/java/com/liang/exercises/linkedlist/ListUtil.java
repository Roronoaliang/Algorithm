package com.liang.exercises.linkedlist;

import com.liang.util.RandAndPrintUtil;

/**
 * @Date 2016年4月24日 下午10:34:16
 */
public class ListUtil {

	/**
	 * 创建单链表
	 * 
	 * @param n
	 * @return
	 */
	public static ListNode create(int n) {
		Integer arr[] = RandAndPrintUtil.randomNumber(n, 50);
		ListNode head = new ListNode(arr[0]);
		ListNode p = head;
		for (int i = 1; i < n; i++) {
			p.next = new ListNode(arr[i]);
			p = p.next;
		}
		RandAndPrintUtil.print("生成的链表：", arr);
		return head;
	}
}
