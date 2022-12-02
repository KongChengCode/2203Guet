package DynamicProblem;

import java.awt.print.Printable;
import java.util.Scanner;

public class _װ���� {
	
	public static void main(String[] args) {
		
		System.out.println("Please input data:");
		Scanner inputScanner  =new Scanner(System.in);
		
		//�洢�����ȼ��Ŀ׵ĸ���
		int hole[] = new int[5];
		//�ܿ���
		int total=0;
		
		for(int i=1;i<=6;i++) {
			//�洢��i��װ���׵�����
			int num = inputScanner.nextInt();
			for(int j=1;j<=num;j++) {
				hole[inputScanner.nextInt()]++;
				total++;
			}
		}
			
		int M = inputScanner.nextInt();
		
		//�洢ÿ��װ��������ΪKʱ�ļ�ֵ
		int w[][] = new int[M+5][8];
		//�洢װ���������
		int pbead[] = new int[M+5];
		//�洢װ����ĵȼ�
		int lBbead[] = new int[M+5];
		
		for(int i=1;i<=M;i++) {
			lBbead[i] = inputScanner.nextInt();
			pbead[i] = inputScanner.nextInt();
			for(int j=1;j<=pbead[i];j++) {
				w[i][j] = inputScanner.nextInt();
			}
		}
		
		//��̬ת������,dp[i][j]��ʾǰi���װ�������j�������ܲ���������ֵ
		int dp[][] = new int[M+1][total+1];
		int holeSum=0, kind=0;
		for(int i=4;i>=1;i--) {//�׵����ʹӴ�С
			holeSum += hole[i];
			if(holeSum == 0) continue;
			for(int j=1;j<=M;j++) {//���ӵ�����
				if(lBbead[j] == i) {//����������ȼ�һ�µ�����
					kind++;
					
					//����ƽ�ƣ���ʼ��
					for(int k=1;k<=holeSum;k++)
						dp[kind][k] = dp[kind-1][k];
					
					//���¶�̬ת������
					for(int k=1;k<=pbead[j];k++) {//��װ���������ͬ��ֵ��ֱͬ�ӿ�����ֵ��ͬ������
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
