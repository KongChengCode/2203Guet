package DynamicProblem;

//��·������https://www.lanqiao.cn/problems/1462/learning/
//�����ʹ��c/c++����֦���ᳬʱ������java�ᳬʱ


public class _��·���� {
	static long dp[][] = new long[1<<21][25];
	static int route[][] = new int[25][25];

	//����a��b�Ƿ�Ϊ����������ǣ�����1�����򷵻��������
	static int gcd(int a, int b){
		return b==0?a:gcd(b, a%b);
	}

	public static void main(String[] args) {
		//��ʼ��router����
		for(int i=1;i<22;i++) 
			for(int j=1;j<22;j++) {
				if(gcd(i, j) == 1) 
					route[i-1][j-1] = route[j-1][i-1] = 1;
				else
					route[i-1][j-1] = route[j-1][i-1] = 0;

				}
		//��ʼ��dp����
		dp[1][0] = 1;
		
		//i��ʾ״̬����1��100000000000000000000
		for(int i=1;i< (1<<21);i++) {
			//j��ʾ��j+1����ѧ¥
			for(int j=0;j<21;j++) {
				
				//�жϵ�ǰ״̬�Ƿ��е�j+1����ѧ¥
				//�����ǰ״̬û�а�����j+1����ѧ¥��ִ�д���
				if(( i>>j &1) == 0) 
					continue;
				
				//�����ǰ״̬������j+1����ѧ¥��ִ�д���
				for(int k=0;k<21;k++) {
					
					//�����ǰ״̬�����˵�k+1����ѧ¥�����ߵ�j+1����ѧ¥����k+1����ѧ¥֮��û��ֱ��·��
					if( (i>>k&1) ==1 || route[j][k] == 0) 
						continue;
					
					dp[i+(1<<k)][k] += dp[i][j];
				}
			}
		}
		
		
		//������
		//��Ϊ���������int��Χ������ʹ��long����
		long ans = 0;
		
		//dp[(1<<21)-1][i]��ʾ�Ե�i+1��¥Ϊ�յ��ұ��������е�¥һ��ķ�����
		//��Ϊ1���κ�����Ϊ���������Բ��õ���1��i+1֮��û��·��
		for(int i=0;i<21;i++)
			ans += dp[(1<<21)-1][i];
		
		System.out.println(ans);
	}

}
