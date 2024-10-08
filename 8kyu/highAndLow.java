
import static java.util.Arrays.stream;

/*
 * In this little assignment you are given a string of space separated numbers, and have to return the highest and lowest number.

Examples

highAndLow("1 2 3 4 5")  // return "5 1"
highAndLow("1 2 -3 4 5") // return "5 -3"
highAndLow("1 9 3 4 -5") // return "9 -5"
Notes

All numbers are valid Int32, no need to validate them.
There will always be at least one number in the input string.
Output string must be two numbers separated by a single space, and highest number is first.
 */

public class highAndLow {
    public static void main(String[] args) {
        System.out.println(highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
    }

    // public static String highAndLow(String numbers) {
    //     // Code here or
    //     String[] ints = Arrays.stream(numbers.split(" ")).
    //         map(Integer::valueOf).sorted().
    //         map(String::valueOf).toArray(String[]::new);
      
    //     return ints[ints.length - 1] + " " + ints[0];
    // }

    static String highAndLow(String numbers) {
        var stats = stream(numbers.split(" ")).mapToInt(Integer::parseInt).summaryStatistics();
    
        return stats.getMax() + " " + stats.getMin();
      }
    
}
