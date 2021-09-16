package 美团专场.美团10场;
/*
    当男职员进入食堂时，他会优先选择已经坐有1人的餐桌用餐，只有当每张餐桌要么空着要么坐满2人时，他才会考虑空着的餐桌；
当女职员进入食堂时，她会优先选择未坐人的餐桌用餐，只有当每张餐桌都坐有至少1人时，她才会考虑已经坐有1人的餐桌；
无论男女，当有多张餐桌供职员选择时，他会选择最靠左的餐桌用餐
 */
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 第三题 {
    
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //数据组数、餐桌数、正在等待进入餐厅的人数
        int T,N,M;
        //每张餐桌的已经有的用餐人数、正在等待进入餐厅的人员的性别
        String str1,str2;
        System.out.print("请输入数据组数：");
        T = scanner.nextInt();
        for(int i=0;i<T;i++){
            System.out.print("请输入餐桌数：");
            N = scanner.nextInt();
            System.out.print("请输入每张餐桌的用餐人数：");
            str1=scanner.next();
            System.out.print("请输入正在等待进入餐厅的人数：");
            M = scanner.nextInt();
            System.out.print("请输入正在等待进入餐厅的人员性别：");
            str2=scanner.next();
            //输出正在等待进入餐厅的人员的入座桌号
            slove(N,str1,M,str2);
        }
    }

    private static void slove(int n, String str1, int m, String str2) {

    }
}
