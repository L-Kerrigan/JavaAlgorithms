class KMPSearch {
    void search(String pat, String txt)
    {
        int m = pat.length();
        int n = txt.length();

        //Create lps[] that will hold the longest
        //Prefix suffix values for pattern
        int[] lps = new int[m];
        int i = 0, j = 0; //Index for pat[]

        //Pre-process the pattern (calculate lps[] array)
        computeLPSArray(pat, m, lps);

        while(i < n){ //Tries to find pattern similarly to brute force search
            if(pat.charAt(j) == txt.charAt(i)){
                j++;
                i++;
            }

            if(j == m){
                System.out.println("The pattern matches at index: " + (i - j));
                j = lps[j-1];
            } else if(i < n && pat.charAt(j) != txt.charAt(i)) {
                if(j != 0){ //If there's a mismatch after j characters match,
                    //don't match lps[0] to lps[j] because we know they'll match
                    j = lps[j-1]; //Stores index of the next character to match
                } else {
                    i++;
                }
            }
        }

    }

    void computeLPSArray(String pat, int M, int[] lps)
    {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else // (pat[i] != pat[len])
            {
                //Consider the example: AAACAAAA and i = 7. The idea is similar to search step.
                if (len != 0) {
                    len = lps[len - 1];

                    // Also, note that we do not increment
                    // i here
                }
                else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String txt;
        String pat;

        long startTime;
        long estimatedTime;

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