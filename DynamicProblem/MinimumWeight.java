package DynamicProblem;

import java.util.Scanner;


//��С��������
/*����������
 * ����һ����ƽ��������Ҫ���һ�����룬ʹ��������Щ������ԳƳ����� 
 * С�ڵ��� N ����������������ô��������������Ҫ�������ٸ����룿
 * ע��������Է�����ƽ���ߡ�
 */

//��ݼ�
//Ctrl + 1���Ե����

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
