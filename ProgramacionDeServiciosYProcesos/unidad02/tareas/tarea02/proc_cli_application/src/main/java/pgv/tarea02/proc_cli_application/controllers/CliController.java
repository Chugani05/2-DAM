package pgv.tarea02.proc_cli_application.controllers;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class CliController implements CommandLineRunner{

    private static Logger logger = LoggerFactory.getLogger(CliController.class);

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Lanzador de Procesos (CLI) Linux ===\r\n" + //
                        "Comandos:\r\n" + //
                        "  lsof -i\r\n" + //
                        "  top\r\n" + //
                        "  ps aux | head \n");
        String command = scanner.nextLine().toLowerCase().trim();
        logger.info(command);
        scanner.close();
        
        if (command.startsWith("ps")) {
            // PsHeadService.java
            logger.info("Executing ps service");
        } else if (command.startsWith("lsof")) {
            // LsofService.java
            logger.info("Executing lsof service");
        } else if (command.startsWith("top")) {
            // TopService.java
            logger.info("Executing top service");
        } else {
            logger.info("Undefined command");
        }
    }
}
