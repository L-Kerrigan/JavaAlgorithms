## About
This repository contains the coursework for module COMP20290 Algorithms 
(https://sisweb.ucd.ie/usis/!W_HU_MENU.P_PUBLISH?p_tag=MODULE&MODULE=COMP20290)
including a number of algorithms written in Java 13 ranging from multiplying to encoding 
and more.

## Contents

| Practical number                    | Topic covered              |
| ----------------------------------- | ---------------------------|
| Practical 1                         | Algorithm Analysis         |
| Practical 2                         | Asymptotic Analysis        |
| Practical 3                         | Recursion                  |
| Practical 4                         | Sorting Algorithm          |
| Practical 5                         | Efficient Sorting          |
| Practical 6                         | Efficient Sorting II       |
| Practical 7                         | Substring Search           |
| Practical 8                         | Tries                      |
| Practical 9                         | Run Length Compression     |


The contents and details are listed below:

## Practical 1
- RussianPeasantAlgorithm
This .java file contains a simple method to use the Russian peasant algorithm in order to
multiply 2 positive integers together. The main method contains a number of timing tests for a
range of positive integers and long integers, with the input, output and resulting time taken
outputted to the terminal.


## Practical 2
- ThreeSumA & ThreeSumB
These .java files count the number of triples in the files they're given, provided those
files only have integers in them. They both do the same thing, but with varying speeds.
ThreeSumA is estimated to run in O(n^3), while ThreeSumB is estimated to run in O(n^2).
These two .java files are runnable ONLY through the terminal. To run them through an IDE
you will need to add to the filepaths in the main method.


## Practical 3
- TowersOfHanoi
This is a simple recursive method that will provide instructions for the Towers of Hanoi
puzzle. There are timing tests in the main method for puzzles with 4, 6, 8 and 10 disks.

- Fibonacci
This contains a simple recursive and iterative method of finding the fibonnaci number
of any number given to it. There are timing tests for both methods in the main method for
10 and 30.


## Practicals 4, 5 & 6
- Sorting
This file contains a number of sorting algorithms.
  - InsertionSort
  - SelectionSort
  - MergeSort
  - EnhancedMergeSort
  - QuickSort
  - EnhancedQuickSort
  - BogoSort
There are 2 versions of every method here.
One version, the original one I made, uses Comparables because they provide
results to show the enhanced merge/quicksort are faster, but since they are
raw/used without a parameter, they throw a lot of warnings that make it
difficult to compile and run this file through the terminal. These methods
are the ones I use for my graphs since they give results that make more sense.
The second version uses ints, but otherwise the code is the same. These
versions were made just so the code could also run through the terminal.


## Practical 7
- BruteForceSearch

- KMPSearch/KnuthMorrisPrattSearch


## Practical 8
-Trie


## Practical 9
- Run Length Encoding



### Acknowledgements
* Dr. Mark Matthews - (https://people.ucd.ie/mark.matthews)
* UCD School of Computer Science - (https://www.cs.ucd.ie/)
