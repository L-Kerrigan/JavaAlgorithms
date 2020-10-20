public class Sorting {

    /*
    There are 2 versions of every method here.
    One version, the original one I made, uses Comparables because they provide
    results to show the enhanced merge/quicksort are faster, but since they are
    raw/used without a parameter, they throw a lot of warnings that make it
    difficult to compile and run this file through the terminal. These methods
    are the ones I use for my graphs since they give results that make more sense.
    The second version uses ints, but otherwise the code is the same. These
    versions were made just so I could also run the code through the terminal.
     */

    public static void selectionSort(Comparable[] array){
        //int min; //To hold the position of the smallest value in the array
        int length = array.length;

        for(int i = 0; i < length-1; i++){
            int min = i; //Allocates value in current position in array to min
            for(int j = i+1; j < length; j++){
                //Loops through the rest of the array to see if any value is smaller
                //than the current min
                if(array[j].compareTo(array[min]) < 0){
                    min = j; //If there is a smaller value, allocate its position to min
                }

                //Swap the value at the current position in the array with the value
                //at min, which should be the smallest value in the rest of the array
                /*Comparable temp = array[min];
                array[min] = array[i];
                array[i] = temp;*/
            }
            comparableSwap(array, min, i);
        }
    }

    public static void selectionSort(int[] array){
        //int min; //To hold the position of the smallest value in the array
        int length = array.length;

        for(int i = 0; i < length-1; i++){
            int min = i; //Allocates value in current position in array to min
            for(int j = i+1; j < length; j++){
                //Loops through the rest of the array to see if any value is smaller
                //than the current min
                if(array[j] < array[min]) {
                    min = j; //If there is a smaller value, allocate its position to min
                }

                //Swap the value at the current position in the array with the value
                //at min, which should be the smallest value in the rest of the array
                /*int temp = array[min];
                array[min] = array[i];
                array[i] = temp;*/
            }
            swap(array, min, i);
        }
    }


    public static void insertionSort(Comparable[] array){
        for(int i = 1; i < array.length; i++){
            Comparable valueToSort = array[i]; //Sets the "pointer" to the value at the current position
            int j = i; //Sets j = i so it only checks the array's contents before this position
            while(j > 0 && array[j-1].compareTo(valueToSort) > 0){
                //While the value at the "pointer" is less than the value at j-1,
                //assign the value at position j-1 to the value at position j
                array[j] = array[j-1];
                j--; //Decrement j to keep moving through the array
            }
            array[j] = valueToSort; //Assign the value to be sorted to the current position of j
        }
    }

    public static void insertionSort(int[] array){
        for(int i = 1; i < array.length; i++){
            int valueToSort = array[i]; //Sets the "pointer" to the value at the current position
            int j = i; //Sets j = i so it only checks the array's contents before this position
            while(j > 0 && array[j-1] > valueToSort){
                //While the value at the "pointer" is less than the value at j-1,
                //assign the value at position j-1 to the value at position j
                array[j] = array[j-1];
                j--; //Decrement j to keep moving through the array
            }
            array[j] = valueToSort; //Assign the value to be sorted to the current position of j
        }
    }

    public static class BogoSort {

        public void bogoSort(Comparable[] array) {
            while (!isSorted(array)) {
                shuffle(array); //Keep shuffling the list until its sorted
            }
        }

        public void bogoSort(int[] array) {
            while (!isSorted(array)) {
                shuffle(array); //Keep shuffling the list until its sorted
            }
        }

        public void shuffle(Comparable[] array) {
            for (int i = 1; i <= array.length - 1; i++) {
                //Swap the value at i with a value at a randomised position
                comparableSwap(array, i, (int) (Math.random() * i));
            }
        }

        public void shuffle(int[] array) {
            for (int i = 1; i <= array.length - 1; i++) {
                //Swap the value at i with a value at a randomised position
                swap(array, i, (int) (Math.random() * i));
            }
        }

        public void swap(Comparable[] a, int i, int j) {
            Comparable temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        public void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        public boolean isSorted(Comparable[] a) {
            for (int i = 1; i < a.length; i++) {
                //Runs through the array to ensure the value at each position is greater than the
                //value at the position before it. Returns true if this is the case, false if not
                if (a[i].compareTo(a[i - 1]) < 0) {
                    return false;
                }
            }
            return true;
        }

        public boolean isSorted(int[] a) {
            for (int i = 1; i < a.length; i++) {
                //Runs through the array to ensure the value at each position is greater than the
                //value at the position before it. Returns true if this is the case, false if not
                if (a[i] < a[i - 1]) {
                    return false;
                }
            }
            return true;
        }
    }


    public static void mergeSort(Comparable[] arr, int n){
        if(n < 2) { //This is the base case. If n < 2, it's either 0 or 1, which doesn't need to be sorted further
            return;
        }

        int mid = n/2; //Finding the centre position
        Comparable[] left = new Comparable[mid]; //Mid used to specify the number of elements in the first half of the array
        Comparable[] right = new Comparable[n - mid]; //The number of elements in the second half can be found by n (total number of elements in the array) - mid

        System.arraycopy(arr, 0, left, 0, mid); //Copies first half of the array to the new array "left"
        System.arraycopy(arr, mid, right, mid - mid, n - mid); //Copies second half of the array to another array "right"

        //Mergesort is recursively called on the first and second half of the array
        mergeSort(left, mid);
        mergeSort(right, (n - mid));

        merge(arr, left, right, mid, (n-mid)); //After the recursive calls have been made, the 2 parts of the array are merged together in order
    }

    public static void mergeSort(int[] arr, int n){
        if(n < 2) { //This is the base case. If n < 2, it's either 0 or 1, which doesn't need to be sorted further
            return;
        }

        int mid = n/2; //Finding the centre position
        int[] left = new int[mid]; //Mid used to specify the number of elements in the first half of the array
        int[] right = new int[n - mid]; //The number of elements in the second half can be found by n (total number of elements in the array) - mid

        System.arraycopy(arr, 0, left, 0, mid); //Copies first half of the array to the new array "left"
        System.arraycopy(arr, mid, right, mid - mid, n - mid); //Copies second half of the array to another array "right"

        //Mergesort is recursively called on the first and second half of the array
        mergeSort(left, mid);
        mergeSort(right, (n - mid));

        merge(arr, left, right, mid, (n-mid)); //After the recursive calls have been made, the 2 parts of the array are merged together in order
    }

    /*public static void enhancedMergeSort(int[] arr, int n){
        if(n < 2){
            return;
        }
        //System.out.println("value of n :" +n);
//        if(n <= 10) {
//            insertionSort(arr);
//            return;
//        }

        int mid = n/2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        //Splitting up the array into 2
        for(int i = 0; i < mid; i++){
            left[i] = arr[i];
        }

        for(int j = mid; j < n; j++){
            right[j - mid] = arr[j];
        }

        enhancedMergeSort(left, mid);
        enhancedMergeSort(right, (n - mid));

        if(!(arr[mid] <= arr[mid + 1])) {
            merge(arr, left, right, mid, (n - mid));
        } else {
            int length = (left.length + right.length);
            int[] newArray = new int[length];
            for(int i = 0; i < left.length; i++){
                newArray[i] = left[i];
            }
            for(int i = 0; i < right.length; i++){
                newArray[left.length+i] = right[i];
            }
        }
    }*/

    public static void enhancedMergeSort(Comparable[] arr, int n){
        if(n < 2) {
            //This is the base case. If n < 2, it's either 0 or 1, which doesn't need to be sorted further
            return;
        } else if(n < 10){
            //This is the base case. If n < 10, it's small enough that insertion sort would yield a quicker result
            insertionSort(arr);
            return;
        }

        int mid = n/2; //Finding the centre position
        Comparable[] left = new Comparable[mid]; //Mid used to specify the number of elements in the first half of the array
        Comparable[] right = new Comparable[n - mid]; //The number of elements in the second half can be found by n (total number of elements in the array) - mid

        System.arraycopy(arr, 0, left, 0, mid); //Copies first half of the array to the new array "left"
        System.arraycopy(arr, mid, right, 0, n - mid); //Copies second half of the array to another array "right"

        //enhancedMergesort is recursively called on the first and second half of the array
        enhancedMergeSort(left, mid);
        enhancedMergeSort(right, (n - mid));

        if(!(left[left.length-1].compareTo(right[0]) <= 0)) {
            //If the two array halves aren't already in order, order and merge them
            merge(arr, left, right, mid, (n - mid));
            //merge(arr, left, right);
        } else { //Otherwise, just attach the two halves together, no ordering needed
            System.arraycopy(left, 0, arr, 0, left.length);
            System.arraycopy(right, 0, arr, left.length, right.length);
            return;
        }
    }

    public static void enhancedMergeSort(int[] arr, int n){
        if(n < 2) {
            //This is the base case. If n < 2, it's either 0 or 1, which doesn't need to be sorted further
            return;
        } else if(n < 10){
            //This is the base case. If n < 10, it's small enough that insertion sort would yield a quicker result
            insertionSort(arr);
            return;
        }

        int mid = n/2; //Finding the centre position
        int[] left = new int[mid]; //Mid used to specify the number of elements in the first half of the array
        int[] right = new int[n - mid]; //The number of elements in the second half can be found by n (total number of elements in the array) - mid

        System.arraycopy(arr, 0, left, 0, mid); //Copies first half of the array to the new array "left"
        System.arraycopy(arr, mid, right, 0, n - mid); //Copies second half of the array to another array "right"

        //enhancedMergesort is recursively called on the first and second half of the array
        enhancedMergeSort(left, mid);
        enhancedMergeSort(right, (n - mid));

        if(!(left[left.length-1] <= right[0])) {
            //If the two array halves aren't already in order, order and merge them
            merge(arr, left, right, mid, (n - mid));
            //merge(arr, left, right);
        } else { //Otherwise, just attach the two halves together, no ordering needed
            System.arraycopy(left, 0, arr, 0, left.length);
            System.arraycopy(right, 0, arr, left.length, right.length);
            return;
        }
    }


    public static void merge(Comparable[] arr, Comparable[] left, Comparable[] right, int l, int r){
        int i = 0, j = 0, k = 0;

        while(i < l && j < r){ //While both arrays still have elements in them
            if(left[i].compareTo(right[j]) <= 0){
                //If the element at the current position in the left array is less than
                //or equal to the current element in the right array, assign its value to
                //the current position in the final array.
                //Increment the positions after the assignment
                arr[k++] = left[i++];
            } else {
                //Otherwise, assign the value at the current position
                //in the right array to the current position in the final array.
                //Increment the positions after the assignment
                arr[k++] = right[j++];
            }
        }

        //Add the remaining elements the the final array
        while(i < l){
            arr[k++] = left[i++];
        }
        while(j < r){
            arr[k++] = right[j++];
        }
    }

    public static void merge(int[] arr, int[] left, int[] right, int l, int r){
        int i = 0, j = 0, k = 0;

        while(i < l && j < r){ //While both arrays still have elements in them
            if(left[i] <= right[j]){
                //If the element at the current position in the left array is less than
                //or equal to the current element in the right array, assign its value to
                //the current position in the final array.
                //Increment the positions after the assignment
                arr[k++] = left[i++];
            } else {
                //Otherwise, assign the value at the current position
                //in the right array to the current position in the final array.
                //Increment the positions after the assignment
                arr[k++] = right[j++];
            }
        }

        //Add the remaining elements the the final array
        while(i < l){
            arr[k++] = left[i++];
        }
        while(j < r){
            arr[k++] = right[j++];
        }
    }

    /*public static void merge(Object[] arr, Object[] left, Object[] right, Comparator<Object> comp){
        int i = 0, j = 0;
        while (i + j < arr.length){
            if(j == right.length || (i < left.length && comp.compare(left[i], right[j]) < 0)) {
                arr[i+j] = left[i++];
            } else {
                arr[i+j] = right[j++];
            }
        }
    }*/

    public static void comparableSwap(Comparable[] arr, int position1, int position2){
        Comparable temp = arr[position1];
        arr[position1] = arr[position2];
        arr[position2] = temp;
    }

    public static void swap(int[] arr, int position1, int position2){
        int temp = arr[position1];
        arr[position1] = arr[position2];
        arr[position2] = temp;
    }

    public static void comparableInsertionSort(Comparable[] arr, int low, int high){
        for(int i = low + 1; i <= high; i++){
            Comparable temp = arr[i];
            int j;

            for(j = i; j > low && temp.compareTo(arr[j-1]) < 0; j--){
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
    }


    public static void enhancedQuickSort(Comparable[] arr, int low, int high){
        if((low + 10) > high){
            //If the array is small, using insertionSort will yield faster results
            comparableInsertionSort(arr, low, high);
        } else {
            //Shuffling seems to slow things down
            //shuffleAlternate(arr);

            //Sort low, middle and high
            int middle = (low + high) / 2;
            if (arr[middle].compareTo(arr[low]) < 0) {
                //If the value at the middle position is less than the value at low,
                //swap them
                comparableSwap(arr, low, middle);
            }
            if (arr[high].compareTo(arr[low]) < 0) {
                //If the value at the high position is less than the value at low,
                //swap them
                comparableSwap(arr, low, high);
            }
            if (arr[high].compareTo(arr[middle]) < 0) {
                //If the value at the high position is less than the value at middle,
                //swap them
                comparableSwap(arr, middle, high);
            }

            //Placing pivot at position high-1
            comparableSwap(arr, middle, high - 1);
            Comparable pivot = arr[high - 1];

            //Partitioning
            int i, j;
            for (i = low, j = high - 1; ; ) {
                while (arr[++i].compareTo(pivot) < 0) {
                    //;
                }
                while (pivot.compareTo(arr[--j]) < 0) {
                    //;
                }
                if (i >= j) {
                    break;
                }
                comparableSwap(arr, i, j);
            }

            //Restores pivot
            comparableSwap(arr, i, high - 1);

            enhancedQuickSort(arr, low, i - 1); //Sorting small elements
            enhancedQuickSort(arr, i + 1, high); //Sorting large elements
        }
    }

    public static void enhancedQuickSort(int[] arr, int low, int high){
        /*if(low > high){
            return;
        }*/
        if((low + 10) > high){
            //If the array is small, using insertionSort will yield faster results
            insertionSort(arr);
            //insertionSort(arr, low, high);
        } else {
            //Shuffling seems to slow things down
            //shuffleAlternate(arr);

            //Sort low, middle and high
            int middle = (low + high) / 2;
            if (arr[middle] < arr[low]) {
                //If the value at the middle position is less than the value at low,
                //swap them
                swap(arr, low, middle);
            }
            if (arr[high] < arr[low]) {
                //If the value at the high position is less than the value at low,
                //swap them
                swap(arr, low, high);
            }
            if (arr[high] < arr[middle]) {
                //If the value at the high position is less than the value at middle,
                //swap them
                swap(arr, middle, high);
            }

            //Placing pivot at position high-1
            swap(arr, middle, high - 1);
            int pivot = arr[high - 1];

            //Partitioning
            int i, j;
            for (i = low, j = high - 1; ; ) {
                while (arr[++i] < pivot) {
                    //;
                }
                while (pivot < arr[--j]) {
                    //;
                }
                if (i >= j) {
                    break;
                }
                swap(arr, i, j);
            }

            //Restores pivot
            swap(arr, i, high - 1);

            enhancedQuickSort(arr, low, i - 1); //Sorting small elements
            enhancedQuickSort(arr, i + 1, high); //Sorting large elements
        }
    }


    public static void quickSort(Comparable[] arr, int low, int high){
        if(low < high) {
            //Finding the partitioning index
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1); //Sorting before partitioning index
            quickSort(arr, pi + 1, high); //Sorting after partitioning index
        }
    }

    public static void quickSort(int[] arr, int low, int high){
        if(low < high) {
            //Finding the partitioning index
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1); //Sorting before partitioning index
            quickSort(arr, pi + 1, high); //Sorting after partitioning index
        }
    }


    public static int partition(Comparable[] arr, int low, int high){
        Comparable pivot = arr[high];
        int i = low-1;

        for(int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                comparableSwap(arr, i, j);
            }
        }

        comparableSwap(arr,i+1, high);
        return i+1;
    }

    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low-1;

        for(int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr,i+1, high);
        return i+1;
    }


    public static void shuffleAlternate(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            // choose index uniformly in [i, n-1]
            int r = i + (int) (Math.random() * (n - i));
            int swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }
    }


    public static int[] randomIntArray(int size) {
        //A method to create an array of a given size full of random values without doubles
        int[] array = new int[size]; //Creates a new array of the given size
        for (int i = 0; i < size; i++) {
            //For every position in the array, store a randomly generated number between 0 and 1000
            array[i] = (int) (Math.random() * 100000);

            for (int j = 0; j < i; j++) {
                //Scan through the array so far
                if (array[i] == array[j]) {
                    //If any values are the same as the newest value, decrement i so a new value is generated for it
                    i--;
                    break;
                }
            }
        }
        return array;
    }

    public static void printArray(int[] arr){
        System.out.print("[ "); //Print opening bracket
        for (int value : arr) {
            //Print each value of the array
            System.out.print(value + " ");
        }
        System.out.print("]"); //Print closing bracket
        System.out.println();
    }

    public static void printComparableArray(Comparable[] array){
        System.out.print("[ "); //Print opening bracket
        for (Comparable value : array) {
            //Print each value of the array
            System.out.print(value + " ");
        }
        System.out.print("]"); //Print closing bracket
        System.out.println();
    }

    public static Comparable[] randomComparableArray(int size) {
        //A method to create an array of a given size full of random values without doubles
        Comparable[] array = new Comparable[size]; //Creates a new array of the given size
        for (int i = 0; i < size; i++) {
            //For every position in the array, store a randomly generated number between 0 and 1000
            array[i] = (int) (Math.random() * 100000);

            for (int j = 0; j < i; j++) {
                //Scan through the array so far
                if (array[i] == array[j]) {
                    //If any values are the same as the newest value, decrement i so a new value is generated for it
                    i--;
                    break;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int arrayLength = 10;
        int arrayLength2 = 100;
        int arrayLength3 = 500;
        int arrayLength4 = 1000;
        int arrayLength5 = 5000;
        int arrayLength6 = 10000;
        long startTime;
        long estimatedTime;

        System.out.println("**Comparable Sorting Method Tests**");
        System.out.println("Insertion Sort w/ array length " + arrayLength + ":");
        Comparable[] b = randomComparableArray(arrayLength);
        printComparableArray(b);
        startTime = System.nanoTime();
        insertionSort(b);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(b);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Insertion Sort w/ array length " + arrayLength2 + ":");
        Comparable[] bb = randomComparableArray(arrayLength2);
        printComparableArray(bb);
        startTime = System.nanoTime();
        insertionSort(bb);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(bb);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Insertion Sort w/ array length " + arrayLength3 + ":");
        Comparable[] bbb = randomComparableArray(arrayLength3);
        printComparableArray(bbb);
        startTime = System.nanoTime();
        insertionSort(bbb);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(bbb);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Insertion Sort w/ array length " + arrayLength4 + ":");
        Comparable[] bbbb = randomComparableArray(arrayLength4);
        printComparableArray(bbbb);
        startTime = System.nanoTime();
        insertionSort(bbbb);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(bbbb);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        System.out.println();
        System.out.println("Insertion Sort w/ array length " + arrayLength5 + ":");
        Comparable[] bbbbb = randomComparableArray(arrayLength5);
        printComparableArray(bbbbb);
        startTime = System.nanoTime();
        insertionSort(bbbbb);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(bbbbb);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        System.out.println();
        System.out.println("Insertion Sort w/ array length " + arrayLength6 + ":");
        Comparable[] bbbbbb = randomComparableArray(arrayLength6);
        printComparableArray(bbbbbb);
        startTime = System.nanoTime();
        insertionSort(bbbbbb);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(bbbbbb);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        System.out.println();
        System.out.println("Selection Sort w/ array length " + arrayLength + ":");
        Comparable[] c = randomComparableArray(arrayLength);
        printComparableArray(c);
        startTime = System.nanoTime();
        selectionSort(c);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(c);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Selection Sort w/ array length " + arrayLength2 + ":");
        Comparable[] cc = randomComparableArray(arrayLength2);
        printComparableArray(cc);
        startTime = System.nanoTime();
        selectionSort(cc);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(cc);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Selection Sort w/ array length " + arrayLength3 + ":");
        Comparable[] ccc = randomComparableArray(arrayLength3);
        printComparableArray(ccc);
        startTime = System.nanoTime();
        selectionSort(ccc);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(ccc);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Selection Sort w/ array length " + arrayLength4 + ":");
        Comparable[] cccc = randomComparableArray(arrayLength4);
        printComparableArray(cccc);
        startTime = System.nanoTime();
        selectionSort(cccc);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(cccc);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        System.out.println();
        System.out.println("Selection Sort w/ array length " + arrayLength5 + ":");
        Comparable[] ccccc = randomComparableArray(arrayLength5);
        printComparableArray(ccccc);
        startTime = System.nanoTime();
        selectionSort(ccccc);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(ccccc);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        System.out.println();
        System.out.println("Selection Sort w/ array length " + arrayLength6 + ":");
        Comparable[] cccccc = randomComparableArray(arrayLength6);
        printComparableArray(cccccc);
        startTime = System.nanoTime();
        selectionSort(cccccc);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(cccccc);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        System.out.println();
        System.out.println("Merge Sort w/ array length " + arrayLength + ":");
        Comparable[] d = randomComparableArray(arrayLength);
        printComparableArray(d);
        startTime = System.nanoTime();
        mergeSort(d, d.length);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(d);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Merge Sort w/ array length " + arrayLength2 + ":");
        Comparable[] dd = randomComparableArray(arrayLength2);
        printComparableArray(dd);
        startTime = System.nanoTime();
        mergeSort(dd, dd.length);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(dd);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Merge Sort w/ array length " + arrayLength3 + ":");
        Comparable[] ddd = randomComparableArray(arrayLength3);
        printComparableArray(ddd);
        startTime = System.nanoTime();
        mergeSort(ddd, ddd.length);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(ddd);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Merge Sort w/ array length " + arrayLength4 + ":");
        Comparable[] dddd = randomComparableArray(arrayLength4);
        printComparableArray(dddd);
        startTime = System.nanoTime();
        mergeSort(dddd, dddd.length);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(dddd);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        System.out.println();
        System.out.println("Merge Sort w/ array length " + arrayLength5 + ":");
        Comparable[] ddddd = randomComparableArray(arrayLength5);
        printComparableArray(ddddd);
        startTime = System.nanoTime();
        mergeSort(ddddd, ddddd.length);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(ddddd);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Merge Sort w/ array length " + arrayLength6 + ":");
        Comparable[] dddddd = randomComparableArray(arrayLength6);
        printComparableArray(dddddd);
        startTime = System.nanoTime();
        mergeSort(dddddd, dddddd.length);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(dddddd);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Enhanced Merge Sort w/ array length " + arrayLength + ":");
        Comparable[] e = randomComparableArray(arrayLength);
        printComparableArray(e);
        startTime = System.nanoTime();
        enhancedMergeSort(e, e.length);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(e);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Enhanced Merge Sort w/ array length " + arrayLength2 + ":");
        Comparable[] ee = randomComparableArray(arrayLength2);
        printComparableArray(ee);
        startTime = System.nanoTime();
        enhancedMergeSort(ee, ee.length);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(ee);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Enhanced Merge Sort w/ array length " + arrayLength3 + ":");
        Comparable[] eee = randomComparableArray(arrayLength3);
        printComparableArray(eee);
        startTime = System.nanoTime();
        enhancedMergeSort(eee, eee.length);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(eee);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Enhanced Merge Sort w/ array length " + arrayLength4 + ":");
        Comparable[] eeee = randomComparableArray(arrayLength4);
        printComparableArray(eeee);
        startTime = System.nanoTime();
        enhancedMergeSort(eeee, eeee.length);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(eeee);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        System.out.println();
        System.out.println("Enhanced Merge Sort w/ array length " + arrayLength5 + ":");
        Comparable[] eeeee = randomComparableArray(arrayLength5);
        printComparableArray(eeeee);
        startTime = System.nanoTime();
        enhancedMergeSort(eeeee, eeeee.length);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(eeeee);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Enhanced Merge Sort w/ array length " + arrayLength6 + ":");
        Comparable[] eeeeee = randomComparableArray(arrayLength6);
        printComparableArray(eeeeee);
        startTime = System.nanoTime();
        enhancedMergeSort(eeeeee, eeeeee.length);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(eeeeee);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Quick Sort w/ array length " + arrayLength + ":");
        Comparable[] f = randomComparableArray(arrayLength);
        printComparableArray(f);
        startTime = System.nanoTime();
        quickSort(f, 0,f.length-1);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(f);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Quick Sort w/ array length " + arrayLength2 + ":");
        Comparable[] ff = randomComparableArray(arrayLength2);
        printComparableArray(ff);
        startTime = System.nanoTime();
        quickSort(ff, 0,ff.length-1);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(ff);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Quick Sort w/ array length " + arrayLength3 + ":");
        Comparable[] fff = randomComparableArray(arrayLength3);
        printComparableArray(fff);
        startTime = System.nanoTime();
        quickSort(fff, 0,fff.length-1);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(fff);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Quick Sort w/ array length " + arrayLength4 + ":");
        Comparable[] ffff = randomComparableArray(arrayLength4);
        printComparableArray(ffff);
        startTime = System.nanoTime();
        quickSort(ffff, 0,ffff.length-1);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(ffff);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        System.out.println();
        System.out.println("Quick Sort w/ array length " + arrayLength5 + ":");
        Comparable[] fffff = randomComparableArray(arrayLength5);
        printComparableArray(fffff);
        startTime = System.nanoTime();
        quickSort(fffff, 0,fffff.length-1);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(fffff);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Quick Sort w/ array length " + arrayLength6 + ":");
        Comparable[] ffffff = randomComparableArray(arrayLength6);
        printComparableArray(ffffff);
        startTime = System.nanoTime();
        quickSort(ffffff, 0,ffffff.length-1);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(ffffff);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Enhanced Quick Sort w/ array length " + arrayLength + ":");
        Comparable[] g = randomComparableArray(arrayLength);
        printComparableArray(g);
        startTime = System.nanoTime();
        enhancedQuickSort(g, 0,g.length-1);
        estimatedTime= System.nanoTime() - startTime;
        printComparableArray(g);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Enhanced Quick Sort w/ array length " + arrayLength2 + ":");
        Comparable[] gg = randomComparableArray(arrayLength2);
        printComparableArray(gg);
        startTime = System.nanoTime();
        enhancedQuickSort(gg, 0,gg.length-1);
        estimatedTime= System.nanoTime() - startTime;
        printComparableArray(gg);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Enhanced Quick Sort w/ array length " + arrayLength3 + ":");
        Comparable[] ggg = randomComparableArray(arrayLength3);
        printComparableArray(ggg);
        startTime = System.nanoTime();
        enhancedQuickSort(ggg, 0,ggg.length-1);
        estimatedTime= System.nanoTime() - startTime;
        printComparableArray(ggg);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Enhanced Quick Sort w/ array length " + arrayLength4 + ":");
        Comparable[] gggg = randomComparableArray(arrayLength4);
        printComparableArray(gggg);
        startTime = System.nanoTime();
        enhancedQuickSort(gggg, 0,gggg.length-1);
        estimatedTime= System.nanoTime() - startTime;
        printComparableArray(gggg);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        System.out.println();
        System.out.println("Enhanced Quick Sort w/ array length " + arrayLength5 + ":");
        Comparable[] ggggg = randomComparableArray(arrayLength5);
        printComparableArray(ggggg);
        startTime = System.nanoTime();
        enhancedQuickSort(ggggg, 0,ggggg.length-1);
        estimatedTime= System.nanoTime() - startTime;
        printComparableArray(ggggg);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Enhanced Quick Sort w/ array length " + arrayLength6 + ":");
        Comparable[] gggggg = randomComparableArray(arrayLength6);
        printComparableArray(gggggg);
        startTime = System.nanoTime();
        enhancedQuickSort(gggggg, 0,gggggg.length-1);
        estimatedTime= System.nanoTime() - startTime;
        printComparableArray(gggggg);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println("Bogo Sort w/ array length " + arrayLength + ":");
        Comparable[] a = randomComparableArray(arrayLength);
        printComparableArray(a);
        startTime = System.nanoTime();
        BogoSort ob = new BogoSort();
        ob.bogoSort(a);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(a);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        System.out.println();
        System.out.println("Bogo Sort w/ array length " + arrayLength2 + ":");
        Comparable[] aa = randomComparableArray(arrayLength2);
        printComparableArray(aa);
        startTime = System.nanoTime();
        BogoSort ob2 = new BogoSort();
        ob2.bogoSort(aa);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(aa);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        System.out.println("Bogo Sort w/ array length " + arrayLength3 + ":");
        Comparable[] aaa = randomComparableArray(arrayLength3);
        printComparableArray(aaa);
        startTime = System.nanoTime();
        BogoSort ob3 = new BogoSort();
        ob3.bogoSort(aaa);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(aaa);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        System.out.println("Bogo Sort w/ array length " + arrayLength4 + ":");
        Comparable[] aaaa = randomComparableArray(arrayLength4);
        printComparableArray(aaaa);
        startTime = System.nanoTime();
        BogoSort ob4 = new BogoSort();
        ob4.bogoSort(aaaa);
        estimatedTime = System.nanoTime() - startTime;
        printComparableArray(aaaa);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();
        System.out.println();


        System.out.println("**Int Sorting Method Tests**");
        System.out.println("Insertion Sort w/ array length " + arrayLength + ":");
        int[] i = randomIntArray(arrayLength);
        printArray(i);
        startTime = System.nanoTime();
        insertionSort(i);
        estimatedTime = System.nanoTime() - startTime;
        printArray(i);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println("Insertion Sort w/ array length " + arrayLength2 + ":");
        int[] ii = randomIntArray(arrayLength2);
        printArray(ii);
        startTime = System.nanoTime();
        insertionSort(ii);
        estimatedTime = System.nanoTime() - startTime;
        printArray(ii);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println("Insertion Sort w/ array length " + arrayLength3 + ":");
        int[] iii = randomIntArray(arrayLength3);
        printArray(iii);
        startTime = System.nanoTime();
        insertionSort(iii);
        estimatedTime = System.nanoTime() - startTime;
        printArray(iii);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println("Insertion Sort w/ array length " + arrayLength4 + ":");
        int[] iiii = randomIntArray(arrayLength4);
        printArray(iiii);
        startTime = System.nanoTime();
        insertionSort(iiii);
        estimatedTime = System.nanoTime() - startTime;
        printArray(iiii);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        System.out.println("Insertion Sort w/ array length " + arrayLength5 + ":");
        int[] iiiii = randomIntArray(arrayLength5);
        printArray(iiiii);
        startTime = System.nanoTime();
        insertionSort(iiiii);
        estimatedTime = System.nanoTime() - startTime;
        printArray(iiiii);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println("Insertion Sort w/ array length " + arrayLength6 + ":");
        int[] iiiiii = randomIntArray(arrayLength6);
        printArray(iiiiii);
        startTime = System.nanoTime();
        insertionSort(iiiiii);
        estimatedTime = System.nanoTime() - startTime;
        printArray(iiiiii);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Selection Sort w/ array length " + arrayLength + ":");
        int[] j = randomIntArray(arrayLength);
        printArray(j);
        startTime = System.nanoTime();
        selectionSort(j);
        estimatedTime = System.nanoTime() - startTime;
        printArray(j);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Selection Sort w/ array length " + arrayLength2 + ":");
        int[] jj = randomIntArray(arrayLength2);
        printArray(jj);
        startTime = System.nanoTime();
        selectionSort(jj);
        estimatedTime = System.nanoTime() - startTime;
        printArray(jj);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Selection Sort w/ array length " + arrayLength3 + ":");
        int[] jjj = randomIntArray(arrayLength3);
        printArray(jjj);
        startTime = System.nanoTime();
        selectionSort(jjj);
        estimatedTime = System.nanoTime() - startTime;
        printArray(jjj);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Selection Sort w/ array length " + arrayLength4 + ":");
        int[] jjjj = randomIntArray(arrayLength4);
        printArray(jjjj);
        startTime = System.nanoTime();
        selectionSort(jjjj);
        estimatedTime = System.nanoTime() - startTime;
        printArray(jjjj);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        System.out.println();
        System.out.println("Selection Sort w/ array length " + arrayLength5 + ":");
        int[] jjjjj = randomIntArray(arrayLength5);
        printArray(jjjjj);
        startTime = System.nanoTime();
        selectionSort(jjjjj);
        estimatedTime = System.nanoTime() - startTime;
        printArray(jjjjj);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Selection Sort w/ array length " + arrayLength6 + ":");
        int[] jjjjjj = randomIntArray(arrayLength6);
        printArray(jjjjjj);
        startTime = System.nanoTime();
        selectionSort(jjjjjj);
        estimatedTime = System.nanoTime() - startTime;
        printArray(jjjjjj);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Merge Sort w/ array length " + arrayLength + ":");
        int[] k = randomIntArray(arrayLength);
        printArray(k);
        startTime = System.nanoTime();
        mergeSort(k, k.length);
        estimatedTime = System.nanoTime() - startTime;
        printArray(k);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Merge Sort w/ array length " + arrayLength2 + ":");
        int[] kk = randomIntArray(arrayLength2);
        printArray(kk);
        startTime = System.nanoTime();
        mergeSort(kk, kk.length);
        estimatedTime = System.nanoTime() - startTime;
        printArray(kk);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Merge Sort w/ array length " + arrayLength3 + ":");
        int[] kkk = randomIntArray(arrayLength3);
        printArray(kkk);
        startTime = System.nanoTime();
        mergeSort(kkk, kkk.length);
        estimatedTime = System.nanoTime() - startTime;
        printArray(kkk);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Merge Sort w/ array length " + arrayLength4 + ":");
        int[] kkkk = randomIntArray(arrayLength4);
        printArray(kkkk);
        startTime = System.nanoTime();
        mergeSort(kkkk, kkkk.length);
        estimatedTime = System.nanoTime() - startTime;
        printArray(kkkk);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        System.out.println();
        System.out.println("Merge Sort w/ array length " + arrayLength5 + ":");
        int[] kkkkk = randomIntArray(arrayLength5);
        printArray(kkkkk);
        startTime = System.nanoTime();
        mergeSort(kkkkk, kkkkk.length);
        estimatedTime = System.nanoTime() - startTime;
        printArray(kkkkk);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Merge Sort w/ array length " + arrayLength6 + ":");
        int[] kkkkkk = randomIntArray(arrayLength6);
        printArray(kkkkkk);
        startTime = System.nanoTime();
        mergeSort(kkkkkk, kkkkkk.length);
        estimatedTime = System.nanoTime() - startTime;
        printArray(kkkkkk);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Enhanced Merge Sort w/ array length " + arrayLength + ":");
        int[] l = randomIntArray(arrayLength);
        printArray(l);
        startTime = System.nanoTime();
        enhancedMergeSort(l, l.length);
        estimatedTime = System.nanoTime() - startTime;
        printArray(l);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Enhanced Merge Sort w/ array length " + arrayLength2 + ":");
        int[] ll = randomIntArray(arrayLength2);
        printArray(ll);
        startTime = System.nanoTime();
        enhancedMergeSort(ll, ll.length);
        estimatedTime = System.nanoTime() - startTime;
        printArray(ll);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Enhanced Merge Sort w/ array length " + arrayLength3 + ":");
        int[] lll = randomIntArray(arrayLength3);
        printArray(lll);
        startTime = System.nanoTime();
        enhancedMergeSort(lll, lll.length);
        estimatedTime = System.nanoTime() - startTime;
        printArray(lll);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Enhanced Merge Sort w/ array length " + arrayLength4 + ":");
        int[] llll = randomIntArray(arrayLength4);
        printArray(llll);
        startTime = System.nanoTime();
        enhancedMergeSort(llll, llll.length);
        estimatedTime = System.nanoTime() - startTime;
        printArray(llll);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        System.out.println();
        System.out.println("Enhanced Merge Sort w/ array length " + arrayLength5 + ":");
        int[] lllll = randomIntArray(arrayLength5);
        printArray(lllll);
        startTime = System.nanoTime();
        enhancedMergeSort(lllll, lllll.length);
        estimatedTime = System.nanoTime() - startTime;
        printArray(lllll);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Enhanced Merge Sort w/ array length " + arrayLength6 + ":");
        int[] llllll = randomIntArray(arrayLength6);
        printArray(llllll);
        startTime = System.nanoTime();
        enhancedMergeSort(llllll, llllll.length);
        estimatedTime = System.nanoTime() - startTime;
        printArray(llllll);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Quick Sort w/ array length " + arrayLength + ":");
        int[] m = randomIntArray(arrayLength);
        printArray(m);
        startTime = System.nanoTime();
        quickSort(m, 0,m.length-1);
        estimatedTime = System.nanoTime() - startTime;
        printArray(m);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Quick Sort w/ array length " + arrayLength2 + ":");
        int[] mm = randomIntArray(arrayLength2);
        printArray(mm);
        startTime = System.nanoTime();
        quickSort(mm, 0,mm.length-1);
        estimatedTime = System.nanoTime() - startTime;
        printArray(mm);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Quick Sort w/ array length " + arrayLength3 + ":");
        int[] mmm = randomIntArray(arrayLength3);
        printArray(mmm);
        startTime = System.nanoTime();
        quickSort(mmm, 0,mmm.length-1);
        estimatedTime = System.nanoTime() - startTime;
        printArray(mmm);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Quick Sort w/ array length " + arrayLength4 + ":");
        int[] mmmm = randomIntArray(arrayLength4);
        printArray(mmmm);
        startTime = System.nanoTime();
        quickSort(mmmm, 0,mmmm.length-1);
        estimatedTime = System.nanoTime() - startTime;
        printArray(mmmm);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        System.out.println();
        System.out.println("Quick Sort w/ array length " + arrayLength5 + ":");
        int[] mmmmm = randomIntArray(arrayLength5);
        printArray(mmmmm);
        startTime = System.nanoTime();
        quickSort(mmmmm, 0,mmmmm.length-1);
        estimatedTime = System.nanoTime() - startTime;
        printArray(mmmmm);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Quick Sort w/ array length " + arrayLength6 + ":");
        int[] mmmmmm = randomIntArray(arrayLength6);
        printArray(mmmmmm);
        startTime = System.nanoTime();
        quickSort(mmmmmm, 0,mmmmmm.length-1);
        estimatedTime = System.nanoTime() - startTime;
        printArray(mmmmmm);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Enhanced Quick Sort w/ array length " + arrayLength + ":");
        int[] n = randomIntArray(arrayLength);
        printArray(n);
        startTime = System.nanoTime();
        enhancedQuickSort(n, 0,n.length-1);
        estimatedTime = System.nanoTime() - startTime;
        printArray(n);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Enhanced Quick Sort w/ array length " + arrayLength2 + ":");
        int[] nn = randomIntArray(arrayLength2);
        printArray(nn);
        startTime = System.nanoTime();
        enhancedQuickSort(nn, 0,nn.length-1);
        estimatedTime = System.nanoTime() - startTime;
        printArray(nn);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Enhanced Quick Sort w/ array length " + arrayLength3 + ":");
        int[] nnn = randomIntArray(arrayLength3);
        printArray(nnn);
        startTime = System.nanoTime();
        enhancedQuickSort(nnn, 0,nnn.length-1);
        estimatedTime = System.nanoTime() - startTime;
        printArray(nnn);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Enhanced Quick Sort w/ array length " + arrayLength4 + ":");
        int[] nnnn = randomIntArray(arrayLength4);
        printArray(nnnn);
        startTime = System.nanoTime();
        enhancedQuickSort(nnnn, 0,nnnn.length-1);
        estimatedTime = System.nanoTime() - startTime;
        printArray(nnnn);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        System.out.println();
        System.out.println("Enhanced Quick Sort w/ array length " + arrayLength5 + ":");
        int[] nnnnn = randomIntArray(arrayLength5);
        printArray(nnnnn);
        startTime = System.nanoTime();
        enhancedQuickSort(nnnnn, 0,nnnnn.length-1);
        estimatedTime = System.nanoTime() - startTime;
        printArray(nnnnn);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println();
        System.out.println("Enhanced Quick Sort w/ array length " + arrayLength6 + ":");
        int[] nnnnnn = randomIntArray(arrayLength6);
        printArray(nnnnnn);
        startTime = System.nanoTime();
        enhancedQuickSort(nnnnnn, 0,nnnnnn.length-1);
        estimatedTime = System.nanoTime() - startTime;
        printArray(nnnnnn);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");

        System.out.println("Bogo Sort w/ array length " + arrayLength + ":");
        int[] h = randomIntArray(arrayLength);
        printArray(h);
        startTime = System.nanoTime();
        BogoSort bogo = new BogoSort();
        bogo.bogoSort(h);
        estimatedTime = System.nanoTime() - startTime;
        printArray(h);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        System.out.println("Bogo Sort w/ array length " + arrayLength2 + ":");
        int[] hh = randomIntArray(arrayLength2);
        printArray(hh);
        startTime = System.nanoTime();
        BogoSort bogo2 = new BogoSort();
        bogo2.bogoSort(hh);
        estimatedTime = System.nanoTime() - startTime;
        printArray(hh);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        System.out.println("Bogo Sort w/ array length " + arrayLength3 + ":");
        int[] hhh = randomIntArray(arrayLength3);
        printArray(hhh);
        startTime = System.nanoTime();
        BogoSort bogo3 = new BogoSort();
        bogo3.bogoSort(hhh);
        estimatedTime = System.nanoTime() - startTime;
        printArray(hhh);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        System.out.println("Bogo Sort w/ array length " + arrayLength4 + ":");
        int[] hhhh = randomIntArray(arrayLength4);
        printArray(hhhh);
        startTime = System.nanoTime();
        BogoSort bogo4 = new BogoSort();
        bogo4.bogoSort(hhhh);
        estimatedTime = System.nanoTime() - startTime;
        printArray(hhhh);
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
    }
}