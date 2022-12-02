package DynamicProblem;

import java.util.Scanner;
//问题分析：https://blog.csdn.net/qq_44579321/article/details/128027483
public class _子串分值和1 {

	//计算以s[predix]为尾部的所有非空子串的不同字符的个数
	//s是输入的字符序列，predix是尾部下标，length是s数组长度
	static void maxSubSum(char[] s,int predix,int length,int dp[]) {
		//存储出现的每个数组元素的个数
		int character[] = new int[27];
		int count=0;
		for(int i=0;i<=predix;i++) {
			character[s[i]-'a'] ++;
			if(character[s[i]-'a'] == 1)
				count++;
		}
		
		dp[predix] = count;
		//从第一个元素开始，计算以s[predix]为尾部的所有子串
		for(int i=1;i<=predix;i++) {
			character[s[i-1]-'a']--;
			if(character[s[i-1]-'a']==0)
				count--;
			//把结果记录到dp数组
			dp[predix]+=count;
		}
		
		
		
	}

	public static void main(String[] args) {
		
		System.out.println("Please input data:");
		Scanner scanner = new Scanner(System.in);
		
		String str = scanner.next();
		int length = str.length();
		
		int NUM;
		NUM = length+5;
		int dp[] = new int[NUM];
		char s[] = str.toCharArray();
		
		int result = 0;
		for(int i=0;i<length;i++) {
			maxSubSum(s, i, length,dp);
			result+=dp[i];
		}
		
		System.out.println(result);
	}

}
