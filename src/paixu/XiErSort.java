package paixu;

import java.util.Arrays;

/**
 * 将待排序数组按照步长gap进行分组，
 * 然后将每组的元素利用直接插入排序的方法进行排序；
 * 每次将gap折半减小，循环上述操作；
 * 当gap=1时，利用直接插入，完成排序。
 */
public class XiErSort {
    public static void main(String[] args) {
        int[] nums =  { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        System.out.println("没有排序前： "+ Arrays.toString(nums));
        shellSort(nums);
        System.out.println("排序后： "+Arrays.toString(nums));
    }
    public static void shellSort(int[] nums) {
        for (int gap = nums.length/2; gap > 0; gap /=2) {
        //保证初始前面只有一个元素使其有序 然后每次插入和之前有序序列比较
            for (int i = gap; i < nums.length; i++) {
                for (int  j = i % gap; j <= i - gap; j += gap) {//同一组的和之前有序的元素比较交换
                    if (nums[i] < nums [j]) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
        }
    }
}
