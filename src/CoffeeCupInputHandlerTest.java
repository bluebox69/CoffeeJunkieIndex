import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

//Testziel: werden die richtigen Fehler geworfen, wenn der InputValue -1, also die ungültige Equivalenzklasse.
public class CoffeeCupInputHandlerTest {

    @Test
    void testErrorMessageForNegativeInput() {
        String simulatedInput = "-1\n1\n";
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOutput)); // Umleite System.out in einen Stream

        try {
            var coffeeCupInputHandler = new CoffeeCupInputHandler();
            coffeeCupInputHandler.getCupInput(); // Führt die Methode aus

            // Überprüfe, ob die erwartete Fehlermeldung ausgegeben wurde
            String consoleOutput = testOutput.toString();
            assertTrue(consoleOutput.contains("Impossible!! Try again"),
                    "Die Fehlermeldung für -1 wurde nicht korrekt ausgegeben.");
        } finally {
            System.setIn(originalIn); // System.in zurücksetzen
            System.setOut(originalOut); // System.out zurücksetzen
        }
    }
}