import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.rashi.HorrocruxesSearch;

public class HorrocruxesSearchTest {

    @Test
    void horrocruxesSearchTest() throws InterruptedException{
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        HorrocruxesSearch.main(null);

        String output = outContent.toString();

        Assertions.assertTrue(HorrocruxesSearch.getFound().get());
        Assertions.assertTrue(HorrocruxesSearch.getWinner().equals("Harry") || HorrocruxesSearch.getWinner().equals("Hermione") || HorrocruxesSearch.getWinner().equals("Ron") );
        Assertions.assertTrue(output.contains("found an Horrocrux"));
    }
}
