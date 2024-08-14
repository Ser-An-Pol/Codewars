/*
 * Jaden Smith, the son of Will Smith, is the star of films such as The Karate Kid (2010) and After Earth (2013). Jaden is also known for some of his philosophy that he delivers via Twitter. When writing on Twitter, he is known for almost always capitalizing every word. For simplicity, you'll have to capitalize each word, check out how contractions are expected to be in the example below.

Your task is to convert strings to how they would be written by Jaden Smith. The strings are actual quotes from Jaden Smith, but they are not capitalized in the same way he originally typed them.

Example:

Not Jaden-Cased: "How can mirrors be real if our eyes aren't real"
Jaden-Cased:     "How Can Mirrors Be Real If Our Eyes Aren't Real"
Note that the Java version expects a return value of null for an empty string or null.
 */


import static java.util.Arrays.stream;
import java.util.stream.Collectors;

public class toJadenCase {
    public static void main(String[] args) {
       
        System.out.println(toJadenCase("How can mirrors be real if our eyes aren't real"));
    }

    public static String toJadenCase(String phrase) {
	
		if (phrase == null || phrase.length() == 0) return null;
		return stream(phrase.split(" ")).map(x -> capitalizing(x)).collect(Collectors.joining(" "));
	}

    public static String capitalizing(String str) {
        return str.replace(str.charAt(0), Character.toUpperCase(str.charAt(0)));
    }

    // public static String toJadenCase(String phrase) {
    //     if (null == phrase || phrase.length() == 0) {
    //         return null;
    //     }
  
    //     return Arrays.stream(phrase.split(" "))
    //                  .map(i -> i.substring(0, 1).toUpperCase() + i.substring(1, i.length()))
    //                  .collect(Collectors.joining(" "));
    // }

    // public static String toJadenCase(String phrase) {
    //     if(phrase == null || phrase.isEmpty()) return null;
    //         return Arrays.stream(phrase.split("\\s+")).map(str -> Character.toUpperCase(str.charAt(0)) + str.substring(1))
    //                 .collect(Collectors.joining(" "));
    // }
    
  
}
