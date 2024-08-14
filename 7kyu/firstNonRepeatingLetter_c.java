

/*
 * Write a function named first_non_repeating_letter† that takes a string input, and returns the first character that is not repeated anywhere in the string.

For example, if given the input 'stress', the function should return 't', since the letter t only occurs once in the string, and occurs first in the string.

As an added challenge, upper- and lowercase letters are considered the same character, but the function should return the correct case for the initial letter. For example, the input 'sTreSS' should return 'T'.

If a string contains all repeating characters, it should return an empty string ("");

† Note: the function is called firstNonRepeatingLetter for historical reasons, but your function should handle any Unicode character.
 */

public class firstNonRepeatingLetter_c {
    public static void main(String[] args) {
        System.out.println(firstNonRepeatingLetter("moon-men"));
    }

    // public static String firstNonRepeatingLetter(String s){
    //     String sl = s.toLowerCase();
    //     String res = "";
    //     int i, j, len = s.length();
    //     for (i = 0; i < len; i++) {
    //         char el = sl.charAt(i);
    //         for (j = 0; j < len; j++) if (el == sl.charAt(j) && i != j) break;
    //         if (j == len) {
    //             res = s.substring(i, i + 1);
    //             break;
    //         }
    //     }
    //     return res;
    // }

    static String firstNonRepeatingLetter(String s) {
        // return s.chars().
        //     filter(c -> s.indexOf(c) == s.lastIndexOf(c))
        //     .mapToObj(c -> "" + (char) c).findFirst().orElse("");
        return s.chars().filter(c -> s.toLowerCase().indexOf((c = Character.toLowerCase(c))) == s.toLowerCase().lastIndexOf(c))
            .mapToObj(c -> "" + (char) c).findFirst().orElse("");
    }
}
