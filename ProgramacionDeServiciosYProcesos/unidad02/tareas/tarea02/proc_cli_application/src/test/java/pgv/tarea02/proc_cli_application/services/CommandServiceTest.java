package pgv.tarea02.proc_cli_application.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pgv.tarea02.proc_cli_application.domain.Job;
import pgv.tarea02.proc_cli_application.repositories.file.FileJobRepository;
import pgv.tarea02.proc_cli_application.services.impl.LsofServiceImpl;

public class CommandServiceTest {

    static LsofServiceImpl lsofServiceImpl;

    @BeforeAll
    static void beforeAll() {
        lsofServiceImpl = new LsofServiceImpl();
        lsofServiceImpl.setFileJobRepository(new FileJobRepository());
    }

    @Test
    void testSetAndGetCommand() {
        String command = "lsof -i";
        lsofServiceImpl.setCommand(command);
        Assertions.assertEquals(command, lsofServiceImpl.getCommand());
    }

    @Test
    void testSetAndGetType() {
        lsofServiceImpl.setType(null);
        Assertions.assertNull(lsofServiceImpl.getType());
        Job job = Job.LSOF;
        lsofServiceImpl.setType(job);
        Assertions.assertEquals(job.toString(), lsofServiceImpl.getType());
    }

    @Test
    void testValidateGoodMainCommand() {
        Assertions.assertTrue(lsofServiceImpl.validate("lsof -i"));
    }

    @Test
    void testValidateBadMainCommand() {
        Assertions.assertFalse(lsofServiceImpl.validate("lsofa -i"));
    }

    @Test
    void testGoodCommandExecution() {
        lsofServiceImpl.setCommand("lsof -i");
        Assertions.assertTrue(lsofServiceImpl.executeCommand());
    }

    @Test
    void testBadCommandExecution() {
        lsofServiceImpl.setCommand(null);
        Assertions.assertFalse(lsofServiceImpl.executeCommand());
    }
}
