package com.timr.chargeit;

/**
 * <pre>
 * Given: Input string X, create an output String y which contains the count of 
 *        consecutive characters followed by the character.
 * Example:
 *     input   "113444451788"
 *     output  "21134415111728";   // note don't combine values in non-consecutive locations
 * </pre>
 * 
 * @author timr
 *
 */
public class CharCount {


    public static String getCountStrBuilder(String str) throws IllegalArgumentException {

        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("String is either null or empty");
        }

        char[] in = str.toCharArray();
        StringBuilder sb = new StringBuilder();

        int cnt = 1;
        char c = in[0];
        char p = c;

        for (int i = 1; i < in.length; i++) {
            c = in[i];
            if (c == p) {
                cnt++;
            } else {
                sb.append("" + cnt);
                sb.append("" + p);
                cnt = 1;
            }
            p = c;
        }
        if (p == c) {
            sb.append("" + cnt);
            sb.append("" + p);
        }
        return sb.toString();
    }

    /*
     * <pre>
     * Using a char[] for the output has a few problems
     * 1) to put an int count in to a char array you must first do a conversion
     * 2) the simple conversion method below only works for single digit count.
     * These could be fixed, but the complexity increases, better to go with 
     * StringBuilder approach above.  
     * </pre>
     * 
     */
    public static char intToChar(int i) throws IllegalArgumentException {
        char ch;
        if (i <= 9) {
            ch = (char) ('0' + i);
            return ch;
        } else
            throw new IllegalArgumentException("value must be in 0..9, single digit rage");
    }

    public static String getCountStr(String str) throws IllegalArgumentException {

        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("String is either null or empty");
        }

        int j = 0;
        int cnt = 0;
        char p, c = ' '; // init to some value, value not important

        char[] in = str.toCharArray();
        char[] out = new char[in.length * 2];

        p = in[0];
        cnt = 1;

        for (int i = 0; i < in.length; i++) {
            c = in[i];
            if (c == p) {
                cnt++;
            } else {

                out[j++] = intToChar(cnt);
                out[j++] = p;
            }
            p = c;
        }
        if (p == c) {
            out[j++] = intToChar(cnt);
            out[j] = c;
        }

        return new String(out);

    }

}
