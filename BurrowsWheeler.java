import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class BurrowsWheeler {
    // apply Burrows-Wheeler transform,
    // reading from standard input and writing to standard output
    public static void transform() {

        // read string from input and create array that will store the last
        // character of the sorted suffixes
        String s = BinaryStdIn.readString();
        char[] indexed = new char[s.length()];
        int first = 0;

        // create circular suffix array object that stores the sorted suffixes
        // and is able to retrieve the index of the original suffixes
        CircularSuffixArray transform = new CircularSuffixArray(s);

        // iterate through array of strings (circular suffix arrays)
        for (int i = 0; i < transform.length(); i++) {

            // use index function so that we can form indexed array in the right
            // order
            // we always put in the last character of the sorted suffix into the
            // location returned by the index function because that index gives
            // us which original suffix is sorted at location i
            // if our index value is 0 then that means it is the original suffix
            // so we store the location (i) into first
            if (transform.index(i) == 0) {
                indexed[i] = s.charAt(s.length() - 1);
                first = i;
            }
            else indexed[i] = s.charAt(transform.index(i) - 1);
        }
        BinaryStdOut.write(first);

        // iterate through indexed array to print it in binary
        for (int i = 0; i < indexed.length; i++) {
            BinaryStdOut.write(indexed[i]);
        }
        BinaryStdOut.close();
    }

    // apply Burrows-Wheeler inverse transform,
    // reading from standard input and writing to standard output
    public static void inverseTransform() {
        // read the integer and string given
        int first = BinaryStdIn.readInt();
        String s = BinaryStdIn.readString();
        int n = s.length();
        int radix = 256;
        // front array to store first character of all strings, count array to
        // store all extended ASCII for sorting, and next array to store location
        // of next character of original string
        char[] front = new char[s.length()];
        int[] count = new int[radix + 1];
        int[] next = new int[s.length()];

        // use key index counting to sort string s
        for (int i = 0; i < n; i++) {
            // build count array at 1 index ahead
            count[s.charAt(i) + 1]++;
        }
        for (int r = 0; r < radix; r++) {
            // sum values in previous array spot
            count[r + 1] += count[r];
        }
        for (int i = 0; i < n; i++) {
            // place character in string in correct location, then update
            // next array to store location of where that character came from
            // we do this because this is indicative of which sorted suffix that
            // character loops around to the back of
            // then increment value in count array
            front[count[s.charAt(i)]] = s.charAt(i);
            next[count[s.charAt(i)]] = i;
            count[s.charAt(i)]++;
        }

        // use next array to iterate through characters in correct order
        for (int i = 0; i < n; i++) {
            BinaryStdOut.write(front[first]);
            first = next[first];
        }
        BinaryStdOut.close();

    }

    // if args[0] is "-", apply Burrows-Wheeler transform
    // if args[0] is "+", apply Burrows-Wheeler inverse transform
    public static void main(String[] args) {
        if (args[0].equals("-")) {
            transform();
        }
        else if (args[0].equals("+")) {
            inverseTransform();
        }
    }
}
