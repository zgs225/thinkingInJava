import utils.PrintUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-2-4
 */
public class ReadProperties {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(
                new BufferedReader(
                        new FileReader(
                                "/Users/yuez/Development/Java/thinkingInJava/src/main/resources/capital.properties")));
        PrintUtil.print(properties.get("China"));
        PrintUtil.print(properties.get("America"));
    }
}
