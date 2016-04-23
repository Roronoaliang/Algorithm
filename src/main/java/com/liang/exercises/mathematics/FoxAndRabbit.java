package com.liang.exercises.mathematics;

/**
 * @Description 狐狸捉兔子：围绕着山顶有10个洞,狐狸要吃兔子,兔子说：“可以,但必须找到我,我就藏身于这
 *              十个洞中,你从10号洞出发,先到1号洞找
 *              ,第二次隔1个洞找,第三次隔2个洞找,以后如此类推,次数不限.”但狐狸从早到晚进进出出了1000次
 *              ,仍没有找到兔子.问兔子究竟藏在哪个洞里?
 * 
 * @Sulotion 使用长度为10的数组表示10个洞,狐狸进过的洞值赋为1，最后输出值为0的下标就是兔子可能藏的洞
 * @Date 2016年4月17日 下午8:56:12
 */
public class FoxAndRabbit {

	public void solution(int len, int count) {
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) { // 初始化赋值为0
			arr[i] = 0;
		}

		for (int i = 1, j = 9; i <= count; i++) { // 寻找count次
			j = (j + i) % len; // 计算下一个洞的下标
			arr[j] = 1; // 找过的洞置为1
		}

		System.out.print("兔子可能藏的洞有： ");
		for (int i = 0; i < len; i++) {
			if (arr[i] != 1) {
				System.out.println(i + 1 + ",\t");
			}
		}
	}

	public static void main(String[] args) {
		FoxAndRabbit far = new FoxAndRabbit();
		far.solution(10, 1000);
		
		far.solution(7, 10000);
	}
}
