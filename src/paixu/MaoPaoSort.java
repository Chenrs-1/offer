package paixu;

/**
 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 * 针对所有的元素重复以上的步骤，除了最后一个。
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 */
public class MaoPaoSort {
    public static void main(String[] args) {
        //冒泡排序算法
        int[] num = new int[]{1,5,8,2,3,9,4};

        System.out.println("排序前：");
        for (int n: num) {
            System.out.print(n+" ");
        }

        for(int i = 0;i<num.length-1;i++){
            for(int j = 0;j<num.length-i-1;j++){
                if(num[j]>num[j+1]){
                    int temp = num[j+1];
                    num[j+1] = num[j];
                    num[j] = temp;
                }
            }
        }
        System.out.println();
        System.out.println("排序后结果：");
        for (int n: num) {
            System.out.print(n+" ");
        }
    }
}
