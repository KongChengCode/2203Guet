package DynamicProblem;

import java.util.Scanner;


//最小砝码问题
/*问题描述：
 * 你有一架天平。现在你要设计一套砝码，使得利用这些砝码可以称出任意 
 * 小于等于 N 的正整数重量。那么这套砝码最少需要包含多少个砝码？
 * 注意砝码可以放在天平两边。
 */

//快捷键
//Ctrl + 1可以导入包

public class MinimumWeight {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int sum = 0;
		int i = 0;
		while(sum<=num) {
			i++;
			sum = (int)((Math.pow(3,i) - 1)/2);
		}
		System.out.print(i);
		input.close();
	}

}
