package functional;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author Jeremy
 * @create 2019/8/1-10:58
 */

@java.lang.FunctionalInterface
public interface BufferedReaderProcess {

    String process(BufferedReader b) throws IOException;

}
