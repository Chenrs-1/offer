public class Offer_5 {
    /**
     * offer 第5题：
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     *
     * 示例 1：
     *
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     * 解题思路
     * 在字符串尾部填充任意字符，使得字符串的长度等于替换之后的长度。因为一个空格要替换成三个字符（%20），
     * 因此当遍历到一个空格时，需要在尾部填充两个任意字符。
     *
     * 令 P1 指向字符串原来的末尾位置，P2 指向字符串现在的末尾位置。P1 和 P2 从后向前遍历，
     * 当 P1 遍历到一个空格时，就需要令 P2 指向的位置依次填充 02%（注意是逆序的），否则就填充上 P1 指向字符的值。
     *
     * 从后向前遍是为了在改变 P2 所指向的内容时，不会影响到 P1 遍历原来字符串的内容。
     */
    public static void main(String[] args) {
        String sq = "We are happy.";
        System.out.println("输入="+sq);
        Offer_5 Solution = new Offer_5();
        String sh = Solution.replaceSpace(sq);
        System.out.println("输入后="+sh);
    }

    public String replaceSpace(String s) {

        StringBuffer sb = new StringBuffer(s);
        int l1 = s.length()-1;
        for(int i = 0;i <= l1;i++){
            if(sb.charAt(i)==' ')
                sb.append("  ");//两个空格
        }
        int l2 = sb.length()-1;
        while(l1 >= 0 && l2 > l1){
            char c = sb.charAt(l1--);

            if(c==' '){
                sb.setCharAt(l2--,'0');
                sb.setCharAt(l2--,'2');
                sb.setCharAt(l2--,'%');
            }else{
                sb.setCharAt(l2--,c);
            }
        }
        return sb.toString();
    }
}
