package DynamicProblem;

import java.awt.print.Printable;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.logging.Handler;

//括号序列
public class BracketSequences {
	
	static int mod = 1000000007;
	static int NUM = 5010;
	
	static int dynamic(int length,char str[]) {
		int dp[][] = new int[NUM][NUM];
		
		//初始化
		for(int i=0;i<NUM;i++)
			for(int j=0;j<NUM;j++)
				dp[i][j] = 0;
		dp[0][0] = 1;
			
		
		//更新dp数组
		for(int i=1;i<=length;i++) {
			if(str[i-1] == '(') {
				for(int j=1;j<=length;j++) {
					dp[i][j] = dp[i-1][j-1];
				}
			}else {
				dp[i][0] = (dp[i-1][0] + dp[i-1][1])%mod;
				for(int j=1;j<=length;j++) {
					dp[i][j] = (dp[i-1][j+1] + dp[i][j-1] )%mod;
				}
			}
		}
		
		//计算方案数
		for(int i=length;i>=1;i--) {
			if(str[i-1]==')'&&dp[i][0]!=0)
				return dp[i][0];
		}
		return 1;
		
	}
	

	public static void main(String[] args) {
		//System.out.println("Please input bracket sequences:");
		Scanner scan = new Scanner(System.in);
		String arr = scan.next();
		char str[] = arr.toCharArray();
		
		int length = arr.length();
		int ans = dynamic(length, str);
		//System.out.println(ans);
		//镜像翻转
		String arr1 = new StringBuffer(arr).reverse().toString();
		char[] str1 = arr1.toCharArray();
		for(int i=0;i<length;i++) {
			if(str1[i]=='(')
				str1[i] = ')';
			else {
				str1[i] = '(';
			}
		}
		//System.out.println(str1);
		//System.out.println(ans1);
		ans =( ans*(dynamic(length, str1)%mod))%mod;
		System.out.println(ans);
		
	}
	
}








