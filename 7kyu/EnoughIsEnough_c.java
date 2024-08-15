/*
 * Alice and Bob were on a holiday. Both of them took many pictures of the places they've been, and now they want to show Charlie their entire collection. However, Charlie doesn't like these sessions, since the motif usually repeats. He isn't fond of seeing the Eiffel tower 40 times.
He tells them that he will only sit for the session if they show the same motif at most N times. Luckily, Alice and Bob are able to encode the motif as a number. Can you help them to remove numbers such that their list contains each number only up to N times, without changing the order?

Task

Given a list and a number, create a new list that contains each number of list at most N times, without reordering.
For example if the input number is 2, and the input list is [1,2,3,1,2,1,2,3], you take [1,2,3,1,2], drop the next [1,2] since this would lead to 1 and 2 being in the result 3 times, and then take 3, which leads to [1,2,3,1,2,3].
With list [20,37,20,21] and number 1, the result would be [20,37,21].
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class EnoughIsEnough_c {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(deleteNth( new int[] { 1, 3, 7 }, 0 )));
    }

    // public static int[] deleteNth(int[] elements, int maxOccurrences) {
	// 	ArrayList<Integer> list = new ArrayList<>();
    //     for (int i = 0; i < elements.length; i++) list.add(elements[i]);

    //     for (int i = 0; i < list.size(); i++) {
    //         Integer el = list.get(i);
    //         int count = (int)list.stream().filter(in -> in == el).count();
    //         while (count > maxOccurrences) {
    //             list.remove(list.lastIndexOf(el));
    //             count--;
    //         }
    //     }
    //     int[] res = new int[list.size()];
    //     for (int i = 0; i < res.length; i++) res[i] = list.get(i);
	// 	return res;
	// }

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
		Map<Integer, Integer> occurrence = new HashMap<>();
		return IntStream.of(elements)
			.filter(motif -> occurrence.merge(motif, 1, Integer::sum) <= maxOccurrences)
			.toArray();
	}
}
