package DynamicProblem;

import java.util.ArrayList;
import java.util.Scanner;

public class temp {
    
    public static void main(String[] args) {
       
    	//int 类型转化为 String类型
    	//String 类型转化为 int 类型
    	String string = "111";
    	
    	//第一种方法：Integer.parseInt
    	int num1 = Integer.parseInt(string);
    	int num2 = Integer.parseInt(string,2);//转化为2进制

    	//第二种方法
    	//Integer.valueOf(string)返回Integer数据
    	int num3 = Integer.valueOf(string).intValue();
    			
    	
    }

}
