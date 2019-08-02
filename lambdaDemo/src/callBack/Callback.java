package callBack;

/**
 * @author Jeremy
 * @create 2019/8/1-13:50
 */
/** 
  * 回调接口 
  * 此接口为联系的方式，程序员A必须要实现此接口 
  * Created by qiudengjiao on 2017/5/27. 
  */
@FunctionalInterface
public interface Callback{

        void event(String result);

        }

