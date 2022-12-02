package DynamicProblem;

/*import java.util.Scanner;

import javax.xml.crypto.dsig.spec.DigestMethodParameterSpec;

public class _���鱳��Sample {
	//������Ʒ����
	static int MAX_NUM = 35;
	//�������
	static int MAX_GROUP = 15;
	//���ı�������
	static int MAX_VOLUME = 205;
	//�洢��Ʒ������
	static int w[] = new int[MAX_NUM];
	//�洢��Ʒ�ļ�ֵ
	static int c[] = new int[MAX_NUM];
	//�洢ÿ��С������Щ��Ʒ
	static int a[][] = new int[MAX_GROUP][MAX_VOLUME];
	
	//��̬ת������
	static int dp[][] = new int[MAX_NUM][MAX_VOLUME];
	

	public static void main(String[] args) {
		//V :��������
		//N : ��Ʒ����
		//T :������
		int V,N,T;
		System.out.println("Please input data:");
		
		Scanner input = new Scanner(System.in);
		V = input.nextInt();
		N = input.nextInt();
		T = input.nextInt();
		
		//p:�������
		int p;
		//���������������w��v��a����
		for(int i=1;i<=N;i++) {
			w[i] = input.nextInt();
			c[i] = input.nextInt();
			p = input.nextInt();
			
			//������a[p]����Ʒ�������ӵ��������
			a[p][++a[p][0]] = i;
		}
		
		
		//��̬�滮
		for(int i=1;i<=T;i++) {//���
			for(int j=V;j>=0;j--) {//���������
				for(int k=1;k<=a[i][0];k++) {//���i�ڵ���Ʒ��
					int temp = a[i][k];
					if(j>=w[temp]) {				
						if(dp[i][j] < (dp[i-1][j-w[temp]]+c[temp]))
							dp[i][j] = dp[i-1][j-w[temp]]+c[temp];
					}
					
				}
			}
		}
		
		System.out.println(dp[T][V]);
	}

}*/
import java.util.Scanner;

import javax.xml.crypto.dsig.spec.DigestMethodParameterSpec;

public class _���鱳��Sample {
	//������Ʒ����
	static int MAX_NUM = 35;
	//�������
	static int MAX_GROUP = 15;
	//���ı�������
	static int MAX_VOLUME = 205;
	//�洢��Ʒ������
	static int w[] = new int[MAX_NUM];
	//�洢��Ʒ�ļ�ֵ
	static int c[] = new int[MAX_NUM];
	//�洢ÿ��С������Щ��Ʒ
	static int a[][] = new int[MAX_GROUP][MAX_VOLUME];
	
	//��̬ת������
	static int dp[] = new int[MAX_VOLUME];
	

	public static void main(String[] args) {
		//V :��������
		//N : ��Ʒ����
		//T :������
		int V,N,T;
		System.out.println("Please input data:");
		
		Scanner input = new Scanner(System.in);
		V = input.nextInt();
		N = input.nextInt();
		T = input.nextInt();
		
		//p:�������
		int p;
		//���������������w��v��a����
		for(int i=1;i<=N;i++) {
			w[i] = input.nextInt();
			c[i] = input.nextInt();
			p = input.nextInt();
			
			//������a[p]����Ʒ�������ӵ��������
			a[p][++a[p][0]] = i;
		}
		
		
		//��̬�滮
		for(int i=1;i<=T;i++) {//���
			for(int j=V;j>=0;j--) {//���������
				for(int k=1;k<=a[i][0];k++) {//���i�ڵ���Ʒ��
					int temp = a[i][k];
					if(j>=w[temp]) {				
						if(dp[j] < (dp[j-w[temp]]+c[temp]))
							dp[j] = dp[j-w[temp]]+c[temp];
					}
					
				}
			}
		}
		
		System.out.println(dp[V]);
	}

}
