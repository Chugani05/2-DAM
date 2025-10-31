package pgv.tarea02.proc_cli_application.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pgv.tarea02.proc_cli_application.services.impl.LsofServiceImpl;
import pgv.tarea02.proc_cli_application.services.impl.PsHeadServiceImpl;
import pgv.tarea02.proc_cli_application.services.impl.TopServiceImpl;

class CliControllerTest {

    static CliController cliController;

    @BeforeAll
    static void beforeAll() {
        cliController = new CliController();
        cliController.lsofService = new LsofServiceImpl();
        cliController.psHeadService = new PsHeadServiceImpl();
        cliController.topService = new TopServiceImpl();
    }

    @Test
    void testRunLsofService() {
        boolean executeService = cliController.runService("lsof");
        Assertions.assertTrue(executeService);
    }

    @Test
    void testRunPsService() {
        boolean executeService = cliController.runService("ps");
        Assertions.assertTrue(executeService);
    }

    @Test
    void testRunTopService() {
        boolean executeService = cliController.runService("top");
        Assertions.assertTrue(executeService);
    }

    @Test
    void testBadRunService() {
        boolean executeService = cliController.runService("ls");
        Assertions.assertFalse(executeService);
    }
}
