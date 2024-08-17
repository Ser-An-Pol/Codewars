
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
 There is a secret string which is unknown to you. Given a collection of random triplets from the string, 
 recover the original string.

A triplet here is defined as a sequence of three letters such that each letter occurs 
somewhere before the next in the given string. "whi" is a triplet for the string "whatisup".

As a simplification, you may assume that no letter occurs more than once in the secret string.

You can assume nothing about the triplets given to you other than that they are valid triplets 
and that they contain sufficient information to deduce the original string. 
In particular, this means that the secret string will never contain letters 
that do not occur in one of the triplets given to you.
 */

public class SecretDetective_c {
    public static void main(String[] args) {
        char[][] triplets = {
            {'t','u','p'},
            {'w','h','i'},
            {'t','s','u'},
            {'a','t','s'},
            {'h','a','p'},
            {'t','i','s'},
            {'w','h','s'}
        };

        System.out.println(recoverSecret(triplets));
    }

    public static String recoverSecret(char[][] triplets) {
        Set<Character> letters = new HashSet<>();
        for (char[] triplet : triplets) {
            for (int j = 0; j < 3; j++) {
                letters.add(triplet[j]);
            }
        }
        @SuppressWarnings("unchecked")
        ArrayList<Character>[] _triplets = new ArrayList[triplets.length];
        for (int i = 0; i < triplets.length; i++) {
            _triplets[i] = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                _triplets[i].add(triplets[i][j]);
            }
        }

        StringBuilder sb = new StringBuilder();
        
        while (!letters.isEmpty()) {
            Character res = '0';
            for (Character letter : letters) {
                boolean flag = true;
                for (var triplet : _triplets) {
                    if (triplet.indexOf(letter) > 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res = letter;
                    for (var triplet : _triplets)
                        triplet.remove(res);
                    break;
                }
            }
            if (res != '0') {
                sb.append(res);
                letters.remove(res);
            }
        }
        return sb.toString();
    }
}
