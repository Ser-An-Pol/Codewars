
import java.util.Arrays;

/*
 * Given two arrays of strings a1 and a2 return a sorted array r in lexicographical order of the strings of a1 which are substrings of strings of a2.

Example 1:

a1 = ["arp", "live", "strong"]

a2 = ["lively", "alive", "harp", "sharp", "armstrong"]

returns ["arp", "live", "strong"]

Example 2:

a1 = ["tarp", "mice", "bull"]

a2 = ["lively", "alive", "harp", "sharp", "armstrong"]

returns []

Notes:

Arrays are written in "general" notation. See "Your Test Cases" for examples in your language.
In Shell bash a1 and a2 are strings. The return is a string where words are separated by commas.
Beware: In some languages r must be without duplicates.
 */

public class WhichAreIn_c {
    public static void main(String[] args) {
        String a[] = new String[]{ "arp", "live", "strong" };
    	String b[] = new String[] { "lively", "alive", "harp", "sharp", "armstrong" };

        System.out.println(Arrays.toString(inArray(a, b)));
    }

//     public static String[] inArray(String[] array1, String[] array2) {
//         ArrayList<String> ars = new ArrayList<>();

//         for (String str : array1) {
//             for (String base : array2) {
//                 if (base.contains(str)) {
//                     ars.add(str);
//                     break;
//                 }
//             }
//         }
//         Collections.sort(ars);
//         String[] res = new String[ars.size()];
//         int i = 0;
//         for (String str : ars) res[i++] = str;
//         return res;
//    }

   public static String[] inArray(String[] array1, String[] array2) {
    return Arrays.stream(array1)
      .filter(str ->
        Arrays.stream(array2).anyMatch(s -> s.contains(str)))
      .distinct()
      .sorted()
      .toArray(String[]::new);
	}
}
