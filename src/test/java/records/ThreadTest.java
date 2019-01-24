package records;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by DCJS
 * 2019/1/11.
 */
public class ThreadTest {
    private static Logger logger = Logger.getLogger(ThreadTest.class);

    private static List<Thread> listThread = new ArrayList();

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread t = searchAndDownConsumes(i);
            listThread.add(t);
        }

        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

            if(listThread.size() == 3){
                Thread t1 = listThread.get(0);
                Thread t2 = listThread.get(1);
                Thread t3 = listThread.get(2);
                System.out.println("线程 ---- 0：" + t1.getState());
                System.out.println("线程 ---- 1：" + t2.getState());
                System.out.println("线程 ---- 2：" + t3.getState());
                if(t1.getState().toString().equals("TERMINATED") && t2.getState().toString().equals("TERMINATED") && t3.getState().toString().equals("TERMINATED") ){
                    listThread.clear();
                    for (int i = 0; i < 3; i++) {
                        Thread t = searchAndDownConsumes(i);
                        listThread.add(t);
                    }
                    System.out.println("重启线程 =========================");
                }
            }
        }
    }

    private static Thread searchAndDownConsumes(int i) {
        Thread t = new Thread(() -> {
            for(; ; ){
                try{
                    Thread.sleep(1000);
                    System.out.println(new Date() + "正常、活着 " + i);
//                    throw new RuntimeException("测试异常！！！");
                    return ;
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        },"下载简历任务第" + i + "线程");
        t.start();
        return t;
    }

}
