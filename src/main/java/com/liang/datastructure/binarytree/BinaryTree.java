package com.liang.datastructure.binarytree;

import java.util.Stack;

/**
 * @Description 二叉树定义,结点采用孩子表示法(二叉链表表示)
 * 
 * @Date 2016年4月8日 下午9:26:32
 */

public abstract class BinaryTree<T> {

	private BinaryNode<T> root; // 根结点
	private int count; // 结点个数

	/**
	 * @Description 结点结构定义
	 * @Date 2016年4月10日 上午12:37:29
	 */
	static class BinaryNode<E> {
		E data; // 数据域,使用泛型以支持多种类型
		BinaryNode<E> leftChild; // 左孩子
		BinaryNode<E> rightChild; // 右孩子

		// BinaryNode<T> parent; // 双亲结点

		public BinaryNode(E data, BinaryNode<E> lChild, BinaryNode<E> rChild) {
			this.data = data;
			this.leftChild = lChild;
			this.rightChild = rChild;
			// this.parent = parent;
		}

		@Override
		public String toString() {
			return "BinaryNode [data=" + data + ", leftChild=" + leftChild
					+ ", rightChild=" + rightChild + "]";
		}

	}

	/**
	 * 创建一棵二叉树
	 */
	protected abstract void initBinaryTree();

	/**
	 * 递归前序遍历
	 * 
	 * @param binaryNode
	 */
	public void preOrder(BinaryNode<T> binaryNode) {
		if (binaryNode == null) {
			return;
		} else {
			visit(binaryNode); // 访问结点
			preOrder(binaryNode.leftChild); // 递归前序遍历左子树
			preOrder(binaryNode.rightChild); // 递归前序遍历右子树
		}
	}

	/**
	 * 递归中序遍历
	 * 
	 * @param binaryNode
	 */
	public void midOrder(BinaryNode<T> binaryNode) {
		if (binaryNode == null) {
			return;
		} else {
			midOrder(binaryNode.leftChild); // 递归中序遍历左子树
			visit(binaryNode);
			; // 访问结点
			midOrder(binaryNode.rightChild); // 递归中序遍历右子树
		}
	}

	/**
	 * 递归后序遍历
	 * 
	 * @param binaryNode
	 */
	public void postOrder(BinaryNode<T> binaryNode) {
		if (binaryNode == null) {
			return;
		} else {
			postOrder(binaryNode.leftChild); // 递归后序遍历左子树
			postOrder(binaryNode.rightChild); // 递归后序遍历右子树
			visit(binaryNode);// 访问结点
		}
	}

	/**
	 * 利用栈非递归前序遍历二叉树
	 * 
	 * @param binaryNode
	 */
	public void preOrderWithStack(BinaryNode<T> binaryNode) {
		Stack<BinaryNode<T>> stack = new Stack<BinaryTree.BinaryNode<T>>();
		while (binaryNode != null || !stack.isEmpty()) { // 当前结点或栈中尚有结点，说明还没遍历完所有结点
			// 访问所有左结点,并压入栈中
			while (binaryNode != null) {
				visit(binaryNode);
				stack.push(binaryNode);
				binaryNode = binaryNode.leftChild;
			}

			// 如果栈非空,则弹出栈顶结点，由于栈顶结点在压入前已访问过，所以不需要再访问，此时需要访问的是栈顶结点的右孩子
			if (!stack.isEmpty()) {
				binaryNode = stack.pop();
				binaryNode = binaryNode.rightChild;
			}
		}
	}

	/**
	 * 利用栈非递归中序遍历二叉树
	 * 
	 * @param binaryNode
	 */
	public void midOrderWithStack(BinaryNode<T> binaryNode) {
		Stack<BinaryNode<T>> stack = new Stack<BinaryTree.BinaryNode<T>>();
		while (binaryNode != null || !stack.empty()) {
			// 压入当前结点的所有左结点,压入前不访问
			while (binaryNode != null) {
				stack.push(binaryNode);
				binaryNode = binaryNode.leftChild;
			}
			// 所有左结点压入后开始从栈中弹出结点访问,访问完成后将当前结点指针指向其右孩子
			if (!stack.empty()) {
				binaryNode = stack.pop(); // 出栈
				visit(binaryNode); // 访问结点
				binaryNode = binaryNode.rightChild; // 设置当前结点为其右孩子
			}
		}
	}

	/**
	 * 利用栈非递归后序遍历二叉树： 1.压入根结点的所有左子孙
	 * 2.检查栈顶结点有无未访问过的右孩子，有则将指针移向右孩子上，没有则取出栈顶结点进行访问——>标记为刚访问——>置当前结点指针指向为Null
	 * 
	 * @param binaryNode 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public void postOrderWithStack(BinaryNode<T> binaryNode) {
		Stack<BinaryNode<T>> stack = new Stack<BinaryNode<T>>();
		BinaryNode<T> pre = null; // 用于刚记录访问过的结点
		while (binaryNode != null || !stack.empty()) {
			// 压入当前结点的所有左孩子
			while (binaryNode != null) {
				stack.push(binaryNode);
				binaryNode = binaryNode.leftChild;
			}

			/**
			 * 判断栈顶的结点是否有右孩子并且尚未访问过（此时不弹出栈）,如果有则将当前结点指针指向改为右孩子,否则弹出栈顶结点进行访问,
			 * 并标记为刚刚访问过的结点
			 */
			if (!stack.empty()) {                                                                                                                          
				BinaryNode<T> right = stack.peek().rightChild;
				if (right == null || right == pre) {
					binaryNode = stack.pop();
					visit(binaryNode);
					pre = binaryNode;
					binaryNode = null; // 必须将当前结点置为null,防止重复压入栈中
				} else {
					binaryNode = right; // 当前结点指针移到右孩子上
				}
			}
		}
	}

	/**
	 * 访问结点数据域
	 * 
	 * @param node
	 */
	private void visit(BinaryNode<T> node) {
		if (node != null && node.data != null) {
			System.out.print(node.data + "\t");
		}
	}

	/**
	 * 销毁二叉树
	 * 
	 * @param tree
	 */
	public void destory() {
		destory(root);
		root = null;
		count = 0;
	}

	/**
	 * 递归销毁二叉树
	 * 
	 * @param tree
	 */
	private void destory(BinaryNode<T> binaryNode) {
		if (binaryNode == null) {
			return;
		}
		if (binaryNode.leftChild != null) {
			destory(binaryNode.leftChild);// 递归销毁左子树
		}
		if (binaryNode.rightChild != null) {
			destory(binaryNode.rightChild); // 递归销毁右子树
		}
		binaryNode = null; // 销毁当前结点
	}

	public BinaryNode<T> getRoot() {
		return root;
	}

	public void setRoot(BinaryNode<T> root) {
		this.root = root;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
