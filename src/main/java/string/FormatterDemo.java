package string;

import utils.PrintUtil;

import java.util.Calendar;
import java.util.Formatter;
import java.util.GregorianCalendar;

/**
 * Created by yuez on 14-1-27.
 */
public class FormatterDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);

        // Explicit argument indices may be used re-order output
        formatter.format("%4$2s %3$2s %2$2s %1$2s", "a", "b", "c", "d");
        PrintUtil.print(sb.toString());

        sb = new StringBuilder();
        Calendar c = new GregorianCalendar(2014, Calendar.JANUARY, 3);
        PrintUtil.print(String.format("Duke's birthday: %1$tm %2$te $3$tY", c));
    }
}
