// Java program for Naive Pattern Searching

public class bruteForceSearch {

    public static void search(String txt, String pat)
    {
        int n = txt.length();
        int m = pat.length();

        for(int i = 0; i <= n-m; i++){
            int j; //Compare every character in the pattern to every character in the array
            for(j = 0; j < m; j++){
                if(txt.charAt(i+j) != pat.charAt(j)){
                    //If at any point the character in the pattern doesn't match the character in the pattern,
                    //break the inner loop
                    break;
                }
            }
            //If j has reached the size of the pattern, it has found a match
            if(j == m){
                System.out.println("Found a match at index: " + i);
            }
        }
        //return n;
    }

    public static void main(String[] args) {
        String txt;
        String pat;

        long startTime;
        long estimatedTime;

        //Timing tests with strings and patterns of varying length
        txt = "ABABDABACDABABCABAB";
        pat = "ABABCABAB";
        System.out.println("Given text: " + txt);
        System.out.println("Given pattern: " + pat);
        System.out.println("Expected matches: 1");
        startTime = System.nanoTime();
        new KMPSearch().search(pat, txt);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        txt = "REQAAAAAAAAAAAAAAHHHHHHHHHHHREQHHFFFFFFFFFFFRRRRRRRRRRREQQQQQQQQQQQQQQQQRERTWSSSSSSSSSSSSSSSSSSSSSSSSSSSREQSS";
        pat = "REQ";
        System.out.println("Given text: " + txt);
        System.out.println("Given pattern: " + pat);
        System.out.println("Expected matches: 4");
        startTime = System.nanoTime();
        new KMPSearch().search(pat, txt);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        txt = "GYUITYOWQTFFFFFFFFFFFFFFFFFFFOOOOOOOOOOOOYGITBBBBBBBBBBASDFGHJKLQWERTYUJAAAAAAAAAAAAAAAAJKKKKKKKKKKKKKGSHHHHHHHHHHHHHHHHHHHHASDFGHJKLQWERTYUZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZNNNNNNNNNNNNMMHHHHHHHHHHHHHHHHHHHHASDFGLQWERTYUHHHHHHHHH";
        pat = "ASDFGHJKLQWERTYU";
        System.out.println("Given text: " + txt);
        System.out.println("Given pattern: " + pat);
        System.out.println("Expected matches: 2");
        startTime = System.nanoTime();
        new KMPSearch().search(pat, txt);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        txt = "PGHFAGGWEQJGYUFQWGWLFGWUIQOFGKULFQBWJBFQ&TYF&IU£$GUIYUFHIIIJJJJJJJJOSJOOOOOOOOQIGFuiWQGFt7£IGUFUFIGUigUGFUIWGF&WQIUGWQHUISHGKJGHSIUFDHSBVFHDBVUDIGHIHIIIJJJJJJJJOSJOOOOOOOO";
        pat = "HIIIJJJJJJJJOSJOOOOOOOO";
        System.out.println("Given text: " + txt);
        System.out.println("Given pattern: " + pat);
        System.out.println("Expected matches: 2");
        startTime = System.nanoTime();
        new KMPSearch().search(pat, txt);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        txt = "11754738265487571284691749999999289207534961856187956187956178659265428739610710562879654831903167809248771284691749999999289207538645931065134890653489046381956481596413878913691671643787128469174999999928920753591561347818954361878431618961489768931";
        pat = "7128469174999999928920753";
        System.out.println("Given text: " + txt);
        System.out.println("Given pattern: " + pat);
        System.out.println("Expected matches: 3");
        startTime = System.nanoTime();
        new KMPSearch().search(pat, txt);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
        System.out.println();

        txt = "ASDADSASSDFFDSFADSAFDSFDSSFADSFAFSAFDFSASFDSAFDSAFDSAFDSFADSFADSFDSFADSFADFSADSFADSFADFSDFSAFSFASAFSDAFSFADSDASFSADSFAFASAFSFADFSSAFSFASFASAFSFSAFSADFSASAFSFASFASAFDSFSAFSFASFAFASFASAFSASSDFFDSAFSAFASFASAFSAFSASFSAFAFSFSAASFSAFSAFFASAFSFASFASAFASAFSFSAAFSFASAFSASSDFFDSASSDFFDSAFSAFSAFSAFASAFFSAAFSAFSAFAFAASSDFFDSSAFAFASFSFSFASFAFSAFASAFASFSAFSFSAFSAASDADSASSDFFDSFADSAFDSFDSSFADSFAFSAFDFSASFDSAFDSAFDSAFDSFADSFADSFDSFADSFADFSADSFADSFADFSDFSAFSFASAFSDAFSFADSDASFSADSFAFASAFSFADFSSAFSFASFASAFSFSAFSADFSASAFSFASFASAFDSFSAFSFASFAFASFASAFSASSDFFDSAFSAFASFASAFSAFSASFSAFAFSFSAASFSAFSAFFASAFSFASFASAFASAFSFSAAFSFASAFSASSDFFDSASSDFFDSAFSAFSAFSAFASAFFSAAFSAFSAFAFAASSDFFDSSAFAFASFSFSFASFAFSAFASAFASFSAFSFSAFSAASDADFAFDSDADFAFDADF";
        pat = "ASSDFFDS";
        System.out.println("Given text: " + txt);
        System.out.println("Given pattern: " + pat);
        System.out.println("Expected matches: 10");
        startTime = System.nanoTime();
        new KMPSearch().search(pat, txt);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Time taken: " + estimatedTime + " nanoseconds");
    }
}
