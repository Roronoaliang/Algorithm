package com.liang.datastructure.binarytree;

import java.util.Scanner;

/**
 * @Description 二叉查找树实现<br/>
 *              二叉搜索树是满足以下性质的特殊二叉树：<br/>
 *              1.任意节点的左子树不空，则左子树上所有结点的值均小于它的根结点的值;<br/>
 *              2.任意节点的右子树不空，则右子树上所有结点的值均大于它的根结点的值;<br/>
 *              3.任意节点的左、右子树也分别为二叉查树;<br/>
 *              4.没有键值相等的节点。
 * @Date 2016年4月10日 下午8:23:39
 */
public class BinarySearchTreeImpl extends BinaryTree<Integer> {

	/**
	 * 创建一棵二叉搜索树
	 */
	@Override
	public void initBinaryTree() {
		Scanner sc = new Scanner(System.in);
		// 1.创建根结点
		System.out.println("请输入一个整数值,输入“N”结束构造二叉树");
		String input = sc.next();
		if ("N".equals(input)) {
			sc.close();
			return;
		} else {
			BinaryNode<Integer> root = new BinaryNode<Integer>(
					Integer.valueOf(input), null, null);
			setRoot(root);
		}
		// 2.循环调用insert插入结点调整成二叉搜索树
		while (true) {
			System.out.println("请输入一个整数值,输入“N”结束构造二叉树");
			input = sc.next();
			if ("N".equalsIgnoreCase(input)) {
				break;
			} else {
				insert(Integer.valueOf(input));
			}
		}
		sc.close();
	}

	/**
	 * 插入结点，插入后仍是一棵二叉搜索树
	 * 
	 * @param data
	 * @return
	 */
	public boolean insert(Integer data) {
		// 1.从根结点开始搜索，确定插入位置
		BinaryNode<Integer> node = getRoot();
		BinaryNode<Integer> insertPoint = null; // 插入点
		while (node != null) {
			insertPoint = node;
			if (node.data == data) {
				return false; // 不能存在相同的值，插入失败
			} else if (data < node.data) {
				node = node.leftChild;
			} else {
				node = node.rightChild;
			}
		}
		// 一直查找到node=null时，insertPoint是插入点
		BinaryNode<Integer> newNode = new BinaryNode<Integer>(data, null, null);

		// 检查插入点是否为空,表示原二叉树为空树,插入点为根结点
		if (insertPoint == null) {
			setRoot(newNode);
			return true;
		} else if (data < insertPoint.data) {
			insertPoint.leftChild = newNode;
		} else {
			insertPoint.rightChild = newNode;
		}
		return true;
	}

	/**
	 * 删除指定结点，删除后仍是一棵二叉搜索树
	 * 
	 * @param node
	 * @return
	 */
	public boolean delete(BinaryNode<Integer> node) {

		return false;
	}

	/**
	 * 根据key非递归查找
	 * 
	 * @param key
	 * @return
	 */
	public BinaryNode<Integer> search(Integer key) {
		BinaryNode<Integer> node = getRoot();
		while (node != null) {
			if (node.data == key) {
				return node;
			} else if (key < node.data) {
				node = node.leftChild;
			} else {
				node = node.rightChild;
			}
		}
		return node;
	}

}
