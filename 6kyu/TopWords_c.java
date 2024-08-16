import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;

/*
 Write a function that, given a string of text (possibly with punctuation and line-breaks), 
 returns an array of the top-3 most occurring words, in descending order of the number of occurrences.

Assumptions:

A word is a string of letters (A to Z) optionally containing one or more apostrophes (') in ASCII.
Apostrophes can appear at the start, middle or end of a word ('abc, abc', 'abc', ab'c are all valid)
Any other characters (e.g. #, \, / , . ...) are not part of a word and should be treated as whitespace.
Matches should be case-insensitive, and the words in the result should be lowercased.
Ties may be broken arbitrarily.
If a text contains fewer than three unique words, then either the top-2 or top-1 words should be returned, 
or an empty array if a text contains no words.

Examples:

"In a village of La Mancha, the name of which I have no desire to call to
mind, there lived not long since one of those gentlemen that keep a lance
in the lance-rack, an old buckler, a lean hack, and a greyhound for
coursing. An olla of rather more beef than mutton, a salad on most
nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra
on Sundays, made away with three-quarters of his income."

--> ["a", "of", "on"]


"e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e"

--> ["e", "ddd", "aa"]


"  //wont won't won't"

--> ["won't", "wont"]
Bonus points (not really, but just for fun):

Avoid creating an array whose memory footprint is roughly as big as the input text.
Avoid sorting the entire array of unique words.
 */

public class TopWords_c {
    public static void main(String[] args) {
        System.out.println(top3(" ...  "));
    }

    // public static List<String> top3(String s) {
    
    //     Map<String, Integer> freq = new HashMap<>();
    //     Arrays.stream(s.toLowerCase().replaceAll("[^[a-z']]", " ")
    //                     .replaceAll("(?<= )'+(?= )", " ")
    //                     .replaceAll(" +", " ")
    //                     .strip()
    //                     .split(" "))
    //                     .forEach(str -> freq.merge(str, 1, (prev, one) -> prev + one));  
    //     return (freq.containsKey("")) ? new ArrayList<String>() :
    //                 freq.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
    //                 .limit(3)
    //                 .map(entr -> entr.getKey())
    //                 .toList();       
    // }

    public static List<String> top3(String s) {
        return Arrays.stream(s.toLowerCase().split("[^a-z*|']"))
                .filter(o -> !o.isEmpty() && !o.replace("'","").isEmpty())
                .collect(groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey)
                .limit(3)
                .collect(Collectors.toList());
    }
}
