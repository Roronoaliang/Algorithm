package com.liang.exercises.linkedlist;

/**
 * @Description 只给出中间结点指针，要从链表中求删除指定中间结点
 * @Solution 由于没有给出头指针因此不能遍历链表，可以用待删除结点后的结点的值依次覆盖前一个结点的值，最后将最后一个结点从链表中删除
 * @Date 2016年4月18日 下午1:05:09
 */
public class DeleteNodeO1 {

	/**
	 * O(1)时间删除结点
	 * @param node
	 * @return
	 */
	public static boolean delete(ListNode node) {
		// 容错判断不能为空，也不能是最后一个结点
		if (node == null || node.next == null) {
			return false;
		}
		// 将指定结点后面的结点值依次前移一位，即执行覆盖操作,但要注意要将最后一个结点置为null
		while (node.next != null) {
			ListNode pre = node; // 指示当前需要被覆盖的结点
			node.val = node.next.val; // 覆盖操作
			node = node.next; // 移动指针指示下一个被覆盖的结点
			if (node.next == null) { // 如果已经移动到最后一个结点，则从链表中将该结点置为null并退出循环
				pre.next = null;
				break;
			}
		}
		return true;
	}

	/**
	 * 测试函数
	 * @param args
	 */
	public static void main(String[] args) {
		
		ListNode head = new ListNode(Integer.MIN_VALUE);
		ListNode p = head;
		ListNode target = null; // 待删除的目标结点
		//创建链表
		for (int i = 0; i < 10; i++) {
			ListNode node = new ListNode(i);
			p.next = node;
			p = node;
			if (i == 5) { // 为测试方便在创建链表的同时指定要删除的结点
				target = p;
			}
		}
		p.next = null;
		System.out.print("删除前链表: ");
		print(head); // 打印删除前的链表
		delete(target); // 删除target结点
		System.out.print("删除后链表: ");
		print(head); // 打印删除target结点后的链表
	}

	/**
	 * 打印结点，不包括头结点
	 * 
	 * @param head
	 */
	public static void print(ListNode head) {
		while (head.next != null) {
			System.out.print(head.next.val + "—>");
			head = head.next;
		}
		System.out.println();
	}
}
