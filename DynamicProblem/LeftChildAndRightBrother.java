package DynamicProblem;

import java.awt.print.Printable;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.directory.SearchControls;

//�������ֵ�����:https://www.lanqiao.cn/problems/1451/learning/
//����˼·��https://blog.csdn.net/qq_44579321/article/details/127828609?spm=1001.2014.3001.5502

public class LeftChildAndRightBrother {
	
	public static int result = 0;
	public static ArrayList<Integer>[] lists = null;
	
	//���Ը��ڵ�Ϊ���ڵ㣬ֱ���ӽڵ�Ϊ���ӵĶ����������߶�
	public static void search(int init,int fatherNode) {
		int hight = lists[fatherNode].size();
		
		if(hight == 0) {
			result = Math.max(init, result);
			return;
		}
		
		int nowHight = init + hight;
		for(int temp :  lists[fatherNode]) {
			search(nowHight,temp);
		}
		
		
	}

	public static void main(String[] args) {
		
		System.out.println("����������");
		Scanner scan = new  Scanner(System.in);
		
		int nodeNumber;
		
		//�����ܵĽڵ���
		nodeNumber = scan.nextInt();
		
		//�����ڽӱ�,����ArrayList����
		lists = new ArrayList[nodeNumber+10];
		
		//ÿ��lists[i]���Ǵ洢һ��ArrayList
		for(int i = 1;i<=nodeNumber;i++) {
			lists[i] = new ArrayList<Integer>();
		}
		
		//д���ڽӱ�
		for(int j = 2;j<=nodeNumber;j++) {
			int node = scan.nextInt();
			lists[node].add(j);
		}
		
		search(0,1);
		System.out.println(result);
		
		scan.close();

	}
	
}
