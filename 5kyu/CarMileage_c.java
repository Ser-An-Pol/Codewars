
import java.util.stream.IntStream;

/*
 "7777...8?!??!", exclaimed Bob, "I missed it again! Argh!" Every time there's an interesting number coming up, 
 he notices and then promptly forgets. Who doesn't like catching those one-off interesting mileage numbers?

Let's make it so Bob never misses another interesting number. We've hacked into his car's computer, 
and we have a box hooked up that reads mileage numbers. We've got a box glued to his dash 
that lights up yellow or green depending on whether it receives a 1 or a 2 (respectively).

It's up to you, intrepid warrior, to glue the parts together. 
Write the function that parses the mileage number input, and returns a 2 if the number is "interesting" (see below), 
a 1 if an interesting number occurs within the next two miles, or a 0 if the number is not interesting.

Note: In Haskell, we use No, Almost and Yes instead of 0, 1 and 2.

"Interesting" Numbers

Interesting numbers are 3-or-more digit numbers that meet one or more of the following criteria:

Any digit followed by all zeros: 100, 90000
Every digit is the same number: 1111
The digits are sequential, incementing†: 1234
The digits are sequential, decrementing‡: 4321
The digits are a palindrome: 1221 or 73837
The digits match one of the values in the awesomePhrases array
† For incrementing sequences, 0 should come after 9, and not before  1, as in 7890.
‡ For decrementing sequences, 0 should come after 1, and not before  9, as in 3210.

So, you should expect these inputs and outputs:

// "boring" numbers
CarMileage.isInteresting(3, new int[]{1337, 256});    // 0
CarMileage.isInteresting(3236, new int[]{1337, 256}); // 0

// progress as we near an "interesting" number
CarMileage.isInteresting(11207, new int[]{}); // 0
CarMileage.isInteresting(11208, new int[]{}); // 0
CarMileage.isInteresting(11209, new int[]{}); // 1
CarMileage.isInteresting(11210, new int[]{}); // 1
CarMileage.isInteresting(11211, new int[]{}); // 2

// nearing a provided "awesome phrase"
CarMileage.isInteresting(1335, new int[]{1337, 256}); // 1
CarMileage.isInteresting(1336, new int[]{1337, 256}); // 1
CarMileage.isInteresting(1337, new int[]{1337, 256}); // 2
Error Checking

A number is only interesting if it is greater than 99!
Input will always be an integer greater than 0, and less than 1,000,000,000.
The awesomePhrases array will always be provided, and will always be an array, but may be empty. (Not everyone thinks numbers spell funny words...)
You should only ever output 0, 1, or 2.

 */
public class CarMileage_c {

    public static void main(String[] args) {
        int number = 1_000_000_000;
        System.out.println(isInteresting(number, new int[]{1337, 256}));
        // System.out.println(isRound(number));
        // System.out.println(isTheSame(number));
        // System.out.println(isPalindrom(number));
        // System.out.println(isSequentialInc(number));
        // System.out.println(isSequentialDec(number));
    }

    public static int isInteresting(int number, int[] awesomePhrases) {
        //Go to town
        if (_isInteresting(number, awesomePhrases)) {
            return 2;
        } else if (_isInteresting(number + 1, awesomePhrases) || _isInteresting(number + 2, awesomePhrases)) {
            return 1;
        } else {
            return 0;
        }
    }

    private static boolean _isInteresting(int number, int[] awesomePhrases) {
        if (number < 100) return false;
        String  numStr = String.valueOf(number);
        return  numStr.chars().skip(1).filter(i -> i != '0').count() == 0 ||
                numStr.chars().distinct().count() == 1 ||
                "1234567890".contains(numStr) ||
                "9876543210".contains(numStr) ||
                numStr.equals(new StringBuilder(numStr).reverse().toString()) ||
                IntStream.of(awesomePhrases).anyMatch(i -> i == number);
    }

    
    // public static boolean isReallyInteresting(int number, final int[] awesomePhrases) {
    //     return Stream.<Predicate<String>>of(
    //             s -> s.matches("\\d0+"),
    //             s -> new StringBuilder(s).reverse().toString().equals(s),
    //             s -> "1234567890".contains(s),
    //             s -> "9876543210".contains(s),
    //             s -> Arrays.stream(awesomePhrases).anyMatch(n -> parseInt(s) == n)
    //     ).anyMatch(p -> number > 99 && p.test(Integer.toString(number)));
    // }

    // public static int isInteresting(int number, int[] awesomePhrases) {
    //     return isReallyInteresting(number, awesomePhrases) ? 2
    //             : isReallyInteresting(number + 1, awesomePhrases) ? 1
    //             : isReallyInteresting(number + 2, awesomePhrases) ? 1 : 0;
    // }

    
    // public static int isInteresting(int number, int[] awesomePhrases) {
    //     if (number < 98) return 0;
    //     else if (number < 100) return 1;

    //     List<Integer> list =  IntStream.rangeClosed(number, number+2)
    //             .filter(i -> isRound(i) || isTheSame(i) || isPalindrom(i) || isSequentialInc(i)
    //                         || isSequentialDec(i) || isInArr(i, awesomePhrases))
    //             .boxed().toList();
    //     if (list.isEmpty()) return 0;
    //     System.out.println(list);
    //     return (list.get(0) == number) ? 2 : 1;
    // }
    // public static boolean  isInArr(int n, int[] arr) {
    //     return Arrays.stream(arr).filter(i -> i == n).count() > 0;
    // }
    // public static boolean isRound(int number) {
    //     return String.valueOf(number).chars().filter(c -> (char)c != '0').count() == 1;
    // }
    // public static boolean isTheSame(int number) {
    //     String str = String.valueOf(number);
    //     return str.chars().filter(c -> (char)c == str.charAt(0)).count() == str.length();
    // }
    // public static boolean isPalindrom(int number) {
    //     String str = String.valueOf(number);
    //     int len = str.length() - 1;
    //     return IntStream.rangeClosed(0, len).filter(i -> str.charAt(i) != str.charAt(len - i)).count() == 0;
    // }
    // public static boolean isSequentialInc(int number) {
    //     String str = String.valueOf(number);
    //     int len = str.length();
    //     return IntStream.range(1, len)
    //         .filter(i -> (Character.getNumericValue(str.charAt(i)) == Character.getNumericValue(str.charAt(i-1)) + 1)
    //                     || (Character.getNumericValue(str.charAt(i)) == 0 && Character.getNumericValue(str.charAt(i-1)) == 9 && i == len-1))
    //         .count() == len - 1;
    // }
    // public static boolean isSequentialDec(int number) {
    //     String str = String.valueOf(number);
    //     int len = str.length();
    //     return IntStream.range(1, len)
    //         .filter(i -> (Character.getNumericValue(str.charAt(i)) == Character.getNumericValue(str.charAt(i-1)) - 1))
    //         .count() == len - 1;
    // }
}
