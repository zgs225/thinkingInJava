package PossessObject;

import utils.PrintUtil;
import utils.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-3
 * Time: 下午10:39
 */
public class SimpleStack {
    public static void main(String[] args) {
        String express = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+e+s---";
        Stack<String> s = new Stack<String>();
        for(int i=0; i<express.toCharArray().length; i++) {
            if(express.toCharArray()[i] == '+') {
                s.push(String.valueOf(express.toCharArray()[i+1]));
            } else if(express.toCharArray()[i] == '-') {
                PrintUtil.print(s.pop());
            }
        }
    }
}
