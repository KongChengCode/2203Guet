package DynamicProblem;

import java.util.Scanner;
//���������https://blog.csdn.net/qq_44579321/article/details/128027483
public class _�Ӵ���ֵ��1 {

	//������s[predix]Ϊβ�������зǿ��Ӵ��Ĳ�ͬ�ַ��ĸ���
	//s��������ַ����У�predix��β���±꣬length��s���鳤��
	static void maxSubSum(char[] s,int predix,int length,int dp[]) {
		//�洢���ֵ�ÿ������Ԫ�صĸ���
		int character[] = new int[27];
		int count=0;
		for(int i=0;i<=predix;i++) {
			character[s[i]-'a'] ++;
			if(character[s[i]-'a'] == 1)
				count++;
		}
		
		dp[predix] = count;
		//�ӵ�һ��Ԫ�ؿ�ʼ��������s[predix]Ϊβ���������Ӵ�
		for(int i=1;i<=predix;i++) {
			character[s[i-1]-'a']--;
			if(character[s[i-1]-'a']==0)
				count--;
			//�ѽ����¼��dp����
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
