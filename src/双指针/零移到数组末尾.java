package 双指针;

public class 零移到数组末尾 {
    private static int[] nums={0,1,0,3,12};
    //第1种方法
    public static void moveZeroes(int[] nums) {
        for(int i=0;i< nums.length;i++){
            if(nums[i]!=0) continue;
            for(int j=i+1;j< nums.length;j++){
                if(nums[j]==0) continue;
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                break;
            }
        }
    }

    public static void main(String[] args) {
        moveZeroes(nums);
        for(int num:nums){System.out.print(num);System.out.print(' ');}
    }
}
