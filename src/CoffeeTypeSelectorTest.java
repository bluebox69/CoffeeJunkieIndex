import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;


class CoffeeTypeSelectorTest {

    @Test
    void testValidCoffeeSelection() {
        CoffeeTypeSelector selector = new CoffeeTypeSelector();
        String simulatedInput = "1\n"; // Auswahl: 1 Americano

        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        try {
            int result = selector.coffeeTypeInputChoice();
            assertEquals(0, result, "Es sollte 1 Americano geben");
        }catch (InvalidCoffeeTypeException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testValidCupNumberSelection() {
        CoffeeTypeSelector selector = new CoffeeTypeSelector();
        String simulatedInput = "1\n"; // Auswahl: 1 Americano

        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        try {
            int result = selector.numberCupsInputChoice(1, 2);
            assertEquals(1, result, "Es sollte 1 zurückgegeben werden");
        }catch (InvalidInputException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testInvalidCoffeeTypeThrowsCustomExceptionNull() {
        CoffeeTypeSelector selector = new CoffeeTypeSelector();
        String simulatedInput = "0\n"; // Ungültige Auswahl: 0 (außerhalb des Bereichs)
        String expected = "Invalid coffee type selected.";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        InvalidCoffeeTypeException e = assertThrows(InvalidCoffeeTypeException.class, selector::coffeeTypeInputChoice);

        String actual = e.getMessage();
        assertTrue(actual.contains(expected));
    }
    @Test
    void testInvalidCoffeeTypeThrowsCustomExceptionSix() {
        CoffeeTypeSelector selector = new CoffeeTypeSelector();
        String simulatedInput = "6\n"; // Ungültige Auswahl: 6 (außerhalb des Bereichs)
        String expected = "Invalid coffee type selected.";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        InvalidCoffeeTypeException e = assertThrows(InvalidCoffeeTypeException.class, selector::coffeeTypeInputChoice);

        String actual = e.getMessage();
        assertTrue(actual.contains(expected));
    }

    @Test
    void testInvalidCupNumberThrowsCustomException() {
        CoffeeTypeSelector selector = new CoffeeTypeSelector();
        String simulatedInput = "-2\n"; // Ungültige Tassenanzahl: -2
        String expected = "Invalid number of cups. You have 2 cups left. Please try again.";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        InvalidInputException e = assertThrows(InvalidInputException.class, () -> {
            selector.numberCupsInputChoice(1, 2); // 2 Tassen zu verarbeiten
        });

        String actual = e.getMessage();
        assertTrue(actual.contains(expected));
    }
    @Test
    void testInvalidCupNumberThrowsExceptionFloat() { // not a custom exception
        CoffeeTypeSelector selector = new CoffeeTypeSelector();
        String simulatedInput = "1.5\n"; // Ungültige Tassenanzahl: 1.5
        String expected = "Invalid input detected. Please enter only whole numbers.";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        InvalidInputException e = assertThrows(InvalidInputException.class, () -> {
            selector.numberCupsInputChoice(1, 2); // 2 Tassen zu verarbeiten
        });

        String actual = e.getMessage();
        assertTrue(actual.contains(expected));
    }

    @Test
    void testInvalidCupNumberThrowsExceptionCharacter() { // not a custom exception
        CoffeeTypeSelector selector = new CoffeeTypeSelector();
        String simulatedInput = "abc\n"; // Ungültige Tassenanzahl: "abc"
        String expected = "Invalid input detected. Please enter only whole numbers.";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        InvalidInputException e = assertThrows(InvalidInputException.class, () -> {
            selector.numberCupsInputChoice(1, 2); // 2 Tassen zu verarbeiten
        });

        String actual = e.getMessage();
        assertTrue(actual.contains(expected));
    }
}
