package com.liang.exercises.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description 题目描述
 * 
 *              输入一个链表，从尾到头打印链表每个节点的值<br/>
 *              输入描述: 输入为链表的表头<br/>
 *              输出描述: 输出为需要打印的“新链表”的表头<br/>
 * @Date 2016年3月26日 下午8:42:39
 */
public class FromTailToHead {

	/**
	 * 解题方法一：使用递归,当递归到最后一个结点，也即listNode.next = null的时候添加第一个结点，然后返回上层依次添加
	 * 
	 * @param listNode
	 * @return
	 */
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ListNode node = listNode;

		if (node != null) {
			if (node.next != null) {
				list = printListFromTailToHead(node.next);
			}
			list.add(node.val);
		}

		return list;

	}

	/**
	 * 方法二：借助栈先进后出的特点先把链表的结点放入栈中，然后再从栈弹出放入ArrayList中
	 * 
	 * @param listNode
	 * @return
	 */
	public ArrayList<Integer> printMethod2(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();

		while (listNode != null) {
			stack.push(listNode.val); //入栈
			listNode = listNode.next;
		}
		int len = stack.size();
		for (int i = 0; i < len; i++) {
			list.add(stack.pop()); //出栈
		}

		return list;
	}

	public static void main(String[] args) {
		
		ListNode node = new ListNode(0);
		ListNode head = node;
		for(int i = 0; i < 10; i++) {
			node.next = new ListNode(i*2+1);
			node = node.next;
		}
		FromTailToHead ftt = new FromTailToHead();
		List<Integer> list = ftt.printMethod2(head);
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "\t");
		}
		
	}
}
