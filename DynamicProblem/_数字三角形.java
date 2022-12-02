package DynamicProblem;

import java.util.Scanner;

public class _数字三角形 {
	static int NUM = 105;
	static int [][] trigle = new int[NUM][NUM];
	
	//计算第line行的最大值
	static void maxOfTrigle(int line) {
		if(line==-1)
			return;
		else {
			for(int i=0;i<=line;i++) {
				trigle[line][i] +=Math.max(trigle[line+1][i],trigle[line+1][i+1]);
			}
			maxOfTrigle(line-1);
		}
	}

	public static void main(String[] args) {
		System.out.println("Please input number:");
		Scanner scan = new Scanner(System.in);
		int line = scan.nextInt();
		
		for(int i=0;i<line;i++) {
			for(int j=0;j<=i;j++) {
				trigle[i][j] = scan.nextInt();
			}
		}

		maxOfTrigle(line-1);

		System.out.println(trigle[0][0]);

	}

}
