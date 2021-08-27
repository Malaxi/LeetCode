package 堆栈问题;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 括号匹配 {
    public static String s="(){}}{";

    public static boolean isValidate(String s){
        Map map=new HashMap();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        if(s.length()==0||s.length()%2!=0){
            return false;
        }

        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            //如果碰到左括号
            if(s.charAt(i)=='['||s.charAt(i)=='{'||s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }
            //如果碰到右括号
            else if(s.charAt(i)==']'||s.charAt(i)=='}'||s.charAt(i)==')'){
                //1.先判断当前栈是否为空
                if(stack.empty()) return false;
                //2.再判断栈顶元素与当前s.charAt是否是一对
                if(stack.pop()!=map.get(s.charAt(i))) return false;
            }
        }
        if(stack.empty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(isValidate(s));
    }

}
