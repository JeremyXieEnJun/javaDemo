package functional;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Jeremy
 * @create 2019/8/1-11:18
 */
public class MethodQuoteDemo01 {

    @Test
    public void test(){
        List<String> list = Arrays.asList("a", "b", "A", "B");
        list.sort(String::compareToIgnoreCase);// 调用compareToIgnoreCase进行比较
        System.out.println(list);
    }

}
