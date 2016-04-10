package com.liang.exercises.linkedlist;

/**
 * @Description 输入一个链表，反转链表后，输出链表的所有元素。
 * @Date 2016年3月28日 下午3:23:31
 */
public class ReverseList {
	
	/**
	 * 逆置方式一：使用三个指针分别指向当前需要修改指针的结点、前驱结点、后继结点
	 * @param head
	 * @return
	 */
	public ListNode reverse_1(ListNode head) {
		if (head == null || head.next == null) { // 如果链表为空或者只有一个结点则不需要逆置直接返回
			return head;
		}
		ListNode pre = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next; // 记录当前要逆置的结点的下一个结点
			cur.next = pre; // 改变当前结点的next指针
			pre = cur; // 把前置结点的指针向前移动一位
			cur = next; // 当前需要逆置的结点指针向前移动一位
		}
		return pre;
	}
	
}
