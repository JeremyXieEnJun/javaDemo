package callBack;


/**
 * @author Jeremy
 * @create 2019/8/1-13:57
 * 程序员B
 * 必须注意的是，这是一个底层的类，底层是不了解上层服务的
 */

public class ProgrammerB {
    public void doWork(Callback callback , String event) {
        System.out.println("程序员A告诉程序员B需要干的事情：" +event);
        System.out.println("程序员B:干活。。。");
        String result = "完成工作";

        //程序员B在这里调用A回调方法，通知A已经完成了任务
        callback.event(result);
    }
}
