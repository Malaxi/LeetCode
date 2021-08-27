package 位运算;

public class 只出现一次的数字 {
    static int[] nums={1,0,1};

    public static void main(String[] args) {
        System.out.println(singleNumber(nums));
    }
    //利用异或的思想：
    //       1.一个数与自己做异或为0
    //       2.一个数与和自己不相等的数做抑或不为0
    //       3.所以用异或运算符将数组中的所有数字连接起来，剩下的就是只出现一次的数
    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
