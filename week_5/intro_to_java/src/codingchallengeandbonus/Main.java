package codingchallengeandbonus;

public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar"));
        System.out.println(convertToFahrenheit(0.0));
        System.out.println(convertToCelsius(32));
    }

    // Exercise 10: isPalindrome Method
    // Define a method isPalindrome(String text):
    // Checks if a given string is a palindrome. If its one it returns true if not it returns false.
    // A palindrome is a word, phrase which reads the same backward as forward,
    // such as "madam" or "racecar".
    public static boolean isPalindrome(String word) {
        String output = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            output = output + word.charAt(i);
        }

        return word.equals(output);
    }

    // Exercise 11: convertToFahrenheit Method
    // Define a method convertToFahrenheit(double celsius):
    // Converts a temperature from Celsius to Fahrenheit.
    // The formula for the conversion is (celsius * 9/5) + 32.
    // It should return the Fahrenheit variable
    public static double convertToFahrenheit(double celsius) {
        return (celsius * ((double) 9 / 5)) + 32;
    }

    // Exercise 12: convertToCelsius Method
    //Define a method convertToCelsius(double fahrenheit):
    // Converts a temperature from Fahrenheit to Celsius.
    // The formula for the conversion is (fahrenheit - 32) * 5/9.
    // It should return the Celsius variable
    public static double convertToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * ((double) 5 / 9);
    }
}
