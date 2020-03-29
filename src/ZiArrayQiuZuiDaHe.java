public class ZiArrayQiuZuiDaHe {
    /**
     * 输入一个整形数组,数组里有正数也有负数。
     * 数组中连续的一个或多个整数组成一个子数组,每个子数组都有一个和。
     * 求所有子数组的和的最大值。要求时间复杂度为 O(n)。
     * 例如输入的数组为 1, -2, 3, 10, -4, 7, 2, -5,和最大的子数组为 3, 10, -4,7, 2, 因此输出为该子数组的和 18。
     * @param args
     */
    public static void main(String[] args) {
        ZiArrayQiuZuiDaHe ziArrayQiuZuiDaHe = new ZiArrayQiuZuiDaHe();
        int maxSum = ziArrayQiuZuiDaHe.maxSum(new int[]{1,-2,3,10,-4,7,2,-5});
        System.out.println(maxSum);
    }

    public int maxSum(int[] array) {

        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("array is null or empty.");
        }

        int result = array[0], mark = 0;

        for (int i = 0; i < array.length; i++) {
            int element = array[i];

            if (mark >= 0) {
                mark += element;
            } else {
                mark = element;
            }

            if (mark > result) {
                result = mark;
            }
        }
        return result;
    }
}
