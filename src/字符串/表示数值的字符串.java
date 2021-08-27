package 字符串;

import java.util.HashMap;
import java.util.Map;

/*
    20.请实现一个函数用来判断字符串是否表示数值（包括整数和小数）
    本质：状态转换机
 */
public class 表示数值的字符串 {
    class Solution {
        public boolean isNumber(String s) {
            //数组中的每一个元素代表以索引号作为初始状态的状态转换表
            Map[] states = {
                    new HashMap() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }}, // 0.
                    new HashMap() {{ put('d', 2); put('.', 4); }},                           // 1.
                    new HashMap() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, // 2.
                    new HashMap() {{ put('d', 3); put('e', 5); put(' ', 8); }},              // 3.
                    new HashMap() {{ put('d', 3); }},                                        // 4.
                    new HashMap() {{ put('s', 6); put('d', 7); }},                           // 5.
                    new HashMap() {{ put('d', 7); }},                                        // 6.
                    new HashMap() {{ put('d', 7); put(' ', 8); }},                           // 7.
                    new HashMap() {{ put(' ', 8); }}                                         // 8.
            };
            //p：存储的是当前状态
            int p = 0;
            //t：存储的是当前读取到的字符
            char t;
            //d:数字、s:符号、e：幂符号、c：当前读取到的字符
            for(char c : s.toCharArray()) {
                if(c >= '0' && c <= '9') t = 'd';
                else if(c == '+' || c == '-') t = 's';
                else if(c == 'e' || c == 'E') t = 'e';
                else if(c == '.' || c == ' ') t = c;
                else t = '?';
                if(!states[p].containsKey(t)) return false;
                p = (int)states[p].get(t);
            }
            return p == 2 || p == 3 || p == 7 || p == 8;
        }
    }
}
