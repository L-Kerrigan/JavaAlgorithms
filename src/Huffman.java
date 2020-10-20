import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Huffman {

    static class Node implements Comparable<Node>{//the Node class implements comparable since we want to be able to compare two nodes with each other based on their frequency
        private final char character;
        private final int frequency;
        private final Node leftChild;
        private final Node rightChild;

        public Node(char character, int frequency, Node leftChild, Node rightChild) {
            this.character = character;
            this.frequency = frequency;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        boolean isLeaf(){//if a node doesn't have any left or right children then it's a leaf node
            return this.leftChild == null && this.rightChild == null;
        }

        @Override
        public int compareTo(Node o) {
            final int frequencyComparison = Integer.compare(this.frequency, o.frequency);
            if (frequencyComparison != 0){//if the frequencies are not equal
                return frequencyComparison;
            }
            return Integer.compare(this.character, o.character);//this doesn't affect the quality of the algorithm but makes sure that the tree is always the same i.e. deterministic
        }

//        @Override
//        public String toString() {
//            return "Node{" +
//                    "character=" + character +
//                    ", frequency=" + frequency +
//                    ", leftChild=" + leftChild +
//                    ", rightChild=" + rightChild +
//                    '}';
//        }
    }

    private static final int SIZE = 256;//the number of characters and symbols that are supported by ASCII
    public HuffmanResult compress(final String data){
        final int[] freq = buildFrequencyTable(data);
        final Node root = buildHuffmanTree(freq);
        final Map<Character, String> lookUpTable = buildLookUpTable(root);
        return new HuffmanResult(generateEncodedData(data, lookUpTable), root);
    }

    private String generateEncodedData(String data, Map<Character, String> lookUpTable) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (final char character : data.toCharArray()){
            stringBuilder.append(lookUpTable.get(character));//getting the binary string for the particular character
        }
        return stringBuilder.toString();
    }

    private static Map<Character, String> buildLookUpTable(final Node root){//maps each character to a binary encoding
        //the length of the binary encoding of a character depends on how often that character occurs
        //the more frequent the character's occurrence the shorter the binary encoding is going to be
        final Map<Character, String> lookUpTable = new HashMap<>();
        //calling a helper method that is going to call itself recursively
        buildLookUpTableHelper(root, "", lookUpTable);
        return lookUpTable;
    }

    private static void buildLookUpTableHelper(Node n, String s, Map<Character, String> lookUpTable) {
        if(!n.isLeaf()){
            buildLookUpTableHelper(n.leftChild, s + '0', lookUpTable);//every time we walk down the tree to the left we append a 0 to the string
            buildLookUpTableHelper(n.rightChild, s + '1', lookUpTable);
        } else {//if it is a leaf node
            //look for that particular node's character
            lookUpTable.put(n.character, s);
        }

    }

    private static Node buildHuffmanTree(int[] freq){//we need the frequency table in order to build the tree
        final PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (char i = 0; i < SIZE; i++){
            if (freq[i] > 0){
                priorityQueue.add(new Node(i, freq[i], null, null));
            }
        }

        if (priorityQueue.size() == 1){//if the string we're passing is only one character long
            priorityQueue.add(new Node('\0', 1, null, null ));
        }

        while (priorityQueue.size() > 1){
            //we take out the two elements out of the priority queue
            //merge them together into one node
            //add the new node into the priority queue
            //we continue on doing this until there is only one node left, the root
            final Node left = priorityQueue.poll();
            final Node right = priorityQueue.poll();
            final Node parent = new Node('\0', left.frequency + right.frequency, left, right);
            priorityQueue.add(parent);
        }
        return priorityQueue.poll();//this will give the root node
    }

    private static int[] buildFrequencyTable(final String data){
        //we need to count the frequencies of each of the characters in our string
        final int[] freq = new int[SIZE];
        for (final char character : data.toCharArray()){//we're going through each character inside of our string
            freq[character]++;
        }
        return freq;
    }

    public String decompress(final HuffmanResult result){
        final StringBuilder resultBuilder = new StringBuilder();

        Node current = result.getRoot();
        int i = 0;
        while (i < result.getEncodedData().length()){
            //we first interpret each symbol from our encoded data
            //starting from the root of the tree
            //we go down through the tree until we reach the leaf to determine where the message ends
            while (!current.isLeaf()){
                char bit = result.getEncodedData().charAt(i);
                if(bit == '1'){
                    //the current is updated to be a right child
                    current = current.rightChild;
                }
                else if(bit == '0'){
                    current = current.leftChild;
                } else {
                    throw new IllegalArgumentException("Invalid bit " + bit);
                }
                i++;
            }
            resultBuilder.append(current.character);
            current = result.getRoot();
        }

        return resultBuilder.toString();
    }


    static class HuffmanResult {
        final String encodedData;
        final Node root;


        public HuffmanResult(String encodedData, Node root) {
            this.encodedData = encodedData;
            this.root = root;
        }

        public Node getRoot() {
            return this.root;
        }

        public String getEncodedData(){
            return this.encodedData;
        }
    }

    public static String readFile(String path, Charset encoding) throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public static void main(String[] args) {

        String filePath = args[1];
        //String filePath = "mobydick.txt";

        String test = null;
        try {
            test = readFile(filePath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //final String test = "I'm on tonight. You know my hips don't lie and I'm starting to feel it's right.";
        //final String test = "Hello";
        final int[] ft = buildFrequencyTable(test);
        final Node n = buildHuffmanTree(ft);
//        //System.out.println(Arrays.toString(ft));
        final Map<Character, String> lookUpTable = buildLookUpTable(n);
//
//        System.out.println(ft);
//        System.out.println(n);


        final Huffman encoder = new Huffman();
        final HuffmanResult result = encoder.compress(test);
//        System.out.println("The encoded message is: " + result.encodedData);
//        System.out.println("The decoded message is: " + encoder.decompress(result));
//        System.out.println("The frequency table is: " + Arrays.toString(ft));
//        System.out.println("The look up table is: " );
//        lookUpTable.forEach((k, v) -> System.out.println("'" + k + "' : " + v));
        //System.out.println("The huffman tree is: " + n);


        long startTime = System.currentTimeMillis();
        if (args[0].equalsIgnoreCase("encode")) {

            encoder.compress(test);
            System.out.println("The encoded message is: " + result.encodedData);
            //String source = "0123456789";
            byte[] byteArray = new byte[0];
            try {
                byteArray = result.encodedData.getBytes("UTF-16BE");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            int sizeInBits = byteArray.length * 8;
            System.out.println("The size of the encoded message in bits is: " + sizeInBits);
        }
        else if (args[0].equalsIgnoreCase("decode")) {
            encoder.decompress(result);
            System.out.println("The decoded message is: " + encoder.decompress(result));

            byte[] byteArray = new byte[0];
            try {
                byteArray = encoder.decompress(result).getBytes("UTF-16BE");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            int sizeInBits = byteArray.length * 8;
            System.out.println("The size of the decoded message in bits is: " + sizeInBits);
        }
        else {
            throw new IllegalArgumentException("Illegal command line argument");
        }


        System.out.println("The frequency table is: " + Arrays.toString(ft));
        System.out.println("The look up table is: " );
        lookUpTable.forEach((k, v) -> System.out.println("'" + k + "' : " + v));
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Time taken: " + estimatedTime);

    }
}