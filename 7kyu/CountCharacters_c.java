/*
 * The main idea is to count all the occurring characters in a string. If you have a string like aba, then the result should be {'a': 2, 'b': 1}.

What if the string is empty? Then the result should be empty object literal, {}.
 */

import java.util.Map;
import java.util.stream.Collectors;

public class CountCharacters_c {
    public static void main(String[] args) {
        System.out.println(count("aba"));
    }

    // public static Map<Character, Integer> count(String str) {

    //     Map<Character, Integer> countMap = new HashMap<Character,Integer>();
        
    //     for (Character ch : str.toCharArray()) {
    //         countMap.put(ch, (int)str.chars().filter(c -> (char)c == ch).count());
    //     }
    //     return countMap;
    // }

    static Map<Character, Integer> count(String str) {
        return str.chars().mapToObj(c -> (char) c).collect(Collectors.toMap(c -> c, c -> 1, Integer::sum));
    }

    // public static Map<Character, Integer> count(String str) {
    //     Map<Character, Integer> count = new HashMap<>();
    //     for (char letter : str.toCharArray()) {
    //         count.merge(letter, 1, Integer::sum);
    //     }
    //     return count;
    // }
}
