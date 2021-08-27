package 查找算法;

import java.util.HashMap;

/*
    50.查找字符串中第一个只出现一次的字符
*/
public class 第一个只出现一次的字符 {
    //第一种方法：利用哈希表统计每个字符出现的次数
    public static char firstUniqChar1(String s) {
        HashMap<Character, Integer> hashmap = new HashMap<>();
        //计算各个字符的出现次数
        for(int i=0;i<s.length();i++){
            //如果hashmap中不包含当前字符和它的计数
            if(!hashmap.containsKey(s.charAt(i))){
                hashmap.put(s.charAt(i),1);
            }
            else {
                Integer integer = hashmap.get(s.charAt(i));
                hashmap.replace(s.charAt(i),hashmap.get(s.charAt(i)),hashmap.get(s.charAt(i))+1);
            }
        }
        //返回只出现一次的字符
        for(int i=0;i<s.length();i++){
            if(hashmap.get(s.charAt(i))==1)
                return s.charAt(i);
        }
        return  ' ';
    }
    //第二种方法：如果该字符第一次出现的位置等于当前位置，且在该位置之后在没有出现该字符
    public static char firstUniqChar2(String s){
        for(int i=0;i<s.length();i++){
            if((i==s.indexOf(s.charAt(i)))&&(s.indexOf(s.charAt(i),i+1)==-1))
                return s.charAt(i);
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar1("abadsddooue"));
        System.out.println("-----------------------------");
        System.out.println(firstUniqChar2("abadsddooue"));
    }
}
