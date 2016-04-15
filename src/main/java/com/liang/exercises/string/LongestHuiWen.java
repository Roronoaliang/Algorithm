package com.liang.exercises.string;

/**
 * @Description 最长回文子串
 * 
 * @Solution1 从第2个字母开始到倒数第二个字母结束，分别以当前指向的字母为回文子串的中心，向左右扩展，统计能达到的最长回文长度和当前下标,
 *            这种方法需要考虑回文串是奇数还是偶数
 * 
 * @Solution2 
 * 
 * @Date 2016年4月4日 上午10:26:48
 */
public class LongestHuiWen {

	public static void solution1(String str) {

		char c[] = str.toCharArray();
		int longest = 1; // 最长回文串长度
		int start = 1; // 回文串开始下标
		int i, j;
		for (i = 1; i < c.length - 1; i++) {
			// 处理奇数长度的回文串
			int len = 1;
			for (j = 1; i - j >= 0 && i + j < c.length;) {
				if (c[i - j] == c[i + j]) {
					j++;
					len += 2;
				} else {
					break;
				}
			}
			if (len > longest) {
				longest = len;
				start = i - longest / 2;
			}

			// 处理偶数长度的回文串
			len = 0;
			for (j = 1; i - j + 1 >= 0 && i + j < c.length;) {
				if (c[i - j + 1] == c[i + j]) {
					j++;
					len += 2;
				} else {
					break;
				}
			}
			if (len > longest) {
				longest = len;
				start = i + 1 - longest / 2;
			}
		}

		if (longest > 1) {
			System.out.println("最长回文串长度： " + longest);
			for (i = 0; i < longest; i++) {
				System.out.print(c[i + start]);
			}
		} else {
			System.out.println("不存在长度大于1的回文串");
		}
	}
	

	public static void main(String[] args) {
		String str = "aabaa";
		solution1(str);
	}
}
