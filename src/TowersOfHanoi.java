public class TowersOfHanoi {
    public static void towersOfHanoi(int disk, String source, String dest, String auxilary){
        if(disk == 1){ //If there's only 1 disk, move it from the start peg to the last peg
            System.out.println("Move the disk on peg " + source + " to " + dest);
        } else{
            towersOfHanoi(disk-1, source, auxilary, dest); //Calls method again, rearranging arguments so the instruction it prints corresponds to the pattern
            System.out.println("Move the disk on peg " + source + " to " + dest);
            towersOfHanoi(disk-1, auxilary, dest, source); //Calls method again, rearranging arguments so the instruction it prints corresponds to the pattern
        }
    }

    public static void main(String[] args) {
        long startTime;
        long estimatedTime;

        //Time tests for different numbers of disks
        System.out.println("Towers of Hanoi with 4 disks");
        startTime = System.currentTimeMillis(); //Start time stored in a variable
        towersOfHanoi(4, "A", "C", "B");
        //Time taken by the method is found by subtracting the start time from the current time
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Time taken : " + estimatedTime + " milliseconds");
        System.out.println();

        System.out.println("Towers of Hanoi with 6 disks");
        startTime = System.currentTimeMillis(); //Start time stored in a variable
        towersOfHanoi(6, "A", "C", "B");
        //Time taken by the method is found by subtracting the start time from the current time
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Time taken : " + estimatedTime + " milliseconds");
        System.out.println();

        System.out.println("Towers of Hanoi with 8 disks");
        startTime = System.currentTimeMillis(); //Start time stored in a variable
        towersOfHanoi(8, "A", "C", "B");
        //Time taken by the method is found by subtracting the start time from the current time
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Time taken : " + estimatedTime + " milliseconds");
        System.out.println();

        System.out.println("Towers of Hanoi with 10 disks");
        startTime = System.currentTimeMillis(); //Start time stored in a variable
        towersOfHanoi(10, "A", "C", "B");
        //Time taken by the method is found by subtracting the start time from the current time
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Time taken : " + estimatedTime + " milliseconds");
        System.out.println();

        System.out.println("Towers of Hanoi with 12 disks");
        startTime = System.currentTimeMillis(); //Start time stored in a variable
        towersOfHanoi(12, "A", "C", "B");
        //Time taken by the method is found by subtracting the start time from the current time
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Time taken : " + estimatedTime + " milliseconds");
        System.out.println();

        System.out.println("Towers of Hanoi with 14 disks");
        startTime = System.currentTimeMillis(); //Start time stored in a variable
        towersOfHanoi(14, "A", "C", "B");
        //Time taken by the method is found by subtracting the start time from the current time
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Time taken : " + estimatedTime + " milliseconds");
        System.out.println();

        System.out.println("Towers of Hanoi with 16 disks");
        startTime = System.currentTimeMillis(); //Start time stored in a variable
        towersOfHanoi(16, "A", "C", "B");
        //Time taken by the method is found by subtracting the start time from the current time
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Time taken : " + estimatedTime + " milliseconds");

    }
}
