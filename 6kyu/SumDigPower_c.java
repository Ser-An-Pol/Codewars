/*
 The number 89 is the first integer with more than one digit that fulfills the property partially 
 introduced in the title of this kata. What's the use of saying "Eureka"? Because this sum gives the same number: 
89 = 8^1 + 9^2
 

The next number in having this property is 135:

See this property again: 
135 = 1^1 + 3^2 + 5^3
 

Task

We need a function to collect these numbers, that may receive two integers a, b that defines the range [a,b] (inclusive) 
and outputs a list of the sorted numbers in the range that fulfills the property described above.

Examples

Let's see some cases (input -> output):

1, 10  --> [1, 2, 3, 4, 5, 6, 7, 8, 9]
1, 100 --> [1, 2, 3, 4, 5, 6, 7, 8, 9, 89]
If there are no numbers of this kind in the range [a,b] the function should output an empty list.

90, 100 --> []
Enjoy it!!

 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class SumDigPower_c {
    public static void main(String[] args) {
        System.out.println(sumDigPow(1, 1000));
    }

    public static List<Long> sumDigPow(long a, long b) {
        return LongStream.range(a, b+1).filter(m -> isSeqDigPow(m)).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
    public static boolean isSeqDigPow(long a) {
        //int[] digits = String.valueOf(a).chars().mapToObj(c -> String.valueOf((char)c)).mapToInt(Integer::valueOf).toArray();
        long[] digits = String.valueOf(a).chars().mapToLong(c -> Character.getNumericValue((char)c)).toArray();
        int len = digits.length;
        long res = 0;
        for (int i = 0; i < len; i++) res += (long)Math.pow(digits[i], i+1);
        return res == a;
    }

    // public static List<Long> sumDigPow(long a, long b) {
    //     return LongStream.rangeClosed(a, b)
    //       .filter(i -> isValid(i))
    //       .boxed()
    //       .collect(Collectors.toList());
    // }
    
    // private static boolean isValid(long x){
    //   String value = Long.toString(x);
    //   return IntStream.range(0, value.length())
    //      .mapToDouble(i -> Math.pow(Character.getNumericValue(value.charAt(i)), i + 1))
    //      .sum() == x;
    // }
}
