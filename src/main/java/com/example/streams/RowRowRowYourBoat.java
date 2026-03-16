package com.example.streams;

/**
 * Enhanced example runner demonstrating exception handling and AI analysis integration
 *
 * AI Analysis Prompts to Use:
 *
 * 1. "Analyze this Stream API method implementation. What edge cases should I consider?"
 * 2. "What exceptions should this method throw and when? Suggest a robust error handling strategy."
 * 3. "Review my exception handling. Are there any improvements or missing scenarios?"
 * 4. "How can I make this Stream operation more efficient or readable?"
 * 5. "What additional validation should I add to make this method production-ready?"
 *
 * Example Output (with exception handling):
 * <pre>
 * ===== Normal Operation =====
 * 1) [Apple, Banana, Orange, Peach, Pear, Tomato]
 * 2) [Banana, Orange, Peach, Pear, Tomato]
 * 3) [Apple, Banana]
 * 4) Apple, Banana, Orange, Peach, Pear, Tomato
 * 5) [Tomato, Potato, Pea, Corn, Carrot]
 * 6) [TOMATO, POTATO, PEA, CORN, CARROT]
 * 7) [1000, 1000, 999, 999, 995, 995, 994, 993, 991, 990] *
 * 8) [1000, 999, 995, 994, 993, 991, 990, 989, 987, 986] *
 * 9) [999, 995, 993, 991, 989, 987, 985, 983, 981, 979] *
 * 10) 498.461 *
 *
 * ===== Exception Handling Demo =====
 * Testing null collection: IllegalArgumentException caught
 * Testing empty collection: EmptyCollectionException caught
 * Testing invalid data: InvalidDataException caught
 *
 *     * These values will be different every run
 * </pre>
 */
public class RowRowRowYourBoat {

    public static void main(String[] args) {

        System.out.println("===== Normal Operation =====");

        try {
            GentlyDownTheStream stream = new GentlyDownTheStream();

            System.out.println("1) " + stream.sortedFruits());
            System.out.println("2) " + stream.sortedFruitsException());
            System.out.println("3) " + stream.sortedFruitsFirstTwo());
            System.out.println("4) " + stream.commaSeparatedListOfFruits());
            System.out.println("5) " + stream.reverseSortedVeggies());
            System.out.println("6) " + stream.reverseSortedVeggiesInUpperCase());
            System.out.println("7) " + stream.topTen());
            System.out.println("8) " + stream.topTenUnique());
            System.out.println("9) " + stream.topTenUniqueOdd());
            System.out.println("10) " + stream.average());

        } catch (InvalidDataException e) {
            System.err.println("Data processing error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }

        System.out.println("\n===== Exception Handling Demo =====");
        demonstrateExceptionHandling();
    }

    /**
     * Demonstrates various exception scenarios and proper handling
     * This shows students how robust error handling works in practice
     */
    private static void demonstrateExceptionHandling() {

        // Test 1: Null collection handling
        try {
            GentlyDownTheStream nullStream = new GentlyDownTheStream();
            nullStream.fruits = null;
            nullStream.sortedFruits();
        } catch (IllegalArgumentException e) {
            System.out.println("Testing null collection: IllegalArgumentException caught");
        } catch (Exception e) {
            System.out.println("Unexpected exception in null test: " + e.getClass().getSimpleName());
        }

        // Test 2: Empty collection handling
        try {
            GentlyDownTheStream emptyStream = new GentlyDownTheStream();
            emptyStream.fruits = java.util.List.of(); // Empty immutable list
            emptyStream.sortedFruits();
        } catch (EmptyCollectionException e) {
            System.out.println("Testing empty collection: EmptyCollectionException caught");
        } catch (Exception e) {
            System.out.println("Unexpected exception in empty test: " + e.getClass().getSimpleName());
        }

        // Test 3: Data processing error
        try {
            GentlyDownTheStream problemStream = new GentlyDownTheStream();
            problemStream.integerValues = java.util.List.of(); // Empty for average calculation
            problemStream.average();
        } catch (InvalidDataException e) {
            System.out.println("Testing invalid data: InvalidDataException caught");
        } catch (Exception e) {
            System.out.println("Unexpected exception in data test: " + e.getClass().getSimpleName());
        }

        // Test 4:
    }

}