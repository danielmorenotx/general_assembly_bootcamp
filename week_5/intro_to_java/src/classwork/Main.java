package classwork;

public class Main {

    public static void main(String[] args) {
        System.out.println(isEven(2));
        System.out.println(getMax(6,7));
        System.out.println(reverseString("word"));
    }

    // =========== CLASSWORK =============

    // Exercise 8: isEven
    // Define a method isEven that takes an integer as input and returns
    // true if the number is even, and false otherwise.
    public static boolean isEven(int x) {
        return x % 2 == 0;
    }


    // Exercise 9: getMax
    // Define a method getMax that takes two integers as input and returns the maximum of the two numbers.
    public static int getMax(int x, int y) {
        return Math.max(x, y);
    }

    // Exercise 10: reverseString
    // Define a method reverseString that takes a string as input and returns the reverse of the string.
    // (If you complete the third one and present it in class you have a reward)
    public static String reverseString(String word) {
        String output = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            output = output + word.charAt(i);
        };
        return output;
    };

}
