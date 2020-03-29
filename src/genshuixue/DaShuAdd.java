package genshuixue;

/**
 * 大数相加
 */
public class DaShuAdd {
    public static void main(String[] args) {
        String j = add("1213123323213125","32131231231232132136");
//        1213123323213125
//        32131231231232132136

//        5213123233213121
//        63123123213213213123

//        52131232332131210000
//        63123123213213213123

//        32132444354555345261
        System.out.println(j);

    }

    public static String add(String str1,String str2){

        String n1 = new StringBuffer(str1).reverse().toString();
        String n2 = new StringBuffer(str2).reverse().toString();

        int l1 = n1.length();
        int l2 = n2.length();
        int maxL = l1>l2?l1:l2;

        //补齐0
        if (l1 < l2) {
            for (int i = l1; i < l2; i++) {
                n1 += "0";
            }
        }else {
            for (int i = l2; i < l1; i++) {
                n2 += "0";
            }
        }
        //System.out.println(n1);//test
        //System.out.println(n2);//test
        StringBuffer res = new StringBuffer();//存放的结果
        int c = 0;//进位

        for (int i = 0; i < maxL; i++) {
            int nSum = Integer.parseInt(n1.charAt(i) + "") + Integer.parseInt(n2.charAt(i) + "") + c;
            int ap = nSum%10;
            res.append(ap);
            c = nSum/10;
        }
        if (c>0) {
            res.append(c);
        }
        return res.reverse().toString();
    }
}
