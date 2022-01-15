import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class CircularSuffixArray {

    // String that we are receiving to be stored in the circular suffix array
    private String usedString;

    // the suffix array that is to be sorted that stores the strings implicitly
    private CircularSuffix[] suffix;

    // circular suffix array of s
    public CircularSuffixArray(String s) {

        // ensure no null arguments
        if (s == null) throw new IllegalArgumentException("No null argument");
        usedString = s;
        suffix = new CircularSuffix[s.length()];

        // create circular suffix object for each location in array
        for (int i = 0; i < suffix.length; i++) {
            suffix[i] = new CircularSuffix(s, i);
        }

        // sort the array
        Arrays.sort(suffix);

    }

    private class CircularSuffix implements Comparable<CircularSuffix> {

        // string to compare
        private final String text;

        // offset to know where to begin referenced string
        private final int offset;

        // assign variables for access
        public CircularSuffix(String text, int offset) {
            this.text = text;
            this.offset = offset;
        }

        // return length of string
        public int length() {
            return text.length();
        }

        // get the character at index i
        public char charAt(int i) {

            // ensure valid argument
            if (i < 0 || i >= usedString.length()) throw new
                    IllegalArgumentException("argument out of bounds");

            // use offset to return character at location if we come before
            // the end of string
            if (i + offset < text.length()) {
                return text.charAt(offset + i);
            }

            // this essentially loops around to the front of the string if we
            // go past the end
            else return text.charAt(offset + i - length());
        }

        // method to compare suffixes
        public int compareTo(CircularSuffix that) {

            // if ASCII number of corresponding characters is less (than argument)
            // then return -1 etc. and move through string
            for (int i = 0; i < text.length(); i++) {
                if (charAt(i) < that.charAt(i)) return -1;
                else if (charAt(i) > that.charAt(i)) return 1;
            }
            return 0;
        }
    }

    // length of s
    public int length() {
        return usedString.length();
    }

    // returns index of ith sorted suffix
    public int index(int i) {

        // validate argument
        if (i < 0 || i >= usedString.length()) throw new
                IllegalArgumentException("argument out of bounds");

        // the ith suffix is just at location i and we return its offset which
        // tells us which suffix it is among the original suffixes
        return suffix[i].offset;
    }

    public static void main(String[] args) {

        // testing for ABRACADABRA!
        CircularSuffixArray tester = new CircularSuffixArray("ABRACADABRA!");
        StdOut.println("Length of tested s: " + tester.length());
        for (int i = 0; i < tester.length(); i++) {
            StdOut.println("index of " + i + " sorted suffix: " + tester.index(i));
        }
    }
}
