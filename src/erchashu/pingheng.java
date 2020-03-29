package erchashu;

import java.util.ArrayList;
import java.util.List;

public class pingheng {

    private static List qianxuNumList = new ArrayList<>();
    private static List zhongxuNumList = new ArrayList<>();
    private static List houxuNumList = new ArrayList<>();

    public static void main(String[] args) {
        String str = "[3,9,20,null,null,15,7]";
        TreeNode1 node = TreeNode1.mkTree(str);
        System.out.println(isBalanced(node));

        qinaxuDigui(node);
        zhongxuDigui(node);
        houxuDigui(node);


        System.out.println("------------------");
        System.out.println(qianxuNumList.toString());
        System.out.println("------------------");
        System.out.println(zhongxuNumList.toString());
        System.out.println("------------------");
        System.out.println(houxuNumList.toString());

    }

    public static boolean isBalanced(TreeNode1 root) {
        //递归三部曲，二叉树的题目大部分都可以使用递归
        //1.找终止条件，树为空的时候即无需继续递归
        return depth(root) != -1;
        //2.找返回值，返回的应该是自己是否是BST以及左右子树的差值
        //3.一次递归应该做什么，左右子树的BST都是true，且要判断最后一次是否是BST
    }

    public static int depth(TreeNode1 root){
        if(root == null)
            return 0;
        int left = depth(root.left);

        if(left == -1)
            return -1;
        int right = depth(root.right);

        if(right == -1)
            return -1;
        return Math.abs(left - right) < 2 ? Math.max(left,right) + 1 : -1;
    }



    public static void qinaxuDigui(TreeNode1 treeNode) {
        qianxuNumList.add(treeNode.val);
        if (treeNode.left != null) {
            qinaxuDigui(treeNode.left);
        }
        if (treeNode.right != null) {
            qinaxuDigui(treeNode.right);
        }
    }

    // 用递归的方法进行中序遍历
    public static void zhongxuDigui(TreeNode1 treeNode) {
        if (treeNode.left != null) {
            zhongxuDigui(treeNode.left);
        }
        zhongxuNumList.add(treeNode.val);
        if (treeNode.right != null) {
            zhongxuDigui(treeNode.right);
        }
    }

    // 用递归的方法进行后序遍历
    public static void houxuDigui(TreeNode1 treeNode) {
        if (treeNode.left != null) {
            houxuDigui(treeNode.left);
        }
        if (treeNode.right != null) {
            houxuDigui(treeNode.right);
        }
        houxuNumList.add(treeNode.val);
    }



}
class TreeNode1 {
    public int val;
    public TreeNode1 left;
    public TreeNode1 right;
    TreeNode1(int x) { val = x; }
    public String toString(){
        return Integer.toString(val);
    }

    // int []arr = {3, 9, 20, Integer.MAX_VALUE, Integer.MAX_VALUE, 15, 7};
    private static int[] StrToIntArray(String str) {
        str = str.substring(1, str.length() - 1);
        String []strs = str.split(",");
        int []arr = new int[strs.length];

        for (int i = 0; i < arr.length; i++) {
            if (strs[i].equals("null")) {
                arr[i] = Integer.MAX_VALUE;
            } else {
                arr[i] = Integer.parseInt(strs[i]);
            }
        }

        return arr;
    }

    // String str = "[3,9,20,null,null,15,7]";
    public static TreeNode1 mkTree(String str) {

        int []arr = StrToIntArray(str);
        TreeNode1 []nodes = new TreeNode1[arr.length + 1];
        for (int i = 1; i < nodes.length; i++) {
            if (arr[i - 1] != Integer.MAX_VALUE) {
                nodes[i] = new TreeNode1(arr[i - 1]);
            }else {
                nodes[i] = null;
            }
        }

        TreeNode1 node = null;
        for (int i = 1; i < nodes.length / 2; i++) {
            node = nodes[i];
            if (node == null) continue;
            node.left = nodes[2 * i];
            node.right = nodes[2 * i + 1];
        }
        return nodes[1];
    }
}