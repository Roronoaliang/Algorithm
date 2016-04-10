package com.liang.datastructure.binarytree;

import java.util.Scanner;

/**
 * @Description
 * @Solution
 * @Date 2016年4月10日 下午2:53:19
 */
public class BinaryTreeImpl extends BinaryTree<Integer> {

	/**
	 * 创建二叉树
	 */
	@Override
	protected void initBinaryTree() {
		BinaryNode<Integer> root = new BinaryNode<Integer>(0, null, null);
		Scanner sc = new Scanner(System.in);
		this.setRoot(root);
		insert(root, sc);
		sc.close();
	}

	/**
	 * 递归插入二叉树结点
	 */

	private void insert(BinaryNode<Integer> binaryNode, Scanner sc) {
		System.out.println("请输入当前结点值,输入“N”表示当前结点为空");
		String input = sc.next();
		if ("N".equalsIgnoreCase(input)) {
			binaryNode.data = null;
		} else {
			Integer data = Integer.valueOf(input);
			binaryNode.data = data;
			this.setCount(this.getCount()+1);
			binaryNode.leftChild = new BinaryNode<Integer>(0, null, null);
			binaryNode.rightChild = new BinaryNode<Integer>(0, null, null);
			insert(binaryNode.leftChild, sc);
			insert(binaryNode.rightChild, sc);
		}
	}

}
