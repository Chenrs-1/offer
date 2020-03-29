package WanDe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class demo1 {
//    public static int[] twoSum(int[] nums, int target) {
//
//        for(int i = 0;i<nums.length;i++) {
//            for(int j=i+1;j<nums.length;j++) {
//                if(nums[i]+nums[j] == target && j!=i) {
//                    return new int[] {i,j};
//                }
//            }
//        }
//        return null;
//    }
    public static List<int[]> cheng(int[] nums, int target) {
        List<int[]> list = new ArrayList<>();
        for(int i = 0;i<nums.length;i++) {
            for(int j = i+1;j<nums.length;j++) {
                if((nums[i] * nums[j]) == target && j!=i) {
                    list.add(new int[] {nums[i],nums[j]});
                }
            }
        }
        if(null == list || list.size() ==0){
            list.add(new int[]{-1,-1});
            return list;
        }else {
            return list;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,5,7,8,11,12,15};
        int target = 60;
        List<int[]> list = cheng(nums, target);
        Iterator<int[]> i = list.iterator();
        while(i.hasNext()){
            int[] s=i.next();
            System.out.print(Arrays.toString(s));
        }
    }

}
