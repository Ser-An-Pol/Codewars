/*
 Given the string representations of two integers, return the string representation of the sum of those integers.

For example:

sumStrings('1','2') // => '3'
A string representation of an integer will contain no characters besides the ten numerals "0" to "9".

I have removed the use of BigInteger and BigDecimal in java

Python: your solution need to work with huge numbers (about a milion digits), converting to int will not work.

 */

public class SumStrings_c {
    public static void main(String[] args) {
        System.out.println(sumStrings("00103", "08567"));
    }

    public static String sumStrings(String a, String b) {
        int len_a = a.length() - 1;
        int len_b = b.length() - 1;
        int len = (len_a < len_b) ? len_a : len_b;
        boolean dec = false;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= len; i++) {
            int m = Character.getNumericValue(a.charAt(len_a - i))
                    + Character.getNumericValue(b.charAt(len_b - i));
            if (dec){
                m++;
                dec = false;
            } 
            if (m > 9) {
                m -= 10;
                dec = true;
            }
            sb.insert(0, m);
        }
        if (len < len_a) {
            if (dec) {
                sb.insert(0, Character.getNumericValue(a.charAt(len_a - len - 1)) + 1);
                sb.insert(0, a.substring(0, len_a - len - 1));
            }
            else
                sb.insert(0, a.substring(0, len_a - len));
        }
        else if (len < len_b) {
            if (dec) {
                sb.insert(0, Character.getNumericValue(b.charAt(len_b - len - 1)) + 1);
                sb.insert(0, b.substring(0, len_b - len - 1));
            }
            else
                sb.insert(0, b.substring(0, len_b - len));
        }
        else if (dec) sb.insert(0, "1");
        return sb.toString().replaceAll("^0+", "");
    }
}
