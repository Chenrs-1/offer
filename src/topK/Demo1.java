package topK;

import java.util.*;

/**
 * 方法:优先级队列,传入的比较器 用大根堆模式来实现.
 * 队列里面只存储十个数据,然后依次遍历十万个数据.
 * 如果遍历的数据比队列顶部的最大值还大,则不管它.
 * 如果遍历的数据比队列顶部的最大值还小,队列中remove掉顶部元素,再将该元素插入进去
 */
public class Demo1 {
    public static void main(String[] args) {
        final int NUM = 100000; //规定十万给数据
        int i = 0; //做判断用
        Random random = new Random(  );
        ArrayList<Integer> arrayList = new ArrayList<Integer>(NUM); //存储十万个数据
        while (i < NUM){
            arrayList.add( random.nextInt(NUM));
            i++;
        }

        PriorityQueue<Integer> integerPriorityQueue =
                new PriorityQueue<>( 10, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2.compareTo( o1 );
                    }
                } );    //创建一个优先级队列,创建一个新的Comparator比较器.实现从大到小排序.

        /**
         * 先把前十个添加进去
         */
        Iterator<Integer> iterator = arrayList.iterator();
        for (int j = 0; j < 10 ; j++) {
            integerPriorityQueue.add( iterator.next() );
        }

        //再继续遍历剩余数据
        while (iterator.hasNext()){
            Integer integer = iterator.next(); //当前遍历的数据
            Integer integer2 = integerPriorityQueue.peek();  //当前优先级队列的堆顶数据.
            if(integer2 > integer){
                integerPriorityQueue.remove(integer2);
                integerPriorityQueue.add( integer );
            }
        }

        //打印最终的十个数据
        Iterator<Integer> iterator2 = integerPriorityQueue.iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
    }
}
