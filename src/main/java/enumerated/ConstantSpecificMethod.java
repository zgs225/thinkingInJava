package enumerated;

import utils.PrintUtil;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by yuez on 14-1-23
 */
public enum ConstantSpecificMethod {
    DATE_TIME {
        String getInfo() {
            return DateFormat.getInstance().format(new Date());
        }
    },
    CLASSPATH {
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },
    VERSION {
        String getInfo() {
            return System.getProperty("java.version");
        }
    };

    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecificMethod c : ConstantSpecificMethod.values())
            PrintUtil.print(c.getInfo());
    }
}
