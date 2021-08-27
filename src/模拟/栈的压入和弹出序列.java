package 模拟;

import java.util.Stack;

/*
    31.输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹
      出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
      序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2}就不可能
      是该压栈序列的弹出序列

 */
public class 栈的压入和弹出序列 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i=0;
        for (int num:pushed) {
            stack.push(num);
            while (!stack.empty()&&stack.peek()==popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.empty();
    }
}
