package topK;

import java.util.Arrays;

public class ZhaoZuiDa {
    public static void main(String[] args) {
        // 源数据
        int[] data = {56,275,12,6,45,478,41,1236,456,12,546,45};

        // 获取Top5
        int[] top5 = topK(data, 5);
        System.out.println(Arrays.toString(top5));
    }

    // 从data数组中获取最大的k个数
    private static int[] topK(int[] data,int k){
        // 先取K个元素放入一个数组topk中
        int[] topk = new int[k];
        for(int i = 0;i< k;i++) {
            topk[i] = data[i];
        }
        sort(topk);
        // 从k开始，遍历data
        for(int i= k;i<data.length;i++) {
            // 当数据大于堆中最小的数（根节点）时，替换堆中的根节点，再转换成堆
            if(data[i] > topk[0]) {
                topk[0] = data[i];
                sort(topk);
            }
        }
        return topk;
    }
    public static void sort(int []arr){
        //1.构建小顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }
    }
    public static void adjustHeap(int []arr,int i,int length){
        int temp = arr[i];//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]>arr[k+1]){//如果左子结点大于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] <temp){//如果子节点小于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }
}
