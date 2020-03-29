package paixu;

import java.util.Arrays;

/**
 * 选择排序
 * 每一次从待排序的数据元素中选出最小（或最大）的一个元素，
 * 存放在序列的起始位置，直到全部待排序的数据元素排完。
 */
public class XuanZeSort {
    public static void main(String[] args) {
        int [] nums = {8,5,2,6,9,3,1,4,0,7};
        System.out.println("没有排序前： "+ Arrays.toString(nums));
        selectionSort(nums);
        System.out.println("排序后： "+Arrays.toString(nums));

    }

    private static void selectionSort(int[] nums) {
        for(int i = 0;i < nums.length-1;i++){
            int tmp = i;
            for(int j = i+1;j < nums.length;j++){
                if(nums[tmp]>nums[j]){
                    tmp = j;
                }
            }
            if(i != tmp){
                int exchang = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = exchang;
            }
        }
    }
}
