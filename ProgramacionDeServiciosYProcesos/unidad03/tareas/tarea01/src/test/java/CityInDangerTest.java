import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.rashi.CityInDanger;

public class CityInDangerTest {

    @Test
    void CityInDangerOnlyNeutralizesTheOtherStops() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        CityInDanger.main(null);

        String content = outContent.toString();

        Assertions.assertTrue(CityInDanger.getThreatNeutralized().get());
        Assertions.assertTrue(CityInDanger.getWinner().equals("Superman") || CityInDanger.getWinner().equals("Batman"));
        Assertions.assertTrue(content.contains("Threat neutralized"));
    }
}
