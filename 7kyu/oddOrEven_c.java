/*
 * Given a list of integers, determine whether the sum of its elements is odd or even.

Give your answer as a string matching "odd" or "even".

If the input array is empty consider it as: [0] (array with a zero).

Examples:

Input: [0]
Output: "even"

Input: [0, 1, 4]
Output: "odd"

Input: [0, -1, -5]
Output: "even"

 */

import static java.util.Arrays.stream;

public class oddOrEven_c {
    public static void main(String[] args) {
        System.out.println(oddOrEven(new int[] {2, 5, 34, 6}));
    }

    public static String oddOrEven (int[] array) {
        return (stream(array).sum() % 2 == 0) ? "even" : "odd";
    }
}
