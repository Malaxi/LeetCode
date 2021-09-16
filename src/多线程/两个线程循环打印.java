package 多线程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    两个线程循环打印0-100
 */
class PrintThread1 implements Runnable{
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static int count = 0;
    //当前线程编号
    private Integer threadNo;

    public PrintThread1(Integer threadNo) {
        this.threadNo = threadNo;
    }
    @Override
    public void run() {
        while (true) {
            try {
                //1.加锁
                lock.lock();
                //2.判断
                while (count % 2 != this.threadNo) {

                    if (count > 100) {//即使没有轮到自己打印，也要判断打印值是否超过界限(如果打印超出界限就没有必要等待，线程就要结束)，不会等待也不会释放锁
                        break;
                    }

                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (count > 100) { //是为了跳出第一次循环，以及判断在等待过程中其它线程是否已经打印完了全部值
                    break;
                }

                //3.干活
                System.out.println("thread-" + this.threadNo + "---->" + count);
                count++;

                //4.唤醒其它线程
                condition.signalAll();
            } finally {
                //5.释放锁
                lock.unlock();
            }
        }
    }
}
public class 两个线程循环打印 {
    public static void main(String[] args) {
        //线程0打印偶数
        new Thread(new PrintThread1(0),"线程0").start();
        //线程1打印奇数
        new Thread(new PrintThread1(1),"线程1").start();
    }
}
