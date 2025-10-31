package pgv.tarea02.proc_cli_application.controllers;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import pgv.tarea02.proc_cli_application.services.impl.LsofServiceImpl;
import pgv.tarea02.proc_cli_application.services.impl.PsHeadServiceImpl;
import pgv.tarea02.proc_cli_application.services.impl.TopServiceImpl;

@Controller
public class CliController implements CommandLineRunner{

    private static Logger logger = LoggerFactory.getLogger(CliController.class);

    @Autowired
    LsofServiceImpl lsofService;

    @Autowired
    PsHeadServiceImpl psHeadService;

    @Autowired
    TopServiceImpl topService;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Lanzador de Procesos (CLI) Linux ===\r\n" + //
                        "Comandos:\r\n" + //
                        "  lsof -i\r\n" + //
                        "  top -n1b\r\n" + //
                        "  ps aux | head \n");
        String command = scanner.nextLine().toLowerCase().trim();
        logger.info(command);
        scanner.close();
        
        if (command.startsWith("ps")) {
            psHeadService.processCommand(command);
        } else if (command.startsWith("lsof")) {
            lsofService.processCommand(command);
        } else if (command.startsWith("top")) {
            topService.processCommand(command);
        } else {
            logger.info("Undefined command");
        }
    }
}
