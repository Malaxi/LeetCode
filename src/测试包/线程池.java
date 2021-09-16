package 测试包;

import java.util.concurrent.*;

public class 线程池 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //---------------------------通过Executors工具类创建线程池------------------------------
        //单个线程的线程池
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        //固定大小的线程池
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
        //可伸缩的线程池
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        //-----------------------------------------------------------------------------------
        //数组阻塞队列
        ArrayBlockingQueue<Object> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        //链表阻塞队列
        LinkedBlockingQueue<Object> linkedBlockingQueue = new LinkedBlockingQueue<>(3);
        //---------------------------------手工创建线程池---------------------------------------
        ThreadPoolExecutor threadpool = new ThreadPoolExecutor(5,
                                                           8,
                                                              5,
                                                                           TimeUnit.MILLISECONDS,
                                                                           new ArrayBlockingQueue<>(3),
                                                                           Executors.defaultThreadFactory(),
                                                                           new ThreadPoolExecutor.DiscardPolicy()
                                                             );
        //使用线程池的execute方法执行任务
        threadpool.execute(()->{
            System.out.println("execute方法");
        });
        //使用线程池的submit方法执行任务
        Future<?> res = threadpool.submit(() -> {
            System.out.println("submit方法");
        });
        System.out.println(res.get());
        //关闭线程池
        threadpool.shutdown();
    }
}
