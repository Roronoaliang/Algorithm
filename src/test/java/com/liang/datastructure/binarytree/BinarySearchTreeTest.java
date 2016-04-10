package com.liang.datastructure.binarytree;

import org.junit.Test;

import com.liang.datastructure.binarytree.BinaryTree.BinaryNode;

public class BinarySearchTreeTest {

	@Test
	public void test() {
		BinarySearchTreeImpl tree = new BinarySearchTreeImpl();
		tree.initBinaryTree(); // 构造二叉树
		System.out.println("\n中序遍历");
		tree.midOrderWithStack(tree.getRoot()); // 中序遍历
		// for (int i = 0; i < 5; i++) {
		// tree.insert(i * 2 + 1); // 插入5个结点
		// }
		System.out.println("\n前序遍历");
		tree.preOrderWithStack(tree.getRoot()); // 前序遍历
		BinaryNode<Integer> node = tree.search(100); // 查找值为100的结点
		System.out.println("\n" + node);
		node = tree.search(9); // 查找值为9的结点
		System.out.println(node);
		node = tree.search(5);// 查找值为5的结点
		System.out.println(node);
	}
}
