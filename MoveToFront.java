import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class MoveToFront {
    // apply move-to-front encoding, reading from stdin and writing to stdout
    public static void encode() {

        // create array that stores all extended ASCII
        int r = 256;
        char[] store = new char[r];
        for (int i = 0; i < r; i++) {
            store[i] = (char) i;
        }
        while (!BinaryStdIn.isEmpty()) {
            // read from input
            char read = BinaryStdIn.readChar();

            char storeNext = store[0];
            // we loop through the array of ASCII until we find what we are
            // looking for. As we loop through array, we move values along to
            // the right
            for (int i = 0; i < r; i++) {
                if (storeNext == read) {
                    // place value at front
                    store[0] = storeNext;
                    BinaryStdOut.write(i, 8);
                    // exit for loop once we have found what we are looking for
                    break;
                }
                else if (i < r - 1) {
                    // move current value to right
                    // and save this value for next iteration
                    char save = store[i + 1];
                    store[i + 1] = storeNext;
                    storeNext = save;
                }
            }
        }
        BinaryStdOut.close();
    }

    // apply move-to-front decoding, reading from stdin and writing to stdout
    public static void decode() {
        int r = 256;
        // create array to store all characters
        char[] store = new char[r];
        for (int i = 0; i < r; i++) {
            store[i] = (char) i;
        }
        // read from standard input
        while (!BinaryStdIn.isEmpty()) {
            char read = BinaryStdIn.readChar(8);
            char storeNext = store[0];
            // corner case where we have a repeated value so we only need to print
            if (read == 0) {
                BinaryStdOut.write(storeNext);
            }

            // we only need to go through array number of times given by input
            for (int i = 0; i < (int) read; i++) {
                // as we go through array, shift to right, and we save value
                // getting replaced for next iteration
                char save = store[i + 1];
                store[i + 1] = storeNext;
                storeNext = save;
                // when at end of looping, we save last value, move it to front,
                // and print it
                if (i == (int) read - 1) {
                    store[0] = storeNext;
                    BinaryStdOut.write(storeNext);
                }
            }
        }
        BinaryStdOut.close();
    }


    // if args[0] is "-", apply move-to-front encoding
    // if args[0] is "+", apply move-to-front decoding
    public static void main(String[] args) {
        if (args[0].equals("-")) {
            encode();
        }
        else if (args[0].equals("+")) {
            decode();
        }
    }
}
