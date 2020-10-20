public class Fibonacci {
    public static long fibonacci(int n){
        if(n>1){ //If n > 1, there's still calculation to be done
            //This double recursive call will continue to pass in smaller and smaller arguments until
            //the base case is met
            //Then it will return the sum of the two preceding values
            return fibonacci(n-2) + fibonacci(n-1);
        } else if(n == 1){ //This is a base case. If n = 1, no more calculation must be done
            return 1;
        }
        return 0; //This is also a base case. If n = 0, no more calculation must be done
    }

    public static long fibonacciIterative(int n){
        if (n == 1){ //If n = 1, no more calculation must be done
            return 1;
        } else if(n == 0){ //If n = 0, no more calculation must be done
            return 0;
        }
        long fib = 1;
        long previousNum =  1;

        for (int i = 2; i < n; i++) {
            long temp = fib; //Assigns current number (fib) to the temporary variable
            fib = fib + previousNum; //Assigns the sum of the current number (fib) + the previous number to the current number (fib)
            previousNum = temp; //What was the current number (temp) becomes the previous number
        }
        return fib; //Returns the result
    }

    public static void main(String[] args) {
        int number = 0;;
        long res;
        long startTime;
        long estimatedTime;

        //Time tests for different numbers
        System.out.println("Recursive Fibonacci");
        System.out.println("Input: " + number);
        startTime = System.nanoTime(); //Start time stored in a variable
        res = fibonacci(number);
        //Time taken by the method is found by subtracting the start time from the current time
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Result: " + res);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        number = 19;
        System.out.println("Iterative Fibonacci");
        System.out.println("Input: " + number);
        startTime = System.nanoTime(); //Start time stored in a variable
        res = fibonacciIterative(number);
        //Time taken by the method is found by subtracting the start time from the current time
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Result: " + res);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        System.out.println("Recursive Fibonacci");
        System.out.println("Input: " + number);
        startTime = System.nanoTime(); //Start time stored in a variable
        res = fibonacci(number);
        //Time taken by the method is found by subtracting the start time from the current time
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Result: " + res);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        System.out.println("Iterative Fibonacci");
        System.out.println("Input: " + number);
        startTime = System.nanoTime(); //Start time stored in a variable
        res = fibonacciIterative(number);
        //Time taken by the method is found by subtracting the start time from the current time
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Result: " + res);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        number = 28;
        System.out.println("Recursive Fibonacci");
        System.out.println("Input: " + number);
        startTime = System.nanoTime(); //Start time stored in a variable
        res = fibonacci(number);
        //Time taken by the method is found by subtracting the start time from the current time
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Result: " + res);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        System.out.println("Iterative Fibonacci");
        System.out.println("Input: " + number);
        startTime = System.nanoTime(); //Start time stored in a variable
        res = fibonacciIterative(number);
        //Time taken by the method is found by subtracting the start time from the current time
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Result: " + res);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        number = 37;
        System.out.println("Recursive Fibonacci");
        System.out.println("Input: " + number);
        startTime = System.nanoTime(); //Start time stored in a variable
        res = fibonacci(number);
        //Time taken by the method is found by subtracting the start time from the current time
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Result: " + res);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        System.out.println("Iterative Fibonacci");
        System.out.println("Input: " + number);
        startTime = System.nanoTime(); //Start time stored in a variable
        res = fibonacciIterative(number);
        //Time taken by the method is found by subtracting the start time from the current time
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Result: " + res);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        number = 46;
        System.out.println("Recursive Fibonacci");
        System.out.println("Input: " + number);
        startTime = System.nanoTime(); //Start time stored in a variable
        res = fibonacci(number);
        //Time taken by the method is found by subtracting the start time from the current time
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Result: " + res);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        System.out.println("Iterative Fibonacci");
        System.out.println("Input: " + number);
        startTime = System.nanoTime(); //Start time stored in a variable
        res = fibonacciIterative(number);
        //Time taken by the method is found by subtracting the start time from the current time
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Result: " + res);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        number = 55;
        System.out.println("Recursive Fibonacci");
        System.out.println("Input: " + number);
        startTime = System.nanoTime(); //Start time stored in a variable
        res = fibonacci(number);
        //Time taken by the method is found by subtracting the start time from the current time
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Result: " + res);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        System.out.println("Iterative Fibonacci");
        System.out.println("Input: " + number);
        startTime = System.nanoTime(); //Start time stored in a variable
        res = fibonacciIterative(number);
        //Time taken by the method is found by subtracting the start time from the current time
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Result: " + res);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();
    }
}
