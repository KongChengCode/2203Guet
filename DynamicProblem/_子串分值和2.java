package DynamicProblem;

import java.util.Scanner;

//���������https://blog.csdn.net/qq_44579321/article/details/128027483
public class _�Ӵ���ֵ��2 {

	public static void main(String[] args) {
		System.out.println("Please input data:");
		Scanner inputScanner = new Scanner(System.in);
		String string = inputScanner.next();
		
		int dp[] = new int[string.length()+5];
		int pos[] = new int[200];
		
		//long������Ϊ��Ҫ��������ǣ���ֻ��ͨ��60%
		long ans=0L;
		
		char[] c = string.toCharArray();
		
		for(int i=1;i<=string.length();i++) {
			dp[i] = dp[i-1] + i - pos[c[i-1]];
			pos[c[i-1]]=i;
			ans+=dp[i];
		}
		
		System.out.println(ans);

	}
}
