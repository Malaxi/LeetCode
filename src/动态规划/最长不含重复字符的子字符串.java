package 动态规划;
/*
    48.请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度
 */
public class 最长不含重复字符的子字符串 {
    public int lengthOfLongestSubstring(String s) {
            int res = 0, tmp = 0;
            for(int j = 0; j < s.length(); j++) {
                int i = j - 1;
                //在当前字符左侧查找距离它最近的重复字符的索引i
                while(i >= 0 && s.charAt(i) != s.charAt(j)) i--;
                //tmp为以j-1字符结尾的最长非重复子字符串的长度
                //判断索引为i的字符是否在以j-1字符结尾的最长非重复子字符串的内部
                tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
                res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
            }
            return res;
        }
    }