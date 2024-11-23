import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoffeeCupAmountTest {

    @Test
    void testNonIntegerInputThrowsCustomException() {
        // Simulierte Benutzereingabe: 1.5 (ungültig)
        String simulatedInput = "1\n";
        String simulatedInputTwo = "1\n";
        InputStream originalIn = System.in;

        //System.in umleiten
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        System.setIn(new ByteArrayInputStream(simulatedInputTwo.getBytes()));

        CoffeeTypeSelector selector = new CoffeeTypeSelector();

        try {
            assertThrows(InvalidInputException.class, () -> {
                selector.coffeeTypeInput(1);
            }, "Die Methode sollte eine InvalidInputException werfen, wenn keine Ganzzahl eingegeben wird.");
        } finally {
            // System.in zurücksetzen
            System.setIn(originalIn);
        }
    }
}
