package 堆栈问题;

import java.util.*;
/*
    重新实现栈结构：包含查找栈中最小值的函数min
*/
public class Stack_minFuction {
    Stack<Integer>A,B;

    public Stack_minFuction() {
        //主栈
        A=new Stack<>();
        //辅助栈
        B=new Stack<>();
    }

    public void push(int x) {
        A.push(x);
        if(B.empty()||x<=B.peek())
            B.push(x);
    }

    public void pop() {
        Integer pop = A.pop();
        if(B.peek().equals(pop)) B.pop();
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
    public void showStack(){
        for(Integer num:A){
            System.out.println(num);
        }
    }
    public static void main(String[] args) {
        Stack_minFuction smf = new Stack_minFuction();
        Random random = new Random();
        for(int i=0;i<10;i++){
            smf.push(random.nextInt(100));
        }
        smf.showStack();
        System.out.println("----------");
        System.out.println(smf.min());

    }
}
