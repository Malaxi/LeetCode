package 排序;

import java.util.PriorityQueue;
import java.util.Queue;

/*
    41.如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
      那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中
      读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值
   本质：采用堆排序
 */
public class 数据流中的中位数 {
    Queue<Integer> minHeap, maxHeap;
    public 数据流中的中位数() {
        // 小顶堆用来保存较大的一半数字，堆顶为较大的一半数字中的最小值
        minHeap = new PriorityQueue<>();
        // 大顶堆用来保存较小的一半数字，堆顶为较小的一半数字中的最大值
        maxHeap = new PriorityQueue<>((x, y) -> (y - x));
    }
    /*
     * 当两堆的数据个数相等时候，minHeap添加元素。
     * 采用的方法不是直接将数据插入minHeap，而是将数据先插入maxHeap，算法调整后
     * 将堆顶的数据插入到minHeap，这样保证minHeap插入的元素始终是为较小的一半数字中的最大值。
     * 同理minHeap数据多，往maxHeap添加数据的时候，先将数据放入minHeap，选出最大值放到maxHeap中,
     * 这样保证maxHeap插入的元素始终是为较大的一半数字中的最小值，最终minHeap保存的是较大的一半元素，
     * maxHeap保存的是较小的一半元素
     */
    public void addNum(int num) {
        if(minHeap.size() != maxHeap.size()) {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        } else {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
    }
    public double findMedian() {
        return minHeap.size() != maxHeap.size() ? minHeap.peek() : (minHeap.peek() + maxHeap.peek()) / 2.0;
    }

}
