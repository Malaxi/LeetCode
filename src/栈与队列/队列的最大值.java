package 栈与队列;

import java.util.Deque;
import java.util.LinkedList;

/*
    59-II.队列的最大值，请定义一个队列并实现函数 max_value
         得到队列里的最大值，要求函数max_value、push_back
        和pop_front的均摊时间复杂度都是O(1)。若队列为空，
        pop_front 和 max_value需要返回 -1
 */
public class 队列的最大值 {
    Deque<Integer> res, max;
    public 队列的最大值() {
        res = new LinkedList<Integer>();
        max = new LinkedList<Integer>();
    }

    public int max_value() {
        if(max.isEmpty()) return -1;
        return max.peekFirst();
    }

    public void push_back(int value) {
        res.addLast(value);
        while(!max.isEmpty() && max.peekLast()<value) max.removeLast();
        max.addLast(value);
    }

    public int pop_front() {
        if(res.isEmpty()) return -1;
        int temp = res.pollFirst();
        if(temp == max.peekFirst()) max.removeFirst();
        return temp;
    }
}
