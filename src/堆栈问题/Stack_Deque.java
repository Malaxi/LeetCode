package 堆栈问题;

import java.util.Stack;
/*
    用栈结构实现队列
*/
public class Stack_Deque {
    //主栈
    private Stack<Integer> A;
    //辅助栈
    private Stack<Integer> B;

    public Stack_Deque() {
        //主栈
        A = new Stack<>();
        //辅助栈
        B = new Stack<>();
    }
    public void appendTail(int value) {
        A.push(value);
    }
    public int deleteHead() {
        if(A.empty()) return -1;
        while (!A.empty()){
            B.push(A.pop());
        }
        return B.pop();
    }
    public void showDeque(){
        for(Integer num:A){
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        Stack_Deque sq=new Stack_Deque();
        for(int i=0;i<10;i++){
            sq.appendTail(i);
        }
        sq.showDeque();
        System.out.println("--------------------");
        System.out.println(sq.deleteHead());
    }
}
