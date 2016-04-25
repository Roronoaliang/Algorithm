package com.liang.exercises.linkedlist;

import java.util.ArrayList;
import java.util.Stack;

import com.liang.util.RandAndPrintUtil;

/**
 * @Description 题目描述
 * 
 *              输入一个链表，从尾到头打印链表每个节点的值<br/>
 *              输入描述: 输入为链表的表头<br/>
 *              输出描述: 输出为需要打印的“新链表”的表头<br/>
 * @Date 2016年3月26日 下午8:42:39
 */
public class PrintTailToHead {

	/**
	 * 使用递归,当递归到最后一个结点，也即listNode.next = null的时候添加第一个结点，然后返回上层依次添加
	 * 
	 * @param node
	 * @return
	 */
	public ArrayList<Integer> solution1(ListNode node) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (node != null) {
			if (node.next != null) {
				list = solution1(node.next);
			}
			list.add(node.val);
		}
		return list;
	}

	/**
	 * 借助栈先进后出的特点先把链表的结点放入栈中，然后再从栈弹出放入ArrayList中
	 * 
	 * @param node
	 * @return
	 */
	public ArrayList<Integer> solution2(ListNode node) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<ListNode> stack = new Stack<ListNode>();
		while (node != null) {
			stack.push(node);
			node = node.next;
		}
		while (!stack.isEmpty()) {
			list.add(stack.pop().val);
		}
		return list;
	}

	/**
	 * 直接插入数组第一元素,后面的元素会被依次往后移动
	 * 
	 * @param node
	 * @return
	 */
	public ArrayList<Integer> solution3(ListNode node) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (node != null) {
			list.add(0, node.val);
			node = node.next;
		}
		return list;
	}

	// 测试函数
	public static void main(String[] args) {
		ListNode head = ListUtil.create(8);
		PrintTailToHead ptt = new PrintTailToHead();
		RandAndPrintUtil.print("递归输出：", (Integer[])ptt.solution1(head).toArray());
		RandAndPrintUtil.print("栈遍历输出：", (Integer[])ptt.solution2(head).toArray());
		RandAndPrintUtil.print("借助数组直接插入：", (Integer[])ptt.solution3(head).toArray());
	}

}