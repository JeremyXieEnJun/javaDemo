package callBack;

/**
 * @author Jeremy
 * @create 2019/8/1-14:42
 * 测试Callback  回调函数的测试
 */
public class MainActivity {
     public static void main(String[] args){

        ProgrammerB programmerB= new ProgrammerB();

        ProgrammerA programmerA = new ProgrammerA(programmerB);

        programmerA.doEvent("编写一个列表界面");
}

      }

