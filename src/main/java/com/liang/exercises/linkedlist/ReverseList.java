package com.liang.exercises.linkedlist;

/**
 * @Description 输入一个链表，反转链表后，输出链表的所有元素。
 * 
 * @Solution1：使用递归，如果没有指向任何结点，则返回，如果只有一个结点也返回，如果有两个结点则改变指针的指向返回新头结点，递归回上一层栈帧同样执行修改指针指向，返回头结点操作
 * 
 * @Solution2：创建一个新的头结点，依次摘下原链表中每一个结点，使用头插法插入新链表中,由于这里讨论的是无头结点的情况，所以最后要返回新头结点的next结点
 * 
 * @Solution3：使用三个指针分别指向当前需要修改指针的结点、前驱结点、后继结点。
 * @Date 2016年3月28日 下午3:23:31
 */
public class ReverseList {

	/**
	 * 递归逆置链表
	 * 
	 * @param head
	 * @return
	 */
	public ListNode solution1(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode p = head;
		ListNode q = p.next;
		head = solution1(p.next);
		q.next = p;
		p.next = null;
		return head;
	}

	/**
	 * 头插法逆置链表
	 * 
	 * @param head
	 * @return
	 */
	public ListNode solution2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = new ListNode(0);
		while (head != null) {
			ListNode p = head.next;
			head.next = newHead.next;
			newHead.next = head;
			head = p;
		}

		return newHead.next;
	}

	/**
	 * 使用三个指针分别指向当前需要修改指针的结点、前驱结点、后继结点
	 * 
	 * @param head
	 * @return
	 */
	public ListNode solution3(ListNode head) {
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
