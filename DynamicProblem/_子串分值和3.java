package DynamicProblem;

import java.awt.print.Printable;
import java.util.Scanner;

//����3
//���������https://blog.csdn.net/qq_44579321/article/details/128027483
public class _�Ӵ���ֵ��3 {

	public static void main(String[] args) {
		System.out.println("Please input data:");
		int pos[] = new int[27];
		
		Scanner inputScanner = new Scanner(System.in);
		char [] c = inputScanner.next().toCharArray();
		
		//����ط��������long���ͣ�ֻ��ͨ��80%
		long length = c.length;

		//����ط�ҲҪ��long����
		long  res = 0;
		for(int i=0;i<length;i++) {
			res += (long)((i-pos[c[i]-'a'])*(length-i));
			pos[c[i]-'a']=i;
		}
		System.out.println(res);

	}

}





