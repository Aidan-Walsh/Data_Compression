# Data_Compression
Here, we utilize the Burrow's Wheeler transform followed by "Move-To-Front" encoding, and further followed by Huffman compression for an efficient 
compression algorithm for text files. The following methods take a text file name from the command line, and outputs the compressed content into a file or take a file with the compressed contents and decompress into a new text file.  


# Before Use
Please note that this code uses Princeton University's library of methods (seen imported at the top of the files). If one runs into issues using these libraries, 
please import other libraries that can get the same job done. One must also have access to Huffman compression if they do not have access to princeton's algorithm library. 
This is because this repo improves Huffman compression, it does not reimplement it. This code is also compiled and ran using "javac-algs4" and "java-algs4". Please use "javac" 
and "java" instead if these do not work. 


# To use
1. Download the java files in this repo
2. Compile the files with the following commands:
  - "javac-algs4 BurrowsWheeler.java"
  - "javac-algs4 CircularSuffixArray.java"
  - "javac-algs4 MoveToFront.java"
3. Run the following command that applies Burrow's Wheeler transform to text file "text.txt", then "Move-To-Front" encoding, followed by Huffman compression. Output is placed into "outputFileName". This is the compression process: 
  - "java-algs4 BurrowsWheeler - < text.txt | java-algs4 MoveToFront - | java-algs4 edu.princeton.cs.algs4.Huffman - >| outputFileName
4. To reverse the process on "outputFileName" to produce a copy "text-copy.txt". This is the decompression process:
  - "java-algs4 edu.princeton.cs.algs4.Huffman + < outputFileName | java-algs4 MoveToFront + | java-algs4 BurrowsWheeler + >| text-copy.txt"


You now have an improved version of Huffman compression thanks to Burrow's Wheeler transform!
