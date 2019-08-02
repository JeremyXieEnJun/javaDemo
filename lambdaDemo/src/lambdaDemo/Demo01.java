package lambdaDemo;

/**
 * @author Jeremy
 * @create 2019/7/30-15:31
 */
public class Demo01 {
    public static void main(String[] args) {
        //1.使用接口实现的类
        Comparator comparator = new MyComparator();

        //2.使用匿名内部类
        Comparator comparator1 = new Comparator(){
            @Override
            public int compare(int a, int b) {
                return a-b;
            }
        };

        //3.使用Lambda表达式来实现接口
        Comparator comparator2 = (a,b) ->(a -b);
        System.out.println(comparator2.compare(2,1));

    }
}


      class MyComparator implements Comparator{
         @Override
       public  int compare(int a,int b){
             return a-b;
         }

      }

      @FunctionalInterface  //这个注释对接口有要求，必须只含一个需要实现的方法
      interface Comparator{
         int compare(int a,int b);
      }


