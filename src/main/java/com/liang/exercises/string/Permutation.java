package com.liang.exercises.string;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @Description 求长度大于等于3的字符串的全排列，按字典序排列
 * @Solution 采用递归的方式，每次固定一位，交换剩余位置的元素
 * @Date 2016年4月7日 上午9:40:09
 */
public class Permutation {

	public static void main(String[] args) {
		Permutation permutation = new Permutation();
		ArrayList<String> list = permutation.permutation("abc");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	ArrayList<String> list = new ArrayList<String>();

	public ArrayList<String> permutation(String str) {
		permutation(str.toCharArray(), 0, str.length() - 1);
		Collections.sort(list);
		return list;
	}

	public void permutation(char[] c, int from, int to) {

		if (to <= 1) {
			return;
		}
		if (from == to) {
			list.add(new String(c));
		} else {
			for (int i = from; i <= to; i++) {
				swap(c, i, from);
				permutation(c, from + 1, to);
				swap(c, from, i);
			}
		}
	}

	public void swap(char[] c, int a, int b) {
		char temp = c[a];
		c[a] = c[b];
		c[b] = temp;
	}

}