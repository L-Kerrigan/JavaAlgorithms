public class RussianPeasantAlgorithm {

    public static long russianMultiply(long a, long b){
        long res = 0;  //A variable to hold the answer
        while (b > 0) {
            if (b % 2 == 1) {
                res += a; //If b is odd, add a to the result
            }
            a *= 2; //Multiply a by 2
            b /= 2; //Divide b by 2
        }
        return res; //At the end res is returned as the result
    }


    public static void main(String[] args) {
        System.out.println("Russian Peasant Algorithm Timing Tests");
        long res;

        //Testing the algorithm with various sizes of positive ints/longs
        //I won't be testing with negative ints/longs, since the Russian Peasant Algorithm
        //doesn't work well with them
        System.out.println("Input: 1, 2");
        long startTimeOne = System.nanoTime(); //Start time stored in a variable
        res = russianMultiply(1, 2);
        //Time taken by the method is found by subtracting the start time from the current time
        long estimatedTimeOne = System.nanoTime() - startTimeOne;
        System.out.println("Result: " + res);
        System.out.println("Time taken : " + estimatedTimeOne);
        System.out.println();

        System.out.println("Input: 77, 54");
        long startTimeTwo = System.nanoTime(); //Start time stored in a variable
        res = russianMultiply(77, 54);
        //Time taken by the method is found by subtracting the start time from the current time
        long estimatedTimeTwo = System.nanoTime() - startTimeTwo;
        System.out.println("Result: " + res);
        System.out.println("Time taken : " + estimatedTimeTwo);
        System.out.println();

        System.out.println("Input: 150, 200");
        long startTimeThree = System.nanoTime(); //Start time stored in a variable
        res = russianMultiply(150, 200);
        //Time taken by the method is found by subtracting the start time from the current time
        long estimatedTimeThree = System.nanoTime() - startTimeThree;
        System.out.println("Result: " + res);
        System.out.println("Time taken : " + estimatedTimeThree);
        System.out.println();

        System.out.println("Input: 1300, 1000");
        long startTimeFour = System.nanoTime(); //Start time stored in a variable
        res = russianMultiply(1300, 1000);
        //Time taken by the method is found by subtracting the start time from the current time
        long estimatedTimeFour = System.nanoTime() - startTimeFour;
        System.out.println("Result: " + res);
        System.out.println("Time taken : " + estimatedTimeFour);
        System.out.println();

        System.out.println("Input: 2000962, 4321787");
        long startTimeFive = System.nanoTime(); //Start time stored in a variable
        res = russianMultiply(2000962, 4321787);
        //Time taken by the method is found by subtracting the start time from the current time
        long estimatedTimeFive = System.nanoTime() - startTimeFive;
        System.out.println("Result: " + res);
        System.out.println("Time taken : " + estimatedTimeFive);
        System.out.println();

        System.out.println("Input: 98711189, 47284299");
        long startTimeSix = System.nanoTime(); //Start time stored in a variable
        res = russianMultiply(98711189, 47284299);
        //Time taken by the method is found by subtracting the start time from the current time
        long estimatedTimeSix = System.nanoTime() - startTimeSix;
        System.out.println("Result: " + res);
        System.out.println("Time taken : " + estimatedTimeSix);
        System.out.println();
    }
}
