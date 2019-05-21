package RECURSIONPRACTICE;
// Java implementation of the approach 
import java.util.ArrayList;

public class smartkeypad {

    // String array to store keypad characters 
    static final String codes[]
            = {" ", ".+@$", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    // Function that returns an Arraylist 
    // which contains all the generated words 
    public static ArrayList<String> printKeyWords(String str)
    {

        // If str is empty 
        if (str.length() == 0) {
            ArrayList<String> baseRes = new ArrayList<>();
            baseRes.add("");

            // Return an Arraylist containing 
            // empty string 
            return baseRes;
        }

        // First character of str 
        char ch = str.charAt(0);

        // Rest of the characters of str 
        String restStr = str.substring(1);

        ArrayList<String> prevRes = printKeyWords(restStr);
        ArrayList<String> Res = new ArrayList<>();

        String code = codes[ch - '0'];

        for (String val : prevRes) {

            for (int i = 0; i < code.length(); i++) {
                Res.add(code.charAt(i) + val);
            }
        }
        return Res;
    }

    // Driver code 
    public static void main(String[] args)
    {
        String str = "12";

        // Print all the possible words 
        System.out.println(printKeyWords(str));
    }
} 
