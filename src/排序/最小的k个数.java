package 排序;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
    40.输入整数数组 arr ，找出其中最小的 k个数。例如，
       输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4
 */
public class 最小的k个数 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i]=arr[i];
        }
        return res;
    }
}
