/*
 Given two strings s1 and s2, we want to visualize how different the two strings are. 
 We will only take into account the lowercase letters (a to z). 
 First let us count the frequency of each lowercase letters in s1 and s2.

s1 = "A aaaa bb c"

s2 = "& aaa bbb c d"

s1 has 4 'a', 2 'b', 1 'c'

s2 has 3 'a', 3 'b', 1 'c', 1 'd'

So the maximum for 'a' in s1 and s2 is 4 from s1; the maximum for 'b' is 3 from s2. 
In the following we will not consider letters when the maximum of their occurrences is less than or equal to 1.

We can resume the differences between s1 and s2 in the following string: 
"1:aaaa/2:bbb" where 1 in 1:aaaa stands for string s1 and aaaa because the maximum for a is 4. 
In the same manner 2:bbb stands for string s2 and bbb because the maximum for b is 3.

The task is to produce a string in which each lowercase letters of s1 or s2 appears 
as many times as its maximum if this maximum is strictly greater than 1; 
these letters will be prefixed by the number of the string where they appear with their maximum value and :. 
If the maximum is in s1 as well as in s2 the prefix is =:.

In the result, substrings (a substring is for example 2:nnnnn or 1:hhh; 
it contains the prefix) will be in decreasing order of their length and 
when they have the same length sorted in ascending lexicographic order 
(letters and digits - more precisely sorted by codepoint); 
the different groups will be separated by '/'. See examples and "Example Tests".

Hopefully other examples can make this clearer.

s1 = "my&friend&Paul has heavy hats! &"
s2 = "my friend John has many many friends &"
mix(s1, s2) --> "2:nnnnn/1:aaaa/1:hhh/2:mmm/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"

s1 = "mmmmm m nnnnn y&friend&Paul has heavy hats! &"
s2 = "my frie n d Joh n has ma n y ma n y frie n ds n&"
mix(s1, s2) --> "1:mmmmmm/=:nnnnnn/1:aaaa/1:hhh/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"

s1="Are the kids at home? aaaaa fffff"
s2="Yes they are here! aaaaa fffff"
mix(s1, s2) --> "=:aaaaaa/2:eeeee/=:fffff/1:tt/2:rr/=:hh"
Note for Swift, R, PowerShell

The prefix =: is replaced by E:

s1 = "mmmmm m nnnnn y&friend&Paul has heavy hats! &"
s2 = "my frie n d Joh n has ma n y ma n y frie n ds n&"
mix(s1, s2) --> "1:mmmmmm/E:nnnnnn/1:aaaa/1:hhh/2:yyy/2:dd/2:ff/2:ii/2:rr/E:ee/E:ss"
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Mixing_c {

    public static void main(String[] args) {
        System.out.println(mix("looping is fun but dangerous", "less dangerous than coding"));
    }

    // public static String mix(String s1, String s2) {
    //     // your code
    //     //System.out.println(s1.replaceAll("[^a-z]", ""));
    //     Map<String, Long> map1 = Arrays.stream(s1.replaceAll("[^a-z]", "")
    //                         .split(""))
    //                         .collect(groupingBy(Function.identity(), Collectors.counting()));
    //     Map<String, Long> map2 = Arrays.stream(s2.replaceAll("[^a-z]", "")
    //                         .split(""))
    //                         .collect(groupingBy(Function.identity(), Collectors.counting()));
    //     map1.entrySet().removeIf(x -> x.getValue() <= 1);
    //     map2.entrySet().removeIf(x -> x.getValue() <= 1);

    //     List<String> resList = new ArrayList<>();
    //     for (var m1 : map1.entrySet()) 
    //         if (map2.containsKey(m1.getKey())) {
    //             Long c2 = map2.get(m1.getKey());
    //             if (c2 > m1.getValue()) 
    //                 resList.add("2:"+m1.getKey().repeat(c2.intValue()));
    //             else if (c2 < m1.getValue())
    //                 resList.add("1:"+m1.getKey().repeat(m1.getValue().intValue()));
    //             else
    //                 resList.add("=:"+m1.getKey().repeat(c2.intValue()));
    //             map2.remove(m1.getKey());
    //         }
    //         else
    //             resList.add("1:"+m1.getKey().repeat(m1.getValue().intValue()));
        
    //     for (var m2 : map2.entrySet())
    //         resList.add("2:"+m2.getKey().repeat(m2.getValue().intValue()));

    //     // System.out.println(map2);
    //     // System.out.println(resList);

    //     Collections.sort(resList, new LengthFirstComparator());
    //     //Collections.reverse(resList);
    //     //System.out.println(resList);
    //     return resList.stream().collect(joining("/"));
    // }
    // public static class LengthFirstComparator implements Comparator<String> {
    //     @Override
    //     public int compare(String o1, String o2) {
    //         if (o1.length()!=o2.length()) {
    //             return -o1.length()+o2.length();
    //         }
    //         return o1.compareTo(o2);
    //     }
    // }

    public static String mix(String s1, String s2) {
    
        List<String> finalStr = new ArrayList<>();

        for (char c = 'a'; c <= 'z'; c++) {
            String s1_char = s1.replaceAll("[^"+c+"]+","");
            String s2_char = s2.replaceAll("[^"+c+"]+","");

            int s1_length = s1_char.length();
            int s2_length = s2_char.length();

            if(s1_length>1 || s2_length>1){
                if(s1_length == s2_length){
                    finalStr.add("=:"+s1_char);
                }
                if(s1_length>s2_length){
                    finalStr.add("1:"+s1_char);
                }
                if(s1_length<s2_length){
                    finalStr.add("2:"+s2_char);
                }
            }
        }
        Comparator<String> length = (x,y) -> y.length()-x.length();
        Comparator<String> type_value = (x,y) -> Character.compare(x.charAt(0),y.charAt(0));

        return finalStr.stream().sorted(length.thenComparing(type_value)).collect(Collectors.joining("/"));
    }

}

// return result.stream()
// .sorted(Comparator.comparing((String[] a) -> a[1].length()).reversed().thenComparing(a -> a[0]).thenComparing(a -> a[1]))
// .map(a -> Arrays.stream(a).collect(Collectors.joining(":")))
// .collect(Collectors.joining("/")).replaceFirst("/$", "");
