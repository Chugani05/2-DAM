package dam.rashi;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("sh", "-c", "ps aux | grep java");
        pb.redirectErrorStream(true);
        pb.redirectOutput(new File("mis_procesos.txt"));
        Process p = pb.start();
        pb.command("wc", "-l", "mis_procesos.txt");
        pb.redirectOutput(Redirect.PIPE);
        Process otherProcess = pb.start();
        try (var br = new BufferedReader(new InputStreamReader(otherProcess.getInputStream()))) {
            String[] line = br.readLine().split(" ");
            Integer linesCounter = Integer.parseInt(line[0]);
            System.out.println("The file has " + String.valueOf(linesCounter) + " lines");
            if (linesCounter > 3) {
                System.out.println("Warning, many active Java processes!!");
            }
        }
    }
}