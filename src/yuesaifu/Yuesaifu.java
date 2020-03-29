package yuesaifu;

public class Yuesaifu {
    public static void main(String[] args) {
        int s = josephus(41,3);
        System.out.println(s);
    }

    public static int josephus(int n, int m) {
        //n个人,  0 1 2..n-1
        int[] people = new int[n];
        //人的索引
        int index = -1;
        //报数记录,  1 2 3..m
        int count = 0;
        //剩余人数  初始值为n
        int remain = n;

        //为了找到最后一个幸存者的位置，假设所有人都会被杀
        while (remain > 0) {
            index++;         //找到报数的人
            if (index == n) {  //所有人遍历一圈后从头遍历
                index = 0;
            }
            if (people[index] == -1) { //如果当前的人被杀  跳过
                continue;
            }

            count++;  //报数
            if (count == m) {
                people[index] = -1;  //报数到m后杀人
                count = 0;  //报数重置
                remain--;   //剩余人数递减
            }
        }
        return index;
    }
}
