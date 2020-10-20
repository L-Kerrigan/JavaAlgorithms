import java.util.Scanner;

public class RunLengthEncoding {

    public static void printRLE(String string){
        int len = string.length();
        for(int i = 0; i < len; i++){ //Run through the length of the string
            int counter = 1; //Create a counter to count how many times a character occurs in a row
            while (i < len - 1 && string.charAt(i) == string.charAt(i+1)){
                //While the current character and the next character are the same,
                //increment the counter
                counter++;
                i++;
            }
            System.out.println(string.charAt(i) + "" + counter);
            System.out.println("The letter " + string.charAt(i) + " occurs " + counter + " times.");
        }
    }

    public static void main(String[] args) {
        Scanner inn = new Scanner(System.in);
        System.out.println("Please enter the string to scan in:");
        printRLE(inn.nextLine());
    }
}
