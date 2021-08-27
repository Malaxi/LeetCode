package 位运算;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    56-II.在一个数组 nums 中除一个数字只出现一次之外，
         其他数字都出现了三次。请找出那个只出现一次的数字
 */
public class 数组中数字出现的次数II {
    //第一种方法：hashmap集合记录每一个数字的出现次数
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        for(int num:nums){
            if(hashmap.get(num)==null)  hashmap.put(num,1);
            else
                hashmap.replace(num,hashmap.get(num)+1);
        }
        for (Map.Entry<Integer,Integer> entry : hashmap.entrySet()) {
            if(entry.getValue()==1) return entry.getKey();
        }
        return -1;
    }
    public static int singleNumber2(int[] nums) {
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }

    public static void main(String[] args) {
        int[]  nums={3,4,3,3};
        数组中数字出现的次数II.singleNumber2(nums);
    }
}
