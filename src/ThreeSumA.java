import java.io.File;

/******************************************************************************
 *  Compilation:  javac ThreeSumA.java
 *  Execution:    java ThreeSum input.txt
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 ******************************************************************************/

public class ThreeSumA {

    private ThreeSumA(){ }

    /**
     * Returns the number of triples (i, j, k) with {@code i < j < k}
     * such that {@code a[i] + a[j] + a[k] == 0}.
     *
     * @param  a the array of integers
     * @return the number of triples (i, j, k) with {@code i < j < k}
     *         such that {@code a[i] + a[j] + a[k] == 0}
     */
    public static int count(int[] a){
        int n = a.length;
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                for(int k = j+1; k < n; k++){
                    if(a[i] + a[j] + a[k] == 0){
                        count++;
                    }
                }
            }
        }

        return count;
    }

    /**
     * Reads in a sequence of integers from a file, specified as a command-line argument;
     * counts the number of triples sum to exactly zero; prints out the time to perform
     * the computation.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        long res;
        In in;
        File file;

        //This will work ONLY if run through the terminal
        //If a file is given as input, then a time test will be run on that file
        //Otherwise if there's no input, the program will run a time test on all _Kint files
        if(args.length == 1) {
            file = new File(args[0]); //Creates a file object using inputted file name
            System.out.println("Input: " + args[0]);

            //Reads strings and numbers from standard input, file input, URLs, and sockets
            in = new In(file);
            int[] a = in.readAllInts();

            long startTime = System.currentTimeMillis(); //Start time stored in a variable
            res = count(a);
            //Time taken by the method is found by subtracting the start time from the current time
            long estimatedTime = System.currentTimeMillis() - startTime;
            System.out.println("Result: " + res); //Printing number of triples
            System.out.println("Time taken: " + estimatedTime  + " milliseconds");

        } else {
            //Running timing tests with each of the _Kint files through the main
            System.out.println("Input: 1Kints.txt");
            file = new File("1Kints.txt");

            //Reads strings and numbers from standard input, file input, URLs, and sockets
            in = new In(file);
            int[] a = in.readAllInts();

            long startTime = System.currentTimeMillis(); //Start time stored in a variable
            res = count(a);
            //Time taken by the method is found by subtracting the start time from the current time
            long estimatedTime = System.currentTimeMillis() - startTime;
            System.out.println("Result: " + res); //Printing number of triples
            System.out.println("Time taken: " + estimatedTime + " milliseconds");
            System.out.println();



            System.out.println("Input: 2Kints.txt");
            file = new File("2Kints.txt");

            //Reads strings and numbers from standard input, file input, URLs, and sockets
            in = new In(file);
            int[] b = in.readAllInts();
            long startTimeTwo = System.currentTimeMillis(); //Start time stored in a variable
            res = count(b);
            //Time taken by the method is found by subtracting the start time from the current time
            long estimatedTimeTwo = System.currentTimeMillis() - startTimeTwo;
            System.out.println("Result: " + res); //Printing number of triples
            System.out.println("Time taken: " + estimatedTimeTwo + " milliseconds");
            System.out.println();



            System.out.println("Input: 4Kints.txt");
            file = new File("4Kints.txt");

            //Reads strings and numbers from standard input, file input, URLs, and sockets
            in = new In(file);
            int[] c = in.readAllInts();

            long startTimeThree = System.currentTimeMillis(); //Start time stored in a variable
            res = count(c);
            //Time taken by the method is found by subtracting the start time from the current time
            long estimatedTimeThree = System.currentTimeMillis() - startTimeThree;
            System.out.println("Result: " + res); //Printing number of triples
            System.out.println("Time taken: " + estimatedTimeThree + " milliseconds");
            System.out.println();



            System.out.println("Input: 8ints.txt");
            file = new File("8ints.txt");

            //Reads strings and numbers from standard input, file input, URLs, and sockets
            in = new In(file);
            int[] d = in.readAllInts();

            long startTimeFour = System.currentTimeMillis(); //Start time stored in a variable
            res = count(d);
            //Time taken by the method is found by subtracting the start time from the current time
            long estimatedTimeFour = System.currentTimeMillis() - startTimeFour;
            System.out.println("Result: " + res); //Printing number of triples
            System.out.println("Time taken: " + estimatedTimeFour + " milliseconds");
            System.out.println();



            System.out.println("Input: 8Kints.txt");
            file = new File("8Kints.txt");

            //Reads strings and numbers from standard input, file input, URLs, and sockets
            in = new In(file);
            int[] e = in.readAllInts();


            long startTimeFive = System.currentTimeMillis(); //Start time stored in a variable
            res = count(e);
            //Time taken by the method is found by subtracting the start time from the current time
            long estimatedTimeFive = System.currentTimeMillis() - startTimeFive;
            System.out.println("Result: " + res); //Printing number of triples
            System.out.println("Time taken: " + estimatedTimeFive + " milliseconds");
            System.out.println();



            System.out.println("Input: 16Kints.txt");
            file = new File("16Kints.txt");

            //Reads strings and numbers from standard input, file input, URLs, and sockets
            in = new In(file);
            int[] f = in.readAllInts();

            long startTimeSix = System.currentTimeMillis(); //Start time stored in a variable
            res = count(f);
            //Time taken by the method is found by subtracting the start time from the current time
            long estimatedTimeSix = System.currentTimeMillis() - startTimeSix;
            System.out.println("Result: " + res); //Printing number of triples
            System.out.println("Time taken: " + estimatedTimeSix + " milliseconds");
            System.out.println();



            System.out.println("Input: 32Kints.txt");
            file = new File("32Kints.txt");

            //Reads strings and numbers from standard input, file input, URLs, and sockets
            in = new In(file);
            int[] g = in.readAllInts();

            long startTimeSeven = System.currentTimeMillis(); //Start time stored in a variable
            res = count(g);
            //Time taken by the method is found by subtracting the start time from the current time
            long estimatedTimeSeven = System.currentTimeMillis() - startTimeSeven;
            System.out.println("Result: " + res); //Printing number of triples
            System.out.println("Time taken: " + estimatedTimeSeven + " milliseconds");
            System.out.println();
        }
    }
}
