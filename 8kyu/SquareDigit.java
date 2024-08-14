/*
 * In this kata, you are asked to square every digit of a number and concatenate them.

For example, if we run 9119 through the function, 811181 will come out, because 92 is 81 and 12 is 1. (81-1-1-81)

Example #2: An input of 765 will/should return 493625 because 72 is 49, 62 is 36, and 52 is 25. (49-36-25)

Note: The function accepts an integer and returns an integer.


 */

import java.util.stream.Collectors;

public class SquareDigit {

    public static void main(String[] args) {

        System.out.println(squareDigits(658));

    }

    // public static  int squareDigits(int n) {
    //     if (n == 0) return 0;
    //     int digit;
    //     StringBuilder sb = new StringBuilder();
    //     while (n > 0) {
    //         digit = n % 10;
    //         sb.insert(0, digit * digit);
    //         n /= 10;
    //     }
    //     return Integer.parseInt(sb.toString());
    // }

    public static int squareDigits(int n) {
    
        return Integer.parseInt(
          String.valueOf(n)
            .chars()
            .map(x -> Character.getNumericValue((char) x))
            .map(x -> x * x)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(""))
        );
      }
}
