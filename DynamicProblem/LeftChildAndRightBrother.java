package DynamicProblem;

import java.awt.print.Printable;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.directory.SearchControls;

//左孩子右兄弟问题:https://www.lanqiao.cn/problems/1451/learning/
//解题思路：https://blog.csdn.net/qq_44579321/article/details/127828609?spm=1001.2014.3001.5502

public class LeftChildAndRightBrother {
	
	public static int result = 0;
	public static ArrayList<Integer>[] lists = null;
	
	//求以父节点为根节点，直接子节点为孩子的二叉树的最大高度
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
		
		System.out.println("请输入数据");
		Scanner scan = new  Scanner(System.in);
		
		int nodeNumber;
		
		//输入总的节点数
		nodeNumber = scan.nextInt();
		
		//构造邻接表,创建ArrayList数组
		lists = new ArrayList[nodeNumber+10];
		
		//每个lists[i]都是存储一个ArrayList
		for(int i = 1;i<=nodeNumber;i++) {
			lists[i] = new ArrayList<Integer>();
		}
		
		//写入邻接表
		for(int j = 2;j<=nodeNumber;j++) {
			int node = scan.nextInt();
			lists[node].add(j);
		}
		
		search(0,1);
		System.out.println(result);
		
		scan.close();

	}
	
}
