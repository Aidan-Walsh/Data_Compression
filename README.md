# Data_Compression
Here, we utilize the Burrow Wheeler transform followed by "Move-To-Front" encoding, and further followed by Huffman compression for an efficient 
compression algorithm for text files. The following methods take a text file name from the command line, and outputs the compressed content into a file. You may also take a file with the compressed contents and decompress into a new text file.  


# Before Use
Please note that this code uses a library of methods (seen imported at the top of the files). 
Please follow this link(https://algs4.cs.princeton.edu/code/) to download the correct path to this library so that you may be able to run and use this code correctly. 


# To use
1. Download the java files in this repo
2. Compile the files with the following commands:
  - "javac-algs4 BurrowsWheeler.java"
  - "javac-algs4 CircularSuffixArray.java"
  - "javac-algs4 MoveToFront.java"
3. Run the following command that applies Burrow Wheeler transform to text file "text.txt", then "Move-To-Front" encoding, followed by Huffman compression. Output is placed into "outputFileName". This is the compression process: 
  - "java-algs4 BurrowsWheeler - < text.txt | java-algs4 MoveToFront - | java-algs4 edu.princeton.cs.algs4.Huffman - >| outputFileName
4. To reverse the process on "outputFileName" to produce a copy "text-copy.txt". This is the decompression process:
  - "java-algs4 edu.princeton.cs.algs4.Huffman + < outputFileName | java-algs4 MoveToFront + | java-algs4 BurrowsWheeler + >| text-copy.txt"


You now have an improved version of Huffman compression thanks to the Burrow Wheeler transform!
