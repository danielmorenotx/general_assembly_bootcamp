package methodoverloading;

public class Main {
    public static void printArea(double radius) { // circle
        System.out.println(Math.PI * Math.pow(radius,2));
    }

    public static void printArea(int a) { // square
        System.out.println(a * a);
    }

    public static void printArea(int a, int b) { // rectangle
        System.out.println(a * b);
    }

    public static void main(String[] args) {
        printArea(3.5);
        printArea(5);
        printArea(5,6);
    }
}
