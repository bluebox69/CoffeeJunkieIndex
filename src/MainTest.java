import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void calculateJunkieIndexValidInputShouldReturnCorrectIndex() {
        int cupAmount = 5;
        int[] coffeeCups = {2, 1, 0, 2, 0};
        double[] caffeineContent = {63.0, 11.5, 66.5, 27.5, 110.0};

        int result = Main.calculateJunkieIndex(cupAmount, coffeeCups, caffeineContent);
        System.out.println(result);

        // scaledIndex: 2
        assertEquals(2, result);
    }

    @Test
    public void calculateJunkieIndexZeroCupsShouldThrowException() {
        int cupAmount = 0;
        int[] coffeeCups = {2, 1, 0, 2, 0};
        double[] caffeineContent = {63.0, 11.5, 66.5, 27.5, 110.0};

        assertThrows(IllegalArgumentException.class, () -> {
            Main.calculateJunkieIndex(cupAmount, coffeeCups, caffeineContent);
        });
    }

    @Test
    public void calculateJunkieIndexNegativCupsShouldThrowException() {
        int cupAmount = -1;
        int[] coffeeCups = {2, 1, 0, 2, 0};
        double[] caffeineContent = {63.0, 11.5, 66.5, 27.5, 110.0};

        assertThrows(IllegalArgumentException.class, () -> {
            Main.calculateJunkieIndex(cupAmount, coffeeCups, caffeineContent);
        });
    }

    @Test
    public void calculateJunkieIndexMismatchedArrayLengthsShouldThrowException() {
        int cupAmount = 5;
        int[] coffeeCups = {2, 1, 0};
        double[] caffeineContent = {63.0, 11.5, 66.5, 27.5, 110.0};

        assertThrows(IllegalArgumentException.class, () -> {
            Main.calculateJunkieIndex(cupAmount, coffeeCups, caffeineContent);
        });
    }

    @Test
    public void calculateJunkieIndexHighConsumptionShouldReturnMaximumIndex() {
        int cupAmount = 50;
        int[] coffeeCups = {10, 20, 15, 5, 0};
        double[] caffeineContent = {63.0, 11.5, 66.5, 27.5, 110.0};

        int result = Main.calculateJunkieIndex(cupAmount, coffeeCups, caffeineContent);

        assertEquals(10, result); // Maximaler Junkie-Index
    }

}