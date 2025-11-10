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

        HorrocruxesSearch horrocruxesSearch = new HorrocruxesSearch();
        horrocruxesSearch.main(null);

        String output = outContent.toString();

        Assertions.assertTrue(horrocruxesSearch.getFound().get());
        Assertions.assertTrue(horrocruxesSearch.getWinner() == "Harry" || horrocruxesSearch.getWinner() == "Hermione" || horrocruxesSearch.getWinner() == "Ron" );
        Assertions.assertTrue(output.contains("found an Horrocrux"));
    }
}
