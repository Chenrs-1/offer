import java.util.Scanner;

/**
 * 在证明数素无穷性时，使用了一个表达式 N＝2＊3＊5＊7＊11…….＊P + 1，其中 P 为一个素数，
 * N 是 2 到 P 中所有素数的乘积加 1，若 P 为最大的素数，可以反证出 N 也是素数，
 * 从而证明素数是无穷多的。但有人因此认为，所有的 N 都是素数。如N0 = 3 为 素数，
 * N1 = 7 为素数，N2 = 31 为素数。请判断第 i 个 N 是否为素数。
 *
 * 输入描述:
 * 每组输入只有一行，包含一个整数i(0 <= i <= 14)，表示要检查的是第i个N。
 * 输出描述:
 * 输出只有一行，若Ni为素数，打印“Ni is a prime”，否则打印“Ni is not a prime”。
 *
 * 输入:1
 * 输出:7 is a prime
 *
 */
public class sushu {
    public static void main(String[] args) {

        int[] a = new int[15];
        int len = a.length;
        int j = 2;//初始值，每次都递增加一
        int i = 0;//用来存放数组值的下标
        while(len>0){
            int w = 2;//除数2
            while(w<=Math.sqrt(j)){
                if(j % w == 0){//看j能不能除整
                    break;//能整除，不是素数
                }
                w += 1;//累加
            }//能出while循环，代表除了本身和1之外的数都不能整除
            if(w>Math.sqrt(j)){//上面循环最后一次加一，一定会大于开根号，
              a[i] = j;//当前这个j是素数，放入数组
              i++;//数组下标加一
              len--;//数组没有放元素的长度减一
            }
            j += 1;//判断是否是素数的数加一
        }

        Scanner sc = new Scanner(System.in);
        int m=sc.nextInt();

        long he = qiuzhi(m,a);

        panduan(he);
    }

    private static long qiuzhi(int m,int[] a){
        long he = 1;
        for(int x = 0;x <= m;x++){
            if(x == m){
                he = he * a[x] + 1;
            }else{
                he = he * a[x];
            }
        }
        return he;
    }

    private static void panduan(long he){
        int c = 2;
        while(c<=Math.sqrt(he)){
            if(he % c == 0){//看j能不能除整
                System.out.println(he+" is not a prime");
                break;//能整除，不是素数
            }
            c += 1;//累加
        }//能出while循环，代表除了本身和1之外的数都不能整除
        if(c>Math.sqrt(he)){//上面循环最后一次加一，一定会大于开根号，
            System.out.println(he+" is a prime");
        }
    }
}
