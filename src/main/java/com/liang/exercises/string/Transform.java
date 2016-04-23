package com.liang.exercises.string;

/**
 * @Description 对于一个给定的字符串，我们需要在线性（也就是O（n))的时间里对它做一些变形。
 *              首先这个字符串中包含着一些空格，就像"Hello World"一样，然后我们要做
 *              是把这个字符串中由空格隔开的单词反序，同时反转每个字符的大小写。如："Hello World"
 *              变形后就变成了"wORLD hELLO"。
 * @Date 2016年4月19日 下午7:05:38
 */

public class Transform {

	public String trans(String s, int n) {
		String result = new String();
		s = change(s); // 转换大小写

		String[] temp = s.split(" ");

		for (int i = 0; i < temp.length; i++) { // 单独反转每个子串
			if (!"".equals(temp[i])) {
				if (!"".equals(temp[i])) {
					result = result + " " + reverse(temp[i]);
				}
			}
		}
		s = reverse(result); // 整体反转一次
		return s;
	}

	/**
	 * 反转字符串
	 * 
	 * @param s
	 * @return
	 */
	public String reverse(String s) {
		char[] c = s.toCharArray();
		for (int i = 0, j = c.length - 1; i < j; i++, j--) {
			char temp = c[i];
			c[i] = c[j];
			c[j] = temp;
		}
		return String.valueOf(c);
	}

	public String change(String s) {
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			c[i] = change(c[i]);
		}
		return String.valueOf(c);
	}

	/**
	 * 转换大小写
	 * 
	 * @param c
	 * @return
	 */
	public char change(char c) {

		if (c >= 'a' && c <= 'z') {
			c -= 32;
		} else if (c >= 'A' && c <= 'Z') {
			c += 32;
		}
		return c;
	}

	public static void main(String[] args) {
		Transform t = new Transform();
		String string = t.trans("This is a     simple", 20);
		System.out.println(string);

		System.out.println(t.trans("Hello World", 9));

	}
}
