package defaultDemo;


/**
 * @author Jeremy
 * @create 2019/8/1-18:05
 */
public class DefaultMethods {
    public static void main(String[] arg){
        NormalInterface instance = new NormalInterfaceImpl();
        instance.myNormalMethod();
        instance.myDefaultMethod();
    }
}

@FunctionalInterface
interface NormalInterface{
    void myNormalMethod();
    default  void myDefaultMethod () {
        System.out.println("-> myDefaultMethod");
    }
}

class NormalInterfaceImpl implements NormalInterface{
    @Override
    public void myNormalMethod() {
        System.out.println("-> myNormalMethod");
    }
}
