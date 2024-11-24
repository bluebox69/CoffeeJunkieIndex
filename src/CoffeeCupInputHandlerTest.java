
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

//Testziel: werden die richtigen Fehler geworfen, wenn der InputValue negative Ganzzahlen sind, also die ungültige Equivalenzklasse.
public class CoffeeCupInputHandlerTest {

    @Test
    void oneShouldReturnOne () {
        var coffeeCupInputhandler = new CoffeeCupInputHandler();

        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(1,coffeeCupInputhandler.getCupInput());
    }

    @Test
    void intMaxReturnIntMax () {
        var coffeeCupInputhandler = new CoffeeCupInputHandler();

        String input = String.valueOf(Integer.MAX_VALUE - 1);
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(Integer.MAX_VALUE - 1,coffeeCupInputhandler.getCupInput());
    }

    @Test
    void zeroShouldReturnInvalidInputException () {
        var coffeeCupInputhandler = new CoffeeCupInputHandler();

        String input = "0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(InvalidInputException.class, () -> {
            coffeeCupInputhandler.getCupInput();
        });
    }

    @Test
    void intMaxPlusOneShouldReturnInvalidInputException () {
        var coffeeCupInputhandler = new CoffeeCupInputHandler();

        String input = String.valueOf(Integer.MAX_VALUE + 1);;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(InvalidInputException.class, () -> {
            coffeeCupInputhandler.getCupInput();
        });
    }

    //negativ Numbers
    @Test
    void negativNumbersShouldReturnInvalidInputException () {
        var coffeeCupInputhandler = new CoffeeCupInputHandler();

        String input = "-1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(InvalidInputException.class, () -> {
            coffeeCupInputhandler.getCupInput();
        });
    }
    @Test
    void stringsShouldReturnInvalidInputException () {
        var coffeeCupInputhandler = new CoffeeCupInputHandler();

        String input = "a";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(InvalidInputException.class, () -> {
            coffeeCupInputhandler.getCupInput();
        });
    }

    @Test
    void stringsMixedShouldReturnInvalidInputException () {
        var coffeeCupInputhandler = new CoffeeCupInputHandler();

        String input = "1a";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(InvalidInputException.class, () -> {
            coffeeCupInputhandler.getCupInput();
        });
    }

    @Test
    void doubleShouldReturnInvalidInputException () {
        var coffeeCupInputhandler = new CoffeeCupInputHandler();

        String input = "1.5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(InvalidInputException.class, () -> {
            coffeeCupInputhandler.getCupInput();
        });
    }


}