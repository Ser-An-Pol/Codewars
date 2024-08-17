/*
 Once upon a time, on a way through the old wild mountainous west,…

… a man was given directions to go from one point to another. 
The directions were "NORTH", "SOUTH", "WEST", "EAST". Clearly "NORTH" and "SOUTH" are opposite, "WEST" and "EAST" too.

Going to one direction and coming back the opposite direction right away is a needless effort. 
Since this is the wild west, with dreadful weather and not much water, 
it's important to save yourself some energy, otherwise you might die of thirst!

How I crossed a mountainous desert the smart way.

The directions given to the man are, for example, the following (depending on the language):

["NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"].
or
{ "NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST" };
or
[North, South, South, East, West, North, West]
You can immediately see that going "NORTH" and immediately "SOUTH" is not reasonable, 
better stay to the same place! So the task is to give to the man a simplified version of the plan. 
A better plan in this case is simply:

["WEST"]
or
{ "WEST" }
or
[West]
Other examples:

In ["NORTH", "SOUTH", "EAST", "WEST"], the direction "NORTH" + "SOUTH" is going north and coming back right away.

The path becomes ["EAST", "WEST"], now "EAST" and "WEST" annihilate each other, therefore, the final result is [] (nil in Clojure).

In ["NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"], "NORTH" and "SOUTH" are not directly opposite 
but they become directly opposite after the reduction of "EAST" and "WEST" so the whole path is reducible to ["WEST", "WEST"].

Task

Write a function dirReduc which will take an array of strings and 
returns an array of strings with the needless directions removed (W<->E or S<->N side by side).

The Haskell version takes a list of directions with data Direction = North | East | West | South.
The Clojure version returns nil when the path is reduced to nothing.
The Rust version takes a slice of enum Direction {North, East, West, South}.
See more examples in "Sample Tests:"

Notes

Not all paths can be made simpler. The path ["NORTH", "WEST", "SOUTH", "EAST"] is not reducible. 
"NORTH" and "WEST", "WEST" and "SOUTH", "SOUTH" and "EAST" are not directly opposite of each other and can't become such. 
Hence the result path is itself : ["NORTH", "WEST", "SOUTH", "EAST"].
if you want to translate, please ask before translating.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class DirReduction_c {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dirReduc(new String[]{"NORTH", "EAST", "NORTH", "EAST", "WEST", "WEST", "EAST", "EAST", "WEST", "SOUTH"})));
    }

    // public static String[] dirReduc(String[] arr) {
    //     // Your code here.

    //     // Map<String, Long> way = Arrays.stream(arr).collect(groupingBy(Function.identity(), Collectors.counting()));
    //     // long dir1 = way.get("NORTH") - way.get("SOUTH");
    //     // long dir2 = way.get("EAST") - way.get("WEST");
    //     // int size = (int)(Math.abs(dir1) + Math.abs(dir2));

    //     // String[] trav = new String[size];
    //     // int i;
    //     // for (i = 0; i < Math.abs(dir1); i++) trav[i] = (dir1 > 0) ? "NORTH" : "SOUTH";
    //     // for (; i < size; i++) trav[i] = (dir2 > 0) ? "EAST" : "WEST";
    //     // return trav;

    //     ArrayList<String> way = new ArrayList<>(Arrays.asList(arr));
    //     boolean flag = true;
    //     while (flag) {
    //         flag = false;
    //         for (int i = 0; i < way.size() - 1; i++)
    //             if (isPair(way.get(i), way.get(i+1))) {
    //                 flag = true;
    //                 way.remove(i+1);
    //                 way.remove(i);
    //             }
    //     } 
    //     String[] trav = new String[way.size()];
    //     int i = 0;
    //     for (var str : way) trav[i++] = str;
    //     return trav;   
    // }

    // public static boolean isPair(String s1, String s2) {

    //     return (s1.equals("NORTH")) && s2.equals("SOUTH") 
    //             || (s1.equals("SOUTH")) && s2.equals("NORTH")
    //             || (s1.equals("EAST")) && s2.equals("WEST")
    //             || (s1.equals("WEST")) && s2.equals("EAST");
    // }

    public static String[] dirReduc(String[] arr) {
        ArrayList<String> dirs = new ArrayList<String>(Arrays.asList(arr));
        for (int i = 0; i + 1 < dirs.size(); i++) {
            if ("NORTHSOUTH,SOUTHNORTH,EASTWEST,WESTEAST".contains(dirs.get(i) + dirs.get(i + 1))) {
                dirs.remove(i + 1);
                dirs.remove(i);
                i = -1;
            }
        }
        return dirs.toArray(new String[dirs.size()]);
  }
}
