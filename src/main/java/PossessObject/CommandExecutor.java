package PossessObject;

import utils.PrintUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-6
 * Time: 下午8:54
 */
public class CommandExecutor {
    public static void main(String[] args) {
        CommandQueue cq = new CommandQueue();
        for(int i=0; i<100; i++) {
            cq.add(new Command("Command No." + String.valueOf(i)));
        }
        CommandExecutor.execute(cq.get());
    }

    public static void execute(Queue<Command> q) {
        while(true) {
            Command c = q.poll();
            if(c == null)
                return;
            PrintUtil.print(c.operation());
        }
    }

    static class Command {
        private String command;

        public Command(String command) {
            this.command = command;
        }

        public String operation() {
            return this.command;
        }
    }

    static class CommandQueue {
        private Queue<Command> queue = new LinkedList<Command>();

        public void add(Command command) {
            queue.offer(command);
        }

        public Queue<Command> get() {
            return this.queue;
        }
    }
}
