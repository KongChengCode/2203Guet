package DynamicProblem;

//回路计数：https://www.lanqiao.cn/problems/1462/learning/
//这道题使用c/c++不剪枝不会超时，但是java会超时


public class _回路计数 {
	static long dp[][] = new long[1<<21][25];
	static int route[][] = new int[25][25];

	//计算a，b是否互为质数，如果是，返回1；否则返回最大公因数
	static int gcd(int a, int b){
		return b==0?a:gcd(b, a%b);
	}

	public static void main(String[] args) {
		//初始化router数组
		for(int i=1;i<22;i++) 
			for(int j=1;j<22;j++) {
				if(gcd(i, j) == 1) 
					route[i-1][j-1] = route[j-1][i-1] = 1;
				else
					route[i-1][j-1] = route[j-1][i-1] = 0;

				}
		//初始化dp数组
		dp[1][0] = 1;
		
		//i表示状态，从1到100000000000000000000
		for(int i=1;i< (1<<21);i++) {
			//j表示第j+1栋教学楼
			for(int j=0;j<21;j++) {
				
				//判断当前状态是否含有第j+1栋教学楼
				//如果当前状态没有包含第j+1栋教学楼，执行代码
				if(( i>>j &1) == 0) 
					continue;
				
				//如果当前状态包含第j+1栋教学楼，执行代码
				for(int k=0;k<21;k++) {
					
					//如果当前状态包含了第k+1栋教学楼，或者第j+1栋教学楼到第k+1栋教学楼之间没有直达路径
					if( (i>>k&1) ==1 || route[j][k] == 0) 
						continue;
					
					dp[i+(1<<k)][k] += dp[i][j];
				}
			}
		}
		
		
		//计算结果
		//因为结果超过了int范围，所以使用long类型
		long ans = 0;
		
		//dp[(1<<21)-1][i]表示以第i+1栋楼为终点且遍历完所有的楼一遍的方案数
		//因为1和任何数互为质数，所以不用担心1和i+1之间没有路径
		for(int i=0;i<21;i++)
			ans += dp[(1<<21)-1][i];
		
		System.out.println(ans);
	}

}
