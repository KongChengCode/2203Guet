package DynamicProblem;

/*import java.util.Scanner;

import javax.xml.crypto.dsig.spec.DigestMethodParameterSpec;

public class _分组背包Sample {
	//最大的物品数量
	static int MAX_NUM = 35;
	//最大的组号
	static int MAX_GROUP = 15;
	//最大的背包容量
	static int MAX_VOLUME = 205;
	//存储物品的重量
	static int w[] = new int[MAX_NUM];
	//存储物品的价值
	static int c[] = new int[MAX_NUM];
	//存储每个小组有哪些物品
	static int a[][] = new int[MAX_GROUP][MAX_VOLUME];
	
	//动态转移数组
	static int dp[][] = new int[MAX_NUM][MAX_VOLUME];
	

	public static void main(String[] args) {
		//V :背包容量
		//N : 物品数量
		//T :最大组号
		int V,N,T;
		System.out.println("Please input data:");
		
		Scanner input = new Scanner(System.in);
		V = input.nextInt();
		N = input.nextInt();
		T = input.nextInt();
		
		//p:所属组号
		int p;
		//将输入的数据输入w、v、a数组
		for(int i=1;i<=N;i++) {
			w[i] = input.nextInt();
			c[i] = input.nextInt();
			p = input.nextInt();
			
			//将所属a[p]的物品的序号添加到数组后面
			a[p][++a[p][0]] = i;
		}
		
		
		//动态规划
		for(int i=1;i<=T;i++) {//组号
			for(int j=V;j>=0;j--) {//背包的体积
				for(int k=1;k<=a[i][0];k++) {//组号i内的物品号
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

public class _分组背包Sample {
	//最大的物品数量
	static int MAX_NUM = 35;
	//最大的组号
	static int MAX_GROUP = 15;
	//最大的背包容量
	static int MAX_VOLUME = 205;
	//存储物品的重量
	static int w[] = new int[MAX_NUM];
	//存储物品的价值
	static int c[] = new int[MAX_NUM];
	//存储每个小组有哪些物品
	static int a[][] = new int[MAX_GROUP][MAX_VOLUME];
	
	//动态转移数组
	static int dp[] = new int[MAX_VOLUME];
	

	public static void main(String[] args) {
		//V :背包容量
		//N : 物品数量
		//T :最大组号
		int V,N,T;
		System.out.println("Please input data:");
		
		Scanner input = new Scanner(System.in);
		V = input.nextInt();
		N = input.nextInt();
		T = input.nextInt();
		
		//p:所属组号
		int p;
		//将输入的数据输入w、v、a数组
		for(int i=1;i<=N;i++) {
			w[i] = input.nextInt();
			c[i] = input.nextInt();
			p = input.nextInt();
			
			//将所属a[p]的物品的序号添加到数组后面
			a[p][++a[p][0]] = i;
		}
		
		
		//动态规划
		for(int i=1;i<=T;i++) {//组号
			for(int j=V;j>=0;j--) {//背包的体积
				for(int k=1;k<=a[i][0];k++) {//组号i内的物品号
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
