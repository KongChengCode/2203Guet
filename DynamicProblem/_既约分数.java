package DynamicProblem;

import java.awt.print.Printable;

//题目分析：https://blog.csdn.net/qq_44579321/article/details/128085845?spm=1001.2014.3001.5501

public class _既约分数 {
	static int gcd(int a,int b) {
		return b == 0?a:gcd(b, a%b);
	}
	
	public static void main(String[] args) {
		long res = 1L;
		for(int i=1;i<2021;i++) 
			for(int j=1;j<i;j++) 
				if(gcd(i, j)==1) 
					res+=2;			
		System.out.println(res);
	}
}
