import java.util.Arrays;

public class MaoPaoPaiXu {
    public static void main(String[] args) {
        int[] a = { 6, 5, 3, 1, 8, 7, 2, 4 };
        int[] maopao = bubbleSort(a);
        System.out.println("冒泡排序结果："+ Arrays.toString(maopao));

    }

    /**
     * 冒泡排序
     *
     * 1.比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 3.针对所有的元素重复以上的步骤，除了最后一个；
     * 4.重复步骤1~3，直到排序完成。
     */
    public static int[] bubbleSort(int[] array) {
       if(array.length == 0){
           return array;
       }
       for(int i = 0;i < array.length;i++){
           for(int j = 0; j< array.length-1-i;j++){
               if(array[j]>array[j+1]){
                   int t = array[j+1];
                   array[j+1] = array[j];
                   array[j] = t;
               }
           }
       }
       return array;
    }
}
