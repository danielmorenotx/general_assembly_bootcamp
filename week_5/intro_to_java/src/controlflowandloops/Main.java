package controlflowandloops;

public class Main {


    public static void main(String[] args) {
        Main instance = new Main();

        // =========== HOMEWORK ============
        // Exercise 1: Simple If-Else
        int number = -1;
        if (number > 0) {
            System.out.println("Positive");
        } else if (number < 0) {
            System.out.println("Negative");
        } else {
            System.out.println("Zero");
        }

        // Exercise 2: For Loop
        for (int i = 1; i <= 100; i++) {
            if (i % 6 == 0) {
                System.out.println("LOTR");
            } else if (i % 2 == 0) {
                System.out.println("Smeagol");
            } else if (i % 3 ==0) {
                System.out.println("Gandalf");
            } else {
                System.out.println(i);
            }
        }

        //Exercise 3: While Loop
        int sum = 0;
        int i = 1;
        while (i <= 10) {
            sum += i;
            i++;
        }
        System.out.println("The total sum of the first ten integers is: " + sum);

        // Exercise 4: Do-While Loop
        // Write a program using a do-while loop that prints all the even numbers until 100.
        int x = 2;
        do {
            System.out.println(x);
            x += 2;
        } while (x <= 100);

        //Exercise 5: Switch Statement
        //Develop a Java application that uses a switch statement to print the name of the month and the season
        // it belongs to, based on an integer variable month representing a month number (1 to 12).
        // So if the given month number is 1, show January and its season in the console.

        int month = 1;

        switch (month) {
            case 1:
                System.out.println("January - Winter");
                break;
            case 2:
                System.out.println("February - Winter");
                break;
            case 3:
                System.out.println("March - Spring");
                break;
            case 4:
                System.out.println("April - Spring");
                break;
            case 5:
                System.out.println("May - Spring");
                break;
            case 6:
                System.out.println("June - Summer");
                break;
            case 7:
                System.out.println("July - Summer");
                break;
            case 8:
                System.out.println("August - Summer");
                break;
            case 9:
                System.out.println("September - Autumn");
                break;
            case 10:
                System.out.println("October - Autumn");
                break;
            case 11:
                System.out.println("November - Autumn");
                break;
            case 12:
                System.out.println("December - Winter");
                break;
            default:
                System.out.println("Not a month number");
        }

    }

}