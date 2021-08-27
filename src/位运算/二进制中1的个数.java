package 位运算;
/*
    15.编写一个函数，输入是一个无符号整数（以二进制串的形式），
    返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
 */
public class 二进制中1的个数 {
    public int hammingWeight(int n) {
        int res=0;
        while (n!=0){
            res=res+n&1;
            n=n>>>1;
        }
        return res;
    }
}
