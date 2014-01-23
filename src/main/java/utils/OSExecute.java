package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yuez on 14-1-20.
 * Run an operating system command
 * and sent the output to the console
 */
public class OSExecute {
    public static void command(String command) {
        boolean err = false;
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while ((s = reader.readLine()) != null)
                PrintUtil.print(s);
            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((s = errors.readLine()) != null) {
                System.err.println(s);
                err = true;
            }
        } catch (IOException e) {
            if (!command.startsWith("CMD /C"))
                command("CMD /C" + command);
            else
                throw new RuntimeException(e);
        }
        if (err)
            throw new OSExecuteException("Errors executing");
    }

    public static void main(String[] args) {
        OSExecute.command("ls -la");
    }
}
