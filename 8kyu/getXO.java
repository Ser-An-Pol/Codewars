/*
 * Check to see if a string has the same amount of 'x's and 'o's. The method must return a boolean and be case insensitive. The string can contain any char.

Examples input/output:

XO("ooxx") => true
XO("xooxx") => false
XO("ooxXm") => true
XO("zpzpzpp") => true // when no 'x' and 'o' is present should return true
XO("zzoo") => false
 */

public class getXO {
    public static void main(String[] args) {
        System.out.println(getXO("ooxx"));
    }

    public static boolean getXO (String str) {
    
        int countX = (int)str.toLowerCase().chars().filter(c -> c == 'x').count();
        int countO = (int)str.toLowerCase().chars().filter(c -> c == 'o').count(); 
        
        return (countO == countX);
    }

    // public static boolean getXO (String str) {
    //     str = str.toLowerCase();
    //     return str.replace("o","").length() == str.replace("x","").length();
        
    // }

    // public static boolean getXO (String str) {
    //     String xValues = str.replaceAll("[^xX]", "");
    //     String oValues = str.replaceAll("[^oO]", "");
        
    //     return xValues.length() == oValues.length();
    // }
}
