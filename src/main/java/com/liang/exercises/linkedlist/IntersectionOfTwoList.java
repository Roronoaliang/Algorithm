package com.liang.exercises.linkedlist;

/**
 * @Description 给出两个无环单链表的头指针，判断是否两条链表是否相交，如果相交，怎么求出他们相交的第一个节点
 * 
 * @Solution1 将链表2接在链表1后面构成一条新链表，如果两条链表原本有交点，那么拼接后的新链表必有环，并且该环的入口结点就是两条链表的第一个交点。
 * 
 * @Solutino2 采用对齐的方式，首先分别遍历一次两条链表，计算出各自的长度len1,len2，然后使用两个指针p,q分别指向两条链表的头结点，
 *            链表较长的先走|len1-len|步，之后两个指针同时移动，当出现p==q时，指向的结点就是第一个交点，
 *            否则当遍历完链表两个指针仍不相遇则两条链表不相交。
 * 
 * @Date 2016年4月25日 上午11:15:14
 */
public class IntersectionOfTwoList {
	/**
	 * 采用对齐的方式求两条链表的第一个交点
	 * 
	 * @param head1
	 * @param head2
	 * @return
	 */
	public ListNode solution2(ListNode head1, ListNode head2) {
		int len1 = 0, len2 = 0, i;
		ListNode p = head1, q = head2;
		//计算两条链表长度
		while (p != null) {
			len1++;
			p = p.next;
		}
		while (q != null) {
			len2++;
			q = q.next;
		}
		//使p指针指向长的链表
		if (len1 >= len2) {
			p = head1;
			q = head2;
			i = len1 - len2;

		} else {
			q = head1;
			p = head2;
			i = len2 - len1;

		}
		//p指针先走两条链表相差的长度
		while (i > 0) {
			p = p.next;
			i--;
		}
		//同时移动p、q
		while(p != null) {
			if(p == q) {
				return p;
			}
			p = p.next;
			q = q.next;
		}
		return null;
	}
}
