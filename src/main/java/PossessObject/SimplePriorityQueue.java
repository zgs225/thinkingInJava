package PossessObject;

import utils.PrintUtil;

import java.util.*;

/**
 * User: yuez
 * Date: 13-12-6
 * Time: 下午9:18
 */
public class SimplePriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        Random rand = new Random(47);
        for(int i=0; i<10; i++) {
            priorityQueue.offer(rand.nextInt(i+10));
        }
        PrintUtil.print(priorityQueue);

        List<Integer> ints = Arrays.asList(25, 22, 20, 18, 14, 9, 3, 1, 2, 3, 9, 14, 18, 21, 23, 23);
        priorityQueue = new PriorityQueue<Integer>(ints);
        PrintUtil.print(priorityQueue);

        priorityQueue = new PriorityQueue<Integer>(ints.size(), Collections.reverseOrder());
        priorityQueue.addAll(ints);
        PrintUtil.print(priorityQueue);

        String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> strings = Arrays.asList(fact.split(""));
        PriorityQueue<String> stringPriorityQueue = new PriorityQueue<String>(strings);
        PrintUtil.print(stringPriorityQueue);

        stringPriorityQueue = new PriorityQueue<String>(strings.size(), Collections.reverseOrder());
        stringPriorityQueue.addAll(strings);
        PrintUtil.print(stringPriorityQueue);

        Set<Character> charSet = new HashSet<Character>();
        for(char c : fact.toCharArray()) {
            charSet.add(c);
        }
    }
}
