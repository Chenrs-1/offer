package paixu;
/**
 * 每步将一个待排序的纪录，按其关键码值的大小插入前面已经排序的文件中适当位置上，直到全部插入完为止。
 * 算法适用于少量数据的排序，时间复杂度为O(n^2)。是稳定的排序方法。
 */

import java.util.Arrays;

public class ChaRuSort {
    public static void main(String[] args){
        int[] nums = { 6, 5, 3, 1, 8, 7, 2, 4 };
        System.out.println("没有排序前： "+Arrays.toString(nums));
        insertionSort(nums);
        System.out.println("排序后： "+Arrays.toString(nums));
    }

    public static void insertionSort(int[] nums){
        for(int i = 1;i < nums.length;i++){
            for(int j = i;j > 0;j--){
                if(nums[j]<nums[j-1]){
                    int tmp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = tmp;
                }
            }
        }
    }
}
