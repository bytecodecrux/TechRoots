package commonmistakes;

public class TypeCasting {
    public static void main(String[] args) {

        // 1. Integer Division Truncation
        /* When dividing integers, Java truncates decimal results unless you cast to double first,
             leading to unexpected zeros in your calculations. The order of operations is crucial here
              - the cast must happen before the division.
         */

        // WRONG WAY
        int a = 9;
        int b = 10;
        double result = a / b * 100;        // Result is 0.0 - integer division happened first!
        System.out.println(result);          // Prints 0.0

        // RIGHT WAY
        double correctResult = (double) a / b * 100;  // Result is 90.0
        System.out.println(correctResult);   // Prints 90.0

        // 2. ClassCastException with Inheritance
        /* Attempting to cast an object to an incompatible type will crash your program with a ClassCastException
        - always check with instanceof first.
         */

        // WRONG WAy
        Object simpleObject = new Object();
        String text = (String) simpleObject;  // RUNTIME ERROR! ClassCastException

        // RIGHT WAY
        if (simpleObject instanceof String) {
            String safetext = (String) simpleObject;  // Only cast when we know it's safe
        }

        // 3. Char-to-Number Confusion:
        /* Casting a char to an int gives you its Unicode value, not the numeric value it represents
        use proper conversion methods instead.
         */

        // WRONG WAY
        char digit = '5';
        int value = digit;        // Result is 53 (the ASCII value), not 5!
        System.out.println(value);

        // RIGHT WAY
        char numVal = '5';
        int correctValue = Character.getNumericValue(numVal);  // Result is 5
        System.out.println(correctValue);

        // ALTERNATIVE
        int anotherCorrectValue = digit - '0';  // Also gives 5
        System.out.println(anotherCorrectValue);


        // 4. Loss of Precision in Financial Calculations:
        /* Financial calculations require special handling during casting to avoid dropping cents
        – never just truncate decimal values when working with money.
         */

        // WRONG WAY
        double price = 19.99;
        int dollarsOnly = (int) price;                 // Truncates to 19, losing cents
        System.out.println("Price: $" + dollarsOnly);  // Prints "Price: $19"

        // RIGHT WAY
        double priceWithCents = 19.99;
        int dollars = (int) priceWithCents;
        int cents = (int) Math.round((priceWithCents - dollars) * 100);
        System.out.println("Price: $" + dollars + "." + (cents < 10 ? "0" + cents : cents)); // Prints "Price: $19.99"

        // 5. String Parsing Exceptions:
        /* Always wrap String-to-number conversions in try-catch blocks to gracefully handle invalid input instead of
        crashing your application.
         */

        // WRONG WAY
        String input = "abc";
        int quantity = Integer.parseInt(input);  // RUNTIME ERROR! NumberFormatException

        // RIGHT WAY
        try {
            String userInput = "abc";
            int quantityRequested = Integer.parseInt(userInput);
            System.out.println("Quantity: " + quantityRequested);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number");
        }
    }
}
