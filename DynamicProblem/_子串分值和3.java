package DynamicProblem;

import java.awt.print.Printable;
import java.util.Scanner;

//做法3
//问题分析：https://blog.csdn.net/qq_44579321/article/details/128027483
public class _子串分值和3 {

	public static void main(String[] args) {
		System.out.println("Please input data:");
		int pos[] = new int[27];
		
		Scanner inputScanner = new Scanner(System.in);
		char [] c = inputScanner.next().toCharArray();
		
		//这个地方如果不是long类型，只能通过80%
		long length = c.length;

		//这个地方也要用long类型
		long  res = 0;
		for(int i=0;i<length;i++) {
			res += (long)((i-pos[c[i]-'a'])*(length-i));
			pos[c[i]-'a']=i;
		}
		System.out.println(res);

	}

}





