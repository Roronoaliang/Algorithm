package com.liang.datastructure.binarytree;

import org.junit.Test;

/**
 * @Description 测试二叉树
 * @Date 2016年4月10日 下午4:14:52
 */
public class BinaryTreeImplTest {

	@Test
	public void testBinaryTree() {
		BinaryTreeImpl i = new BinaryTreeImpl();
		i.initBinaryTree(); // 创建二叉树
		System.out.println("当前结点数：" + i.getCount());
		System.out.println("递归前序遍历结果：");
		i.preOrder(i.getRoot()); // 递归前序遍历
		System.out.println("\n非递归前序遍历结果：");
		i.preOrderWithStack(i.getRoot()); // 非递归前序遍历
		System.out.println("\n递归中序遍历结果：");
		i.midOrder(i.getRoot()); // 递归中序遍历
		System.out.println("\n非递归中序遍历结果：");
		i.midOrderWithStack(i.getRoot()); // 非递归中序遍历
		System.out.println("\n递归后序遍历结果：");
		i.postOrder(i.getRoot()); // 递归后序遍历
		System.out.println("\n非递归后序遍历结果：");
		i.postOrderWithStack(i.getRoot()); // 非递归后序遍历
		i.destory(); // 销毁二叉树
		System.out.println("\n销毁后递归前序遍历结果：");
		i.preOrder(i.getRoot());
		System.out.println("\n结点数：" + i.getCount());
	}
}
