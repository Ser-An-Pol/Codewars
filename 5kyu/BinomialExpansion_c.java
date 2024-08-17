
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/*
 The purpose of this kata is to write a program that can do some algebra.

Write a function expand that takes in an expression with a single, one character variable, and expands it. 
The expression is in the form (ax+b)^n where a and b are integers which may be positive or negative, 
x is any single character variable, and n is a natural number. 
If a = 1, no coefficient will be placed in front of the variable. If a = -1, a "-" will be placed in front of the variable.

The expanded form should be returned as a string in the form ax^b+cx^d+ex^f...
 where a, c, and e are the coefficients of the term, x is the original one character variable 
 that was passed in the original expression and b, d, and f, 
 are the powers that x is being raised to in each term and are in decreasing order.

If the coefficient of a term is zero, the term should not be included. 
If the coefficient of a term is one, the coefficient should not be included. 
If the coefficient of a term is -1, only the "-" should be included. 
If the power of the term is 0, only the coefficient should be included. 
If the power of the term is 1, the caret and power should be excluded.

Examples:

KataSolution.expand("(x+1)^2");      // returns "x^2+2x+1"
KataSolution.expand("(p-1)^3");      // returns "p^3-3p^2+3p-1"
KataSolution.expand("(2f+4)^6");     // returns "64f^6+768f^5+3840f^4+10240f^3+15360f^2+12288f+4096"
KataSolution.expand("(-2a-4)^0");    // returns "1"
KataSolution.expand("(-12t+43)^2");  // returns "144t^2-1032t+1849"
KataSolution.expand("(r+0)^203");    // returns "r^203"
KataSolution.expand("(-x-1)^2");     // returns "x^2+2x+1"
 */

public class BinomialExpansion_c {
    public static void main(String[] args) {
        System.out.println(expand("(p-1)^3"));
    }


    // public static String VAR;
	// public static String expand(String expr) {
    //     int[] a_expr = getAlgExpr(expr);
    //     long[] coef = new long[a_expr[2]+1];
    //     int mid = (a_expr[2]+1) / 2;
    //     StringBuilder res = new StringBuilder();


    //     if (a_expr[2] == 0) return "1";

    //     coef[0] = 1;
    //     for (int k = 1; k < coef.length; k++)
    //         if (k <= mid) coef[k] = getBinomCoef(a_expr[2], k);
    //         else coef[k] = coef[a_expr[2]-k];

    //     for (int k = 0; k < coef.length; k++) {
    //         coef[k] *= pow(a_expr[0], a_expr[2] - k)*pow(a_expr[1], k);
    //         if (coef[k] == 0) continue;
    //         if (k == 0) {
    //             if (coef[k] == -1) res.append("-");
    //             else if (coef[k] != 1) res.append(coef[k]);
    //         }
    //         else {
    //             if (coef[k] > 0) res.append("+");
    //             res.append(coef[k]);
    //         }
    //         if (k != a_expr[2]) {
    //             res.append(VAR);
    //             if (k < a_expr[2]-1) res.append("^"+(a_expr[2]-k));
    //         }
    //     }
    //     //System.out.println(Arrays.toString(coef));

	// 	return res.toString();
	// }

    // public static long pow(int a, int p) {
    //     return LongStream.range(0, p).map(i -> a).reduce(1, (long x, long y) -> x*y);
    // }

    public static long getBinomCoef(int n, int k) {
        return LongStream.rangeClosed(k + 1, n).reduce(1, (long x, long y) -> x*y) /
                LongStream.rangeClosed(1, n - k).reduce(1, (long x, long y) -> x*y);

    }

    // public static int[] getAlgExpr(String expr) {
    //     int[] a_expr = new int[3];

    //     Matcher matcher = Pattern.compile("(?<=\\^)\\d+").matcher(expr);
    //     if (matcher.find()) a_expr[2] = Integer.parseInt(expr.substring(matcher.start(), matcher.end()));
    //     else a_expr[2] = 1;

    //     matcher = Pattern.compile("(?<=[a-zA-Z])[-+]\\d+(?=\\))").matcher(expr);
    //     if (matcher.find()) a_expr[1] = Integer.parseInt(expr.substring(matcher.start(), matcher.end()));

    //     matcher = Pattern.compile("[a-zA-Z]").matcher(expr);
    //     if (matcher.find()) VAR = expr.substring(matcher.start(), matcher.end());

    //     matcher = Pattern.compile("(?<=\\()-?\\d+(?=[a-zA-Z])").matcher(expr);
    //     if (matcher.find()) a_expr[0] = Integer.parseInt(expr.substring(matcher.start(), matcher.end()));
    //     else if (expr.charAt(expr.indexOf(VAR)-1) == '-') a_expr[0] = -1;
    //     else a_expr[0] = 1;

    //     return a_expr;
    // }


    public static String expand(String expr) {

		Matcher m = Pattern.compile("(\\-?\\d*)([a-z])([+-]\\d+)\\D+(\\d+)").matcher(expr);
		m.find();
		int p = Integer.parseInt(m.group(4));
		String[] str = new String[p + 1];
		int a = m.group(1).length() == 0 ? 1 : m.group(1).equals("-") ? -1 : Integer.parseInt(m.group(1));
		int b = Integer.parseInt(m.group(3));
		for (int i = 0; i <= p; i++) {
			long f = (long) (getBinomCoef(p, i) * Math.pow(a, p - i) * (i == 0 ? 1 : Math.pow(b, i)));
			if (f != 0) {
				str[i] = p - i == 0 ? f + ""
						: (f == 1 ? "" : f == -1 ? "-" : f) + m.group(2) + (p - i != 1 ? "^" + (p - i) : "");
			}
		}
		return Arrays.stream(str).filter(s -> s != null).collect(Collectors.joining("+")).replaceAll("\\+\\-", "\\-");
	}
}
