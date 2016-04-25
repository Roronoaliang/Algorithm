package com.liang.exercises.linkedlist;

/**
 * @Description 给定一个链表（单链表）的头结点，如何判断该链表是否有环，如果有环求出环的入口结点
 * 
 * @Solution 对于一个单链表，如果有环，必然是最后一个结点的next指针指向前面的结点构成环，判断链表是否有环可以使用快慢指针,
 *           即设置两个指针同时指向头结点，一个fast指针一次走两步，一个slow指针一次走一步，当fast指针与slow指针相遇时说明有环,
 *           当fast指针移动到null时说明没有环
 * 
 * @Solution2 求环入口结点：当fast指针与slow指针相遇时，将fast指针移会头结点，并且改为一次走一步，与slow指针同时移动，
 *            当两个指针再次相遇时即为环入口结点。
 *            证明：假设从头结点到环入口结点路径为a,从环入口结点到两指针相遇的路径为b,则slow指针走过的路径总长n =
 *            a+b,fast指针走过的路径总长为2n = a + b + (i * len)(绕行i圈环走过的结点数) 所以有i*len =
 *            n, 即如果从相遇点出发再移动n步
 *            ,仍能回到相遇点,那么如果另外一个指针从头结点开始移动n步也能回到相遇点，并且再到达相遇点之前进入环之后两个指针走过的结点是相同的
 *            ,所以此时从头结点出发与从相遇点出发的指针第一次相遇的结点便是环的入口结点
 * 
 * @Solution3 求环的入口结点简单方法：
 *            同样使用两个指针，首先使一个指针指向头结点p,使另一个指针指向头结点的下一个结点q,然后一步一步移动两个指针
 *            ,移动的过程中使p指针的next指向null
 *            ,即从链表中断开该结点,最后当q指针的next为空那么说明q指针当前指向的结点为环的入口结点。
 *            使用该方法的前提是确认了链表已经有环，并且该方法会对原链表产生破坏
 * 
 * 
 * @Date 2016年4月5日 上午9:34:39
 */
public class LoopsOfLinkedList {

	/**
	 * 判断是否有环
	 * 
	 * @param head
	 * @return
	 */
	public boolean hasLoop(ListNode head) {
		ListNode fast = head, slow = head;
		if (head == null) {
			return false;
		}
		if (head.next == head) { // 单个结点并且构成环
			return true;
		}
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 获取链表环入口结点，若链表无环返回null
	 * 
	 * @param head
	 * @return
	 */
	public ListNode getEntrance(ListNode head) {
		ListNode fast = head, slow = head;
		if (head == null || head.next == head) {
			return head;
		}
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				fast = head; // fast指针回到第一个结点处
				while (slow != fast) {
					fast = fast.next;
					slow = slow.next;
				}
				return slow;
			}
		}
		return null;
	}

	/**
	 * 采用删除结点的方式查询环入口结点，
	 * @param head
	 * @return
	 */
	public ListNode entryNodeOfLoop(ListNode head) {
		if (!hasLoop(head)) {
			return null;
		}
		// 采用结点脱离链表的方式
		ListNode p = head, q = head.next;
		while (q != null) {
			p.next = null;
			p = q;
			q = q.next;
		}
		return p;
	}
}
