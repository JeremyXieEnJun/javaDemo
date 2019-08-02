package callBack;

/**
 * @author Jeremy
 * @create 2019/8/1-13:52
 */

/** 
  * 层序员 A 
  * 层序员 A 是作为上层应用身份出现的，下层应用（程序员 B）是不知道 
  * 有哪些方法，因此它想被下层应用（程序员 B）调用必须实现此接口 
  * Created by qiudengjiao on 2017/5/27. 
  */
public class ProgrammerA implements Callback {

    //B程序员对象引用  
    private ProgrammerB programmerB;

    //在构造方法中国持有B程序员的引用  
    public ProgrammerA(ProgrammerB programmerB) {
        this.programmerB = programmerB;
    }

    /**
     *  
     *  程序员A通过这个方法告诉程序员B任务 
     */
    public void doEvent(String event) {
        //这里启用了一个线程来实现  ProgramerB  的方法调用。
        //程序员A调用程序员B中的方法,在这里注册回调接口
        //用Lambda表达式实现一个线程的run接口
        //ProgrammerA.this是指的callback接口在本身的实现
        new Thread(() -> programmerB.doWork(ProgrammerA.this, event)).start();
    }

    /** 
     * * 程序员B完成任务后调用此方法告诉A，也就是程序员A的回调方法 
     * 
     * @param result 
     */

    @Override
    public void event(String result){
        System.out.println("程序员B告诉程序员A："+result);
    }

}