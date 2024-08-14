
public class BitCounting {

    public static void main(String[] args) {
        System.out.println(countBits(123));

        // int n = -5;
        // System.out.println(Integer.toBinaryString(n));
        // System.out.println(Integer.toBinaryString(n >> 1));
        // System.out.println(Integer.toBinaryString(n >> 2));

        // int n = 27;
        // System.out.println(Integer.toString(n, 16));
    }

    // public static int countBits(int n) {
    //     // Show me the code!
    //     int count = 0;
    //     while (n > 0) {
    //         if (n % 2 == 1) {
    //             count++;
    //         }
    //         n /= 2;
    //     }
    //     return count;
    // }

    // public static int countBits(int n){	
    //     return Integer.bitCount(n);
    // }

    // public static int countBits(int n){
    // 	return (int) Integer.toBinaryString(n).chars()
    //           .filter(c -> c == '1')
    //           .count();
    // }

    // public static int countBits(int n) {
    //     return Integer.toBinaryString(n).replaceAll("0", "").length();
    // }

    // public static int countBits(int n) {
	// 	return n == 0 ? 0 : (n & 1) + countBits(n >> 1);
	// }

    public static int countBits(int n){
		return Integer.toString(n,2).replaceAll("0","").length();
	}
}
