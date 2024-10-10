
public class Main {

    public static void main(String[] args) {

        CoffeeTypeSelector coffeeTypeSelector = new CoffeeTypeSelector();
        CoffeeCupInputHandler coffeeCupInputHandler = new CoffeeCupInputHandler();

        System.out.println("Welcome to the Coffee Junkie Index!");
        System.out.println("-----------------------------------");
        //get input from User
        int cupAmount = coffeeCupInputHandler.getCupInput();
        int[] coffeeCups = coffeeTypeSelector.coffeeTypeInput(cupAmount);

        //berechne den Junkie Index → 1 to 10
        System.out.println(".... Calculating Junkie Index ....");
        int junkieIndex = calculateJunkieIndex(cupAmount, coffeeCups, coffeeTypeSelector.getCaffeineContent());

        printResult(junkieIndex);
        System.out.println("Programm finished");


    }

    private static void printResult(int junkieIndex) {
        switch (junkieIndex) {
            case 1:
                System.out.println("Junkie-Index: 1 You are very sober, Good!");
                break;
            case 2:
                System.out.println("Junkie-Index: 2 You are sober, Go ahead!");
                break;
            case 3:
                System.out.println("Junkie-Index: 3 You like Coffee, do you!");
                break;
            case 4:
                System.out.println("Junkie-Index: 4 A moderate coffee lover, keep sipping!");
                break;
            case 5:
                System.out.println("Junkie-Index: 5 Halfway to coffee nirvana, nice!");
                break;
            case 6:
                System.out.println("Junkie-Index: 6 You're in the zone, just one more cup!");
                break;
            case 7:
                System.out.println("Junkie-Index: 7 Caffeine enthusiast detected! Proceed with caution.");
                break;
            case 8:
                System.out.println("Junkie-Index: 8 Serious coffee addiction, but we love it!");
                break;
            case 9:
                System.out.println("Junkie-Index: 9 You might need an intervention, but who needs sleep?");
                break;
            case 10:
                System.out.println("Junkie-Index: 10 Coffee is your spirit animal! Time to join a support group!");
                break;
            default:
                System.out.println("Junkie-Index: Invalid level. Are you sure you drink coffee?");
                break;
        }
    }

    private static int calculateJunkieIndex(int cupAmount, int[] coffeeCups, double[] caffeineContent) {

        double totalCoffeinContent = getTotalCoffeinContent(coffeeCups, caffeineContent);

        double rawIndex = ((cupAmount * 10 * 2) + totalCoffeinContent) / 1000;
        double scaledIndex = Math.min(Math.max(rawIndex * 10, 1), 10);
        //System.out.printf("scaledIndex: %d %n", (int)scaledIndex);
        return (int) scaledIndex;
    }

    private static double getTotalCoffeinContent(int[] coffeeCups, double[] caffeineContent) {
        double totalCoffeinContent = 0;
        for (int i = 0; i < caffeineContent.length; i++) {
            totalCoffeinContent += (caffeineContent[i] * coffeeCups[i]);
            //System.out.printf("Total Koffeingehalt: %f %n", totalCoffeinContent);
        }
        return totalCoffeinContent;
    }


}

