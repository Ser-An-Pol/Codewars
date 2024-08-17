/*
 The Fibonacci numbers are the numbers in the following integer sequence (Fn):

0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, ...

such as

F(n) = F(n-1) + F(n-2) with F(0) = 0 and F(1) = 1.

Given a number, say prod (for product), we search two Fibonacci numbers F(n) and F(n+1) verifying

F(n) * F(n+1) = prod.

Your function productFib takes an integer (prod) and returns an array:

[F(n), F(n+1), true] or {F(n), F(n+1), 1} or (F(n), F(n+1), True)
depending on the language if F(n) * F(n+1) = prod.

If you don't find two consecutive F(n) verifying F(n) * F(n+1) = prodyou will return

[F(n), F(n+1), false] or {F(n), F(n+1), 0} or (F(n), F(n+1), False)
F(n) being the smallest one such as F(n) * F(n+1) > prod.

Some Examples of Return:

(depend on the language)

productFib(714) # should return (21, 34, true), 
                # since F(8) = 21, F(9) = 34 and 714 = 21 * 34

productFib(800) # should return (34, 55, false), 
                # since F(8) = 21, F(9) = 34, F(10) = 55 and 21 * 34 < 800 < 34 * 55
-----
productFib(714) # should return [21, 34, true], 
productFib(800) # should return [34, 55, false], 
-----
productFib(714) # should return {21, 34, 1}, 
productFib(800) # should return {34, 55, 0},        
-----
productFib(714) # should return {21, 34, true}, 
productFib(800) # should return {34, 55, false}, 
Note:

You can see examples for your language in "Sample Tests".
 */

import java.util.Arrays;
import java.util.stream.Stream;

public class ProdFib_c {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productFib(4895)));
    }

    // public static long[] productFib(long prod) {
    //     // your code
    //     long f1 = 0, f2 = 1;
    //     long mult = 0;
    //     while (mult < prod) {
    //         if (f1 < f2) f1 += f2;
    //         else f2 += f1;
    //         mult = f1*f2;
    //     }
    //     long[] res = new long[3];
    //     res[2] = (mult > prod) ? 0 : 1;
    //     if (f1 < f2) { 
    //         res[0] = f1;
    //         res[1] = f2;
    //     }
    //     else { 
    //         res[0] = f2;
    //         res[1] = f1;
    //     }
    //     return res;
    // }


    // public static long[] productFib(long prod) {
    //     long a = 0L;
    //     long b = 1L;
    //     while (a * b < prod) {
    //         long tmp = a;
    //         a = b;
    //         b = tmp + b;
    //     }
    //     return new long[]{a, b, a * b == prod ? 1 : 0};
    // }

    public static long[] productFib(long prod) {
        return Stream.iterate(new long[]{ 0, 1 }, x -> new long[]{ x[1], x[0] + x[1] })
              .filter(x -> x[0] * x[1] >= prod)
              .findFirst()
              .map(x -> new long[]{ x[0], x[1], x[0] * x[1] == prod ? 1 : 0})
              .get();
    }
}
