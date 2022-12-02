package DynamicProblem;

import java.awt.print.Printable;
import java.util.Scanner;

public class _装饰珠 {
	
	public static void main(String[] args) {
		
		System.out.println("Please input data:");
		Scanner inputScanner  =new Scanner(System.in);
		
		//存储各个等级的孔的个数
		int hole[] = new int[5];
		//总孔数
		int total=0;
		
		for(int i=1;i<=6;i++) {
			//存储第i件装备孔的数量
			int num = inputScanner.nextInt();
			for(int j=1;j<=num;j++) {
				hole[inputScanner.nextInt()]++;
				total++;
			}
		}
			
		int M = inputScanner.nextInt();
		
		//存储每个装饰珠数量为K时的价值
		int w[][] = new int[M+5][8];
		//存储装饰珠的上限
		int pbead[] = new int[M+5];
		//存储装饰珠的等级
		int lBbead[] = new int[M+5];
		
		for(int i=1;i<=M;i++) {
			lBbead[i] = inputScanner.nextInt();
			pbead[i] = inputScanner.nextInt();
			for(int j=1;j<=pbead[i];j++) {
				w[i][j] = inputScanner.nextInt();
			}
		}
		
		//动态转移数组,dp[i][j]表示前i类的装饰珠放入j个孔所能产生的最大价值
		int dp[][] = new int[M+1][total+1];
		int holeSum=0, kind=0;
		for(int i=4;i>=1;i--) {//孔的类型从大到小
			holeSum += hole[i];
			if(holeSum == 0) continue;
			for(int j=1;j<=M;j++) {//珠子的种类
				if(lBbead[j] == i) {//优先填入与等级一致的珠子
					kind++;
					
					//纵向平移，初始化
					for(int k=1;k<=holeSum;k++)
						dp[kind][k] = dp[kind-1][k];
					
					//更新动态转移数组
					for(int k=1;k<=pbead[j];k++) {//把装饰珠个数不同价值不同直接看做价值不同的珠子
						for(int m=holeSum;m>=k;m--) {
							dp[kind][m] = Math.max(dp[kind][m], dp[kind-1][m-k]+w[j][k]);
							
							System.out.println("kind="+kind+",holeSum="+holeSum+"k="+k);
							for(int i1=1;i1<=total;i1++)
								System.out.print(dp[kind][i1]+"\t");
							System.out.println();
						}
					}
				}
			}
		}
		
		int res=0;
		for(int i1=1;i1<=total;i1++)
			res = Math.max(res, dp[kind][i1]);
		System.out.println(res);
	}

}
